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
//====================================================
function getAllGroupByCateg($categ){
    include('php/connection.php'); 
    $arraycateg=array();
    try{    
   $sqlcateg="select itemscol from items where item_group='$categ' group by itemscol";
   $sth = $conn->prepare($sqlcateg);
    $sth->execute();
    $data = $sth->fetchAll();
    for($i=0;$i<sizeof($data);$i++){
        $arraycateg[$i]=$data[$i];
    }
     return $arraycateg;
}
catch(PDOException $e){
    
}
}
//====================================================
//====================================================
function getAllItemsCateg($categ,$group){
    include('php/connection.php'); 
    $arraygroup=array();
    try{    
   $sqlcateg="select itemscateg from items where item_group='$categ' and itemscol='$group' group by item_group,itemscateg";
   $sth = $conn->prepare($sqlcateg);
    $sth->execute();
    $data = $sth->fetchAll();
    for($i=0;$i<sizeof($data);$i++){
        $arraygroup[$i]=$data[$i];
    }
     return $arraygroup;
}
catch(PDOException $e){
    
}
}
//====================================================
function getAllItemsname($a,$b,$c){
    include('php/connection.php'); 
    $arraygroup=array();
    try{    
   $sqlcateg="select item_name,item_orig_price from items where   itemscol='$b'
   and itemscateg='$a' and item_group='$c' group by item_group,itemscateg";
   $sth = $conn->prepare($sqlcateg);
    $sth->execute();
    $data = $sth->fetchAll();
    for($i=0;$i<sizeof($data);$i++){
        $arraygroup[0][$i]=$data[0][$i];
		$arraygroup[1][$i]=$data[1][$i];
		
    }
     return $arraygroup;
}
catch(PDOException $e){
    
}
}
//=================================================
function getItemCode(){   
include('php/connection.php'); 
    try{
        $sth = $conn->prepare("select count(*)as countall from items");
        $sth->execute();
        $result = $sth->fetchColumn(0);
        return str_pad($result+1, 6, '0', STR_PAD_LEFT);
    }
    catch(PDOException $e){

    }  
}
//========================end function to check if administrator or client
?>
