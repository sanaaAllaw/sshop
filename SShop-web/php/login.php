<?php
try{    
    session_start();
    include("connection.php"); 
    include("generalfunc.php");
    $user_log=trim($_POST['username_log']);
    $pass_log=encryptpassword(trim($_POST['pass_log']));
   $sqllogin="select username,password from users where username='$user_log' and password='$pass_log'";
   $sth = $conn->prepare($sqllogin);
    $sth->execute();
    $data = $sth->fetch();
    if(empty($data['username'])and empty($data['password'])){
        echo 1;
    }
    else{
        $_SESSION["login_id"]=$user_log;
        header('Location:../index.php');
    }
}
catch(PDOException $e){
    
}
?>
