<!DOCTYPE html>
<html >
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
  

    
        <link rel="stylesheet" href="css/style-comp.css">

  <head>
  
    <meta charset="UTF-8">
    <title>Login Form</title>
    
    
  
    
    
  </head>

  <body>
<?php
	  include("menu.php");
	?>
    <div class="menu" align="center">
  <div class="main">
        <div class="header" >
            <h1>Add New items</h1>
        </div>
        <p></p>
            <form method="post" action="items_action.php" enctype="multipart/form-data">
                <ul class="left-form">
                    <h2>New item</h2>
                    <li>
                        <input type="text"   placeholder="code" required name="code" value="<?php echo getItemCode();?>" readonly/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                    <li>
                        <input type="text"   placeholder="item name" required name="name"/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                   
                   <li>
                        <input type="text"   placeholder="qty" required name="qty"/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                   <li>
                        <li><input class="fileChoose" name="logo" type="file"  id="logo"></li>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                    
                    
                    <input type="submit"  value="Create item">
                        <div class="clear"> </div>
                </ul>
                <ul class="right-form">
                    
                    <div>
                        <li><input type="text"  placeholder="supplier" name="supplier"/></li>
                        <li><select name="categorie" id="categorie">                                     
                        <option value="Men">Men</option>
                        <option value="Women">Women</option>
                        <option value="Kids">Kids</option>
                        </select></li>
                        <li><select name="group" id="group">                                     
                        <option value="Clothes">Clothes</option>
                        <option value="Watches">Watches</option>
                       
                        </select></li>
                        <li><input type="text"  placeholder="price" required name="price"/></li>
                       
                        <li><input type="text"  placeholder="barcode" name="barcode"/></li>
                     
                       
                        
                    </div>
                    <div class="clear"> </div>
                </ul>
                <div class="clear"> </div>
                    
            </form>
            
        </div>
            <!-----start-copyright---->
                      
    </div>
   

        <script src="js-login/index.js"></script>

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
                        </div>

                       
                        
                    </div>
                </div>  
            </section> 
        </div>
    </body>
</html>