package web;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import model.Resume;
import model.ResumeId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import repository.ResumeRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class GenerateResumePdfRestController {
    private final ResumeRepository resumeRepository;

    @GetMapping("/resumes/{id}/pdf")
    public void generateResumePdf(@PathVariable String id, HttpServletResponse response) {
        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename=CV.pdf");

        Resume resume = resumeRepository.find(new ResumeId(id))
                .orElse(new Resume());

        createDocument(resume, response);
    }

    private void createDocument(Resume resume, HttpServletResponse response) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            Font header = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);

            Resume.PersonalData personalData = resume.getPersonalData();

            if (personalData != null) {
                document.add(new Paragraph("Dane osobowe", header));
                document.add(new Paragraph("Imie: " + personalData.getFirstName()));
                document.add(new Paragraph("Nazwisko: " + personalData.getLastName()));
                document.add(new Paragraph("E-Mail: " + personalData.getEmail()));
                document.add(new Paragraph("Telefon: " + personalData.getPhone()));
                document.add(new Paragraph("Data urodzenia: " + personalData.getBirthDate()));
            }

            Resume.Address address = resume.getAddress();

            if (address != null) {
                document.add(new Paragraph("Adres: " + address.getStreet() + ", " + address.getPostalCode() + " " + address.getCity()));
            }

            List<Resume.WorkExperience> workExperiences = resume.getWorkExperiences();
            if (workExperiences != null) {
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Doswiadczenie zawodowe", header));

                for (Resume.WorkExperience workExperience : workExperiences) {
                    if (workExperience.getEnabled()) {
                        Resume.WorkExperience.Company company = workExperience.getCompany();
                        if (company != null) {
                            document.add(new Paragraph(workExperience.getStartDate() + " - " + workExperience.getEndDate() + ", " + company.getName() + ", " + company.getCity()));
                        } else {
                            document.add(new Paragraph(workExperience.getStartDate() + " - " + workExperience.getEndDate()));
                        }

                        document.add(new Paragraph("Stanowisko: " + workExperience.getPosition()));
                        document.add(new Paragraph("Opis:" + workExperience.getDescription()));
                    }
                }
            }

            List<Resume.Education> educations = resume.getEducations();
            if (educations != null) {
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Edukacja", header));

                for (Resume.Education education : educations) {
                    if (education.getEnabled()) {
                        Resume.Education.School school = education.getSchool();
                        if (school != null) {
                            document.add(new Paragraph(education.getStartDate() + " - " + education.getEndDate() + ", " + school.getName()));
                        } else {
                            document.add(new Paragraph(education.getStartDate() + " - " + education.getEndDate()));
                        }
                        document.add(new Paragraph("Stopien: " + education.getDegree()));
                    }
                }
            }

            List<Resume.Language> languages = resume.getLanguages();
            if (languages != null) {
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Jezyki obce", header));

                for (Resume.Language language : languages) {
                    if (language.getEnabled()) {
                        document.add(new Paragraph(language.getName() + ": " + language.getLevel()));
                    }
                }
            }

            List<Resume.Hobby> hobbies = resume.getHobbies();
            if (hobbies != null) {
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Zainteresowania", header));

                for (Resume.Hobby hobby : hobbies) {
                    if (hobby.getEnabled()) {
                        document.add(new Paragraph(hobby.getName()));
                    }
                }
            }

            List<Resume.Skill> skills = resume.getSkills();
            if (skills != null) {
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Umiejetnosci", header));

                for (Resume.Skill skill : skills) {
                    if (skill.getEnabled()) {
                        document.add(new Paragraph(skill.getName()));
                    }
                }
            }

            List<Resume.Course> courses = resume.getCourses();
            if (courses != null) {
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Kursy / Szkolenia", header));

                for (Resume.Course course : courses) {
                    if (course.getEnabled()) {
                        document.add(new Paragraph(course.getStartDate() + " - " + course.getEndDate() + ", " + course.getName()));
                    }
                }
            }

            document.close();
        } catch (DocumentException | IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
