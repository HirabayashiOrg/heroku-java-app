angular.module('myapp', ['ngResource'])
.controller('myctrl', ['$scope', '$resource', function($scope, $resource){
	var Todo = $resource('/todo/api/list');

	$scope.list = Todo.query();
	$scope.add  = function() {
		var title = $scope.title;
		$.post('/todo/api/add', {
			title: title
		}, function(data) {
			$scope.list = Todo.query();
		});
	};
	$scope.update = function(id) {
		alert(id);
	};
}]);