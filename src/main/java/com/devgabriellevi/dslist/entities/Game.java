/**
 * Pacote para as Entidades (Entities).
 * Entidades são classes Java que representam as tabelas do seu banco de dados.
 */
package com.devgabriellevi.dslist.entities;

// Importações de classes para funcionalidades específicas.
import java.util.Objects; // Usado para implementar os métodos hashCode e equals de forma segura.
import jakarta.persistence.Column; // Para especificar detalhes do mapeamento da coluna.
import jakarta.persistence.Entity; // Marca a classe como uma entidade JPA.
import jakarta.persistence.GeneratedValue; // Configura a geração de chave primária.
import jakarta.persistence.GenerationType; // Define a estratégia de geração da chave.
import jakarta.persistence.Id; // Marca um campo como chave primária.
import jakarta.persistence.Table; // Especifica o nome da tabela no banco de dados.

/**
 * A anotação @Entity informa ao JPA (Java Persistence API) que esta classe é uma entidade
 * e deve ser mapeada para uma tabela no banco de dados.
 * O JPA é a especificação, e o Hibernate é a implementação que o Spring usa por padrão.
 */
@Entity
/**
 * A anotação @Table especifica o nome exato da tabela no banco de dados
 * que esta entidade representa. Se omitido, o nome da tabela seria o nome da classe (game).
 */
@Table(name = "tb_game")
public class Game {

	// @Id marca este atributo como a chave primária (Primary Key) da tabela.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue configura a estratégia de geração da chave primária.
	// GenerationType.IDENTITY indica que o próprio banco de dados será responsável por gerar o valor (ex: auto-incremento).
	private long id;
	
	// Atributos que serão mapeados para colunas na tabela 'tb_game'.
	// Se o nome do atributo for igual ao da coluna (convertido para snake_case),
	// a anotação @Column é opcional.
	private String title;
	
	// @Column é usado aqui para mapear o atributo 'year' para a coluna 'game_year'.
	@Column(name = "game_year")
	private Integer year;
	
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	// A propriedade columnDefinition = "TEXT" especifica o tipo exato da coluna no banco de dados,
	// útil para textos longos que podem não caber em um VARCHAR padrão.
	@Column(columnDefinition = "TEXT")
	private String shortDescription;
	
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	/**
	 * Construtor padrão (sem argumentos).
	 * O JPA exige que toda entidade tenha um construtor público ou protegido sem argumentos para poder criar instâncias dos objetos.
	 */
	public Game() {
	}

	/**
	 * Construtor com todos os argumentos para facilitar a criação de objetos Game já com todos os dados.
	 */
	public Game(long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
			String shortDescription, String longDescription) {
		
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	// --- MÉTODOS GETTERS E SETTERS ---
	// São métodos públicos que permitem que outras classes acessem ou modifiquem
	// os valores dos atributos privados, respeitando o encapsulamento.

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

	public void setPlatforms(String platform) {
		this.platforms = platform;
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

	/**
	 * O método hashCode gera um número inteiro (código hash) para um objeto.
	 * É usado por coleções baseadas em hash (como HashSet e HashMap) para armazenar e recuperar objetos de forma eficiente.
	 * A implementação aqui baseia o hash apenas no 'id', pois ele é único para cada jogo.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * O método equals é usado para comparar dois objetos e verificar se eles são "iguais".
	 * A implementação padrão (da classe Object) compara apenas a referência de memória.
	 * Aqui, sobrescrevemos para que dois objetos Game sejam considerados iguais se seus 'id' forem iguais.
	 * Isso é crucial para o JPA e para o funcionamento correto de coleções.
	 */
	@Override
	public boolean equals(Object obj) {
		// Verifica se é a mesma instância de memória.
		if (this == obj)
			return true;
		// Verifica se o objeto a ser comparado não é nulo.
		if (obj == null)
			return false;
		// Verifica se os objetos são da mesma classe.
		if (getClass() != obj.getClass())
			return false;
		// Faz o "cast" do objeto para o tipo Game para poder acessar seus atributos.
		Game other = (Game) obj;
		// Compara os IDs. Se forem iguais, os objetos são considerados iguais.
		return id == other.id;
	}
}