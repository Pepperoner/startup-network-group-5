$(function() {

    $(".registerLink").click(function (e) {
        e.preventDefault();

        var url = "/user_type-selector";
        $.ajax({
            type: "GET",
            url: url,
            success: function(data){
                $('#content').empty().append(data);
            }
        });

    });
});