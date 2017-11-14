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
                    <h1>Sales Report</h1>
                </div>
                <p></p>
                <form method="post" action="report_view.php" enctype="multipart/form-data">
                <ul class="left-form">
                    
                     <li><input type="date" value="<?php echo date('Y-m-d'); ?>"   name="date1" style="width: 100%;"/></li>
                                                                                
                <li><input type="date" value="<?php echo date('Y-m-d'); ?>"  name="date2" style="width: 100%;"/></li>

                   <li>
<h4>Items</h4>
                    <select class="chosen-select" multiple tabindex="8" name="items[]" size="1" id="items" style="width: 100%;">


                            <?php
                    include('php/connection.php'); 
                   
                    $sqlcateg="select name from items";
                    $sth = $conn->prepare($sqlcateg);
                    $sth->execute();
                    $data = $sth->fetchAll();
                    for($i=0;$i<sizeof($data);$i++){
                            ?>
                            <option value="<?php echo $data[$i][0];?>" ><?php echo $data[$i][0];?></option>
                            <?php }?>
                    </select>
                </li>
                  
                    


                    <input type="submit"  value="Preview">
                    <div class="clear"> </div>
                </ul>
                <ul class="right-form">

      <li>
                    <h4>Supplier</h4>
                    <select class="chosen-select" multiple tabindex="8" name="supplier[]" size="1" id="supplier" style="width: 100%;">


                            <?php
                                $arrayMen=getallsupp();
                        for($i=0;$i<sizeof($arrayMen[0]);$i++){
                            ?>
                            <option value="<?php echo $arrayMen[0][$i];?>" ><?php echo $arrayMen[0][$i].' '.$arrayMen[1][$i];?></option>
                            <?php }?>
                    </select>
                </li>
                <h4>Type</h4>
                <li><select class="chosen-select" multiple tabindex="8" name="categorie[]" size="1" id="categorie" style="width: 100%;">
                                     
                        <option value="Men">Men</option>
                        <option value="Women">Women</option>
                        <option value="Kids">Kids</option>
                    </select></li>
                    
                <li>   
                <h4>Group</h4>
                  <select class="chosen-select" multiple tabindex="8" name="group[]" size="1" id="group" style="width: 100%;">                                  
                        <option value="Clothes">Clothes</option>
                        <option value="Watches">Watches</option>

                    </select></li>
                <li>  
                <h4>Category</h4>
                <select class="chosen-select"  multiple tabindex="8" name="categ[]" size="1" id="categ" style="width: 100%;">                                
                        <option value="Dresses">Dresses</option>
                        <option value="Styles">Styles </option>
                        <option value="cultural">cultural </option>
                        <option value="Beauty">Beauty </option>

                    </select></li>
               
               


            </div>
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
    </body>
</html>