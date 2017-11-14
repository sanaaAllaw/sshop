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
      $arrayprofile=getprofileInfo();
    ?>
    <div class="menu" align="center">
  <div class="main">
        <div class="header" >
            <h1><?php echo $arrayprofile[0][0].' '.$arrayprofile[1][0];?> 's profile</h1>
        </div>
        <p></p>
            <form method="post" action="profile_action.php" enctype="multipart/form-data">
                <ul class="left-form">
                    
                    <h2>First name</h2>
                    <li>  
                        <input type="text"   placeholder="first name" required name="fname" value="<?php echo $arrayprofile[0][0];?>" readonly/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                    <h2>Last name</h2>
                    <li>
                        <input type="text"   placeholder="last name" required name="lname" value="<?php echo $arrayprofile[1][0];?>"/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                   <h2>Username</h2>
                   <li>
                        <input type="text"   placeholder="qty" required name="username" value="<?php echo $arrayprofile[2][0];?>" readonly="readonly"/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                  <h2>Password</h2>
                   <li>
                        <input type="password"   placeholder="qty" required name="password" value="<?php echo $arrayprofile[3][0];?>"/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                    
                    
                    <input type="submit"  value="Update profile">
                        <div class="clear"> </div>
                </ul>
                <ul class="right-form">
                    
                    <div>
                        <h2>Address</h2>
                   <li>
                        <input type="text"   placeholder="address" required name="address" value="<?php echo $arrayprofile[4][0];?>"/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                        <h2>Phone</h2>
                   <li>
                        <input type="text"   placeholder="phone"  name="phone" value="<?php echo $arrayprofile[5][0];?>"/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                        <h2>Mobile</h2>
                   <li>
                        <input type="text"   placeholder="mobile" required name="mobile" value="<?php echo $arrayprofile[6][0];?>"/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                        <h2>Email</h2>
                   <li>
                        <input type="text"   placeholder="email"  name="email" value="<?php echo $arrayprofile[7][0];?>"/>
                        <a href="#" class="icon ticker"> </a>
                        <div class="clear"> </div>
                    </li> 
                       
                     
                       
                        
                   
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