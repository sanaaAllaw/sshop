<?php
try{    
    session_start();
    include("connection.php"); 
    include("generalfunc.php");
    include("sqlitefunc.php");

    $user_log=trim($_POST['username_log']);
    $pass_log=md5(trim($_POST['pass_log']));
    if(checkIfAdmin($user_log,$pass_log)==true){
        $_SESSION["login_id"]=$user_log;
        $_SESSION["admin"]=true;
        header('Location:../register_admin.php');
    }
    else{
        $sqllogin="select username,password,type from users where username='$user_log' and password='$pass_log'";
        $sth = $conn->prepare($sqllogin);
        $sth->execute();
        $data = $sth->fetch();
        if(empty($data['username'])and empty($data['password'])){
            header('Location:../index.php');
        }
        else{
            if($data['type']=='CLI'){
                $_SESSION["login_id"]=$user_log;
				$_SESSION["admin"]=false;
            }else{
                $_SESSION["login_id"]=$user_log;
                $_SESSION["admin"]=true;  
            }
            header('Location:../index.php');

        }
    }
}
catch(PDOException $e){

}
?>
