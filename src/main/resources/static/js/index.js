var cvUrl = localStorage.getItem("userUrl");
console.log(cvUrl);

var showUrl = "resumes\/" + cvUrl;
console.log(showUrl);

function createPersonalDataObject() {
    var pd_firstName = document.getElementById("personalData-firstName").value;
    var pd_lastName = document.getElementById("personalData-lastName").value;
    var pd_email = document.getElementById("personalData-email").value;
    var pd_phone = document.getElementById("personalData-phone").value;
    var pd_birthDate = document.getElementById("personalData-birthDate").value;
    var pd_photo = document.getElementById("personalData-photo").value;

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

function createAddressObject() {
    var ad_street = document.getElementById("address-street").value;
    var ad_postalCode = document.getElementById("address-postalCode").value;
    var ad_city = document.getElementById("address-city").value;

    var address = {};
    address["street"] = ad_street;
    address["postalCode"] = ad_postalCode;
    address["city"] = ad_city;
    return address;
}


function createWorkExperiencesObject() {
    var experiences_company_name = document.getElementById("experiences-company-name").value;
    var experiences_company_city = document.getElementById("experiences-company-city").value;
    var experiences_position = document.getElementById("experiences-position").value;
    var experiences_description = document.getElementById("experiences-description").value;
    var experiences_startDate = document.getElementById("experiences-startDate").value;
    var experiences_endDate = document.getElementById("experiences-endDate").value;

    var Experiences = [];
    var workExperiences = {};
    workExperiences.company = {};
    workExperiences.company["name"] = experiences_company_name;
    workExperiences.company["city"] = experiences_company_city;
    workExperiences.position = experiences_position;
    workExperiences.description = experiences_description;
    workExperiences.startDate = experiences_startDate;
    workExperiences.endDate = experiences_endDate;
    workExperiences.enabled = true;
    Experiences.push(workExperiences);
    return Experiences;
}

function createEducationsObject() {
    var educations_school_name = document.getElementById("educations-school-name").value;
    var educations_degree = document.getElementById("educations-degree").value;
    var educations_startDate = document.getElementById("educations-startDate").value;
    var educations_endDate = document.getElementById("educations-endDate").value;

    var educationsArray = [];
    var educations = {};
    educations.school = {};
    educations.school["name"] = educations_school_name;
    educations.degree = educations_degree;
    educations.startDate = educations_startDate;
    educations.endDate = educations_endDate;
    //educations.enabled = true;
    educationsArray.push(educations);
    return educationsArray;
}

function createLanguagesObject() {
    var languages_name = document.getElementById("languages-name").value;
    var languages_level = document.getElementById("languages-level").value;

    var languagesArray = [];
    var languages = {};
    languages.name = languages_name;
    languages.level = languages_level;
    //languages.enabled = true;
    languagesArray.push(languages);
    return languagesArray;
}

function createHobbiesObject() {
    var hobbies_name = document.getElementById("hobbies-name").value;

    var hobbiesArray = [];
    var hobbies = {};
    hobbies.name = hobbies_name;
    //hobbies.enabled = true;
    hobbiesArray.push(hobbies);
    return hobbiesArray;
}

function createSkillsObject() {
    var skills_name = document.getElementById("skills-name").value;

    var skillsArray = [];
    var skills = {};
    skills.name = skills_name;
    //skills.enabled = true;
    skillsArray.push(skills);
    return skillsArray;
}

function createCoursesObject() {
    var courses_name = document.getElementById("courses-name").value;
    var courses_startDate = document.getElementById("courses-startDate").value;
    var courses_endDate = document.getElementById("courses-endDate").value;

    var coursesArray = [];
    var courses = {};
    courses.name = courses_name;
    courses.startDate = courses_startDate;
    courses.endDate = courses_endDate;
    coursesArray.push(courses);
    return coursesArray;

}

function createCVObject() {
    var completeCVObject = {};
    completeCVObject.personalData = createPersonalDataObject();
    completeCVObject.address = createAddressObject();
    completeCVObject.workExperiences = createWorkExperiencesObject();
    completeCVObject.educations = createEducationsObject();
    completeCVObject.languages = createLanguagesObject();
    completeCVObject.hobbies = createHobbiesObject();
    completeCVObject.skills = createSkillsObject();
    completeCVObject.courses = createCoursesObject();
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
    .catch(function(error) {
               // If there is any error you will catch them here
        console.log(error);
       })
}

document.getElementById("sendCurriculumData").addEventListener("click", sendCurriculumData);

function previewPersonalDataFirstName(value){
    document.getElementById("preview-personalData-firstName").innerHTML = value;
}
function previewPersonalDataLastName(value){
    document.getElementById("preview-personalData-lastName").innerHTML = value;
}
function previewPersonalDataEmail(value){
    document.getElementById("preview-personalData-email").innerHTML = value;
}
function previewPersonalDataPhone(value){
    document.getElementById("preview-personalData-phone").innerHTML = value;
}
function previewPersonalDataBirthDate(value){
    document.getElementById("preview-personalData-birthDate").innerHTML = value;
}
function previewPersonalDataPhoto(value){
    document.getElementById("preview-personalData-photo").innerHTML = value;
}
function previewAddressStreet(value){
    document.getElementById("preview-address-street").innerHTML = value;
}
function previewAddressPostalCode(value){
    document.getElementById("preview-address-postalCode").innerHTML = value;
}
function previewAddressCity(value){
    document.getElementById("preview-address-city").innerHTML = value;
}