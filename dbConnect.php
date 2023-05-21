<?php

define('HOST','localhost:3307');
define('USER','root');
define('PASS','');
define('DB','amanapp');

$con = mysqli_connect(HOST,USER,PASS,DB) or die ('Unable to Connect');
			//mysqli_set_charset($con,"utf8");			
	       // mysqli_query($con,"set character_set_server='utf-8'");
	        //mysqli_query($con,"set names 'utf-8'");				


	
?>	
