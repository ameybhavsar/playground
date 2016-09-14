myApp.controller('ListCtrl', function($scope,$http){
	$scope.name = "List page in";
	
	 $scope.list = function() {
	        $http.get("http://localhost:8080/student/list")
	            .then(function(response) {
	                console.log(response);
	                $scope.studentList = response.data;
	            });
	    }

});