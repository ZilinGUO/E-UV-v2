$(document).ready(function() {


});
function check(form) {
    var minimum=$('#minimum').val();
    var maximum=$('#maximum').val();

    if(minimum>maximum){
        alert('The minimum number of people must be bigger than the maximum');
        return;
    }
     $('#form').submit();
}