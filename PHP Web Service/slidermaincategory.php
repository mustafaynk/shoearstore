<?php

include("ayar.php");
$tabload=$_POST['tabload'];
$kosul=$_POST['kosul'];
$qry="SELECT * FROM ".$tabload." where Status=1 order by Id";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
	}
print_r(json_encode($flag));
mysql_close();
?>