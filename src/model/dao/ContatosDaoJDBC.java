package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import db.DB;
import entities.Contatos;

public class ContatosDaoJDBC implements ContatosDao {

	private Connection conn;

	public ContatosDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Contatos c) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO contato " + " (Id, Nome, Telefone, Email) "
					+ "VALUES " + "(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setInt(1,c.getId());
			st.setString(2, c.getNome());
			st.setString(3,c.getTelefone());
			st.setString(4,c.getTelefone());
			int linhasAfetadas=st.executeUpdate();
			if (linhasAfetadas>0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					c.setId(id);
					
				}
				DB.closeResultSet(rs);
				
			} else {

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		
		
	}

	@Override
	public void update(Contatos c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contatos findByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contatos findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contatos> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contatos> findByContantos(Contatos Contatos) {
		// TODO Auto-generated method stub
		return null;
	}

}
