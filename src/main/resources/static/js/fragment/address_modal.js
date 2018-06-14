$(function() {
    $('#name_toggle').click(function(e) {
        $('#name_output').toggleClass('name_is_hide');
        $('#name_input').toggleClass('name_is_hide');

        // $('.address_modal_header').toggleClass('address_modal_header_stretch').promise().done(function(){
        //     $('#name_output').fadeToggle();
        //     $('#name_input').fadeToggle();
        // });
        
        var lastnameKana = $('#modalLastnameKana').val();
        var firstnameKana = $('#modalFirstnameKana').val();
        var lastname = $('#modalLastname').val();
        var firstname = $('#modalFirstname').val();
        
        $('#modalFullname').text(lastname + ' ' + firstname);
        $('#modalFullnameKana').text('【' + lastnameKana + ' ' + firstnameKana + '】');
    });
});

