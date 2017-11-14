<?php
include("php/connection.php");
include("php/generalfunc.php");
session_start();
$code=preg_replace("/^\s+|\s+$/", "",$_POST['itemcodevar']);
$qty=preg_replace("/^\s+|\s+$/", "",$_POST['qty']);
$name=preg_replace("/^\s+|\s+$/", "",$_POST['itemname']);

$price=preg_replace("/^\s+|\s+$/", "",$_POST['price']);

$barcode=preg_replace("/^\s+|\s+$/", "",$_POST['barcode']);

$fond=preg_replace("/^\s+|\s+$/", "",$_POST['fond']);
//$logo=preg_replace("/^\s+|\s+$/", "",$_FILES["logo"]["name"]);
$datevar=date('Y/m/d');


   


$itemquery="Update `items` set `qty`=qty+'$qty',`name`='$name',`fond`='$fond',`price`='$price',`barcode`='$barcode' where itemcode='$code'";
$conn->exec($itemquery); 
$movquery="INSERT INTO `movements` 
(`itemcode`, `itemname`, `qty`, `price`, `supplier`, `date`,`movtype`)
 VALUES('$code','$name', '$qty','$price', '', '$datevar','PIV')";
$conn->exec($movquery);                               
header('Location:edit_item.php');
mysqli_close($connection);

?>