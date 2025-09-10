package com.devgabriellevi.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devgabriellevi.dslist.dto.GameListDTO;
import com.devgabriellevi.dslist.entities.GameList;
import com.devgabriellevi.dslist.repositories.GameListRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    /**
     * Busca todas as listas de jogos do banco de dados e as converte para DTOs.
     * @return Uma lista de GameListDTO.
     */
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        // 1. Busca todas as entidades GameList do banco de dados.
        List<GameList> result = gameListRepository.findAll();
        
        // 2. Converte a lista de entidades 'GameList' para uma lista de 'GameListDTO'.
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}