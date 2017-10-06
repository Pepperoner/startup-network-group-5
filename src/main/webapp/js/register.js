$(function() {

    $("#registerLink").click(function (e) {
        e.preventDefault();

        var url = "/user_type-selector";
        //console.log($("#show_reg_form").serialize());
        $.ajax({
            type: "GET",
            url: url,
            //data: $("#show_reg_form").serialize(),
            success: function(data){
                $('#content').empty().append(data);
            }
        });

    });
/*
    $("#show_reg_form").submit(function(e) {
        var url = "/registration-form";
        console.log($("#show_reg_form").serialize());
        $.ajax({
            type: "POST",
            url: url,
            data: $("#show_reg_form").serialize(),
            success: function(data){
                $('#content').empty().append(data);
            }
        });
        e.preventDefault();
    });
*/
});