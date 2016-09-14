var myApp = angular.module('myApp',['ngRoute']);

window.fbAsyncInit = function() {
	FB.init({
		appId : '537312899796006',
		xfbml : true,
		version : 'v2.7'
	});
};

//to asynchronous download the sdk
(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

myApp.service('SharedDataService', function (){
	var response = {}
});