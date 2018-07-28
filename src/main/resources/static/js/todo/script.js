$(function() {
	$('li').on({
		'click': function() {
			$(this).toggleClass('active');
		}
	});
});

angular.module('myapp', ['ngResource'])
.controller('myctrl', ['$scope', '$resource', function($scope, $resource){
	var TodoList = $resource('/todo/api/list',{}, {
		get: {
			method: 'GET',
			isArray: true
		},
	});
	var TodoAdd = $resource('/todo/api/add',{
		title: 'title',
	}, {
		add: {
			method: 'POST',
		},
	});

	$scope.list = TodoList.get();
	$scope.add = function() {
		var title = $scope.title;
		var obj = {
			id    : 99,
			title : title,
			status: 0,
		}
		$scope.title = '';
		$scope.list.push(obj);
	}
}]);