package com.devgabriellevi.dslist.entities;

import java.util.Objects;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * A anotação @Embeddable indica que esta classe não é uma entidade por si só,
 * mas seus atributos podem ser "embutidos" como parte de outra entidade.
 * É usada aqui para criar uma chave primária composta.
 */
@Embeddable
public class BelongingPK {
	
	// @ManyToOne define uma relação de muitos-para-um. Muitos "pertencimentos" podem ter o mesmo jogo.
	// @JoinColumn especifica a coluna de chave estrangeira (foreign key) na tabela de junção.
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList list;
	
	// Construtores, getters, setters, hashCode e equals.
	public BelongingPK() {
	}

	public BelongingPK(Game game, GameList list) {
		this.game = game;
		this.list = list;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public GameList getList() {
		return list;
	}
	public void setList(GameList list) {
		this.list = list;
	}


	// hashCode e equals são baseados em ambos os objetos (game e list),
	// pois juntos eles formam a chave única.
	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
}