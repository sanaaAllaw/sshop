<!doctype html>
<html>
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
        <title>A simple, clean, and responsive HTML invoice template</title>
        <script type="">
          function printdiv(printpage)
{
var headstr = "<html><head><title></title></head><body>";
var footstr = "</body>";

var newstr = document.all.item(printpage).innerHTML;
var oldstr = document.body.innerHTML;
document.body.innerHTML = headstr+newstr+footstr;
window.print();
document.body.innerHTML = oldstr;
return false;
}
        </script>
        
    </head>

    <body>
        <?php

        include("menu.php");
        include("num_to_ar.php");
        updatestatus();

        ?>
        <div id='DivIdToPrint'>
        <style>
            .invoice-box{
                max-width:800px;
                margin:auto;
                padding:30px;
                border:1px solid #eee;
                box-shadow:0 0 10px rgba(0, 0, 0, .15);
                font-size:16px;
                line-height:24px;
                font-family:'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
                color:#555;
            }

            .invoice-box table{
                width:100%;
                line-height:inherit;
                text-align:left;
            }

            .invoice-box table td{
                padding:5px;
                vertical-align:top;
            }

            .invoice-box table tr td:nth-child(2){
                text-align:right;
            }

            .invoice-box table tr.top table td{
                padding-bottom:20px;
            }

            .invoice-box table tr.top table td.title{
                font-size:45px;
                line-height:45px;
                color:#333;
            }

            .invoice-box table tr.information table td{
                padding-bottom:40px;
            }

            .invoice-box table tr.heading td{
                background:#eee;
                border-bottom:1px solid #ddd;
                font-weight:bold;
            }

            .invoice-box table tr.details td{
                padding-bottom:20px;
            }

            .invoice-box table tr.item td{
                border-bottom:1px solid #eee;
            }

            .invoice-box table tr.item.last td{
                border-bottom:none;
            }

            .invoice-box table tr.total td:nth-child(2){
                border-top:2px solid #eee;
                font-weight:bold;
            }

            @media only screen and (max-width: 600px) {
                .invoice-box table tr.top table td{
                width:100%;
                display:block;
                text-align:center;
            }

            .invoice-box table tr.information table td{
                width:100%;
                display:block;
                text-align:center;
            }
            }
        </style>
        <div class="invoice-box" id="invoicebox">
            <table cellpadding="0" cellspacing="0">
                <tr class="top">
                    <td colspan="2">
                        <table>
                            <tr>
                                <td class="title">
                                    <img src="http://nextstepwebs.com/images/logo.png" style="width:100%; max-width:300px;">
                                </td>
                                <?php

                                $arraytrans=gettransdatetime();
                                if(sizeof($arraytrans)>0){?>

                                    <td>
                                        Invoice #: 123<br>
                                        Created: <?php echo $arraytrans[0][0];?><br>
                                        Due: <?php echo $arraytrans[1][0];?>
                                    </td>
                                    <?php }?>
                            </tr>
                        </table>
                    </td>
                </tr>
                <?php
                $arrayinfo=getpersoninfo();
                $suminvoice=getsumtrans();
                if(sizeof($arrayinfo)>0){

                    ?>
                    <a href="" onclick="printdiv('invoicebox');">Print invoice</a>
                    <tr class="information">
                        <td colspan="2">
                            <table>
                                <tr>
                                    <td>
                                        <?php $arrayName=getFullNameByCode($_SESSION['login_id']);?>
                                        Name: &nbsp;<?php echo $arrayName[0][0].'  '.$arrayName[1][0];?><br>

                                      
                                    </td>

                                    <td>
                                        <?php echo $arrayinfo[0][0];?>&nbsp;<?php echo $arrayinfo[1][0];?><br>
                                        <br>
                                        Mobile:&nbsp;<?php echo $arrayinfo[2][0];?>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <?php }?>
                <tr class="heading">
                    <td>
                        Payment Method
                    </td>

                    <td>
                        Check #
                    </td>
                </tr>

                <tr class="details">
                    <td>
                        On Delivery
                    </td>

                    <td>
                        <?php echo $suminvoice;?>&nbsp;L.L
                    </td>
                </tr>

                <tr class="heading">
                    <td>
                        Item
                    </td>

                    <td>
                        Price
                    </td>
                </tr>
                <?php

                $arrayMen=getAllinvoiceInfo();
                $sizevar=0;
                if(sizeof($arrayMen)>0){$sizevar=sizeof($arrayMen[0]);}
                for($i=0;$i<$sizevar;$i++){
                    ?>
                    <tr class="item">
                        <td>
                            <?php echo $arrayMen[0][$i].' ( '.$arrayMen[2][$i].' items )';?>
                        </td>

                        <td>
                            <?php echo $arrayMen[1][$i]*$arrayMen[2][$i];?>&nbsp;L.L
                        </td>
                    </tr>
                    <?php }?>


                <tr class="total">
                    <td></td>

                    <td>
                        Total: <?php echo $suminvoice;?>&nbsp;L.L
                    </td>
                </tr>
                <tr class="total">
                    <td></td>

                    <td>
                        <?php
                        echo convertNumberToWord($suminvoice);
                        ?>&nbsp;Lebanese pound, LBP

                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
