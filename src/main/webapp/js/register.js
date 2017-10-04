$(function() {
    //alert( "ready!" );
    $("#show_reg_form").submit(function(e) {

        var url = "/registration-form"; // the script where you handle the form input.
        console.log($("#show_reg_form").serialize());
        $.ajax({
            type: "POST",
            url: url,
            data: $("#show_reg_form").serialize(), // serializes the form's elements.
            success: function(data){
                $('.container').replaceWith(data);
            }
        });

        e.preventDefault(); // avoid to execute the actual submit of the form.
    });

});