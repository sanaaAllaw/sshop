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
      <script src="js/chosen.jquery.js"></script> 
                  <link rel="stylesheet" href="css/chosen.css">


    <link rel="stylesheet" href="css/style_comp.css">

    <head>

        <meta charset="UTF-8">
        <title>supplier</title>





    </head>

    <body>
        <?php
        include("menu.php");

        ?>
        <div class="menu" align="center">
            <div class="main">
                <div class="header" >
                    <h1>New Supplier</h1>
                </div>
                <p></p>


                <form method="post" action="supplier_action.php" enctype="multipart/form-data">
                    <ul class="left-form">
                        <h2>Supplier Code</h2>
                        <li>  
                            <input type="text"   placeholder="supplier code" required name="suppliercode" readonly 
                                value="<?php echo getsuppcode();?>"/>

                            <div class="clear"> </div>
                        </li> 
                        <h2>First name</h2>
                        <li>  
                            <input type="text"   placeholder="first name" required name="fname" />

                            <div class="clear"> </div>
                        </li> 
                        <h2>Last name</h2>
                        <li>
                            <input type="text"   placeholder="last name" required name="lname" />

                            <div class="clear"> </div>
                        </li> 
                        <h2>Company</h2>
                        <li>
                            <input type="text"   placeholder="company" required name="company" />

                            <div class="clear"> </div>
                        </li> 
                        <h2>City</h2>
                        <li>
                            <input type="text"   placeholder="city"  name="city"/>

                            <div class="clear"> </div>
                        </li> 


                        <input type="submit"  value="Accept">
                        <div class="clear"> </div>
                    </ul>
                    <ul class="right-form">

                        <div>
                        <h2>Phone</h2>
                        <li>
                            <input type="text"   placeholder="phone" required name="phone"/>

                            <div class="clear"> </div>
                        </li> 
                        <h2>Fax</h2>
                        <li>
                            <input type="text"   placeholder="fax"  name="fax" />

                            <div class="clear"> </div>
                        </li> 
                        <li>
                            <select class="chosen-select"  tabindex="8" name="country" size="1" id="country" style="width: 100%;">
                         
                                <?php
                                for($i=0;$i<sizeof($countries);$i++){
                                    ?>
                                    <option value="<?php echo $countries[$i];?>" ><?php echo $countries[$i];?></option>
                                    <?php }?>
                            </select>
                        </li>
                        <h2>Street address</h2>
                        <li>
                            <input type="text"   placeholder="street address"  name="str1" />

                            <div class="clear"> </div>
                        </li> 
                        <h2>Picture</h2>
                        <li>

                            <script src="js/jquery.min.js"></script>

                            <input type='file' id="imgInp" name="logo"/>



                        </li> 






                        <div class="clear"> </div>
                    </ul>
                    <div class="clear"> </div>

                </form>

            </div>
            <!-----start-copyright---->

        </div>


        <script src="js-login/index.js"></script>

          <script src="js/chosen.jquery.js" type="text/javascript"></script>
  <script src="docsupport/prism.js" type="text/javascript" charset="utf-8"></script>


<script type="text/javascript">
    var config = {
      '.chosen-select'           : {},
      '.chosen-select-deselect'  : {allow_single_deselect:true},
      '.chosen-select-no-single' : {disable_search_threshold:10},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width'     : {width:"25%"}
    }
    for (var selector in config) {
      $(selector).chosen(config[selector]);
    }
  </script>
        </div>



        </div>
        </div>  
        </section> 
        </div>
    </body>
</html>