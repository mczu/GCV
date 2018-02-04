var cvUrl = localStorage.getItem("userUrl");
console.log(cvUrl);

var showUrl = "resumes\/" + cvUrl;
console.log(showUrl);



var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope) {
    //TEST
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

var pd_firstName = document.getElementById("pd_firstName").value;
var pd_lastName = document.getElementById("pd_lastName").value;
var pd_email = document.getElementById("pd_email").value;
var pd_phone = document.getElementById("pd_phone").value;
var pd_birthDate = document.getElementById("pd_birthDate").value;
var pd_photo = document.getElementById("pd_photo").value;

var ad_street = document.getElementById("ad_street").value;
var ad_postalCode = document.getElementById("ad_postalCode").value;
var ad_city = document.getElementById("ad_city").value;


function createPersonalDataObject() {
    var personalData = {};
    personalData.firstName = pd_firstName;
    personalData.lastName = pd_lastName;
    personalData.email = pd_email;
    personalData.phone = pd_phone;
    personalData.birthDate = pd_birthDate;
    personalData.photo = pd_photo;
    console.log(personalData);
    return personalData;
}

/*function createAddressObject() {
    var address = {};
    address["street"] = ad_street;
    address["postalCode"] = ad_postalCode;
    address["city"] = ad_city;
    return address;
}


function createWorkExperiencesObject() {
    var workExperiences = {};
    workExperiences.company = {};
    workExperiences.company["name"] = ;
    workExperiences.company["city"] = ;
    workExperiences.position = "";
    workExperiences.description = "";
    workExperiences.startDate = "";
    workExperiences.endDate = "";
    workExperiences.enabled = true;
    return workExperiences;
}

function createEducationsObject() {
    var school = {};
    var educations = [{}];
}*/

function createCVObject() {
    var completeCVObject = {};
    completeCVObject.personalData = createPersonalDataObject();
    /*completeCVObject.address = createAddressObject();
    completeCVObject.workExperiences = createWorkExperiencesObject();
    completeCVObject.educations = createEducationsObjects();
    completeCVObject.languages = createLanguages();
    completeCVObject.hobbies = createHobbies();
    completeCVObject.skills = createSkills();
    completeCVObject.courses = createCourses();*/
    return completeCVObject;
}

function sendCurriculumData() {
    var urlLog = showUrl;
    var newData = JSON.stringify(createCVObject());
    var requestLog = new Request(urlLog, {
        method: 'PUT',
        body: newData,
        headers: new Headers({
            'Content-Type': 'application/json'
        })
    });
    console.log(createCVObject());
    console.log(newData);
    fetch(requestLog)
        .then(function (response) {
            // Handle response we get from the API
           /* swal("Generowanie CV udane!", "Nastąpi teraz przejście do panelu użytkownika")
                .then(function(){
                    window.location.href = "http://localhost:8080/register.html";
                });*/
        })
    /*   .catch(function(error) {
               // If there is any error you will catch them here
       });*/
}

document.getElementById("generateCV").addEventListener("click", sendCurriculumData);