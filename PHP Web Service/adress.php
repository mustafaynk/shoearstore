<?php

include("ayar.php");

$islem=$_POST["tabload"];
@$kullaniciidandid=$_POST["kosul"];

$kullaniciid=substr($kullaniciidandid,0,strpos($kullaniciidandid,"-"));
$idandtype=substr($kullaniciidandid,strpos($kullaniciidandid,"-")+1,strlen($kullaniciidandid));
$id=substr($idandtype,0,strpos($idandtype,","));
$type=substr($idandtype,strpos($idandtype,",")+1,strlen($idandtype));

if($islem=="sil"){
	if($type=="Teslimat") $delete = mysql_query("DELETE FROM userdeliveryadress WHERE Id='$id' and MemberShipId='$kullaniciid'");
	else $delete = mysql_query("DELETE FROM userinvoiceadress WHERE Id='$id' and MemberShipId='$kullaniciid'");

	if ($delete) {
		echo 'Basarili';

	}else{ 
	echo '';
	}
}

	
mysql_close();
?>