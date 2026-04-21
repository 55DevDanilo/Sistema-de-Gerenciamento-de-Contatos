package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
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
			st = conn.prepareStatement("INSERT INTO contatos " + " (Nome, Telefone, Email) " + "VALUES " + "(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, c.getNome());
			st.setString(2, c.getTelefone());
			st.setString(3, c.getEmail());
			int linhasAfetadas = st.executeUpdate();
			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);// 1 - > referente a retornar a primieira(e única) posição
					c.setId(id);

				}
				DB.closeResultSet(rs);

			} else {
				throw new DbException("Unexpected error! No rows affected!");

			}

		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		} finally {

			DB.closeStatement(st);

		}

	}

	@Override
	public void update(Contatos c) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {

			st = conn.prepareStatement("UPDATE contatos" + " SET Nome = ?, Telefone = ?, Email = ? " + "WHERE Id = ?");
			st.setString(1, c.getNome());
			st.setString(2, c.getTelefone());
			st.setString(3, c.getEmail());
			st.setInt(4, c.getId());
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM contatos where Id = ?");
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public Contatos findByName(String nome) {
		// TODO Auto-generated method stub
		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			st = conn.prepareStatement("SELECT * FROM contatos WHERE nome = ?");
			st.setString(1, nome);
			rs = st.executeQuery();
			if (rs.next()) {

				return instantContatos(rs);
			}
			return null;

		} catch (

		SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Contatos instantContatos(ResultSet rs) throws SQLException {
		Contatos cont = new Contatos();
		cont.setNome(rs.getString("nome"));
		cont.setEmail(rs.getString("email"));
		cont.setTelefone(rs.getString("telefone"));
		cont.setId(rs.getInt("id"));
		return cont;
	}

	@Override
	public Contatos findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {

			st = conn.prepareStatement("SELECT * FROM contatos WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				return instantContatos(rs);

			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Contatos> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM contatos " + "ORDER BY Nome");
			rs = st.executeQuery();
			List<Contatos> list = new ArrayList<>();
			while (rs.next()) {
				list.add(instantContatos(rs));
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);

		}
	}

	@Override
	public List<Contatos> findByContantos(Contatos contatos) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT nome FROM constatos " + " where Nome = ? " + " ORDER BY Nome");
			st.setString(1, contatos.getNome());
			rs = st.executeQuery();
			List<Contatos> list = new ArrayList<>();
			while (rs.next()) {
				list.add(instantContatos(rs));
			}

			return list;
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

}
