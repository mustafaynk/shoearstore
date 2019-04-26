<?php

include("ayar.php");

$maincategory=$_POST['tabload'];
$subcategory=$_POST['kosul'];

$qry="SELECT * FROM maincategory where Status=1 LIMIT 3";	
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
	}
	if(@is_null($flag)) $flag=array("Veri"=>"Yok");
print(json_encode($flag));
mysql_close();
?>