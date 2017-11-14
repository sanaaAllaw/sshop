<?php
try{
    session_start();
    include('php/connection.php');
    include('php/generalfunc.php');
}
catch(PDOException $e){
}
?>
<div class="header">
    <div class="header-top-strip">
        <div class="container">
            <div class="header-top-left">
                <ul>
                    <?php
                    if(isset($_SESSION["login_id"])){?>
                        <li><a href="index.php"><span class="glyphicon glyphicon-user"></span>&nbsp;<?php echo $_SESSION["login_id"];?></a></li>
                        <li><a href="logout.php" class="simpleCart_empty">Logout</a></li>
                        <?php if(isset($_SESSION['sqliteLogin'])){?>
                            <li><a href="profile.php" class="simpleCart_empty">Profile</a></li>
                            <?php }?>
                        <?php }else{?>
                        <li><a href="account.php"><span class="glyphicon glyphicon-user"> </span>Login</a></li>
                        <li><a href="register.php"><span class="glyphicon glyphicon-lock"> </span>Create an Account</a></li>
                        <?php }?> 

                </ul>

            </div>
            <?php
            if(isset($_SESSION["login_id"])){?>
                <div class="header-right">
                    <div class="cart box_1">
                        <a href="checkout.php">
                            <h3> <span > <?php echo getsumtrans();?>L.L </span> (<span id="simpleCart_quantity"><?php echo getcounttrans();?></span>)<img src="images/bag.png" alt=""></h3>
                        </a>    
                        <p><a href="deleteAllItemuser.php" class="simpleCart_empty">Empty cart</a></p>
                        <div class="clearfix"> </div>
                    </div>
                </div>
                <?php }?>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<div class="banner-top">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="logo">
                <h1><a href="index.php"><span>S</span> -Shop</a></h1>
            </div>
        </div>
        <!--/.navbar-header-->
        <?php
        if(isset($_SESSION["login_id"])){?>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Men <b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-3">
                            <div class="row">
                                <?php 
                                $arrayMen=getAllGroupByCateg("Men");
                                for($i=0;$i<sizeof($arrayMen);$i++){?>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">

                                            <h6><?php echo $arrayMen[$i][0];?></h6>
                                            <?php 
                                            $arrayMengroup=getAllItemsCateg("Men",$arrayMen[$i][0]);
                                            for($j=0;$j<sizeof($arrayMengroup);$j++){?>
                                                <li><a href="products.php?a=<?php echo $arrayMengroup[$j][0];?>&b=<?php echo $arrayMen[$i][0];?>&c=Men">
                                                    <?php echo $arrayMengroup[$j][0];?></a></li>
                                                <?php  }
                                            ?>

                                        </ul>
                                    </div>  
                                    <?php  }
                                ?>


                                <div class="clearfix"></div>
                            </div>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">women <b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-3">
                            <div class="row">
                                <?php 
                                $arrayMen=getAllGroupByCateg("Women");
                                for($i=0;$i<sizeof($arrayMen);$i++){?>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">

                                            <h6><?php echo $arrayMen[$i][0];?></h6>
                                            <?php 
                                            $arrayMengroup=getAllItemsCateg("Women",$arrayMen[$i][0]);
                                            for($j=0;$j<sizeof($arrayMengroup);$j++){?>
                                                <li><a href="products.php?a=<?php echo $arrayMengroup[$j][0];?>&b=<?php echo $arrayMen[$i][0];?>&c=Women"><?php echo $arrayMengroup[$j][0];?></a></li>
                                                <?php  }
                                            ?>

                                        </ul>
                                    </div>  
                                    <?php  }
                                ?>
                                <div class="clearfix"></div>
                            </div>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">kids <b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-2">
                            <div class="row">
                                <?php 
                                $arrayMen=getAllGroupByCateg("Kids");
                                for($i=0;$i<sizeof($arrayMen);$i++){?>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">

                                            <h6><?php echo $arrayMen[$i][0];?></h6>
                                            <?php 
                                            $arrayMengroup=getAllItemsCateg("Kids",$arrayMen[$i][0]);
                                            for($j=0;$j<sizeof($arrayMengroup);$j++){?>
                                                <li><a href="products.php?a=<?php echo $arrayMengroup[$j][0];?>&b=<?php echo $arrayMen[$i][0];?>&c=Kids"><?php echo $arrayMengroup[$j][0];?></a></li>
                                                <?php  }
                                            ?>

                                        </ul>
                                    </div>  
                                    <?php  }
                                ?>
                                <div class="clearfix"></div>
                            </div>
                        </ul>
                    </li>
                    <?php
                    if(isset($_SESSION["admin"])){
                        if($_SESSION["admin"]==true){?>  
                            <li><a href="add_item.php">Add Items</a></li>


                            <li><a href="register_admin.php">Add admin</a></li>

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Inventory <b class="caret"></b></a>
                                <ul class="dropdown-menu multi-column columns-1">
                                <div class="col-sm-4">
                                    <ul class="multi-column-dropdown">
                                        <style>
                                            #btnlink:link, #btnlink:visited {
                                                background-color: maroon;
                                                color: white;
                                                padding: 5px 14px;
                                                text-align: center;
                                                text-decoration: none;
                                                width:120px;
                                                display: inline-block;
                                            }


                                            #btnlink:hover, #btnlink:active {
                                                background-color: red;
                                            }
                                        </style>

                                        <h6 ><a href="supplier.php" id="btnlink">Supplier</a></h6>
                                        <h6 ><a href="customer.php" id="btnlink">Customer</a></h6>
                                        <h6 ><a href="allinvoices.php" id="btnlink">Invoices</a></h6>
                                        <h6 ><a href="reports.php" id="btnlink">Report</a></h6>
                                        <h6 ><a href="stockreport.php" id="btnlink">Stock Card</a></h6>
                                        <h6 ><a href="edit_item.php" id="btnlink">Edit Items</a></h6>

                                    </ul>
                                </div>  
                            </li>
                            <?php }}
                    if(isset($_SESSION['login_id'])){?>
                        <li><a href="invoiceHist.php">Invoice hystorie</a></li>
                        <?php }?>
                </ul>
            </div>  

            <div class="clearfix"></div>
        </div>
        </ul>
        </li>
        </ul>
    </div>
    <?php }?>
<!--/.navbar-collapse-->
</nav>
<!--/.navbar-->
</div>
</div>