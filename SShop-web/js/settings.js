 function insert_vehicle_type() {
  var str=document.getelementbyid("type_vehicle").value;
    if (window.xmlhttprequest) {
    // code for ie7+, firefox, chrome, opera, safari
     xmlhttp = new xmlhttprequest();
  } else {
    // code for ie6, ie5
   xmlhttp = new activexobject("microsoft.xmlhttp");
 }
                               
   xmlhttp.open("get","veh_type.php?q="+str,true);
  xmlhttp.send();
      document.getelementbyid("type_vehicle").value='';
  document.getelementbyid("type_vehicle").focus();
 }