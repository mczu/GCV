package web;

import lombok.AllArgsConstructor;
import model.Resume;
import model.ResumeId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.ResumeRepository;

@RestController
@AllArgsConstructor
public class CreateResumeRestController {
    private final ResumeRepository resumeRepository;

    @PostMapping("/resumes")
    public ResponseEntity<ResumeId> createResume(@RequestBody Resume resume) {
        return ResponseEntity.ok(resumeRepository.create(resume));
    }
}
