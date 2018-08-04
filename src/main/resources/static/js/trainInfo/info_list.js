$(function() {
	$('.reg').on({
		'click': function() {
			// 選択した路線を取得
			var line = $(this).parent().children('span').text();
			// alert(line);
			$.post('/trainInfo/info/notice/reg', {
				line: line
			}, function(response) {
				alert(JSON.stringify(response));
			});
		}
	});
});