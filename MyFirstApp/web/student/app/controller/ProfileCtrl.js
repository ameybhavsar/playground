myApp.controller('ProfileCtrl', function($scope,$http,SharedDataService){
	$scope.name = "Logged in";
	$scope.student = SharedDataService.response;

	$scope.save = function(student){
		console.log(student)
		var req  = {
			name : student.name,
			email : student.email,
			gender : student.gender,
			picture : student.picture
		}
		$http.post("http://localhost:8080/student/add", req)
			.then(function() {
				console.log("success");
			});
	}
});