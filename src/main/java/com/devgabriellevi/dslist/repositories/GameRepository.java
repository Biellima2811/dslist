package com.devgabriellevi.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devgabriellevi.dslist.entities.Game;

public interface GameRepository extends JpaRepository <Game, Long>{

}
