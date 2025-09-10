package com.devgabriellevi.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgabriellevi.dslist.dto.GameDTO;
import com.devgabriellevi.dslist.dto.GameMinDTO;
import com.devgabriellevi.dslist.services.GameService;

/**
 * @RestController combina @Controller e @ResponseBody, indicando que esta classe é um controlador
 * e que os métodos retornarão dados (como JSON) diretamente no corpo da resposta HTTP.
 */
@RestController
/**
 * @RequestMapping(value = "/games") mapeia todas as requisições que começam com "/games"
 * para este controlador. É o endereço base para os endpoints desta classe.
 */
@RequestMapping(value = "/games")
public class GameController {
	
	/**
	 * Injeta uma instância de GameService no controlador.
	 * O Controller delega a lógica de negócio para o Service.
	 */
	@Autowired
	private GameService gameService;
	
	/**
	 * @GetMapping mapeia requisições HTTP do tipo GET para o endereço "/games"
	 * (que é o endereço base definido no @RequestMapping).
	 * Este método será executado quando um cliente fizer um GET para http://localhost:8080/games.
	 * @return Uma lista de GameMinDTO, que o Spring converterá automaticamente para o formato JSON.
	 */
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		GameDTO result = gameService.findById(id);
		return result;
	}
	@GetMapping
	public List<GameMinDTO> findAll() {
		// 1. O Controller chama o método findAll() do serviço para obter os dados.
		List<GameMinDTO> result = gameService.findAll();
		// 2. O Controller retorna o resultado. O Spring se encarrega de serializar
		// a lista de objetos Java para uma string no formato JSON e enviá-la na resposta HTTP.
		return result;
	}
}