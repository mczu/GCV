import config.LoginConfiguration;
import config.ResumeConfiguration;
import config.UserConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import({
        ResumeConfiguration.class,
        UserConfiguration.class,
        LoginConfiguration.class
})
@SpringBootConfiguration
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
