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
$categ=preg_replace("/^\s+|\s+$/", "",$_POST['categ']);
$fond=preg_replace("/^\s+|\s+$/", "",$_POST['fond']);
$logo=preg_replace("/^\s+|\s+$/", "",$_FILES["logo"]["name"]);
$datevar=date('Y/m/d');
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


$sqlInsertItems="INSERT INTO `items`
(`itemcode`,
`name`,
`description`,
`qty`,
`price`,
`barcode`,
`fond`,
`expiry`,
`salesman`,
`supplier`,
`item_group`,
`itemscol`,
`itemscateg`,
`itempic`)
VALUES ('$code','$name','$name','$qty','$price','$barcode','$fond',
'','','$supplier','$group','$categorie','$categ','$logo')";  
$conn->exec($sqlInsertItems); 
$movquery="INSERT INTO `movements` 
(`itemcode`, `itemname`, `qty`, `price`, `supplier`, `date`,`movtype`)
 VALUES('$code','$name', '$qty','$price', '$supplier', '$datevar','PIV')";
$conn->exec($movquery);                               
header('Location:add_item.php');
mysqli_close($connection);
?>
