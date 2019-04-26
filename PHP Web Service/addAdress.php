<?php
include("ayar.php");

	$adresTip=$_POST["adrestip"];
	$kullaniciid=$_POST["kullaniciid"];
    $ad=$_POST["ad"];
    $soyad=$_POST["soyad"];
    $telefon=$_POST["telefon"];
    $acikadres=$_POST["acikadres"];
    $ulke=$_POST["ulke"];
    $il=$_POST["il"];
    $ilce=$_POST["ilce"];
    $adresad=$_POST["adresad"];
    $firmaad=$_POST["firmaad"];
    $firmavergino=$_POST["firmavergino"];
    $firmavergi=$_POST["firmavergi"];

	
	echo $firmaad;
	echo $firmavergino;
	echo $firmavergi;
	
	if($adresTip=="Teslimat") $kayit  = mysql_query("INSERT INTO userdeliveryadress(UserName, UserSurname, UserTelephone, AdressCountry, AdressCity, AdressDistrict, OpenAdress, AdressName, MemberShipId, Status) VALUES ('$ad','$soyad','$telefon','$ulke','$il','$ilce','$acikadres','$adresad','$kullaniciid',1)");
	else $kayit=mysql_query("INSERT INTO userinvoiceadress(UserName, UserSurname, UserTelephone, AdressCountry, AdressCity, AdressDistrict, OpenAdress, AdressName, MemberShipId, CompanyName, CompanyTaxName, CompanyTaxNumber, Status) VALUES ('$ad','$soyad','$telefon','$ulke','$il','$ilce','$acikadres','$adresad','$kullaniciid','$firmaad','$firmavergi','$firmavergino',1)");

	if($kayit)
    {
		$status=array("status"=>"1");
    }else{
		$status=array("status"=>"0");
    }
        
    mysql_close();
	$flag[]=$status;
	print(json_encode($flag));
?>