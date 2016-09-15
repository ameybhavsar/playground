myApp.controller('HomeCtrl', function($location,$scope,SharedDataService){

	$scope.FBLogin = function(){
		FB.getLoginStatus(function(response) {
			$scope.statusChangeCallback(response);
		});
	};

	$scope.statusChangeCallback = function(response){
		console.log('statusChangeCallback');
		console.log(response);
		if (response.status === 'connected') {
			$scope.testAPI();
		} else if (response.status === 'not_authorized') {
			document.getElementById('status').innerHTML = 'Please log ' +
				'into this app.';
		} else {
			document.getElementById('status').innerHTML = 'Please log ' +
				'into Facebook.';
		}
	}

	$scope.testAPI = function(){
		FB.api(
			'/me',
			'GET',
			{"fields":"name,birthday,education,email,picture,gender"},
			function(response) {
				console.log(response);
				SharedDataService.response = response
				$location.path("/profile");
				$scope.$apply();

			}
		);
	}
});