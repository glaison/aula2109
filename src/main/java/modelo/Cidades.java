package modelo;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateError;
import dao.DAO;

@Entity
@Table(name = "cidades")
public class Cidades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String nome;
	
	@ManyToOne(targetEntity = Estado.class)
	@JoinColumn(name = "id_estado")
	private Integer idEstado;
	
	
	
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

	public Integer getIdEstado() {
		return idEstado;
	}
	
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}


	
	
	
	@Override
	public String toString() {
		return "Cidades [id=" + id + ", nome=" + nome + ", idEstado=" + idEstado + "]";
	}

	public static List<Cidades> ler() { 
		EntityManager entityManager = DAO.getEntityManager();
		
		String jpql = "SELECT obj from Cidades obj";
		TypedQuery<Cidades> query = entityManager.createQuery(jpql, Cidades.class);
			try {
				System.out.println(query.getResultList());
				return query.getResultList();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return query.getResultList();		
	}
	
	
	public static void inserir(Cidades c) {
		System.out.println(c.toString());

		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Cadastro efetuado", " com sucesso!!!");
				context.addMessage(null, mensagem);
		try {
			EntityManager entityManager = DAO.getEntityManager();
			entityManager.getTransaction().begin();
				entityManager.persist(c);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("cidade Salva!");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("cidade inserido"));

		} catch (HibernateError ex) {
			ex.printStackTrace();
		}
	}
	
	

}
