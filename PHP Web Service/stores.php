<?php

include("ayar.php");

$storecity=$_POST['tabload'];
$kosul=$_POST['kosul'];

	$qry="SELECT * FROM stores WHERE StoreCity='$storecity'";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
	}
	if(@is_null($flag)) $flag="";
print_r(json_encode($flag));
mysql_close();
?>