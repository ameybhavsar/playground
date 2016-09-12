var app = angular.module('studentApp', []);

app.controller('studentCtrl', function($scope, $http) {

    $scope.student = {
        name: "",
        email:"",
        gender:""
    }

    $scope.submit = function() {
        $http.get("http://localhost:8080/student")
            .then(function(response) {
                console.log(response);
                $scope.myWelcome = response.data;
            });
    }

    $scope.list = function() {
        $http.get("http://localhost:8080/student/list")
            .then(function(response) {
                console.log(response);
                $scope.studentList = response.data;
            });
    }

    $scope.update = function(student) {
        console.log(student)
        $http.get("http://localhost:8080/student/add")
            .then(function(response) {
                console.log(response);
                $scope.myWelcome = response.data;
            });
    }

});