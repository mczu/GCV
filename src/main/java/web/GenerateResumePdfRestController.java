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
import java.util.Optional;

@RestController
@AllArgsConstructor
public class GenerateResumePdfRestController {
    private final ResumeRepository resumeRepository;

    @GetMapping("/resumes/{id}/pdf")
    public void generateResumePdf(@PathVariable String id, HttpServletResponse response) {
        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename=CV");

        Optional<Resume> resumeOptional = resumeRepository.find(new ResumeId(id));

        if (resumeOptional.isPresent()) {
            createDocument(resumeOptional.get(), response);
        }
    }

    private void createDocument(Resume resume, HttpServletResponse response) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            Font header = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            document.add(new Paragraph("Dane osobowe", header));
            document.add(new Paragraph("Imie: " + resume.getPersonalData().getFirstName()));
            document.add(new Paragraph("Nazwisko: " + resume.getPersonalData().getLastName()));
            document.add(new Paragraph("E-Mail: " + resume.getPersonalData().getEmail()));
            document.add(new Paragraph("Telefon: " + resume.getPersonalData().getPhone()));
            document.add(new Paragraph("Data urodzenia: " + resume.getPersonalData().getBirthDate()));
            document.add(new Paragraph("Adres: " + resume.getAddress().getStreet() + ", " + resume.getAddress().getPostalCode() + " " + resume.getAddress().getCity()));

            document.add(new Paragraph(" "));

            document.add(new Paragraph("Doświadczenie zawodowe", header));
            for (Resume.WorkExperience workExperience : resume.getWorkExperiences()) {
                if (workExperience.getEnabled()) {
                    document.add(new Paragraph(workExperience.getStartDate() + " - " + workExperience.getEndDate() + ", " + workExperience.getCompany().getName() + ", " + workExperience.getCompany().getCity()));
                    document.add(new Paragraph("Stanowisko: " + workExperience.getPosition()));
                    document.add(new Paragraph("Opis:" + workExperience.getDescription()));
                }
            }

            document.close();
        } catch (DocumentException | IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
