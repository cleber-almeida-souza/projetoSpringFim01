package br.com.clebersouza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * 
 * @author cleber.souza
 *  classe de inicialização do framework Spring Boot
 */
@SpringBootApplication(scanBasePackages = { "br.com.clebersouza" })
public class ProjetoSpringFim01Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringFim01Application.class, args);
	}

}
