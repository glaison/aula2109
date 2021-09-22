package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Estado;

@ManagedBean
@ViewScoped
public class EstadoBean {
	Estado e = new Estado();
	
	public List<Estado> estados;
	
	public List<Estado> getEstadoList(){
		estados =  (ArrayList<Estado>) Estado.ler();
		return estados;
	}
	

	
	
	
	
	public Integer getId() {
		return e.getId();
	}

	public void setId(Integer id) {
		e.setId(id);
	}

	public String getSigla() {
		return e.getSigla();
	}

	public void setSigla(String sigla) {
		e.setSigla(sigla);
	}

	public String getDescricao() {
		return e.getDescricao();
	}

	public void setDescricao(String descricao) {
		e.setDescricao(descricao);
	}
	
	public void adicionar() {
		Estado.inserir(e);
		
	}


}
