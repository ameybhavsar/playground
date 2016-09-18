myApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when("/", {
			templateUrl : "home/login.html",
			controller : "HomeCtrl"
		})
		.when("/profile", {
			templateUrl : "home/profile.html",
			controller : "ProfileCtrl"
		})
		.when("/list", {
			templateUrl : "home/list.html",
			controller : "ListCtrl"
		})
		.when("/map", {
			templateUrl : "home/map.html",
			controller : "MapCtrl"
		})
		.otherwise("/",{
			templateUrl : "home/login.html",
			controller : "HomeCtrl"
		});
}]);