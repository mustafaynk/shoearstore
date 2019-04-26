<?php

include("ayar.php");

$UyeId=$_POST['tabload'];
$orderno=$_POST['kosul'];

$qry="SELECT * FROM OrderCompleted  where MemberShipId='$UyeId' and Status>1 and OrderNo='$orderno'";
	@$query=mysql_query($qry);
	if($query)
	{
		while($row=mysql_fetch_array($query))
		{
			$id=$row["OrdersId"];
			$query2=mysql_query("Select * from orderdetail where OrdersId='$id' and Status=1");
			$orders=mysql_fetch_array($query2);
			$flag[]=array_merge($row,$orders);
		}
	}
	if(@is_null($flag)) $flag=array("Veri"=>"Yok");
print(json_encode($flag));
mysql_close();
?>