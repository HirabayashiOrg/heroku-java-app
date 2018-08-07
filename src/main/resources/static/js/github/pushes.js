$(function() {
	$('button').on({
		'click': function() {
			if(confirm('Are you sure ?')) {
				var id = $(this).val();
				// alert(id);
				$.post('/github/api/pushes/delete', {
					id: id
				}, function(data) {
					location.reload();
				});
			} else {
				return false;
			}
		}
	})
});