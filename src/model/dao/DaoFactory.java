
package model.dao;

import db.DB;

public class DaoFactory {

	public static ContatosDao createContatosDao() {
		return new ContatosDaoJDBC(DB.getConnection());
	}

	
}

