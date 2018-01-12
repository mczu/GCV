package repository;

import model.Resume;
import model.ResumeId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResumeRepositoryMap implements ResumeRepository {
    private static Map<ResumeId, Resume> resumes = new HashMap<>();

    public ResumeId create(Resume resume) {
        ResumeId resumeId = new ResumeId();
        resumes.put(resumeId, resume);
        return resumeId;
    }

    public void update(ResumeId resumeId, Resume resume) {
        resumes.put(resumeId, resume);
    }

    public Optional<Resume> find(ResumeId resumeId) {
        return Optional.ofNullable(resumes.get(resumeId));
    }
}
