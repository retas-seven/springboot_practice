$(function() {
    /**
     * 詳細ボタン押下時の処理
     */
    $('.detail_btn').click(function(e) {
    	var tmp = $(this).parent('td');
    	var id = tmp.attr('data-id');
        var fullnameKana = conv(tmp.attr('data-fullname_kana'));
        var fullname = conv(tmp.attr('data-fullname'));
        var homePhoneNumber = conv(tmp.attr('data-home_phone_number'));
        var mobilePhoneNumber = conv(tmp.attr('data-mobile_phone_number'));
        var email = conv(tmp.attr('data-email'));
        var zipCode = conv(tmp.attr('data-zip_code'));
        var prefecture = conv(tmp.attr('data-prefecture'));
        var address = conv(tmp.attr('data-address'));
        var buildingName = conv(tmp.attr('data-building_name'));

        if (fullnameKana != '') {
            $('#modalFullnameKana').text('【' + fullnameKana + '】');
        } else {
        	$('#modalFullnameKana').text('');
        }

        $('#modalTargetId').val(id);
        $('#modalFullname').text(fullname);
        $('#modalHomePhoneNumber').val(homePhoneNumber);
        $('#modalMobilePhoneNumber').val(mobilePhoneNumber);
        $('#modalEmail').val(email);
        $('#modalZipCode').val(zipCode);
        $('#modalPrefecture').val(prefecture);
        $('#modalAddress').val(address);
        $('#modalBuildingName').val(buildingName);
        
        $('.ajax_result').remove();
        
        // モーダルで詳細情報を表示
        $('#address_modal').modal();
    });
    
	/**
	 * 検索ボタン押下時の処理
	 */
    $('#search_button').click(function(e) {
    	var searchCondition = $('#search_condition').val();
    	window.location.href = '/address_list/search/' + searchCondition;
    });
    
	/**
	 * 検索条件（個別文字）押下時の処理
	 */
    $('.search_individual_str > p > a').click(function(e) {
    	var searchCondition = $(this).text();
    	window.location.href = '/address_list/search_individual/' + searchCondition;
    });
    
	/**
	 * 編集ボタン押下時の処理
	 */
    $('.edit_btn').click(function(e) {
        var addressId = $(this).attr('id');
        var mainForm = $(this).parents('form');
        mainForm.attr('action', mainForm.attr('action') + '/' + addressId);
        mainForm.submit();
    });
    
	/**
	 * 更新ボタン押下時の処理
	 */
    $('#modal_update_button').click(function(e) {
    	$('#loading').fadeIn();
		e.preventDefault();
		
        $.post({
            url: '/address_list/update',
            data: $('#addressListForm').serialize(),
            success: function(data) {
                $('.ajax_result').remove();

                // 全体のエラーメッセージを設定
                $.each (data.globalErrorMessages, function (index, value){
                    console.log('【' + index + '】【' + value+ '】');
                    $('#modal_global_error').append('<p class="ajax_result has-global-error">' + value + '</p>');
                });

                // フィールド個別のエラーメッセージを設定
                $.each (data.fieldErrorMessages, function (key, value){
                    console.log('【' + key + '】【' + value+ '】');
                    $('input[name=' + key + ']').after('<p class="ajax_result has-error">' + value + '</p>');
                });

                $('#loading').fadeOut();
            }
        })
	});
});


function conv(value) {
	if(value === undefined) {
		return '';
	} else {
		return value;
	}
}
