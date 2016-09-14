myApp.controller('ProfileCtrl', function($scope,$http,SharedDataService){
	$scope.name = "Logged in";
	$scope.student = SharedDataService.response;
	
	$scope.save = function(student){
		
	}
});