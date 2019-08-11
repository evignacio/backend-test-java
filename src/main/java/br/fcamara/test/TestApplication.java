package br.fcamara.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import br.fcamara.test.service.EstabelecimentoService;
import br.fcamara.test.service.VeiculoService;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"br.fcamara.test.domain"})  // scan JPA entities
public class TestApplication {

	@Bean
	public EstabelecimentoService estabelecimentoService() {
		return new EstabelecimentoService();
	}
	
	public VeiculoService veiculoService() {
		return new VeiculoService();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
