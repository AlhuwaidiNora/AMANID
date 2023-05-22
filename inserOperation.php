<?php
require_once('../include/dbConnect.php');
require_once('../API/operationAPI.php');

	$mysqli = $con;
    //$mysqli->set_charset('charset');
	if($_SERVER['REQUEST_METHOD']=='GET'){
		check_insert($mysqli,$_GET['name'],$_GET['amount']);	
	}else{
		$obj = (object) [
			"ID"=>"-1",
			"name"=>"NO Name",
			"amount"=>"0"
   ];
   echo json_encode($obj);
	}
	
	function check_insert($mysqli,$name,$amount){

        
			if(insert_operation($mysqli,$name,$amount)){
				$last_id = $mysqli->insert_id;
				get_operation_by_id($mysqli,$last_id);
		   }else{
			$obj = (object) [
				"ID"=>"-1",
				"name"=>"NO Name",
				"amount"=>"0"
	   ];
	   echo json_encode($obj);
		   }
		 
         
		 
		
		 
		 
	 }



	
	
	
	


$mysqli->close();
	
?>	
