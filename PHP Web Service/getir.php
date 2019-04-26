<?php

include("ayar.php");

$tabload=$_POST['tabload'];
$kosul=$_POST['kosul'];

if($tabload=="slider"){
	$qry="SELECT * FROM slider where Status=1";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
	}
}else if($tabload=="maincategory"){
	$qry="SELECT * FROM maincategory where Status=1";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$id=$row["Id"];
			$sorgu="SELECT * FROM categorybanner where MainCategoryId='$id' and Status=1";
			$resim=mysql_fetch_array(mysql_query($sorgu));
			$flag[]=array_merge($row,$resim);
		}
	}
}
else if($tabload=="subcategory"){
	$qry="SELECT * FROM subcategory where MainCategoryId='$kosul' and Status=1";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
	}
}else if($tabload=="subsubcategory"){
	$qry="SELECT * FROM subsubcategory where SubCategoryId='$kosul' and Status=1";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
	}
}
else if($tabload=="products"){
	$qry="SELECT * FROM ".$tabload." where StockCode='$kosul' and Status=1";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$id=$row["Id"];
			$flag[]=$row;
		}
		$sorgu="SELECT * FROM productsimages where ProductId='$id' and Status=1";
		@$sor=mysql_query($sorgu);
		if($sor){
			$resim="";
			while($oku=mysql_fetch_array($sor))
			{
				$resim=$resim.$oku["ImagePath"].",";
			}
		}
		$resim=rtrim($resim,",");
		$sonuc=array("ImagePath"=>$resim);
		$flag[]=$sonuc;
		$sorgu="SELECT COUNT(*) AS satir,SUM(Points) AS toplam FROM comments where ProductId='$id' and Status=1";
		$sor=mysql_query($sorgu);
		$result=mysql_fetch_assoc($sor);
		$flag[]=array("Comment"=>$result['satir']);
		$flag[]=array("Rating"=>$result['toplam']);
	}
}else if($tabload=="comments"){
	$qry="SELECT * FROM ".$tabload." where ProductId='$kosul'";
	@$query=mysql_query($qry);
	if($query)
	{
		$ad="";
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
			$id=$row["CommentatorMemberShipId"];
			$sorgu="SELECT FirstName as ad,LastName as soyad FROM membership where Id='$id'";
			$sor=mysql_query($sorgu);
			$result=mysql_fetch_assoc($sor);
			$ad=$ad.$result["ad"]." ".$result["soyad"].",";
		}
		$ad=rtrim($ad,",");
		$flag[]=array("Name"=>$ad);
	}
}else if($tabload=="RenkGetir"){
	$qry="SELECT * FROM products where ProductName='$kosul' and Status=1";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$stokcode=$row["StockCode"];
			$stok=array("StockCode"=>$stokcode);
			$sorgu="SELECT * FROM productsimages where ProductStokCode='$stokcode' and Status=1";
			@$sor=mysql_query($sorgu);
			$oku=mysql_fetch_assoc($sor);
			$sonuc=array("Resim"=>$oku["ImagePath"]);
			$flag[]=array_merge($stok,$sonuc);
		}
	}
}else if($tabload=="NumaraGetir"){
	$qry="SELECT ProductOptions FROM products where StockCode='$kosul' and Status=1";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
	}
}else if($tabload=="Adres"){
	$adrestip=substr($kosul,0,strpos($kosul,"-"));
	$membershipid=substr($kosul,strpos($kosul,"-")+1,strlen($kosul));
	if($adrestip=="Teslimat") $qry="SELECT * FROM userdeliveryadress where MemberShipId='$membershipid' and Status=1";
	else $qry="SELECT * FROM userinvoiceadress where MemberShipId='$membershipid' and Status=1";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
	}
}
print(json_encode($flag));

?>