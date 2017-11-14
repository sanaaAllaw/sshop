<?php
try{
  session_start();
  include('php/connection.php');
	$itemcode='';
	$qty='';
  $sqlcateg="select item_name,qty from transaction where login_id=$_SESSION[login_id]";
                    $sth = $conn->prepare($sqlcateg);
                    $sth->execute();
                    $data = $sth->fetchAll();
                    for($i=0;$i<sizeof($data);$i++){
                        $itemcode= $data[$i][0];
						$qty= $data[$i][1];
						$itemquery="Update `items` set `item_qty`=item_qty+'$qty' where item_code='$itemcode'";
						$conn->exec($itemquery); 
					}
  $sqlcheckUsername="delete from transaction where login_id='$_SESSION[login_id]'";
    $sth = $conn->prepare($sqlcheckUsername);
    $sth->execute();
    
header("Location:index.php");
}


catch(PDOException $e){
    
}
?>
