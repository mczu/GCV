package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Resume {
    private PersonalData personalData = new PersonalData();
    private Address address = new Address();
    private List<WorkExperience> workExperiences = new ArrayList<>();
    private List<Education> educations = new ArrayList<>();
    private List<Language> languages = new ArrayList<>();
    private List<Hobby> hobbies = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

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
