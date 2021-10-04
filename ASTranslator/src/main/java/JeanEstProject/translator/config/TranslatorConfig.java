package JeanEstProject.translator.config;
import JeanEstProject.repo.config.RepositoryConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
@Import({RepositoryConfig.class})
@Configuration
public class TranslatorConfig {
}
