package JeanEstProject.logic.config;

import JeanEstProject.translator.config.TranslatorConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan;

@Import({TranslatorConfig.class})
@Configuration
@ComponentScan(basePackages = {"JeanEstProject.logic.flow"})
public class LogicConfig {

}
