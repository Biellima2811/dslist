package com.devgabriellevi.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devgabriellevi.dslist.dto.GameDTO;
import com.devgabriellevi.dslist.dto.GameMinDTO;
import com.devgabriellevi.dslist.entities.Game;
import com.devgabriellevi.dslist.repositories.GameRepository;

/**
 * A anotação @Service marca esta classe como um componente da camada de Serviço.
 * O Spring irá gerenciar sua instância (criá-la e injetá-la onde for necessário).
 * Esta camada contém as regras de negócio da aplicação.
 */
@Service
public class GameService {
	
	/**
	 * A anotação @Autowired realiza a injeção de dependência.
	 * O Spring irá automaticamente injetar uma instância de GameRepository
	 * nesta variável quando a classe GameService for criada.
	 * Isso desacopla as camadas: o Service não precisa saber como criar um Repository.
	 */
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {

		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
	}
	
	/**
	 * Método de negócio para buscar todos os jogos.
	 * A responsabilidade deste método é buscar os dados do banco de dados (usando o repository)
	 * e convertê-los para o formato que a API deve expor (a lista de DTOs).
	 * @return Uma lista de GameMinDTO.
	 */
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		// 1. Chama o método findAll() do repositório, que executa um "SELECT * FROM tb_game" no banco.
		// O resultado é uma lista de entidades Game completas.
		List<Game> result = gameRepository.findAll();
		
		// 2. Converte a lista de entidades 'Game' para uma lista de 'GameMinDTO'.
		// .stream() -> Cria um fluxo de dados a partir da lista.
		// .map(x -> new GameMinDTO(x)) -> Para cada 'Game' (x) no fluxo, cria um novo 'GameMinDTO'.
		// .toList() -> Coleta os 'GameMinDTO' gerados e os agrupa em uma nova lista.
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}