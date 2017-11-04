var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
  //general data
  $scope.firstName= "Jan";
  $scope.lastName= "Kowalski";
  $scope.email = "jan.kowalski@gmail.com";
  $scope.phoneNumber = 596690424;
  $scope.address = "Gdansk";
  //experience
  $scope.workBeginningYear = 2014;
  $scope.workFinishYear;
  $scope.companyName = "IKM";
  $scope.positionName = "organizator wydarzeń";
  $scope.positionDescription = "organizowanie eventów";
  //education
  $scope.beginningYear = 2010;
  $scope.finishYear = 2015;
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
  //skills
  $scope.skill = "obsługa pakietu Office";
  //hobbies
  $scope.hobby = "wyjazdy na safari, survival"; 
});
