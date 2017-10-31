<?php
include("php/connection.php");
session_start();
//$mof=preg_replace("/^\s+|\s+$/", "",$_POST['mof_number']);
$name=preg_replace("/^\s+|\s+$/", "",$_POST['name']);
//$country=preg_replace("/^\s+|\s+$/", "",$_POST['country']);

$code=preg_replace("/^\s+|\s+$/", "",$_POST['code']);
$qty=preg_replace("/^\s+|\s+$/", "",$_POST['qty']);
$supplier=preg_replace("/^\s+|\s+$/", "",$_POST['supplier']);
$categorie=preg_replace("/^\s+|\s+$/", "",$_POST['categorie']);
$price=preg_replace("/^\s+|\s+$/", "",$_POST['price']);

$barcode=preg_replace("/^\s+|\s+$/", "",$_POST['barcode']);
$group=preg_replace("/^\s+|\s+$/", "",$_POST['group']);
$logo=preg_replace("/^\s+|\s+$/", "",$_FILES["logo"]["name"]);
//$picture=preg_replace("/^\s+|\s+$/", "",$_POST['piture']);
if (!file_exists('pictures/')) {
    mkdir('pictures/', 0777, true);
}
if(isset($_FILES['logo'])){
$target_dir = 'pictures/';
$ext = pathinfo($_FILES["logo"]["name"], PATHINFO_EXTENSION);
$target_file = $target_dir .$_FILES["logo"]["name"];
$uploadOk = 1;
$imageFileType = pathinfo($target_file, PATHINFO_EXTENSION);

// Move the file
move_uploaded_file($_FILES["logo"]["tmp_name"], $target_file);
}
$logo=$target_dir.preg_replace("/^\s+|\s+$/", "",$_FILES["logo"]["name"]);


$sqlInsertItems="INSERT INTO `sshop`.`items` (`item_code`, `item_name`, `item_barcode`,
 `item_supp`, `item_orig_price`, `item_qty`, `item_group`, `Itemscol`, `item_pic`) 
VALUES ('$code','$name','$barcode','$supplier','$price','$qty','$categorie','$group','$logo')";  
$conn->exec($sqlInsertItems);                               
header('Location:add_item.php');
mysqli_close($connection);
?>
