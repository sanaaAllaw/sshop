<?php
include("php/connection.php");
session_start();
//$mof=preg_replace("/^\s+|\s+$/", "",$_POST['mof_number']);
$fname=preg_replace("/^\s+|\s+$/", "",$_POST['fname']);
//$country=preg_replace("/^\s+|\s+$/", "",$_POST['country']);

$lname=preg_replace("/^\s+|\s+$/", "",$_POST['lname']);
$username=preg_replace("/^\s+|\s+$/", "",$_POST['username']);
$password=md5(preg_replace("/^\s+|\s+$/", "",$_POST['password']));
$address=preg_replace("/^\s+|\s+$/", "",$_POST['address']);
$phone=preg_replace("/^\s+|\s+$/", "",$_POST['phone']);

$mobile=preg_replace("/^\s+|\s+$/", "",$_POST['mobile']);
$email=preg_replace("/^\s+|\s+$/", "",$_POST['email']);


$sqlInsertItems="UPDATE `sshop`.`users` SET `firstname`='$fname', `LastName`='$lname',
`Password`='$password', `Address`='$address', `Phone`='$phone', 
`Mobile`='$mobile', `Email`='$email' WHERE `username`='$username';
";  
$conn->exec($sqlInsertItems);                               
header('Location:index.php');
mysqli_close($connection);
?>
