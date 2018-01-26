package repository;

import model.Resume;
import model.ResumeId;

import java.util.Optional;

public interface ResumeRepository {
    ResumeId create(Resume resume);
    void update(ResumeId resumeId, Resume resume);
    Optional<Resume> find(ResumeId resumeId);
}
