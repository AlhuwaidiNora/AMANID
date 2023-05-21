<?php
require_once('../include/dbConnect.php');
require_once('../API/operationAPI.php');

	$mysqli = $con;
    //$mysqli->set_charset('charset');
	if($_SERVER['REQUEST_METHOD']=='GET'){
		check($mysqli,$_GET['id']);	
	}else{
		$obj = (object) [
			"ID"=>"-1",
			"name"=>"NO Name",
			"amount"=>"0"
   ];
   echo json_encode($obj);
	}
	
	function check($mysqli,$id){
		get_operation_by_id($mysqli,$id);
        
			
		   }
		 
         
	



	
	
	
	


$mysqli->close();
	
?>	
