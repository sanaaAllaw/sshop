<?php
include("php/connection.php");
include("php/generalfunc.php");
session_start();
$itemName=$_REQUEST['item_name'];
$price=$_REQUEST['price'];
$datevar=date('Y/m/d');
$timevar=date('H:i:s');
$loginvar=$_SESSION["login_id"];
//$invoicenum=getInvoiceCode();

$sqlcateg="select item_name from transaction where item_name='$itemName' and status =1";
$sth = $conn->prepare($sqlcateg);
$sth->execute();
$data = $sth->fetchAll();
if($data[0]>0){
    $mysqlquery="Update `transaction` set `qty`=qty+1  where item_name='$itemName'"; 
}
else{
    $mysqlquery="Insert into `transaction` (`item_name`,`qty`, `price`, `date`,`time`, `login_id`,`status`)VALUES 
    ('$itemName',1, '$price','$datevar', '$timevar','$loginvar', '1' )";  
}

$conn->exec($mysqlquery); 
$itemquery="Update `items` set `item_qty`=item_qty-1 where item_code='$itemName'";
$conn->exec($itemquery); 

?>