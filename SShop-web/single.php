<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
    <head>
        <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Single :: w3layouts</title>
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
        <!--/.navbar-collapse-->
        </nav>
        <!--/.navbar-->
        </div>
        </div>
        </div>
        <!-- content-section-starts -->
        <div class="container">
            <div class="products-page">
                <div class="products">


                    <div class="tags">


                    </div>

                </div>
                <div class="new-product">
                    <div class="col-md-5 zoom-grid">
                        <div class="flexslider">
                            <ul class="slides">
                                <li data-thumb="<?php echo $_GET['pic'];?>">
                                    <div class="thumb-image"> <img src="<?php echo $_GET['pic'];?>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
                                </li>
                                <li data-thumb="<?php echo $_GET['pic'];?>">
                                    <div class="thumb-image"> <img src="<?php echo $_GET['pic'];?>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
                                </li>
                                <li data-thumb="<?php echo $_GET['pic'];?>">
                                    <div class="thumb-image"> <img src="<?php echo $_GET['pic'];?>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
                                </li> 
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-7 dress-info">
                        <div class="dress-name">
                            <h3>LOREM IPSUM DRESS</h3>
                            <?php 
                            $arrayitem=getItembyItemCode($_GET['code']);?>
                            <span><?php echo $_GET['price'];?>L.L</span>
                            <div class="clearfix"></div>
                            <p><?php echo $arrayitem[0][0];?></p>
                            <p><?php echo $arrayitem[2][0];?></p>
                        </div>
                        <div class="span span1">  
                            <p class="left">Barcode</p>
                            <p class="right"><?php echo $arrayitem[5][0];?></p>
                            <div class="clearfix"></div>
                        </div>
                        <div class="span span2">
                            <p class="left">Group</p>
                            <p class="right"><?php echo $arrayitem[2][0];?></p>
                            <div class="clearfix"></div>
                        </div>
                        <div class="span span3">
                            <p class="left">Category</p>
                            <p class="right"><?php echo $arrayitem[6][0];?></p>
                            <div class="clearfix"></div>
                        </div>
                        <div class="span span4">
                            <p class="left">Price</p>
                             <p class="right"><?php echo $arrayitem[1][0];?> L.L</p>
                            <div class="clearfix"></div>
                        </div>
                        <div class="purchase">

                            
                            <div class="clearfix"></div>
                        </div>
                        <script src="js/imagezoom.js"></script>
                        <!-- FlexSlider -->
                        <script defer src="js/jquery.flexslider.js"></script>
                        <script>
                            // Can also be used with $(document).ready()
                            $(window).load(function() {
                                $('.flexslider').flexslider({
                                    animation: "slide",
                                    controlNav: "thumbnails"
                                });
                            });
                        </script>
                    </div>
                    <div class="clearfix"></div>
                    <div class="reviews-tabs">
                        <!-- Main component for a primary marketing message or call to action -->

                        <div class="tab-pane" id="source">

                        </div>        
                    </div>

                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="other-products products-grid">
            <div class="container">
                <header>
                    <h3 class="like text-center">Related Products</h3>   
                </header>     
                <?php

                $arrayMen=getAllItems();
                $sizevar=sizeof($arrayMen);
                if($sizevar>0){
                    for($i=0;$i<sizeof($arrayMen[0]);$i++){
                        ?>       
                        <div class="col-md-4 product simpleCart_shelfItem text-center">
                            <a href="#"><img src="<?php echo $arrayMen[0][$i];?>" alt="" /></a>
                            <div class="mask">
                                <a href="#">Quick View</a>
                            </div>
                            <a class="product_name" href="#">Sed ut perspiciatis</a>
                            <p><a class="item_add" href="#"><i></i> <span class="item_price"><?php echo $arrayMen[2][$i];?>L.L</span></a></p>
                        </div>
                        <?php } 
                }?> 
                <div class="clearfix"></div>
            </div>
        </div>




        <script src="js/responsive-tabs.js"></script>
        <script type="text/javascript">
            $( '#myTab a' ).click( function ( e ) {
                e.preventDefault();
                $( this ).tab( 'show' );
            } );
            $( '#moreTabs a' ).click( function ( e ) {
                e.preventDefault();
                $( this ).tab( 'show' );
            } );
            ( function( $ ) {
                // Test for making sure event are maintained
                $( '.js-alert-test' ).click( function () {
                    alert( 'Button Clicked: Event was maintained' );
                } );
                fakewaffle.responsiveTabs( [ 'xs', 'sm' ] );
            } )( jQuery );
        </script>

    </body>
</html>