<?php

include("ayar.php");

$memberid=$_POST['tabload'];
$ikincikosul=$_POST['kosul'];

$qry="SELECT * FROM wishlist WHERE MemberShipId='$memberid' and WishListStatus=1";
@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$stockcode=$row["ProductStockCode"];
			$query2=mysql_query("Select ImagePath as resim from productsimages where ProductStokCode='$stockcode' and Status=1 LIMIT 1");
			$oku=mysql_fetch_assoc($query2);
			$resim=array("Resim"=>$oku["resim"]);
			$flag[]=array_merge($row,$resim,mysql_fetch_array(mysql_query("Select * FROM products where StockCode='$stockcode'")));
		}
	}
if(@is_null($flag)) {
	print("");
}
else print(json_encode($flag));
mysql_close();
?>