package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.ResumeRepository;
import repository.ResumeRepositoryMap;
import web.CreateResumeRestController;
import web.FindResumeRestController;
import web.UpdateResumeRestController;

@Configuration
public class ResumeConfiguration {

    @Bean
    public ResumeRepository resumeRepository() {
        return new ResumeRepositoryMap();
    }

    @Bean
    public FindResumeRestController findResumeRestController(
            ResumeRepository resumeRepository
    ) {
        return new FindResumeRestController(resumeRepository);
    }

    @Bean
    public CreateResumeRestController createResumeRestController(
            ResumeRepository resumeRepository
    ) {
        return new CreateResumeRestController(resumeRepository);
    }

    @Bean
    public UpdateResumeRestController updateResumeRestController(
            ResumeRepository resumeRepository
    ) {
        return new UpdateResumeRestController(resumeRepository);
    }
}
