<?php
//==============================================check mail validation
function checkValidationMail($mailVar){
    if(filter_var($mailVar, FILTER_VALIDATE_EMAIL)) {
        echo '1';
    }
    else {
        echo '0';
    }

}
//==============================================end check mail validation
//==============================================encrypt password for saving
function encryptpassword($pass){
    $md5_var=md5($pass);
    return $md5_var;
}
//==============================================encrypt password for saving
//=========================function to check if administrator or client
function checkadministrator($login_id){
    try{
        $username=$login_id;
        $sth = $dbh->prepare("select user_status from users where username='$username'");
        $sth->execute();
        $result = $sth->fetchColumn(0);
        if(strtoupper($result)=='CLI'){
           return 'cli';  
        }
        if(strtoupper($result)=='EMP'){
           return 'emp';  
        }
    }
    catch(PDOException $e){

    }
}
//========================end function to check if administrator or client
?>
