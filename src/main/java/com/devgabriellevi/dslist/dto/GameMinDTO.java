package com.devgabriellevi.dslist.dto;

import com.devgabriellevi.dslist.entities.Game;

/**
 * GameMinDTO (Data Transfer Object) é uma classe que serve como um "contrato" ou "molde"
 * para os dados que a API irá expor publicamente.
 * O objetivo é enviar apenas as informações necessárias para o cliente (frontend),
 * omitindo dados internos ou desnecessários (como longDescription, score, etc.).
 * Isso torna a API mais segura, leve e eficiente.
 */
public class GameMinDTO {

	// Atributos que serão expostos na API.
	private long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	// Construtor padrão.
	public GameMinDTO() {
	}

	/**
	 * Construtor que recebe uma entidade Game e copia apenas os dados necessários.
	 * Esta é a forma mais comum de converter uma Entidade em um DTO.
	 * @param entity A entidade Game original vinda do banco de dados.
	 */
	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
		
	}

	// Apenas getters são necessários, pois um DTO é, geralmente, um objeto de dados imutável
	// usado apenas para transporte.
	public long getId() { return id; }
	public String getTitle() { return title; }
	public Integer getYear() { return year; }
	public String getImgUrl() { return imgUrl; }
	public String getShortDescription() { return shortDescription; }
}