$(function() {
    /**
     * 詳細ボタン押下時の処理
     */
    $('.detail_btn').click(function(e) {
        var fullname = $(this).siblings('input[name=fullname]').val();
        var homePhoneNumber = $(this).siblings('input[name=homePhoneNumber]').val();
        var mobilePhoneNumber = $(this).siblings('input[name=mobilePhoneNumber]').val();
        var email = $(this).siblings('input[name=email]').val();
        var zipCode = $(this).siblings('input[name=zipCode]').val();
        var prefecture = $(this).siblings('input[name=prefecture]').val();
        var address = $(this).siblings('input[name=address]').val();
        var buildingName = $(this).siblings('input[name=buildingName]').val();
        
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
	 * 編集ボタン押下時の処理
	 */
    $('.edit_btn').click(function(e) {
        var addressId = $(this).attr('id');
        var mainForm = $(this).parents('form');
        mainForm.attr('action', mainForm.attr('action') + '/' + addressId);
        mainForm.submit();
    });
});



