var cvUrl = localStorage.getItem("userUrl");
console.log(cvUrl);

var showUrl = "resumes\/" + cvUrl;
console.log(showUrl);

var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
  //general data
  $scope.firstName= "Jan";
  $scope.lastName= "Kowalski";
  $scope.email = "jan.kowalski@gmail.com";
  $scope.phoneNumber = 596690424;
  $scope.address = "Gdansk";
  $scope.fullName = function(){
    return $scope.firstName + " " + $scope.lastName;
  };
  //experience
  $scope.startDate= 2014;
  $scope.endDate;
  $scope.companyName = "IKM";
  $scope.positionName = "organizator wydarzeń";
  $scope.positionDescription = "organizowanie eventów";
  //experience
  $scope.experience = [
  {
  "startDate" : 2013,
  "endDate" : 2013,
  "companyName": "Świetlica",
  "positionName": "asystent",
  "positionDescription" : "asystowanie"
  },
  {
  "startDate" : 2013,
  "endDate" : 2013,
  "companyName": "Świetlica",
  "positionName": "asystent",
  "positionDescription" : "asystowanie"
   }
   ];
  //education
  $scope.schoolStartDate= 2010;
  $scope.schoolEndDate= 2015;
  $scope.schoolName = "Uniwersytet Gdański";
  $scope.schoolSubject = "Kulturoznawstwo";
  $scope.degree = "magister kulturoznawstwa";
  //courses
  $scope.courseYear = 2013;
  $scope.courseOrganization = "Atena - Kursy i Szkolenia";
  $scope.courseName = "Zarządzanie projektami";
  $scope.courseDescription = "w organizacjach kultury i pozarządowych";
  //language skills
  $scope.foreignLanguage = "angielski";
  $scope.languageLevel = "B2";
  $scope.languages = ["angielski", "niemiecki", "hiszpański", "japoński", "rosyjski"];
  //skills
  $scope.skill = "obsługa pakietu Office";
  //hobbies
  $scope.hobby = "wyjazdy na safari, survival"; 
});
