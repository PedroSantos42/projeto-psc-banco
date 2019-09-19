package dao;

import javax.persistence.EntityManager;

import contract.IDAO;
import contract.IEntity;
import util.UtilJPA;

public class AbstractDAO implements IDAO {

	public void add(IEntity myEntity) {
		add(myEntity, UtilJPA.getEntityManager(), true);
	}
	
	private void add(IEntity myEntity, EntityManager em, boolean closeEm) {
		em.getTransaction().begin();
		em.persist(myEntity);
		em.getTransaction().commit();
		
		if (closeEm)
			em.close();
	}

	public void update(IEntity myEntity) {
		update(myEntity, UtilJPA.getEntityManager(), true);
	}
	
	private void update(IEntity myEntity, EntityManager em, boolean closeEm) {
		em.getTransaction().begin();
		em.merge(myEntity);
		em.getTransaction().commit();
		
		if (closeEm)
			em.close();
	}

	public void removeByPrimaryKey(IEntity myEntity, Object myPrimaryKey) {
		removeByPrimaryKey(myEntity, UtilJPA.getEntityManager(), true);
	}
	
	private void removeByPrimaryKey(IEntity myEntity, EntityManager em, boolean closeEm) {
		em.getTransaction().begin();
		
		IEntity entity = (IEntity) em.find(myEntity.getClass(), myEntity.getPrimaryKey());
		
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		
		em.getTransaction().commit();
		
		if (closeEm)
			em.close();
	}

	public void removeByObject(IEntity myEntity) {
		removeByObject(myEntity, UtilJPA.getEntityManager(), true);
	}
	
	private void removeByObject(IEntity myEntity, EntityManager em, boolean closeEm) {
		em.getTransaction().begin();
		em.remove(em.contains(myEntity) ? myEntity : em.merge(myEntity));
		em.getTransaction().commit();
		
		if (closeEm)
			em.close();
	}

	public IEntity listByPrimaryKey(Class myClass, Object myPrimaryKey) {
		return listByPrimaryKey(myClass, myPrimaryKey, UtilJPA.getEntityManager(), true);
	}
	
	private IEntity listByPrimaryKey(Class myClass, Object myPrimaryKey, EntityManager em, boolean closeEm) {
		IEntity entity = em.find(
				myClass,
				myPrimaryKey
				);
		
		if (closeEm)
			em.close();
		
		return entity;
	}

	public IEntity listByObject(IEntity myEntity) {
		return listByObject(myEntity, UtilJPA.getEntityManager(), true);
	}
	
	private IEntity listByObject(IEntity myEntity, EntityManager em, boolean closeEm) {
		IEntity entity = (IEntity) em.find(
				myEntity.getClass(),
				myEntity.getPrimaryKey()
				);
		
		if (closeEm)
			em.close();
		
		return entity;
	}
}
