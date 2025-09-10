package com.devgabriellevi.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgabriellevi.dslist.dto.GameListDTO;
import com.devgabriellevi.dslist.services.GameListService;

/**
 * @RestController combina @Controller e @ResponseBody, indicando que esta classe é um controlador
 * e que os métodos retornarão dados (como JSON) diretamente no corpo da resposta HTTP.
 */
@RestController
/**
 * @RequestMapping(value = "/games") mapeia todas as requisições que começam com "/games"
 * para este controlador. É o endereço base para os endpoints desta classe.
 */
@RequestMapping(value = "/lists")
public class GameListController {
	
	/**
	 * Injeta uma instância de GameService no controlador.
	 * O Controller delega a lógica de negócio para o Service.
	 */
	@Autowired
	private GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		// 1. O Controller chama o método findAll() do serviço para obter os dados.
		List<GameListDTO> result = gameListService.findAll();
		// 2. O Controller retorna o resultado. O Spring se encarrega de serializar
		// a lista de objetos Java para uma string no formato JSON e enviá-la na resposta HTTP.
		return result;
	}
}