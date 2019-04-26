<?php

include("ayar.php");

$categoryid=$_POST['tabload'];
$kullaniciidAndsiralamaolcutu=$_POST['kosul'];
$kullaniciid=substr($kullaniciidAndsiralamaolcutu,0,strpos($kullaniciidAndsiralamaolcutu,"-"));
$siralamaolcutu=substr($kullaniciidAndsiralamaolcutu,strpos($kullaniciidAndsiralamaolcutu,"-")+1,strlen($kullaniciidAndsiralamaolcutu));

if($siralamaolcutu=="DateOrder"){
	$query=mysql_query("SELECT urun.*,AVG(Points) as Rating,COUNT(Points) as Comment FROM products as urun LEFT JOIN comments ON comments.ProductStockCode=urun.StockCode where urun.MainCategoryId='$categoryid' and urun.Status=1 group by urun.Id order by RegistrationDate desc LIMIT 5");
	while($row=mysql_fetch_array($query))
	{
		$stockCode=$row["StockCode"];
		$qry=mysql_query("SELECT ImagePath as resim FROM productsimages where ProductStokCode='$stockCode' LIMIT 1");
		$resim=mysql_fetch_assoc($qry);
		$image=array("Resim"=>$resim["resim"]);
		if(mysql_num_rows(mysql_query("SELECT * FROM wishlist WHERE MemberShipId='$kullaniciid' AND ProductStockCode='$stockCode' AND WishListStatus=1"))>0)
		{
			$favorites=array("Favorites"=>"1");
		}else{
			$favorites=array("Favorites"=>"0");
		}
		$flag[]=array_merge($image,$row,$favorites);
	}
}else if($siralamaolcutu=="RatingOrder"){
	$query=mysql_query("SELECT urun.*,AVG(Points) as Rating,COUNT(Points) as Comment FROM products as urun LEFT JOIN comments ON comments.ProductStockCode=urun.StockCode where urun.MainCategoryId='$categoryid' and urun.Status=1 group by urun.Id order by Rating desc LIMIT 5");
	while($row=mysql_fetch_array($query)){
		$id=$row["StockCode"];
		$qry=mysql_query("SELECT ImagePath as resim FROM productsimages where ProductStokCode='$id' LIMIT 1");
		$resim=mysql_fetch_assoc($qry);
		$image=array("Resim"=>$resim["resim"]);
		if(mysql_num_rows(mysql_query("SELECT * FROM wishlist WHERE MemberShipId='$kullaniciid' AND ProductStockCode='$stockCode' AND WishListStatus=1"))>0)
		{
			$favorites=array("Favorites"=>"1");
		}else{
			$favorites=array("Favorites"=>"0");
		}
		$flag[]=array_merge($image,$row,$favorites);
	}
}else if($siralamaolcutu=="CommentOrder")
{
	$query=mysql_query("SELECT urun.*,AVG(Points) as Rating,COUNT(Points) as Comment FROM products as urun LEFT JOIN comments ON comments.ProductStockCode=urun.StockCode where urun.MainCategoryId='$categoryid' and urun.Status=1 group by urun.Id order by Comment desc LIMIT 5");
	while($row=mysql_fetch_array($query)){
		$id=$row["StockCode"];
		$qry=mysql_query("SELECT ImagePath as resim FROM productsimages where ProductStokCode='$id' LIMIT 1");
		$resim=mysql_fetch_assoc($qry);
		$image=array("Resim"=>$resim["resim"]);
		if(mysql_num_rows(mysql_query("SELECT * FROM wishlist WHERE MemberShipId='$kullaniciid' AND ProductStockCode='$stockCode' AND WishListStatus=1"))>0)
		{
			$favorites=array("Favorites"=>"1");
		}else{
			$favorites=array("Favorites"=>"0");
		}
		$flag[]=array_merge($image,$row,$favorites);
	}
}
if(@is_null($flag)) $flag[]=null;
print(json_encode($flag));
mysql_close();
?>