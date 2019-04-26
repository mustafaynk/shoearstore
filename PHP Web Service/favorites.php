<?php

include("ayar.php");

$kullaniciid=$_POST['tabload'];
$stockcodeandstatus=$_POST['kosul'];
$stockcode=substr($stockcodeandstatus,0,strpos($stockcodeandstatus,"-"));
$status=substr($stockcodeandstatus,strpos($stockcodeandstatus,"-")+1,strlen($stockcodeandstatus));
if($status=="add"){
	$sor= mysql_query("SELECT * FROM wishlist WHERE MemberShipId='$kullaniciid' AND ProductStockCode='$stockcode' AND WishListStatus=-1");
	if(mysql_num_rows($sor)>0)
	{
		$update=mysql_query("UPDATE wishlist SET WishListStatus=1 WHERE MemberShipId='$kullaniciid' AND ProductStockCode='$stockcode'");
		if($update){
		print("Updated");	
		}else{
			print("Error");
		}
	}else{
		$added=mysql_query("INSERT INTO wishlist (WishListId, MemberShipId, ProductStockCode, WishListStatus) VALUES (NULL,'$kullaniciid','$stockcode',1)");
		if($added){
		print("Added");	
		}else{
			print("Error");
		}
	}
}else if($status=="delete"){
	$update=mysql_query("UPDATE wishlist SET WishListStatus=-1 WHERE MemberShipId='$kullaniciid' AND ProductStockCode='$stockcode'");
		if($update){
		print("Deleted");	
		}else{
			print("Error");
		}
}

?>