<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>SShop</title>
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
	<!-- header-section-starts -->
	<?php
       
      include("menu.php");
    ?>
	<!-- header-section-ends -->
			
	<div class="banner">
		<div class="container">
<div class="banner-bottom">
	<div class="banner-bottom-left">
		<h2>B<br>U<br>Y</h2>
	</div>
	<div class="banner-bottom-right">
		<div  class="callbacks_container">
					<ul class="rslides" id="slider4">
					<li>
								<div class="banner-info">
									<h3>Smart But Casual</h3>
									<p>Start your shopping here...</p>
								</div>
							</li>
							<li>
								<div class="banner-info">
								   <h3>Shop Online</h3>
									<p>Start your shopping here...</p>
								</div>
							</li>
							<li>
								<div class="banner-info">
								  <h3>Pack your Bag</h3>
									<p>Start your shopping here...</p>
								</div>								
							</li>
						</ul>
					</div>
					<!--banner-->
	  			<script src="js/responsiveslides.min.js"></script>
			 <script>
			    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 4
			      $("#slider4").responsiveSlides({
			        auto: true,
			        pager:true,
			        nav:false,
			        speed: 500,
			        namespace: "callbacks",
			        before: function () {
			          $('.events').append("<li>before event fired.</li>");
			        },
			        after: function () {
			          $('.events').append("<li>after event fired.</li>");
			        }
			      });
			
			    });
			  </script>
	</div>
	<div class="clearfix"> </div>
</div>
	
	</div>
		</div>
		<!-- content-section-starts-here -->
		<div class="container">
			<div class="main-content">
				<div class="online-strip">
					
					<div class="col-md-4 shipping-grid">
						<div class="shipping">
							<img src="images/shipping.png" alt="" />
						</div>
						<div class="shipping-text">
							<h3>Free Shipping</h3>
							<p>on orders over $ 200</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-4 online-order">
						<p>Order online</p>
						<h3>Tel:81712458</h3>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="products-grid">
				<header>
					<h3 class="head text-center">Latest Products</h3>
				</header>
				<?php
                        
                        $arrayMen=getAllItemslast();
                         $sizevar=sizeof($arrayMen);
                        if($sizevar>0){
                        for($i=0;$i<sizeof($arrayMen[0]);$i++){
                            ?>
					<div class="col-md-4 product simpleCart_shelfItem text-center">
						<a href="single.php?pic=<?php echo $arrayMen[0][$i];?>&price=<?php echo $arrayMen[2][$i];?>&code=<?php echo $arrayMen[4][$i];?>"><img src="<?php echo $arrayMen[0][$i];?>" alt="" /></a>
						<div class="mask">
							<a href="single.php?pic=<?php echo $arrayMen[0][$i];?>&price=<?php echo $arrayMen[2][$i];?>&code=<?php echo $arrayMen[4][$i];?>">Quick View</a>
						</div>
						<a class="product_name" href="single.php?pic=<?php echo $arrayMen[0][$i];?>&price=<?php echo $arrayMen[2][$i];?>&code=<?php echo $arrayMen[4][$i];?>"><?php echo $arrayMen[1][$i];?></a>
						<p><a class="item_add" href="#"><i></i> <span class="item_price"><?php echo $arrayMen[2][$i];?></span></a></p>
					</div>
					<?php }}?>
					<div class="clearfix"></div>
				</div>
			</div>

		</div>
		<div class="other-products">
		<div class="container">
			<h3 class="like text-center">Featured Collection</h3>        			
				     <ul id="flexiselDemo3">
				      <?php
                        
                        $arrayMen=getAllItems();
                        $sizevar=sizeof($arrayMen);
                        if($sizevar>0){
                        for($i=0;$i<sizeof($arrayMen[0]);$i++){
                            ?>
						<li><a href="single.php?pic=<?php echo $arrayMen[0][$i];?>&price=<?php echo $arrayMen[2][$i];?>&code=<?php echo $arrayMen[4][$i];?>"><img src="<?php echo $arrayMen[0][$i];?>" class="img-responsive" alt="" /></a>
							<div class="product liked-product simpleCart_shelfItem">
							<a class="like_name" href="single.php?pic=<?php echo $arrayMen[0][$i];?>&price=<?php echo $arrayMen[2][$i];?>&code=<?php echo $arrayMen[4][$i];?>"><?php echo $arrayMen[1][$i];?></a>
							<p><a class="item_add" href="#"><i></i> <span class=" item_price"><?php echo $arrayMen[2][$i];?></span></a></p>
							</div>
						</li>
						 <?php
                    }
                        }
                    ?>
						
				     </ul>
				    <script type="text/javascript">
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
		
		</div>
		</div>
</body>
</html>