package JeanEstProject.web.sb.config;

import JeanEstProject.logic.config.LogicConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({LogicConfig.class})
@Configuration
@ComponentScan({
        "JeanEstProject.web.sb.controller",
        "JeanEstProject.web.sb.exception"
})
public class WebConfiguration {
}


