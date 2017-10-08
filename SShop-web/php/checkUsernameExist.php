<?php
try{
  include('connection.php');
  $username=$_REQUEST['userVar'];
  $sqlcheckUsername="select username from users where username='$username'";
    $sth = $conn->prepare($sqlcheckUsername);
    $sth->execute();
    $data = $sth->fetch();
    if(empty($data['username'])){
        echo 1;
    }
    else{
        echo 0;
    }
}
catch(PDOException $e){
    
}
?>
