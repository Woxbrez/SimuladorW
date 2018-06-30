package br.com.treinando;

import br.com.util.HibernateUtil;

public class GeraTabela {

	public static void main(String[] args) {
		try {
			HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
