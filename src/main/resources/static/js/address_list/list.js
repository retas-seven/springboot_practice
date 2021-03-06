$(function() {
    /**
     * 詳細ボタン押下時の処理
     */
    $('.detail_btn').click(function(e) {
    	var tmp = $(this).parent('td');
    	var id = tmp.attr('data-id');
        var lastnameKana= conv(tmp.attr('data-lastname_kana'));
        var firstnameKana= conv(tmp.attr('data-firstname_kana'));
        var lastname= conv(tmp.attr('data-lastname'));
        var firstname= conv(tmp.attr('data-firstname'));
        var homePhoneNumber = conv(tmp.attr('data-home_phone_number'));
        var mobilePhoneNumber = conv(tmp.attr('data-mobile_phone_number'));
        var email = conv(tmp.attr('data-email'));
        var zipCode = conv(tmp.attr('data-zip_code'));
        var prefecture = conv(tmp.attr('data-prefecture'));
        var address = conv(tmp.attr('data-address'));
        var buildingName = conv(tmp.attr('data-building_name'));

        $('#modalTargetId').val(id);
        $('#modalFullname').text(lastname + ' ' + firstname);
        $('#modalFullnameKana').text('【' + lastnameKana + ' ' + firstnameKana + '】');
        $('#modalLastnameKana').val(lastnameKana);
        $('#modalFirstnameKana').val(firstnameKana);
        $('#modalLastname').val(lastname);
        $('#modalFirstname').val(firstname);
        $('#modalHomePhoneNumber').val(homePhoneNumber);
        $('#modalMobilePhoneNumber').val(mobilePhoneNumber);
        $('#modalEmail').val(email);
        $('#modalZipCode').val(zipCode);
        $('#modalPrefecture').val(prefecture);
        $('#modalAddress').val(address);
        $('#modalBuildingName').val(buildingName);
        
        // 入力チェックエラーメッセージ等の表示が残っている場合があるので除去
        $('.ajax_result').remove();
        
        // 名前の入力項目を非表示にし、名前の文字列を表示する
//        if ($('#name_output').hasClass('name_is_hide')) {
    	$('#name_output').removeClass('name_is_hide');
    	$('#name_input').addClass('name_is_hide');
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
//        }
        
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
	 * 削除ボタン押下時の処理
	 */
    $('.delete_btn').click(function(e) {
        if(!confirm('削除しますか？')){
            return false;
        }
        
		e.preventDefault();
    	$('#loading').fadeIn();
    	var deleteTargetId = $(this).parent('td').attr('data-id');
        console.log('deleteTargetId:' + deleteTargetId);
		
        $.post({
            url: '/address_list/delete',
            data: {
            	deleteTargetId: deleteTargetId
            },
            success: function(jsonResponse) {
            	// 既存のエラーメッセージを除去
                $('.ajax_delete_result').remove();

                // 全体のエラーメッセージを設定
                $.each (jsonResponse.globalErrorMessages, function (index, value){
                    $('#global_error').append('<p class="ajax_delete_result has-global-error">' + value + '</p>');
                });
                
            	// 一覧表の行を削除
                if (jsonResponse.success) {
                	$('#' + deleteTargetId).remove();
                } else {
                	$("html,body").animate({scrollTop:$('#addressListForm').offset().top});
                }

                $('#loading').fadeOut();
                
                // 削除成功メッセージ
                if (jsonResponse.success) {
                	iziToast.show({
                		messageColor: 'rgba(13, 80, 36, 0.8)',
                	    color: 'green',
                	    position: 'topRight',
                	    timeout: 3000,
                	    messageSize: '17',
                	    message: '削除しました。'
                	});
                }
            }
        })
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
            success: function(jsonResponse) {
            	// 既存のエラーメッセージを除去
                $('.ajax_result').remove();

                // 全体のエラーメッセージを設定
                $.each (jsonResponse.globalErrorMessages, function (index, value){
//                  console.log('【' + index + '】【' + value+ '】');
                    $('#modal_global_error').append('<p class="ajax_result has-global-error">' + value + '</p>');
                });

                // フィールド個別のエラーメッセージを設定
                $.each (jsonResponse.fieldErrorMessages, function (key, value){
//                  console.log('【' + key + '】【' + value+ '】');
                    $('input[name=' + key + ']').after('<p class="ajax_result has-error">' + value + '</p>');
                });
                
            	// 更新内容を一覧表の行に反映
                if (jsonResponse.success) {
                	var targetId = $('#modalTargetId').val();
                	$('#' + targetId).children('td').eq(0).text($('#modalLastname').val() + ' ' + $('#modalFirstname').val());
                	$('#' + targetId).children('td').eq(1).text($('#modalMobilePhoneNumber').val());
                	$('#' + targetId).children('td').eq(2).text($('#modalHomePhoneNumber').val());
                	$('#' + targetId).children('td').eq(3).text($('#modalEmail').val());
                	
                	var dataTd = $('#' + targetId).children('td').eq(4);
                	dataTd.attr('data-lastname_kana', $('#modalLastnameKana').val());
                	dataTd.attr('data-firstname_kana', $('#modalFirstnameKana').val());
                	dataTd.attr('data-lastname', $('#modalLastname').val());
                	dataTd.attr('data-firstname', $('#modalFirstname').val());
                	dataTd.attr('data-mobile_phone_number', $('#modalMobilePhoneNumber').val());
                	dataTd.attr('data-home_phone_number', $('#modalHomePhoneNumber').val());
                	dataTd.attr('data-email', $('#modalEmail').val());
                	dataTd.attr('data-zip_code', $('#modalZipCode').val());
                	dataTd.attr('data-prefecture', $('#modalPrefecture').val());
                	dataTd.attr('data-address', $('#modalAddress').val());
                	dataTd.attr('data-building_name', $('#modalBuildingName').val());
                }

                $('#loading').fadeOut();
                
                // 更新成功メッセージ
                if (jsonResponse.success) {
                	iziToast.show({
                		messageColor: 'rgba(13, 80, 36, 0.8)',
                	    color: 'green',
                	    position: 'topRight',
                	    timeout: 3000,
                	    messageSize: '17',
                	    message: '更新しました。'
                	});
                }
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
