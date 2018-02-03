var cvUrl = localStorage.getItem("userUrl");
console.log(cvUrl);

var showUrl = "resumes\/" + cvUrl;
console.log(showUrl);

var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {

     $http.get(showUrl)
        .then(function(response) {
            console.log(response.data);
            $scope.personalData = response.data.personalData;
            $scope.address = response.data.address;
            $scope.workExperiences = response.data.workExperiences;
            $scope.educations = response.data.educations;
            $scope.courses = response.data.courses;
            $scope.languages = response.data.languages;
            $scope.skills = response.data.skills;
            $scope.hobbies = response.data.hobbies;
        });
});
