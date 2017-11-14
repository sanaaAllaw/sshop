<?php
  include("../php/connection.php");
  $first_name=$_REQUEST['firstname'];
  $last_name=$_REQUEST['lastname'];
  $user_email=$_REQUEST['email'];
  $user_password=$_REQUEST['password'];
  $user_phone=$_REQUEST['phone'];
  $mysqlquery="Insert into `users` (`name`, `password`, `phone`,`email`)VALUES (?, ?, ?, ?)";
  $mysqlquery->bind_param("ssss", $firstname, $password,$phone,$email);
  // set parameters and execute
  $firstname = $first_name;
  $password = $user_password;
  $phone = $user_phone;
  $email = $user_email;
  $mysqlquery->execute(); 
?>