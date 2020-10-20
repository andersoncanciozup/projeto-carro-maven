package br.com.zup.estrelas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.zup.estrelas.pojo.Carro;

public class CarroDAO {

	EntityManager manager;

	public CarroDAO() {
		this.manager = Persistence.createEntityManagerFactory("carros").createEntityManager();
	}

	public void insereCarro(Carro carro) {
		manager.getTransaction().begin();
		manager.persist(carro);
		manager.getTransaction().commit();

	}

	public List<Carro> listaCarros() {
		Query query = manager.createQuery("select c from Carro c");

		List<Carro> carros = query.getResultList();

		return carros;
	}

	public void removeCarro(String chassi) {
		Carro carroARemover = manager.find(Carro.class, chassi);

		manager.getTransaction().begin();
		manager.remove(carroARemover);
		manager.getTransaction().commit();
	}

	public Carro carroPesquisado(String chassi) {
		Carro consultaCarro = manager.find(Carro.class, chassi);

		return consultaCarro;

	}

	public List<Carro> listaCarrosCategoria(String categoria) {
		Query query = manager.createQuery("select c from Carro c where c.categoria = :categoria");

		query.setParameter("categoria", categoria);

		List<Carro> carros = query.getResultList();

		return carros;
	}

	public List<Carro> listaCarrosMontadora(String fabricante) {
		Query query = manager.createQuery("select c from Carro c where c.fabricante = :fabricante");
		
		query.setParameter("fabricante", fabricante);
		
		List<Carro> carros = query.getResultList();
				
		return carros;
	}
}