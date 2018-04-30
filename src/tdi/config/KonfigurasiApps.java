package tdi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "tdi.service","tdi.dao" })
public class KonfigurasiApps {

}
