<?php
include("php/connection.php");
session_start();
//$mof=preg_replace("/^\s+|\s+$/", "",$_POST['mof_number']);
$fname=preg_replace("/^\s+|\s+$/", "",$_POST['fname']);
$lname=preg_replace("/^\s+|\s+$/", "",$_POST['lname']);
$country=preg_replace("/^\s+|\s+$/", "",$_POST['country']);
$str1=preg_replace("/^\s+|\s+$/", "",$_POST['str1']);
$fax=preg_replace("/^\s+|\s+$/", "",$_POST['fax']);

$city=preg_replace("/^\s+|\s+$/", "",$_POST['city']);
$company=preg_replace("/^\s+|\s+$/", "",$_POST['company']);
$phone=preg_replace("/^\s+|\s+$/", "",$_POST['phone']);
$logo=preg_replace("/^\s+|\s+$/", "",$_FILES["logo"]["name"]);
//$picture=preg_replace("/^\s+|\s+$/", "",$_POST['piture']);
if (!file_exists('pictures/')) {
    mkdir('pictures/', 0777, true);
}
if(isset($_FILES['logo'])){
$target_dir = 'customer/';
$ext = pathinfo($_FILES["logo"]["name"], PATHINFO_EXTENSION);
$target_file = $target_dir .$_FILES["logo"]["name"];
$uploadOk = 1;
$imageFileType = pathinfo($target_file, PATHINFO_EXTENSION);

// Move the file
move_uploaded_file($_FILES["logo"]["tmp_name"], $target_file);
}
$logo=$target_dir.preg_replace("/^\s+|\s+$/", "",$_FILES["logo"]["name"]);


$sqlInsertItems="INSERT INTO `customer`
 (`fname`, `lname`, `company`, `phone`, `str1`, `city`, `country`, `fax`, `picture`)
 VALUES ('$fname', '$lname', '$company', '$phone','$str1', '$city', '$country','$fax', '$logo');
";  
$conn->exec($sqlInsertItems);                               
header('Location:customer.php');
mysqli_close($connection);
?>
