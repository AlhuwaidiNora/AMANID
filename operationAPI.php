<?php

		
		
 
	
// === get row users by id ===//

function get_operation_by_id($mysqli,$ID){

	$sql = $mysqli->query(" SELECT * FROM  `operation` WHERE `id` = '".$ID."' ORDER BY `ID` ASC ");
		if(mysqli_num_rows($sql) > 0){
        $result = array(); 
		$row = mysqli_fetch_array($sql);
	    
		 $obj = (object) [
    	 "id"=>$row['id'],
	     "name"=>$row['name'],
		 "amount"=>$row['amount']
];

       echo json_encode($obj);
		}else{
			$obj = (object) [
				"id"=>"-1",
				"name"=>"NO NAME",
				"amount"=>"0"
	   ];
	   echo json_encode($obj);	
		}
	 
	}
     

		
	
		
function update_operation_by_id($mysqli,$ID,$name,$amount){
	
	$sql = $mysqli->query(" SELECT * FROM  `operation` WHERE `id` = '".$ID."' ");
		if(mysqli_num_rows($sql) > 0){
			
	$upd_sql = $mysqli->query(" UPDATE `operation` SET 
								 `name` = '".$name."',
								 `amount` = '".$amount."',
								  WHERE `id` = '".$ID."' ");	
	                if(isset($upd_sql)){
						get_users_by_id($mysqli,$ID);
					}else{
                    echo "no update";
		            
				  }				
			
			
		}else{
		echo "no update";
		}
	
	
	
				 
}
	


// === insert users  ===//
function  insert_operation($mysqli,$name,$amount){
  		  if ($mysqli->query("INSERT INTO `operation` (`name`,`amount`)	
													VALUES(
												'".$name."',
												'".$amount."');")) {
													
			               			
							return true;
	                                          }else{
										
						   return false;
			                            }
}	



	
?>	
