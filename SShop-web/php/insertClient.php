<?php
try{
 include('connection.php');
 include('generalfunc.php');
 //================================================================= collect posted data
 $usernamevar='';
 $mailVar='';
 $firstnamevar=$_POST['firstname'];
 $lasttnamevar=$_POST['lastname'];
 $usernameOrmailvar=$_POST['username'];
 $passwordvar=$_POST['password'];
 $Mobilevar=$_POST['mobile'];
 if(checkValidationMail($usernameOrmailvar)==true){
     $mailVar=$usernameOrmailvar;
 }
 else{
    $usernamevar=$usernameOrmailvar; 
 }
 //================================================================= end collect posted data
 $sqlInsertCLient="INSERT INTO `sshop`.`users` (`firstname`, `LastName`, `Username`, `Password`, `Mobile`, `Email`)
  VALUES ('$firstnamevar','$lasttnamevar','$usernamevar','$passwordvar','$Mobilevar','$mailVar')";
  $conn->exec($sqlInsertCLient); 
  header('Location:../register.php');
}
catch(PDOException $e){
    
}

?>
