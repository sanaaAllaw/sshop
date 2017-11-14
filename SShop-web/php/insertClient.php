<?php
try{
    include('connection.php');
    include('generalfunc.php');
    session_start();
    //================================================================= collect posted data
    $usernamevar='';
    $mailVar='';
    $firstnamevar=trim($_POST['firstname']);
    $lasttnamevar=trim($_POST['lastname']);
    $usernameOrmailvar=trim($_POST['username']);
    $passwordvar=md5(trim($_POST['password']));
    $Mobilevar=trim($_POST['mobile']);
    if(checkValidationMail($usernameOrmailvar)==true){
        $mailVar=$usernameOrmailvar;
    }
    else{
        $usernamevar=$usernameOrmailvar; 
    }
    //================================================================= end collect posted data
    if(isset($_SESSION["admin"])){
        $sqlInsertCLient="INSERT INTO `users` (`firstname`, `LastName`, `Username`, `Password`, `Mobile`, `Email`, `type`)
        VALUES ('$firstnamevar','$lasttnamevar','$usernamevar','$passwordvar','$Mobilevar','$mailVar','admin');
        INSERT INTO `sshop`.`clients` (`Username`) VALUES ('$usernamevar')"; 
         $conn->exec($sqlInsertCLient); 
    header('Location:../logout.php');  
    }
    else{
        $sqlInsertCLient="INSERT INTO `users` (`firstname`, `LastName`, `Username`, `Password`, `Mobile`, `Email`, `type`)
        VALUES ('$firstnamevar','$lasttnamevar','$usernamevar','$passwordvar','$Mobilevar','$mailVar','CLI');
        INSERT INTO `sshop`.`clients` (`Username`) VALUES ('$usernamevar')";  
         $conn->exec($sqlInsertCLient); 
    header('Location:../index.php'); 
    }   
   
}
catch(PDOException $e){

}

?>
