package JeanEstProject.domain.web.sb.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = {
        "JeanEstProject.web.sb.controller",
        "JeanEstProject.web.sb.exception"
})
public class WebConfiguration {
}


