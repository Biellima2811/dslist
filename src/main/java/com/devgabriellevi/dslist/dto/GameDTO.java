/**
 * Pacote para os DTOs (Data Transfer Objects).
 * Estas classes definem a estrutura dos dados que são transferidos entre as camadas
 * e, principalmente, expostos pela API.
 */
package com.devgabriellevi.dslist.dto;

// Importações de classes necessárias.
import com.devgabriellevi.dslist.entities.Game;
import org.springframework.beans.BeanUtils;

/**
 * GameDTO é uma classe que representa a visão COMPLETA de uma entidade Game.
 * Diferente do GameMinDTO, este DTO carrega todos os dados de um jogo.
 * É ideal para ser usado em uma tela de detalhes de um jogo específico,
 * onde o usuário precisa ver todas as informações.
 */
public class GameDTO {

    // --- ATRIBUTOS ---
    // Estes atributos espelham os da classe Game para facilitar a transferência de dados.
    private long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    /**
     * Construtor padrão (sem argumentos).
     * É uma boa prática ter um construtor vazio, pois muitas bibliotecas e frameworks (como o JPA e o Jackson)
     * precisam dele para criar instâncias da classe.
     */
    public GameDTO() {
    }
    
    /**
     * Construtor que recebe uma entidade Game.
     * Este é o ponto central da conversão de uma Entidade para um DTO.
     * Ele cria um GameDTO a partir de um objeto Game vindo do banco de dados.
     * @param entity O objeto Game original que será convertido.
     */
    public GameDTO(Game entity) {
        // BeanUtils.copyProperties é um utilitário do Spring que copia os valores
        // dos atributos de um objeto para outro, contanto que os nomes e tipos
        // dos atributos sejam os mesmos. É uma forma rápida e limpa de evitar
        // fazer a atribuição manual (this.id = entity.getId(), this.title = entity.getTitle(), etc.).
        BeanUtils.copyProperties(entity, this);
    }

    // --- MÉTODOS GETTERS E SETTERS ---
    // Métodos públicos que permitem que outras partes do programa acessem (get) e
    // modifiquem (set) os valores dos atributos privados, respeitando o encapsulamento.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}