$(function() {

    $("a.delete-user").click(function (e) {
        e.preventDefault();

        var url = $(this).attr("href");
        var id = $(this).data("id");
        $.ajax({
            type: "POST",
            url: url,
            data: { id: id},
            success: function(data){
                location.reload();
            }
        });


        //$.ajax({
            /*type: "POST",
            url: url,
            //data: $("#show_reg_form").serialize(),
            success: function(data){
                //$('#content').empty().append(data);
            }*/
        //});

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