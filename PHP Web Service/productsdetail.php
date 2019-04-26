<?php

include("ayar.php");

$kullaniciid=$_POST['tabload'];
$stockcode=$_POST['kosul'];

	$qry="SELECT * FROM products where StockCode='$stockcode' and Status=1";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
		$sorgu="SELECT * FROM productsimages where ProductStokCode='$stockcode' and Status=1";
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
		$sorgu="SELECT COUNT(*) AS satir,AVG(Points) AS toplam FROM comments where ProductStockCode='$stockcode' and Status=1";
		$sor=mysql_query($sorgu);
		$result=mysql_fetch_assoc($sor);
		$flag[]=array("Comment"=>$result['satir']);
		if($result['toplam']!= null) $flag[]=array("Rating"=>$result['toplam']);
		else $flag[]=array("Rating"=>"0");
		if(mysql_num_rows(mysql_query("SELECT * FROM wishlist WHERE MemberShipId='$kullaniciid' AND ProductStockCode='$stockcode' AND WishListStatus=1"))>0)
		{
			$flag[]=array("Favorites"=>"1");
		}else{
			$flag[]=array("Favorites"=>"0");
		}
	}
print(json_encode($flag));
mysql_close();
?>