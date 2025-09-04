/**
 * Pacote principal da aplicação.
 * O nome segue a convenção de domínio reverso (com.empresa.projeto).
 */
package com.devgabriellevi.dslist;

// Importações de classes do framework Spring Boot.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A anotação @SpringBootApplication é uma conveniência que combina três outras anotações:
 * 1. @Configuration: Marca a classe como uma fonte de definições de beans para o contexto da aplicação.
 * 2. @EnableAutoConfiguration: Diz ao Spring Boot para começar a adicionar beans com base nas configurações do classpath,
 * outros beans e várias configurações de propriedade.
 * 3. @ComponentScan: Diz ao Spring para procurar por outros componentes, configurações e serviços no pacote 'com.devgabriellevi.dslist'.
 */
@SpringBootApplication
public class DslistApplication {

	/**
	 * O método main é o ponto de entrada padrão para qualquer aplicação Java.
	 * É aqui que a execução do programa começa.
	 * @param args Argumentos de linha de comando que podem ser passados ao iniciar a aplicação.
	 */
	public static void main(String[] args) {
		// A classe SpringApplication é usada para inicializar e executar uma aplicação Spring a partir do método main.
		// O método .run() inicia o servidor web embutido (Tomcat, por padrão), cria o contexto do Spring
		// e processa todas as configurações, preparando a aplicação para receber requisições.
		SpringApplication.run(DslistApplication.class, args);
	}

}