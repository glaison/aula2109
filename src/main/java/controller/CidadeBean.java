package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Cidades;
import modelo.Estado;

@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public List<Cidades> cidades;
	Cidades c = new Cidades();
	Estado e = new Estado();
	
	public List<Cidades> getCidadeList() {
		cidades =  (ArrayList<Cidades>) Cidades.ler();
		return cidades;
	}
	
	public Integer getId() {
		return c.getId();
	}

	public void Integer(Integer id) {
		c.setId(id);
	}

	public String getNome() {
		return c.getNome();
	}

	public void setNome(String nome) {
		c.setNome(nome);
	}
	

	/*public Integer getIdEstado() {
		return c.getIdEstado();
	}
	
	public void setIdEstado(Integer idEstado) {
		c.setIdEstado(idEstado);
	} */
	
	public Integer getIdEstado() {
		return c.getIdEstado();
		
	}
	
	public void setIdEstado(Integer idEstado) {
		c.setIdEstado(idEstado);
	}
	
	
	
	public void adicionar() {
		System.out.println("ID_ESTADO= "+c.getIdEstado());
		
		Cidades.inserir(c);

		
	}


}
