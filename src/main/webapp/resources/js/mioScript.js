/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('#sceltaTipo').click(function(){ myFunction(); return false; });

function myfunction (e) {
    e.preventDefault();
    alert("Hello! I am an alert box!!");
//    var href = $(this).attr("href");
//    $("#top h2").append("GRUPPO :").append(href);
    //window.open(href);
}
