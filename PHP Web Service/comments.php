<?php

include("ayar.php");

$tabload=$_POST['tabload'];
$kosul=$_POST['kosul'];

	$qry="SELECT * FROM comments where ProductStockCode='$kosul' and Status=1";
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
print_r(json_encode($flag));
mysql_close();
?>