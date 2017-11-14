<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Chectout :: w3layouts</title>
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
    </head>
    <body>
        <?php
        include("menu.php");
        ?>
        </nav>
        <!--/.navbar-->
        </div>
        </div>
        </div>
        <!-- checkout -->
        <div class="cart-items">
            <div class="container">
                <div class="dreamcrub">
                    <ul class="breadcrumbs">
                        <li class="home">
                            <a href="index.html" title="Go to Home Page">Home</a>&nbsp;
                            <span>&gt;</span>
                        </li>
                        <li class="women">
                            Cart
                        </li>
                    </ul>
                    
                    <div class="clearfix"></div>
                </div>
                <h2>MY SHOPPING BAG (<?php echo getcounttrans();?>)</h2>
                <div class="cart-gd">
                    <script>
						if($('#sumtrans').val()==null){
							$("#sumtransbtn").attr('disabled','disabled');
						}else{
							$("#sumtransbtn").removeAttr('disabled');
						}
						function removecard(a){
                                $('#cart-header'+a).fadeOut('slow', function(c){
                                    $('#cart-header'+a).remove();
                                });
                                var itemsvar=$("#itemsvals"+a).val();
                                var datatrans={
                                    itemcode:itemsvar
                                }
                                //alert(itemsvar);
                                 $.ajax({
                                    type: "POST",
                                    data: datatrans,
                                    url: "deleteitem.php",
                                    success: function(response)
                                    {  
                                       
                                    }


                                });
                            }      
                      
                    </script>
                    <?php

                    $arrayMen=getAllItemstrans();
                    
                    
                    $sizevar=0;
                        if(sizeof($arrayMen)>0){$sizevar=sizeof($arrayMen[0]);$itemsvars=  $arrayMen[0][0];}
                        for($i=0;$i<$sizevar;$i++){

                        ?>
                        <div class="cart-header" id="cart-header<?php echo $i;?>">
                            <div class="close1" onclick="removecard(<?php echo $i;?>)" id="closes"+<?php echo $i;?> onclick="removeitem(<?php echo $i;?>)"> </div>
                            <div class="cart-sec simpleCart_shelfItem">
                                <div class="cart-item cyc">
                                    <img src="<?php echo $arrayMen[0][$i];?>" class="img-responsive" alt="">
                                </div>
                                <div class="cart-item-info">
                                    <input type="hidden" id="itemsvals<?php echo $i;?>" value="<?php echo $arrayMen[4][$i];?>"/>
                                    <h3><a href="#" id="hrefs"+<?php echo $i;?>> <?php echo $arrayMen[1][$i];?> </a><span>Pickup time:&nbsp;<?php echo $arrayMen[5][$i];?></span></h3>
                                    <ul class="qty">
                                        <li><p> order value:&nbsp;<?php echo $arrayMen[7][$i];?></p></li>

                                    </ul>
                                    <div class="delivery">
                                        <p>Service Charges : &nbsp;<?php echo $arrayMen[2][$i]*$arrayMen[7][$i];?></p>
                                        <span>Delivered at &nbsp;<?php echo $arrayMen[6][$i];?></span>
                                        <div class="clearfix"></div>
                                    </div>    
                                </div>
                                <div class="clearfix"></div>

                            </div>
                        </div>                    
                        <script>
                        </script>
                        <?php }?>

                </div>
            </div>
        </div>

        <!-- //checkout -->    
        <div class="news-letter">
            <div class="container">
                <div class="join">
                    <h6>Total</h6>
                    <div class="sub-left-right">
                        <form method="POST" action="invoice.php">                                                                                                                                     
                            <input type="text" value="<?php echo getsumtrans();?>" readonly style="color:red" id="sumtrans"/>
                            <input type="submit" value="Complete transaction" id="sumtransbtn"/>
                        </form>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>

        </div>
        </div>
    </body>
</html>