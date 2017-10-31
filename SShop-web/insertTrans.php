<?php
  include("../php/connection.php");
  $itemName=$_REQUEST['item_name'];
  $price=$_REQUEST['price'];
 
  $mysqlquery="Insert into `transaction` (`item_name`, `price`, `date`)VALUES (?, ?, ?)";
  $mysqlquery->bind_param("ssss", $item_name, $pricevar,$datevar);
  // set parameters and execute
  $item_name = $itemName;
  $pricevar = $price;
  $datevar = date("Y/m/d");
  
  $mysqlquery->execute(); 
?>