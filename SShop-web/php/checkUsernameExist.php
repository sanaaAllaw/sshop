<?php
try{
  include('connection.php');
  $username=$_REQUEST['userVar'];
  $sqlcheckUsername="select username from users where username='$username'";
  if ($res = $conn->query($sqlcheckUsername)) {
    if ($res->fetchColumn() > 0) {
       echo 1;
    }
    else{
        echo 0;
    }
  }
}
catch(PDOException $e){
    
}
?>
