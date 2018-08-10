$(function() {
	$('.reg').on({
		'click': function() {
			// 選択した路線を取得
			var line = $(this).parent().children('span').text();
			// alert(line);
			$.post('/trainInfo/info/notice/reg', {
				line: line
			}, function(response) {
				alert(response.message);
			});
		}
	});

	$('.del').on({
		'click': function() {
			// 選択した路線を取得
			var line = $(this).parent().children('span').text();
			// alert(line);
			$.post('/trainInfo/api/notice/del', {
				line: line
			}, function(response) {
				alert(response);
			});
		}
	});
});