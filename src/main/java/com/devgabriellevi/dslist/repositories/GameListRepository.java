package com.devgabriellevi.dslist.repositories;

// Importa a classe JpaRepository do Spring Data JPA.
import org.springframework.data.jpa.repository.JpaRepository;

import com.devgabriellevi.dslist.entities.GameList;

/**
 * GameRepository é uma interface que define as operações de acesso a dados para a entidade Game.
 * Ao estender JpaRepository<Game, Long>, ela herda automaticamente uma série de métodos
 * para realizar operações CRUD (Create, Read, Update, Delete) no banco de dados.
 *
 * JpaRepository<Game, Long> significa:
 * - Game: A entidade que este repositório gerencia.
 * - Long: O tipo da chave primária (ID) da entidade Game.
 *
 * O Spring Data JPA se encarrega de criar uma implementação concreta desta interface em tempo de execução.
 * Você não precisa escrever nenhum código SQL para métodos como findAll(), findById(), save(), delete(), etc.
 */
public interface GameListRepository extends JpaRepository <GameList, Long> {
	// Você pode adicionar métodos de consulta personalizados aqui, se necessário.
	// O Spring Data JPA os implementará automaticamente com base no nome do método.
	// Ex: List<Game> findByYear(Integer year);
}