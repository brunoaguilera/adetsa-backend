package py.com.adetsa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
@ComponentScan(basePackages = ("py.com.adetsa"))
public class SwaggerConfig {

	public final String[] PATTERNS = { "/socios/.*", "/channels/.*" };

	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(PATTERNS);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Modulo Adetsa API", "API for Modulo Adetsa",
				"Modulo Adetsa API terms of service", "info@adetsa.com.py",
				"Modulo Adetsa API Licence", "Modulo Adetsa API License URL");
	}
}