$(function() {
    /**
     * 詳細ボタン押下時の処理
     */
    $('.detail_btn').click(function(e) {
    	var tmp = $(this).parent('td');
        var fullnameKana = tmp.attr('data-fullname_kana');
        var fullname = tmp.attr('data-fullname');
        var homePhoneNumber = tmp.attr('data-home_phone_number');
        var mobilePhoneNumber = tmp.attr('data-mobile_phone_number');
        var email = tmp.attr('data-email');
        var zipCode = tmp.attr('data-zip_code');
        var prefecture = tmp.attr('data-prefecture');
        var address = tmp.attr('data-address');
        var buildingName = tmp.attr('data-building_name');
        
        if (fullnameKana.trim() != '') {
            $('#modalFullnameKana').text('【' + fullnameKana + '】');
        } else {
        	$('#modalFullnameKana').text('');
        }
        
        $('#modalFullname').text(fullname);
        $('#modalHomePhoneNumber').text(homePhoneNumber);
        $('#modalMobilePhoneNumber').text(mobilePhoneNumber);
        $('#modalEmail').text(email);
        $('#modalZipCode').text(zipCode);
        $('#modalPrefecture').text(prefecture);
        $('#modalAddress').text(address);
        $('#modalBuildingName').text(buildingName);
        
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
	 * 編集ボタン押下時の処理
	 */
    $('.edit_btn').click(function(e) {
        var addressId = $(this).attr('id');
        var mainForm = $(this).parents('form');
        mainForm.attr('action', mainForm.attr('action') + '/' + addressId);
        mainForm.submit();
    });
});



