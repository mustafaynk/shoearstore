<?php

include("ayar.php");

$eposta=$_POST['tabload'];
$parola=$_POST['kosul'];


if(($eposta!=" ") and ($parola!=" ")){
$eposta=str_replace("'","","$eposta");
$parola=str_replace("'","","$parola");

		$sor= mysql_query("SELECT * FROM membership WHERE EMail='$eposta' and Password='$parola'");
		if(mysql_num_rows($sor)>0)
		{
			while($oku=mysql_fetch_array($sor))
			{
				$flag[]=$oku;
			}
		}else
		{
			$flag[]=array("Id"=>"-1");
		}
		
}
print(json_encode($flag));

?>