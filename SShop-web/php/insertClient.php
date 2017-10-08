<?php
try{
 include('connection.php');
 include('generalfunc.php');
 //================================================================= collect posted data
 $usernamevar='';
 $mailVar='';
 $firstnamevar=trim($_POST['firstname']);
 $lasttnamevar=trim($_POST['lastname']);
 $usernameOrmailvar=trim($_POST['username']);
 $passwordvar=encryptpassword(trim($_POST['password']));
 $Mobilevar=trim($_POST['mobile']);
 if(checkValidationMail($usernameOrmailvar)==true){
     $mailVar=$usernameOrmailvar;
 }
 else{
    $usernamevar=$usernameOrmailvar; 
 }
 //================================================================= end collect posted data
 $sqlInsertCLient="INSERT INTO `sshop`.`users` (`firstname`, `LastName`, `Username`, `Password`, `Mobile`, `Email`, `login_status`)
  VALUES ('$firstnamevar','$lasttnamevar','$usernamevar','$passwordvar','$Mobilevar','$mailVar','CLI');
  INSERT INTO `sshop`.`clients` (`Username`) VALUES ('$usernamevar')";      
  $conn->exec($sqlInsertCLient); 
  header('Location:../register.php');
}
catch(PDOException $e){
    
}

?>
