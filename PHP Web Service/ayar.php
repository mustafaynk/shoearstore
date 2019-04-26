<?php
$dbhost		= "localhost";
$dbuser		= "root";
$dbpass		= "";
$dbadi		= "shoearstore";
	@$baglan		= mysql_connect($dbhost,$dbuser,$dbpass);
	if(! $baglan) die("Mysql baglantisi saglanamiyor");
	
	

	mysql_select_db($dbadi,$baglan) or die("Veritabani baglantisi saglanamiyor");
	
mysql_query("SET NAMES UTF8");
mysql_query("SET_CHARACTER utf8_general_ci");
mysql_query("SET_CHARACTER SET 'utf8_general_ci'");
mysql_query("SET COLLATION_CONNECTION = 'utf8_general_ci'");

?>