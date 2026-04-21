package model.dao;

import java.util.List;

import entities.Contatos;

public interface ContatosDao {

	void insert(Contatos c);

	void update(Contatos c);

	void deleteById(Integer id);

	Contatos findByName(String nome);

	Contatos findById(Integer id);

	List<Contatos> findAll();

	/* List<Contatos> findByContantos(Contatos Contatos); */

}
