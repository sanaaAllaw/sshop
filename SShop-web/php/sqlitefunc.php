<?php
function checkIfAdmin($username,$password){  
     include("sqlite_conn.php"); 
    $boolexist=false;
    $result = $myPDO->query("SELECT username,password FROM users where username='$username' and password='$password'");
    foreach($result as $row)
    {
        $_SESSION['sqliteLogin']=true; 
        $boolexist=true;
    }
    return $boolexist;
}
?>
