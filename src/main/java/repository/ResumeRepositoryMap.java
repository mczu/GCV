package repository;

import model.Resume;
import model.ResumeId;

import java.util.Map;

public class ResumeRepositoryMap implements ResumeRepository {
    private static Map<ResumeId, Resume> resumes;

    public ResumeId create(Resume resume) {
        ResumeId resumeId = new ResumeId();
        resumes.put(resumeId, resume);
        return resumeId;
    }

    public void update(ResumeId resumeId, Resume resume) {
        resumes.put(resumeId, resume);
    }

    public Resume find(ResumeId resumeId) {
        return resumes.get(resumeId);
    }
}
