package controller;

import modelo.Fornec;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import dao.ConexaoFactory;

public class Fornecedores {
	
	public void salvar(Fornec f) throws SQLException {
		
		StringBuilder sql  = new StringBuilder();
		
		sql.append("INSERT INTO fornecedores");
		sql.append("nome");
		sql.append("VALUES(?)");
		
		
		Connection conexao =  ConexaoFactory.conectar();	
		
		PreparedStatement commando =  conexao.prepareStatement(sql.toString());
		commando.setString(1, f.getNome());
		commando.executeUpdate();
		
	}
	
	public static void main(String[] args) {
		Fornec f1 = new Fornec();
		f1.setNome("Primeiro Fornecedor");
		
		Fornec f2 = new Fornec();
		f2.setNome("Segundo Fornecedor");
		
		Fornecedores f = new Fornecedores();
		
		try {
			f.salvar(f1);
			f.salvar(f2);
			System.out.println("Salvo com sucesso!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao salvar!!!");
		}
		
		
	}

}
