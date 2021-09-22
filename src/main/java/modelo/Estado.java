package modelo;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateError;


import dao.DAO;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 2)
	private String sigla;
	
	@Column(length = 100)
	private String descricao;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public static List<Estado> ler() { 
		EntityManager entityManager = DAO.getEntityManager();
		
		String jpql = "SELECT obj from Estado obj";
		TypedQuery<Estado> query = entityManager.createQuery(jpql, Estado.class);
			try {
				System.out.println(query.getResultList());
				return query.getResultList();				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return query.getResultList();		
	}

	
	
	public static void inserir(Estado e) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(
				FacesMessage.SEVERITY_INFO, "Cadastro efetuado", " com sucesso!!!");
				context.addMessage(null, mensagem);
		
		try {
			EntityManager entityManager = DAO.getEntityManager();
			entityManager.getTransaction().begin();
				entityManager.persist(e);
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println("conectado Salvo!");

		} catch (HibernateError ex) {
			ex.printStackTrace();
		}
	}
	

}
