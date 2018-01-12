package web;

import lombok.AllArgsConstructor;
import model.Resume;
import model.ResumeId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import repository.ResumeRepository;

@RestController
@AllArgsConstructor
public class FindResumeRestController {
    private final ResumeRepository resumeRepository;

    @GetMapping("/resumes/{id}")
    public ResponseEntity<Resume> findResume(@PathVariable String id) {
        return resumeRepository.find(new ResumeId(id))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
