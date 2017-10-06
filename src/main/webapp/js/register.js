(function($){
    $(function() {
        var urlRegForm = document.location.pathname + '/registration-form';
        var roleForm = $('#show_reg_form');
        roleForm.on('submit', getRegistrationForm);

        function getRegistrationForm(e) {
            console.log(roleForm.serialize());

            $.ajax({
                type: 'POST',
                url: urlRegForm,
                data: roleForm.serialize(), // serializes the form's elements.
                success: function(data){
                    $('.container').replaceWith(data);
                }
            });

            e.preventDefault(); // avoid to execute the actual submit of the form.
        }
    });
})(jQuery);