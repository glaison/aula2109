package modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String nome;

	@Column
	private String cpf;

	@Column
	private String endereco;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidades cidade;


	// determina que essa tabela é gerenciada por outra informa qual a entidade estamos associando

	
	/*
	 * usado para performance, nem todos os campos são carregados até que sejam  necessários todos os eventos anteriores serão sempre refletidos nas entidades
	 * relacionadas
	 */
	@OneToMany(mappedBy = "cliente", targetEntity = Imoveis.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Imoveis> imoveis;// um cliente pode ter vários imóveis demais getters e setters das propriedades private
	
	

	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	
	
								
}