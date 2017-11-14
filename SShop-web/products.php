<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Products :: w3layouts</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/component.css" rel='stylesheet' type='text/css' />
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
        <!--/.navbar-collapse-->
        </nav>
        <!--/.navbar-->
        </div>
        </div>
        </div>

        <!-- content-section-starts -->
        <div class="container">
            <div class="products-page">
                
                <div class="new-product">
                    <div class="new-product-top">
                        <ul class="product-top-list">
                            <li><a href="index.html">Home</a>&nbsp;<span>&gt;</span></li>
                            <li><span class="act">Best Sales</span>&nbsp;</li>
                        </ul>
                        
                        <div class="clearfix"></div>
                    </div>
                    <div class="mens-toolbar">
                       
                        
                        <div class="clearfix"></div>        
                    </div>
                    <div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">
                        <div class="cbp-vm-options">
                            <a href="#" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected" data-view="cbp-vm-view-grid" title="grid">Grid View</a>
                            <a href="#" class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list" title="list">List View</a>
                        </div>
                       
                        <div class="clearfix"></div>
                        <ul>
                        <?php
                        $a=$_GET['a'];
                        $b=$_GET['b'];
                        $c=$_GET['c'];
                        $arrayMen=getAllItemsname($a,$b,$c);
                        for($i=0;$i<sizeof($arrayMen[0]);$i++){
                            ?>
                            <li>
                            <a class="cbp-vm-image" href="single.php?pic=<?php echo $arrayMen[3][$i];?>&price=<?php echo $arrayMen[1][$i];?>&code=<?php echo $arrayMen[4][$i];?>">
                                <div class="simpleCart_shelfItem">
                                <div class="view view-first">
                                    <div class="inner_content clearfix">
                                        <div class="product_image">
                                            <img src="<?php echo $arrayMen[3][$i];?>" class="img-responsive" alt=""/>
                                            <div class="mask">
                                                <div class="info">Quick View</div>
                                            </div>
                                            <div class="product_container">
                                                <div class="cart-left">
                                                    <p class="title" id="<?php echo 'spans'.$i;?>"><?php echo $arrayMen[4][$i];?></p>
                                                </div>
                                                <div class="pricey"><span class="item_price" id="<?php echo 'spanprice'.$i;?>"><?php echo $arrayMen[1][$i];?></span></div>
                                                <div class="clearfix"></div>
                                            </div>        
                                        </div>
                                    </div>
                                </div>
                            </a>
                            <div class="cbp-vm-details">
                                <?php echo $arrayMen[0][$i];?>
                            </div>
                             <div class="cbp-vm-details" style="color: green;">
                                Available qty:&nbsp;<?php  if($arrayMen[5][$i]>0){echo $arrayMen[5][$i];}else{echo "Out of stock";};?>
                            </div>
                            <a class="cbp-vm-icon cbp-vm-add item_add"  href="#" onClick="insertTrans(<?php echo $i;?>)">Add to cart</a>
                        </div>
                        </li>
                        <?php
                    }
                    ?>
                    </ul>
                </div>
                <script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
                <script src="js/classie.js" type="text/javascript"></script>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
        </div>
        <!-- content-section-ends -->
        <div class="other-products">
            <div class="container">
                <h3 class="like text-center">Featured Collection</h3>                    
                <ul id="flexiselDemo3">
                      <?php
                        
                        $arrayMen=getAllItems();
                        $sizevar=0;
                        if(sizeof($arrayMen)>0){$sizevar=sizeof($arrayMen[0]);}
                        for($i=0;$i<$sizevar;$i++){
                            ?>
                        <li><a href="single.php?pic=<?php echo $arrayMen[0][$i];?>&price=<?php echo $arrayMen[2][$i];?>&code=<?php echo $arrayMen[4][$i];?>"><img src="<?php echo $arrayMen[0][$i];?>" class="img-responsive" alt="" /></a>
                            <div class="product liked-product simpleCart_shelfItem">
                            <a class="like_name" href="single.php?pic=<?php echo $arrayMen[0][$i];?>&price=<?php echo $arrayMen[2][$i];?>"><?php echo $arrayMen[1][$i];?></a>
                            <p><a class="item_add" href="#"><i></i> <span class=" item_price"><?php echo $arrayMen[2][$i];?></span></a>
                            </p>
                            </div>
                        </li>
                         <?php
                    }
                    ?>
                        
                     </ul>
                <script type="text/javascript">
                    function insertTrans(counterspan){
                       
                        var item_name=$('#spans'+counterspan).text();
                        var price=$('#spanprice'+counterspan).text();
                        
                        inserttransAction(item_name,price);
                    }
                    function inserttransAction(item_name,price){
                        
                        var users_data = {
                            item_name: item_name,
                            price: price

                        };
                        
                        $.ajax({
                            type: "POST",
                            data: users_data,
                            url: "insertTrans.php",
                            success: function(response)
                            {    
                               
                            }
                        });
                    }
                    $(window).load(function() {
                        $("#flexiselDemo3").flexisel({
                            visibleItems: 4,
                            animationSpeed: 1000,
                            autoPlay: true,
                            autoPlaySpeed: 3000,            
                            pauseOnHover: true,
                            enableResponsiveBreakpoints: true,
                            responsiveBreakpoints: { 
                                portrait: { 
                                    changePoint:480,
                                    visibleItems: 1
                                }, 
                                landscape: { 
                                    changePoint:640,
                                    visibleItems: 2
                                },
                                tablet: { 
                                    changePoint:768,
                                    visibleItems: 3
                                }
                            }
                        });

                    });
                </script>
                <script type="text/javascript" src="js/jquery.flexisel.js"></script>
            </div>
        </div>
        <!-- content-section-ends-here -->

        <div class="clearfix"></div>
        </div>
        </div>

        </div>
        </div>
    </body>
</html>