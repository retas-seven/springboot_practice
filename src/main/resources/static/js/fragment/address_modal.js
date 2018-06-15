$(function() {
    $('#name_toggle').click(function(e) {
        if ($('#name_output').hasClass('name_is_hide')) {
        	// 切り替え後のモードが「表示」の場合
            var lastnameKana = $('#modalLastnameKana').val();
            var firstnameKana = $('#modalFirstnameKana').val();
            var lastname = $('#modalLastname').val();
            var firstname = $('#modalFirstname').val();
            
            $('#modalFullname').text(lastname + ' ' + firstname);
            $('#modalFullnameKana').text('【' + lastnameKana + ' ' + firstnameKana + '】');

//        	$('#name_input_output').removeClass('address_modal_header_nobiru');
            $('#modalFullname').removeClass('input_mode').attr('readonly',true);
            $('#modalFullnameKana').removeClass('input_mode').attr('readonly',true);
            $('#modalLastnameKana').removeClass('input_mode').attr('readonly',true);
            $('#modalFirstnameKana').removeClass('input_mode').attr('readonly',true);
            $('#modalLastname').removeClass('input_mode').attr('readonly',true);
            $('#modalFirstname').removeClass('input_mode').attr('readonly',true);
            $('#modalHomePhoneNumber').removeClass('input_mode').attr('readonly',true);
            $('#modalMobilePhoneNumber').removeClass('input_mode').attr('readonly',true);
            $('#modalEmail').removeClass('input_mode').attr('readonly',true);
            $('#modalZipCode').removeClass('input_mode').attr('readonly',true);
            $('#modalPrefecture').removeClass('input_mode').attr('readonly',true);
            $('#modalAddress').removeClass('input_mode').attr('readonly',true);
            $('#modalBuildingName').removeClass('input_mode').attr('readonly',true);
        } else {
        	// 切り替え後のモードが「入力」の場合
//        	$('#name_input_output').addClass('address_modal_header_nobiru');
            $('#modalFullname').addClass('input_mode').attr('readonly',false);
            $('#modalFullnameKana').addClass('input_mode').attr('readonly',false);
            $('#modalLastnameKana').addClass('input_mode').attr('readonly',false);
            $('#modalFirstnameKana').addClass('input_mode').attr('readonly',false);
            $('#modalLastname').addClass('input_mode').attr('readonly',false);
            $('#modalFirstname').addClass('input_mode').attr('readonly',false);
            $('#modalHomePhoneNumber').addClass('input_mode').attr('readonly',false);
            $('#modalMobilePhoneNumber').addClass('input_mode').attr('readonly',false);
            $('#modalEmail').addClass('input_mode').attr('readonly',false);
            $('#modalZipCode').addClass('input_mode').attr('readonly',false);
            $('#modalPrefecture').addClass('input_mode').attr('readonly',false);
            $('#modalAddress').addClass('input_mode').attr('readonly',false);
            $('#modalBuildingName').addClass('input_mode').attr('readonly',false);
        }
    	
        // 「入力」，「表示」のモードを切り替え
        $('#name_output').toggleClass('name_is_hide');
        $('#name_input').toggleClass('name_is_hide');
    });
});

