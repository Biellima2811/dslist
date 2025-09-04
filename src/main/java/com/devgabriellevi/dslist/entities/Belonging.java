package com.devgabriellevi.dslist.entities;

// IMPORTANTE: Esta classe representa a tabela de junção (join table)
// que resolve a relação de muitos-para-muitos entre Game e GameList.
// Ela precisaria da anotação @Entity para ser uma entidade do banco de dados.
// Ex: @Entity @Table(name = "tb_belonging")
public class Belonging {

	// A chave primária desta entidade é a classe embutida (embedded) BelongingPK.
	// Ela precisaria da anotação @EmbeddedId para funcionar.
	private BelongingPK id = new BelongingPK();
	
	// Além da chave composta, a tabela de junção pode ter outros dados,
	// como a posição do jogo naquela lista específica.
	private Integer position;
	
	// Faltariam os construtores, getters e setters para a classe funcionar completamente.
}