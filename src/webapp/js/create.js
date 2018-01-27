var pd_firstName = document.getElementById("pd_firstName").value;
var pd_lastName = document.getElementById("pd_lastName").value;
var pd_email = document.getElementById("pd_email").value;
var pd_phone = document.getElementById("pd_phone").value;
var pd_birthDate = document.getElementById("pd_birthDate").value;
var pd_photo = document.getElementById("pd_photo").value;

var ad_street = document.getElementById("ad_street").value;
var ad_postalCode = document.getElementById("ad_postalCode").value;
var ad_city = document.getElementById("ad_city").value;

function prepareRegistrationData() {
    console.log(password);
}

function createPersonalDataObject() {
    var personalData = {};
    personalData.firstName = pd_firstName;
    personalData.lastName = pd_lastName;
    personalData.email = pd_email;
    personalData.phone = pd_phone;
    personalData.birthDate = pd_birthDate;
    personalData.photo = pd_photo;
    return personalData;
}

function createAddressObject() {
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
}

function createCVObject() {
    var completeCVObject = {};
    completeCVObject.personalData = createPersonalDataObject();
    completeCVObject.address = createAddressObject();
    completeCVObject.workExperiences = createWorkExperiencesObject();
    completeCVObject.educations = createEducationsObjects();
    completeCVObject.languages = createLanguages();
    completeCVObject.hobbies = createHobbies();
    completeCVObject.skills = createSkills();
    completeCVObject.courses = createCourses();
    return completeCVObject;
}

function sendCVData() {
    var completeCVJSON = createCVObject();
    console.log(completeCVJSON);
}

document.getElementById("generateCV").addEventListener("click", sendCVData);