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
        $sqlcateg="select item_group from items where itemscol='$categ' group by item_group";
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
function getAllItems(){
    include('php/connection.php'); 
    $arrayitem=array();
    try{    
        $sqlcateg="select itempic,name,price,item_group,itemcode,qty from items group by itemcode";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][$i]=$data[$i][0];
            $arrayitem[1][$i]=$data[$i][1];
            $arrayitem[2][$i]=$data[$i][2];
            $arrayitem[3][$i]=$data[$i][3];
            $arrayitem[4][$i]=$data[$i][4];
            $arrayitem[5][$i]=$data[$i][5];
        }
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}
function getAllItemslast(){
    include('php/connection.php'); 
    $arrayitem=array();
    try{    
        $sqlcateg="select itempic,name,price,item_group,itemcode from items
        group by itemcode ORDER BY itemcode DESC";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][$i]=$data[$i][0];
            $arrayitem[1][$i]=$data[$i][1];
            $arrayitem[2][$i]=$data[$i][2];
            $arrayitem[3][$i]=$data[$i][3];
            $arrayitem[4][$i]=$data[$i][4];
        }
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}
function getcounttrans(){
    include('php/connection.php'); 
     $loginvar=$_SESSION['login_id'];
    $countvar='';
    try{    
        $sqlcateg="select count(*)as countvar from transaction where login_id='$loginvar' and status='1' ";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        $countvar=$data[0][0];
        return $countvar;
    }
    catch(PDOException $e){

    }
}
function getFullNameByCode($loginvar){
    include('php/connection.php'); 
    try{      
        $sqlcateg="select firstname,lastname from users where username='$loginvar'";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        $arrayName[0][0]=$data[0][0];
        $arrayName[1][0]=$data[0][1];
        return $arrayName;
    }
    catch(PDOException $e){

    }
}         
function getsumtrans(){
    include('php/connection.php'); 
     $loginvar=$_SESSION['login_id'];
    $countvar='';
    try{        
        $sqlcateg="select sum(price*qty)as countvar from transaction where login_id='$loginvar' and status='1' ";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        $countvar=$data[0][0];
        return $countvar;
    }
    catch(PDOException $e){

    }
}
function getsumtransspec($a){
    include('php/connection.php'); 
     $loginvar=$_SESSION['login_id'];
    $countvar='';
    try{        
        $sqlcateg="select sum(price*qty)as countvar from transaction where invoiceNum='$a' and status='0' ";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        $countvar=$data[0][0];
        return $countvar;
    }
    catch(PDOException $e){

    }
}
function getAllItemstrans(){
    include('php/connection.php'); 

    $loginvar=$_SESSION['login_id'];
    $arrayitem=array();
    try{    
        $sqlcateg="select itempic,items.name,transaction.price,item_group,itemcode,time,date,transaction.qty from transaction,items
        where items.itemcode=transaction.item_name and login_id='$loginvar' and status='1' group by itemcode ";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][$i]=$data[$i][0];
            $arrayitem[1][$i]=$data[$i][1];
            $arrayitem[2][$i]=$data[$i][2];
            $arrayitem[3][$i]=$data[$i][3];
            $arrayitem[4][$i]=$data[$i][4];
            $arrayitem[5][$i]=$data[$i][5];
            $arrayitem[6][$i]=$data[$i][6];
            $arrayitem[7][$i]=$data[$i][7];
        }
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}
function gettransaction(){
    include('php/connection.php'); 
    $arrayitem=array();
    try{    
        $sqlcateg="select item_pic,item_name,item_orig_price,item_group,item_code from items
        group by item_code ORDER BY item_code DESC";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][$i]=$data[$i][0];
            $arrayitem[1][$i]=$data[$i][1];
            $arrayitem[2][$i]=$data[$i][2];
            $arrayitem[3][$i]=$data[$i][3];
            $arrayitem[4][$i]=$data[$i][4];
        }
        return $arrayitem;
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
        $sqlcateg="select itemscateg from items where item_group='$group' and itemscol='$categ' group by item_group,itemscateg";
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
        $sqlcateg="select name,price,item_group,itempic,itemcode,qty from items where   itemscol='$c'
        and itemscateg='$a' and item_group='$b' ";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arraygroup[0][$i]=$data[$i][0];
            $arraygroup[1][$i]=$data[$i][1];
            $arraygroup[2][$i]=$data[$i][2];
            $arraygroup[3][$i]=$data[$i][3];
            $arraygroup[4][$i]=$data[$i][4];
             $arraygroup[5][$i]=$data[$i][5];
        }
        return $arraygroup;
    }      
    catch(PDOException $e){

    }
}
//=================================================
function getItembyItemCode($a){
    include('php/connection.php'); 
    $arraygroup=array();
    try{    
        $sqlcateg="select item_name,item_orig_price,item_group,item_pic,item_code,item_barcode,itemscol from items where item_code='$a'";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arraygroup[0][$i]=$data[$i][0];
            $arraygroup[1][$i]=$data[$i][1];
            $arraygroup[2][$i]=$data[$i][2];
            $arraygroup[3][$i]=$data[$i][3];
            $arraygroup[4][$i]=$data[$i][4];
            $arraygroup[5][$i]=$data[$i][5];
            $arraygroup[6][$i]=$data[$i][6];
        }
        return $arraygroup;
    }      
    catch(PDOException $e){

    }
}
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
function getInvoiceCode(){   
    include('php/connection.php'); 
    try{
        $sth = $conn->prepare("select invoiceNum from transaction order by invoiceNum desc limit 1");
        $sth->execute();
        $result = $sth->fetchColumn(0);
        return str_pad($result+1, 6, '0', STR_PAD_LEFT);
    }
    catch(PDOException $e){
    }  
}
function getadminuserPass(){   
    include('php/connection.php'); 
    try{
        $sth = $conn->prepare("select count(*)as countall from users");
        $sth->execute();
        $result = $sth->fetchColumn(0);  
        return 'admin_'.str_pad($result+1, 6, '0', STR_PAD_LEFT);
    }
    catch(PDOException $e){
    }  
}
function getsuppcode(){   
    include('php/connection.php'); 
    try{
        $sth = $conn->prepare("select count(*)as countall from supplier");
        $sth->execute();
        $result = $sth->fetchColumn(0);  
        return str_pad($result+1, 6, '0', STR_PAD_LEFT);
    }
    catch(PDOException $e){
    }  
}
function getcustcode(){   
    include('php/connection.php'); 
    try{
        $sth = $conn->prepare("select count(*)as countall from customer");
        $sth->execute();
        $result = $sth->fetchColumn(0);  
        return str_pad($result+1, 6, '0', STR_PAD_LEFT);
    }
    catch(PDOException $e){
    }  
}
//========================end function to check if administrator or client
 function getAllinvoiceInfo(){
    include('php/connection.php'); 

    $loginvar=$_SESSION['login_id'];
    $arrayitem=array();
    try{             
        $sqlcateg="select items.name,transaction.price,transaction.qty from transaction,items
        where items.itemcode=transaction.item_name and login_id='$loginvar' and status='0' group by itemcode";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][$i]=$data[$i][0];
            $arrayitem[1][$i]=$data[$i][1];
            $arrayitem[2][$i]=$data[$i][2];
           
        }
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}
function getAllinvoiceInfospec($a){
    include('php/connection.php'); 

    $loginvar=$_SESSION['login_id'];
    $arrayitem=array();
    try{             
        $sqlcateg="select items.item_name,price,qty from transaction,items
        where items.item_code=transaction.item_name and invoiceNum='$a' and status='0' group by item_code ";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][$i]=$data[$i][0];
            $arrayitem[1][$i]=$data[$i][1];
            $arrayitem[2][$i]=$data[$i][2];
           
        }
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}
function gettransdatetimespec($a){
    include('php/connection.php'); 

    $loginvar=$_SESSION['login_id'];
    $arrayitem=array();
    try{    
        $sqlcateg="select date,time from transaction
        where  invoiceNum='$a' and status='0' group by item_name ";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        
            for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][0]=$data[0][0];
            $arrayitem[1][0]=$data[0][1];
           
        }
           
        
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}

 function gettransdatetime(){
    include('php/connection.php'); 

    $loginvar=$_SESSION['login_id'];
    $arrayitem=array();
    try{    
        $sqlcateg="select date,time from transaction
        where  login_id='$loginvar' and status='0' group by item_name ";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        
            for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][0]=$data[0][0];
            $arrayitem[1][0]=$data[0][1];
           
        }
           
        
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}
function getpersoninfo(){
    include('php/connection.php'); 

    $loginvar=$_SESSION['login_id'];
    $arrayitem=array();
    try{      
        $sqlcateg="select firstname,lastname,mobile from users where Username='$loginvar'";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][$i]=$data[$i][0];
            $arrayitem[1][$i]=$data[$i][1];
            $arrayitem[2][$i]=$data[$i][2];
           
        }
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}
function updatestatus(){
    include('php/connection.php'); 
    $invoicenum=getInvoiceCode();
    $loginvar=$_SESSION['login_id'];
    $arrayitem=array();
    try{    
        $sqlcateg="update transaction set status=0,`invoiceNum`='$invoicenum' where login_id='$loginvar' and status=1";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
    }
    catch(PDOException $e){

    }
}
function convertNumberToWord($num = false)
{
    $num = str_replace(array(',', ' '), '' , trim($num));
    if(! $num) {
        return false;
    }
    $num = (int) $num;
    $words = array();
    $list1 = array('', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten', 'eleven',
        'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen'
    );
    $list2 = array('', 'ten', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety', 'hundred');
    $list3 = array('', 'thousand', 'million', 'billion', 'trillion', 'quadrillion', 'quintillion', 'sextillion', 'septillion',
        'octillion', 'nonillion', 'decillion', 'undecillion', 'duodecillion', 'tredecillion', 'quattuordecillion',
        'quindecillion', 'sexdecillion', 'septendecillion', 'octodecillion', 'novemdecillion', 'vigintillion'
    );
    $num_length = strlen($num);
    $levels = (int) (($num_length + 2) / 3);
    $max_length = $levels * 3;
    $num = substr('00' . $num, -$max_length);
    $num_levels = str_split($num, 3);
    for ($i = 0; $i < count($num_levels); $i++) {
        $levels--;
        $hundreds = (int) ($num_levels[$i] / 100);
        $hundreds = ($hundreds ? ' ' . $list1[$hundreds] . ' hundred' . ' ' : '');
        $tens = (int) ($num_levels[$i] % 100);
        $singles = '';
        if ( $tens < 20 ) {
            $tens = ($tens ? ' ' . $list1[$tens] . ' ' : '' );
        } else {
            $tens = (int)($tens / 10);
            $tens = ' ' . $list2[$tens] . ' ';
            $singles = (int) ($num_levels[$i] % 10);
            $singles = ' ' . $list1[$singles] . ' ';
        }
        $words[] = $hundreds . $tens . $singles . ( ( $levels && ( int ) ( $num_levels[$i] ) ) ? ' ' . $list3[$levels] . ' ' : '' );
    } //end for loop
    $commas = count($words);
    if ($commas > 1) {
        $commas = $commas - 1;
    }
    return implode(' ', $words);
}
function getprofileInfo(){
    include('php/connection.php'); 

    $loginvar=$_SESSION['login_id'];
    $arrayitem=array();
    try{    
        $sqlcateg="select firstname,lastname,username,password,address,phone,mobile,email from users
        where username='$loginvar'";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][$i]=$data[$i][0];
            $arrayitem[1][$i]=$data[$i][1];
            $arrayitem[2][$i]=$data[$i][2];
            $arrayitem[3][$i]=$data[$i][3];
            $arrayitem[4][$i]=$data[$i][4];
            $arrayitem[5][$i]=$data[$i][5];
            $arrayitem[6][$i]=$data[$i][6];
            $arrayitem[7][$i]=$data[$i][7];
           
        }
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}
function getallsupp(){
    include('php/connection.php'); 

    $loginvar=$_SESSION['login_id'];
    $arrayitem=array();
    try{    
        $sqlcateg="select fname,lname from supplier";
        $sth = $conn->prepare($sqlcateg);
        $sth->execute();
        $data = $sth->fetchAll();
        for($i=0;$i<sizeof($data);$i++){
            $arrayitem[0][$i]=$data[$i][0];
            $arrayitem[1][$i]=$data[$i][1];
            
           
        }
        return $arrayitem;
    }
    catch(PDOException $e){

    }
}
$countries = array("Lebanon","Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", 
"Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan",
 "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", 
 "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory",
  "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde",
   "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands",
    "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica",
     "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica",
      "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", 
      "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", 
      "France Metropolitan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", 
      "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", 
      "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", 
      "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", 
      "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
       "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", 
       "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia",  "Lesotho", "Liberia", 
       "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of",
        "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique",
         "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of",
          "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal",
           "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria",
            "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", 
            "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico",
             "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", 
             "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", 
             "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands",
              "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena",
               "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", 
               "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", 
               "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago",
                "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", 
                "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", 
                "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", 
                "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe");

?>