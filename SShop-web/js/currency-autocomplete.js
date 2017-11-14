
$(function(){
	
	
	
  var currencies = [
    { value: 'mohamed el dakdouki', tel: '71472024', adress: 'barja', station: '102A', building: '403B',new_price:'90000'},
   
  ];
  
  // setup autocomplete function pulling from currencies[] array
  $('#autocomplete').autocomplete({
    lookup: currencies,
    onSelect: function (suggestion) {
      var thehtml =  suggestion.value + '<strong>:الإسم</strong>  <br>'+ suggestion.tel+'<strong>:هاتف</strong><br>' + suggestion.adress + '<strong> :العنوان</strong>  <br>'+suggestion.station + '<strong>:رقم العقار</strong>  <br>'+suggestion.building + '<strong>:رقم المبنى</strong>  <br>$$ &nbsp;'+suggestion.new_price + '<strong>:المبلغ المتبقي</strong>  <br>'; 
      $('#outputcontent').html(thehtml);
    }
  });
  

});