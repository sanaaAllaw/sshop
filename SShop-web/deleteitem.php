<?php
try{
  include('php/connection.php');
  $itemname=$_REQUEST['itemcode'];
  $sqlcheckUsername="delete from transaction where item_name='$itemname'";
    $sth = $conn->prepare($sqlcheckUsername);
    $sth->execute();
    $itemquery="Update `items` set `item_qty`=item_qty+1 where item_code='$itemName'";
$conn->exec($itemquery); 
}
catch(PDOException $e){
    
}
?>
