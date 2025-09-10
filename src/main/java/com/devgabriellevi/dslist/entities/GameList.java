package com.devgabriellevi.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// IMPORTANTE: Para que esta classe se torne uma entidade do banco de dados,
// ela precisa das anotações @Entity e @Table, assim como a classe Game.
// Ex: @Entity @Table(name = "tb_game_list")
@Entity
@Table(name = "tb_game_list")
public class GameList {

	// Esta entidade também precisaria de um @Id e @GeneratedValue.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	// Construtor padrão exigido pelo JPA.
	public GameList () {
	}
	
	// Construtor com argumentos.
	public GameList(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getters e Setters.
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	// Métodos hashCode e equals para comparação de objetos, baseados no ID.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		GameList other = (GameList) obj;
		return Objects.equals(id, other.id);
	}
}