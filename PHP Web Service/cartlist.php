<?php

include("ayar.php");

$kullaniciid=$_POST["tabload"];
@$stockcode=$_POST["stockcode"];
@$piece=$_POST["piece"];
@$size=$_POST["size"];
$islem=$_POST["kosul"];

if($islem=="add"){
	$RenkSorgusu = mysql_query("SELECT * FROM Products where StockCode='$stockcode' and Status=1 ");
	$Resim=mysql_fetch_assoc(mysql_query("SELECT * FROM ProductsImages where ProductStokCode='$stockcode' and Status=1 LIMIT 1"));
if (mysql_num_rows($RenkSorgusu)) {
$RenkSorgusuCevap=mysql_fetch_assoc($RenkSorgusu);
$Color = $RenkSorgusuCevap['Color'];
$ProductName = $RenkSorgusuCevap['ProductName']; 
$ProductImage = $Resim['ImagePath'];
if($RenkSorgusuCevap['LastPrice'] != 0) $Price = $RenkSorgusuCevap['LastPrice'];
else $Price = $RenkSorgusuCevap['FirstPrice'];
}
$ekle = mysql_query("INSERT INTO  orders(
	MemberShipId,Status)VALUES 
  ('$kullaniciid', 1)");    
$ordersorgu = mysql_query("SELECT * FROM orders where MemberShipId='$kullaniciid' and Status=1 order by OrdersId desc limit 1 ");
if (mysql_num_rows($ordersorgu)) {
$ordercevap=mysql_fetch_assoc($ordersorgu);
$orderid = $ordercevap['OrdersId'];
}
$ekle2 = mysql_query("INSERT INTO  orderdetail(
	OrdersId,ProductStockCode,ProductName,ProductImagePath,CurrnetPrice,Color,Number,Piece,Status)VALUES 
  ('$orderid','$stockcode','$ProductName','$ProductImage','$Price','$Color','$size','$piece', 1)");    
if($ekle2){
	echo 'Eklendi';
}else{
	echo 'Eklenemedi';
}	
}else if($islem=="listele"){
	$qry="SELECT * FROM orders where MemberShipId='$kullaniciid' and Status=1 order by OrdersId desc";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$orderid=$row['OrdersId'];
			$sorgu="SELECT * FROM orderdetail where OrdersId='$orderid' and Status=1";
			$sor=mysql_query($sorgu);
			$result=mysql_fetch_array($sor);
			$flag[]=array_merge($row,$result);
		}
		if(@is_null($flag)) echo '';
		else print_r(json_encode($flag));
	}else{
		echo '';
	}
	
}else if($islem=="delete"){
	$guncelle = mysql_query("UPDATE orderdetail SET Status='-1' WHERE OrdersId='$kullaniciid' ");//kullaniciid=orderid
	$guncelle2 = mysql_query("UPDATE orders SET Status='-1' WHERE OrdersId='$kullaniciid' ");

	if ($guncelle>0 and $guncelle2>0) {
		echo 'Basarili';

	}else{ 
	echo '';
	}
}
else if($islem=="count"){
	$qry="SELECT COUNT(*) as Satir FROM orders where MemberShipId='$kullaniciid' and Status=1 order by OrdersId desc";
	@$query=mysql_query($qry);
	$row=mysql_fetch_array($query);
	echo $row['Satir'];
}else{
	$guncelle = mysql_query("UPDATE orderdetail SET Piece='$islem' WHERE OrdersId='$kullaniciid' ");//kullaniciid=orderid
	if($guncelle){
		echo 'Success';
	}else{
		echo '';
	}
}

	
mysql_close();
?>