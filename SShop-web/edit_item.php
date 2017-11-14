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


    <script src="js/jquery-1.11.2.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/chosen.jquery.js"></script> 
    <script src="js/jquery-1.9.1.min.js"></script> 
    <script src="js/chosen.jquery.js"></script> 
    <link rel="stylesheet" href="css/chosen.css">

    <link rel="stylesheet" href="css/style_comp.css">

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
                    <h1>Edit items</h1>
                </div>
                <p></p>
                <form method="post" action="edit_item.php" enctype="multipart/form-data" id="itemform">
                    <ul class="left-form">
                    <h2>Item</h2>
                    <li>
                        <input type="text"   placeholder="code" required name="code" onkeydown="submitedititem()" />

                        <div class="clear"> </div>
                    </li> 
                   
                </form>
                <?php

                if(isset($_POST['code'])){
                    $sqlcateg="select itemcode,name,qty,fond,price,barcode from items where itemcode='$_POST[code]'";
                    //echo $sqlcateg;
                    $sth = $conn->prepare($sqlcateg);
                    $sth->execute();
                    $dataitem = $sth->fetchAll(); }
                if(isset($dataitem)){
                    if(sizeof($dataitem)>0){
                        ?>
                        <form method="post" action="update_item.php" enctype="multipart/form-data">
                        <input type="hidden" name="itemcodevar" value="<?php echo $dataitem[0][0];?>"/>
                        <li>
                            <input type="text"   placeholder="item name" required name="itemname" value="<?php echo $dataitem[0][1];?>"/>

                            <div class="clear"> </div>
                        </li> 

                        <li>
                            <input type="text"   placeholder="qty" required name="qty" value="<?php echo $dataitem[0][2];?>"/>

                            <div class="clear"> </div>
                        </li> 
                        <li>
                            <input type="text"   placeholder="Fond" required name="fond" value="<?php echo $dataitem[0][3];?>"/>

                            <div class="clear"> </div>
                        </li> 
                        <li>


                            <div class="clear"> </div>
                        </li> 


                        <input type="submit"  value="Update item">
                        <div class="clear"> </div>
                        </ul>
                        <ul class="right-form">

                       
                        <li><input type="text"  placeholder="price" required name="price" value="<?php echo $dataitem[0][4];?>"/></li>

                        <li><input type="text"  placeholder="barcode" name="barcode" value="<?php echo $dataitem[0][5];?>"/></li>



                    </div>
                    <div class="clear"> </div>
                    </ul>
                    <div class="clear"> </div>

                    </form>
                    <?php }
            }?>
        </div>
        <!-----start-copyright---->

        </div>


        <script src="js-login/index.js"></script>


        <script src="js/chosen.jquery.js" type="text/javascript"></script>
        <script src="docsupport/prism.js" type="text/javascript" charset="utf-8"></script>


        <script type="text/javascript">
        function submitedititem(){
             if (event.which == 13) {
        event.preventDefault();
    
        $("#itemform").submit();
    }
        }
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
    </body>
</html>