<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap-3.1.1.min.js"></script>
 <head>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <!-- Custom Theme files -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Eshop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
            Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--webfont-->
        <!-- for bootstrap working -->
        <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
        <!-- //for bootstrap working -->
        <!-- cart -->
        <script src="js/simpleCart.min.js"> </script>
        <!-- cart -->
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
        <meta charset="utf-8">
        <title></title>
        <script type="">
            function printDiv() 
            {
               var printContents = document.getElementById('#DivIdToPrint').innerHTML;
    var originalContents = document.body.innerHTML;
     document.body.innerHTML = printContents;
     window.print();
     document.body.innerHTML = originalContents;                   
              
    

            }
        </script>
        
    </head>
     <body>
        <?php

        include("menu.php");
      

        ?>
        </body>
<?php


if(isset($_POST['items'])){
$arrayitem=$_POST['items'];
}
if(isset($_POST['supplier'])){
$arraysupp=$_POST['supplier'];
}
if(isset($_POST['categorie'])){
$arraycategorie=$_POST['categorie'];
}
if(isset($_POST['group'])){
$arraygroup=$_POST['group'];
}
if(isset($_POST['categ'])){
$arraycateg=$_POST['categ'];
}

$fromdate=$_POST['date1'];

$todate=$_POST['date2'];
$request_sqlsupp='';
$request_sqlitem='';
$request_sqlcategorie='';
$request_sqlgroup='';
$request_sqlcateg='';
$dateBetween='';
if(isset($_POST['date1']) and isset($_POST['date2'])){
    if(($_POST['date1']!="") and ($_POST['date2'])!=""){   
        $dateBetween="(date between '".$_POST['date1']."' and '".$_POST['date2']."') and"; 
    }
}
if(isset($_POST['supplier'])){
    if($_POST['supplier']!=''){
        $allSup="";
        $numbSup=count($_POST['supplier']);
        if($numbSup>1){
            $allSup.=$_POST['supplier'][0];
            for($i=1;$i<$numbSup;$i++){
                $allSup.=','.$_POST['supplier'][$i];
            }
        }
        else if($numbSup==1){
            $allSup.=$_POST['supplier'][0];
        }
        $array_supp=explode(',',$allSup);
        $request_sqlsupp=$request_sqlsupp.'(';
        for($i=0;$i<sizeof($array_supp);$i++){
            $request_sqlsupp=$request_sqlsupp."(movements.supplier like '%$array_supp[$i]%')or";   
        } 
        $request_sqlsupp='and('.substr($request_sqlsupp,sizeof($request_sqlsupp),-2);
        $request_sqlsupp=$request_sqlsupp.')';
    }
}
//=======================================================
if(isset($_POST['items'])){
    if($_POST['items']!=''){
        $allSup="";
        $numbSup=count($_POST['items']);
        if($numbSup>1){
            $allSup.=$_POST['items'][0];
            for($i=1;$i<$numbSup;$i++){
                $allSup.=','.$_POST['items'][$i];
            }
        }
        else if($numbSup==1){
            $allSup.=$_POST['items'][0];
        }
        $array_supp=explode(',',$allSup);
        $request_sqlitem=$request_sqlitem.'(';
        for($i=0;$i<sizeof($array_supp);$i++){
            $request_sqlitem=$request_sqlitem."(items.name like '%$array_supp[$i]%')or";   
        } 
        $request_sqlitem='and('.substr($request_sqlitem,sizeof($request_sqlitem),-2);
        $request_sqlitem=$request_sqlitem.')';

    }
}
//=======================================================
if(isset($_POST['categorie'])){
    if($_POST['categorie']!=''){
        $allSup="";
        $numbSup=count($_POST['categorie']);
        if($numbSup>1){
            $allSup.=$_POST['categorie'][0];
            for($i=1;$i<$numbSup;$i++){
                $allSup.=','.$_POST['categorie'][$i];
            }
        }
        else if($numbSup==1){
            $allSup.=$_POST['categorie'][0];
        }
        $array_supp=explode(',',$allSup);
        $request_sqlcategorie=$request_sqlcategorie.'(';
        for($i=0;$i<sizeof($array_supp);$i++){
            $request_sqlcategorie=$request_sqlcategorie."(Item_group like '%$array_supp[$i]%')or";   
        } 
        $request_sqlcategorie='and('.substr($request_sqlcategorie,sizeof($request_sqlcategorie),-2);
        $request_sqlcategorie=$request_sqlcategorie.')';

    }
}
//=======================================================
if(isset($_POST['group'])){
    if($_POST['group']!=''){
        $allSup="";
        $numbSup=count($_POST['group']);
        if($numbSup>1){
            $allSup.=$_POST['group'][0];
            for($i=1;$i<$numbSup;$i++){
                $allSup.=','.$_POST['group'][$i];
            }
        }
        else if($numbSup==1){
            $allSup.=$_POST['group'][0];
        }
        $array_supp=explode(',',$allSup);
        $request_sqlgroup=$request_sqlgroup.'(';
        for($i=0;$i<sizeof($array_supp);$i++){
            $request_sqlgroup=$request_sqlgroup."(Itemscol like '%$array_supp[$i]%')or";   
        } 
        $request_sqlgroup='and('.substr($request_sqlgroup,sizeof($request_sqlgroup),-2);
        $request_sqlgroup=$request_sqlgroup.')';

    }
}
//=======================================================
if(isset($_POST['categ'])){
    if($_POST['categ']!=''){
        $allSup="";
        $numbSup=count($_POST['categ']);
        if($numbSup>1){
            $allSup.=$_POST['categ'][0];
            for($i=1;$i<$numbSup;$i++){
                $allSup.=','.$_POST['categ'][$i];
            }
        }
        else if($numbSup==1){
            $allSup.=$_POST['categ'][0];
        }
        $array_supp=explode(',',$allSup);
        $request_sqlcateg=$request_sqlcateg.'(';
        for($i=0;$i<sizeof($array_supp);$i++){
            $request_sqlcateg=$request_sqlcateg."(Itemscateg like '%$array_supp[$i]%')or";   
        } 
        $request_sqlcateg='and('.substr($request_sqlcateg,sizeof($request_sqlcateg),-2);
        $request_sqlcateg=$request_sqlcateg.')';

    }
}


