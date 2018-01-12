package web;

import lombok.AllArgsConstructor;
import model.Resume;
import model.ResumeId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.ResumeRepository;

@RestController
@AllArgsConstructor
public class UpdateResumeRestController {
    private final ResumeRepository resumeRepository;

    @PutMapping("/resumes/{id}")
    public void updateResume(@PathVariable String id, @RequestBody Resume resume) {
        resumeRepository.update(new ResumeId(id), resume);
    }
}
