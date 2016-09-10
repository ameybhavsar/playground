var app = angular.module("myShoppingList", []); 

var productList = [
      {
		product : "Milk",
		qty : "10"
      },
      {
    	product : "Bread",
  		qty : "2"
      }
]

app.controller("myCtrl", function($scope) {  
    $scope.productList = productList;
});

