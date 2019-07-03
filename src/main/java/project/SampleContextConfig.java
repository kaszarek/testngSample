package project;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = { "project.*" })
public class SampleContextConfig {

}
