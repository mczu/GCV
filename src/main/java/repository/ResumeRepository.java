package repository;

import model.Resume;
import model.ResumeId;

public interface ResumeRepository {
    ResumeId create(Resume resume);
    void update(ResumeId resumeId, Resume resume);
    Resume find(ResumeId resumeId);
}
