package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Resume {
    private PersonalData personalData;
    private Address address;
    private List<WorkExperience> workExperiences;
    private List<Education> educations;
    private List<Language> languages;
    private List<Hobby> hobbies;
    private List<Skill> skills;
    private List<Course> courses;

    @Setter
    @Getter
    public static class PersonalData {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String birthDate;
        private String photo;
    }

    @Setter
    @Getter
    public static class Address {
        private String street;
        private String postalCode;
        private String city;
    }

    @Setter
    @Getter
    public static class WorkExperience {
        private Company company;
        private String position;
        private String description;
        private String startDate;
        private String endDate;
        private Boolean enabled;

        @Setter
        @Getter
        public static class Company {
            private String name;
            private String city;
        }
    }

    @Setter
    @Getter
    public static class Education {
        private School school;
        private String degree;
        private String startDate;
        private String endDate;
        private Boolean enabled;

        @Setter
        @Getter
        public static class School {
            private String name;
        }
    }

    @Setter
    @Getter
    public static class Language {
        private String name;
        private String level;
        private Boolean enabled;
    }

    @Setter
    @Getter
    public static class Hobby {
        private String name;
        private Boolean enabled;
    }

    @Setter
    @Getter
    public static class Skill {
        private String name;
        private Boolean enabled;
    }

    @Setter
    @Getter
    public static class Course {
        private String name;
        private String startDate;
        private String endDate;
        private Boolean enabled;
    }
}
