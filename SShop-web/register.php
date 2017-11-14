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
<script src="js/js_functions.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

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
	
		</div>
		<!-- registration-form -->
<div class="registration-form">
	<div class="container">
	<div class="dreamcrub">
			   	 <ul class="breadcrumbs">
                    <li class="home">
                       <a href="index.html" title="Go to Home Page">Home</a>&nbsp;
                       <span>&gt;</span>
                    </li>
                    <li class="women">
                       Registration
                    </li>
                </ul>
                <ul class="previous">
                	<li><a onclick="window.history.back()">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
			   </div>
		<h2>Registration</h2>
		<div class="registration-grids">
			<div class="reg-form">
				<div class="reg">
					 <p>Welcome, please enter the following details to continue.</p>
					 <p>If you have previously registered with us, <a href="account.php">click here</a></p>
					 <form method="POST" action="php/insertClient.php">
						 <ul>
							 <li class="text-info">First Name: </li>
							 <li><input type="text" value="" name="firstname" required="" autofocus="autofocus"></li>
						 </ul>
						 <ul>
							 <li class="text-info">Last Name: </li>
							 <li><input type="text" value="" name="lastname"></li>
						 </ul>				 
						<ul>
							 <li class="text-info">Email Or Username: </li>
							 <li><input type="text" value="" name="username" id="username" required="" onkeyup="checkUserNameExistance();"></li>
                             <li><label id="lblusercheck" ></label></li>
						 </ul>
						 <ul>
							 <li class="text-info">Password: </li>
							 <li><input type="password" value="" name="password" id="password" required=""></li>
						 </ul>
						 <ul>
							 <li class="text-info">Re-enter Password:</li>
							 <li><input type="password" value="" name="rpassword" required="" id="rpassword" onkeyup="checkPassword();"></li>
                             <li><label id="lblpasscheck" ></label></li>
						 </ul>
						 <ul>
							 <li class="text-info">Mobile Number:</li>
							 <li><input type="text" value="" name="mobile" required="" onkeyup="checkmobile();"></li>
                             <li><label id="lblmobilecheck" ></label></li>
						 </ul>						
						 <input type="submit" value="REGISTER NOW" Class="btn-disable" id="btn-reg" >
						  
					 </form>
				 </div>
			</div>
			<div class="reg-right">
				 <h3>Fashion</h3>
				 <div class="strip"></div>
				 <p style="color: maroon;">
                  Fashion is a popular style or practice, especially in clothing, footwear, accessories, makeup, body, or furniture. Fashion is a distinctive and often constant trend in the style in which a person dresses. It is the prevailing styles in behaviour and the newest creations of textile designers. Because the more technical term costume is regularly linked to the term "fashion", the use of the former has been relegated to special senses like fancy dress or masquerade wear, while "fashion" generally means clothing, including the study of it. Although aspects of fashion can be feminine or masculine, some trends are androgynous
                 </p>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- registration-form -->

		
		  
		  <div class="copyright text-center">
				<p>2017 SShop. All Rights Reserved | Design by  Sanaa Allaw</p>
		  </div>
          <style type="text/css">
    .btn-disable
        {
        cursor: not-allowed;
        pointer-events: none;

        /*Button disabled - CSS color class*/
        color: #c0c0c0;
        background-color: #ffffff;

        }
</style>
		</div>
		</div>
		<script>
        //======================check password if match
        function checkPassword(){
           var pPasswordvar=$("#password").val();  
           var prePasswordvar=$("#rpassword").val();
           
           if(pPasswordvar==prePasswordvar){
             $("#lblpasscheck").html("Password match"); 
             $("#lblpasscheck").css("color","Green"); 
             $("#btn-reg").removeClass( "btn-disable" );
           }
           else{
               $("#lblpasscheck").html("Password not match");
               $("#lblpasscheck").css("color","red");
               $("#btn-reg").addClass( "btn-disable" );
               
           }
        }
        //======================end check password if match
        //===============================
        function checkmobile(numbervariable){
             var boolcheckmobile=checkNumberValidation(numbervariable);
             if(boolcheckmobile==true){
                 
             }   else{
                 
             }
        }
        //====================================================check if username allready exist
    function checkUserNameExistance(){
        var pUsername=$("#username").val();
        
        if(pUsername==''){
           $("#btn-reg").addClass( "btn-disable" ); 
        }
        
        var dataCheckUser={
            userVar:pUsername
        }
        
        
         $.ajax({
                type: "POST",
                data: dataCheckUser,
                url: "php/checkUsernameExist.php",
                success: function(response)
                {  
                     if(response==1){
                     $("#btn-reg").removeClass( "btn-disable" );
                     $("#lblusercheck").html('Username available');
                     $("#lblusercheck").css("color","Green");
                     }
                     if(response==0){
                       $("#btn-reg").addClass( "btn-disable" );
                        $("#lblusercheck").html('Username allready exist');
                        $("#lblusercheck").css("color","red");
                     }
                 }
                  
                
             });
            
    }
     //====================================================end check if username allready exist
	</script>
</body>
</html>