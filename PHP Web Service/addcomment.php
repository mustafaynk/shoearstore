<?php

include("ayar.php");

$kullaniciidandcomment=$_POST['tabload'];
$ratingandstockcode=$_POST['kosul'];

$kullaniciid=substr($kullaniciidandcomment,0,strpos($kullaniciidandcomment,"-"));
$comment=substr($kullaniciidandcomment,strpos($kullaniciidandcomment,"-")+1,strlen($kullaniciidandcomment));

$rating=substr($ratingandstockcode,0,strpos($ratingandstockcode,"-"));
$stockcode=substr($ratingandstockcode,strpos($ratingandstockcode,"-")+1,strlen($ratingandstockcode));

	$qry="INSERT INTO comments(CommentatorMemberShipId, Review, Points, CommentDate, ProductStockCode, Status) VALUES ('$kullaniciid','$comment','$rating',NOW(),'$stockcode',0)";
	@$query=mysql_query($qry);
	if($query)
	{
		echo 'Basarili';
	}else{
		echo 'Hata';
	}
mysql_close();
?>