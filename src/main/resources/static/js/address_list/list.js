$(function() {
    $('.edit_btn').click(function(e) {
        var addressId = $(this).attr('id');
        var mainForm = $(this).parents('form');
        mainForm.attr('action', mainForm.attr('action') + '/' + addressId);
        mainForm.submit();
    });
});



