package com.devgabriellevi.dslist.dto;

import com.devgabriellevi.dslist.entities.GameList;

public class GameListDTO {
	private Long id;
	private String name;
	
	//Constructor vazio
	public GameListDTO() {
	}

	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
}