//echo $request_sqlsupp.'</br>';

//echo $request_sqlitem.'</br>'; 

//echo $request_sqlcategorie.'</br>';

//echo $request_sqlgroup.'</br>';

//echo $request_sqlcateg.'</br>';

 $dateBetween='('.substr($dateBetween,sizeof($dateBetween),-3);
//echo $dateBetween;

$sqlcateg="select items.itemcode,items.name,movtype,movements.qty,items.qty,date,movements.supplier 
from items,movements where items.itemcode=movements.itemcode and $dateBetween  $request_sqlsupp $request_sqlitem
 $request_sqlcategorie $request_sqlgroup $request_sqlcateg group by itemcode";
//echo $sqlcateg;
$sth = $conn->prepare($sqlcateg);
$sth->execute();
$data = $sth->fetchAll();

?>
<div class="container">
   <table style="background-color: antiquewhite">
       <tr>
           <td style="font-weight: bold">Company: </td><td>S-Shop</td>
       </tr>
       <tr>
           <td style="font-weight: bold">Date: </td><td><?php echo date('Y-M-D');?></td>
       </tr>
   </table>
    <h2 align="center">Stock Card report</h2>
    <p></p>                                                                                      
    <div class="table-responsive">          
        <table class="table" >
            <thead>
                <tr style="font-weight: bold;font-size: 12px; background-color: lightgray">
                    <th>#</th>
                    <th>Item Code</th>
                    <th>Item Description</th>
                    <th>Movement Type</th>
                    <th>Movement Qty</th>
                    <th>Available Qty</th>
                    <th>Date</th>
                    <th>Supplier</th>
                    
                    
                </tr>
            </thead>
            <tbody>
            <?php 
               $movsumqtyvar=0;
                $avsumqty=0;
                $sumtotprice=0;
                $sumavqty=0;
              for($i=0;$i<sizeof($data);$i++){
                  $movsumqtyvar=$movsumqtyvar+$data[$i][3];
                   $avsumqty=$avsumqty+$data[$i][4];
            ?>   
                <tr>
                    <td><?php echo $i+1;?></td>
                    <td><?php echo $data[$i][0];?></td>
                    <td><?php echo $data[$i][1];?></td>
                    <td><?php echo $data[$i][2];?></td>
                    <td style="color:green"><?php echo $data[$i][3];?></td>
                    <td style="color:red"><?php echo $data[$i][4];?></td>
                    <td><?php echo $data[$i][5];?></td>
                    <td><?php echo $data[$i][6];?></td>
                    
                </tr>
                <?php }?>
            </tbody>
            <tr style="font-weight: bold;font-size: 18px; background-color: lightgray">
                <td>Total</td>
                <td></td>
                    <td></td>
                    <td></td>
                    <td><?php echo $movsumqtyvar;?></td>
                    <td><?php echo $avsumqty;?></td>
                   <td></td>
                   <td></td>
                   <td></td>
                    <td></td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>