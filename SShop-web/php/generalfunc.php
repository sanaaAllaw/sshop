<?php
//==============================================check mail validation
  function checkValidationMail($mailVar){
      if(filter_var($mailVar, FILTER_VALIDATE_EMAIL)) {
        echo '1';
    }
    else {
       echo '0';
    }

  }
  //==============================================end check mail validation
?>
