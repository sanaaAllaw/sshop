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
                            All invoices
                        </li>
                    </ul>

                    <div class="clearfix"></div>
                </div>
                <h2>Invoices</h2>
                <script>
                    function myFunction() {
                        // Declare variables 
                        var input, filter, table, tr, td, i;
                        input = document.getElementById("myInput");
                        filter = input.value.toUpperCase();
                        table = document.getElementById("myTable");
                        tr = table.getElementsByTagName("tr");

                        // Loop through all table rows, and hide those who don't match the search query
                        for (i = 0; i < tr.length; i++) {
                            td = tr[i].getElementsByTagName("td")[3];
                            if (td) {
                                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                    tr[i].style.display = "";
                                } else {
                                    tr[i].style.display = "none";
                                }
                            } 
                        }
                    }
                </script>
                <style>
                    * {
                        box-sizing: border-box;
                    }

                    #myInput {
                        background-image: url('/css/searchicon.png');
                        background-position: 10px 10px;
                        background-repeat: no-repeat;
                        width: 100%;
                        font-size: 16px;
                        padding: 12px 20px 12px 40px;
                        border: 1px solid #ddd;
                        margin-bottom: 12px;
                    }

                    #myTable {
                        border-collapse: collapse;
                        width: 100%;
                        border: 1px solid #ddd;
                        font-size: 18px;
                    }

                    #myTable th, #myTable td {
                        text-align: left;
                        padding: 12px;
                    }

                    #myTable tr {
                        border-bottom: 1px solid #ddd;
                    }

                    #myTable tr.header, #myTable tr:hover {
                        background-color: #f1f1f1;
                    }
                </style>
                <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for invoices..">

                <table id="myTable">
                    <tr class="header">
                        <th style="width:20%;">Invoice Number</th>
                        <th style="width:20%;">Qty</th>
                         <th style="width:20%;">Total Price</th>
                          <th style="width:20%;">Client</th>
                          <th style="width:20%;">Status</th>
                    </tr>
                    <?php
                    include('php/connection.php'); 
                   
                    $sqlcateg="select invoiceNum,sum(qty) sumqty,sum(price*qty) as amount,mobile,status from transaction,users
                    where transaction.login_id=users.username  group by invoiceNum ";
                    $sth = $conn->prepare($sqlcateg);
                    $sth->execute();
                    $data = $sth->fetchAll();
                    for($i=0;$i<sizeof($data);$i++){
                        $user_log= $data[$i][1];
                        ?>
                        <tr onclick="document.location = 'invoice.php?invoiceNum=<?php echo $data[$i][0];?>';">
                            <td><?php echo $data[$i][0];?></td>
                            <td><?php echo $data[$i][1];?></td>
                            <td><?php echo $data[$i][2];?></td>
                            <td><?php echo $data[$i][3];?></td>
                            <?php if($data[$i][4]=='0'){ ?>
                                 <td style="color:green" id="status">Payed</td>
                           <?php }   else{?>
                                    <td style="color:red" id="status">Pending</td>
                           <?php } ?>
                        </tr>
                        <?php }?>
                </table>
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

    </body>
</html>