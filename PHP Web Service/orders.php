<?php

include("ayar.php");

$UyeId=$_POST['tabload'];
@$ikincikosul=$_POST['kosul'];

$qry="SELECT * FROM OrderCompleted  where MemberShipId='$UyeId' and Status>1  GROUP BY OrderNo order by Id desc";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$flag[]=$row;
		}
	}
	if(@is_null($flag)) {
		echo '';
	}else{
	print(json_encode($flag));	
	}
mysql_close();
?>