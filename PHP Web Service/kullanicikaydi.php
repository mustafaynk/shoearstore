<?php
include("ayar.php");

    $ad=$_POST["First_Name"];
    $soyad=$_POST["Last_Name"];
    $eposta=$_POST["E_Mail"];
    $parola=$_POST["Password"];

    if(($ad==" ") or ($soyad==" ") or ($eposta==" ") or ($parola==" "))
    {
        echo "Lütfen Boş Yer Bırakmayınız";
    }
    else
    {
		$sor = mysql_query("SELECT * FROM membership WHERE EMail='$eposta'");
        if(mysql_num_rows($sor)==0)
        {
            $kayit  = mysql_query("INSERT INTO membership (FirstName,LastName,EMail,Password,Status) VALUES ('$ad','$soyad','$eposta','$parola',1);");
			if($kayit)
            {
				$sor=mysql_query("SELECT * FROM membership where EMail='$eposta'");
				while($oku=mysql_fetch_array($sor)){
					$id=$oku["Id"];
				}
				$id=array("Id"=>$id);
				$status=array("status"=>"1");
				$status=array_merge($status,$id);
            }else{
				$status=array("status"=>"0");
            }
        }
        else
        {
			$status=array("status"=>"-1");
        }
    }
    mysql_close();
	$flag[]=$status;
	print(json_encode($flag));
?>