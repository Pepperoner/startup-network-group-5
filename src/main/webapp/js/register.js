$(function() {
    //alert( "ready!" );

    $("#show_reg_form").click(function(e){
        e.preventDefault();
        var role = $('input[name="userRole"]:checked').val();
        console.log('role: ' + role);
        $.ajax({
            url : "/registration-form",
            data : "userType="+role,
            //dataType : 'json',
            //timeout : 100000,
            success : function(data) {
                $('.container').replaceWith(data);
            },
            // error : function(e) {
            //     console.log("ERROR: ", e);
            //     display(e);
            // },
            // done : function(e) {
            //     console.log("DONE");
            //     enableSearchButton(true);
            // }
        });
    });


});