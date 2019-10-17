package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import contract.IEntity;
import contract.dao.IEnderecoDAO;
import model.Endereco;
import util.UtilJPA;

public class EnderecoDAO extends AbstractDAO implements IEnderecoDAO {

	@Override
	public List<Endereco> listAllEndereco(Endereco endereco) {
		return listAllEndereco(endereco, UtilJPA.getEntityManager(), true);
	}

	private List<Endereco> listAllEndereco(IEntity myEntity, EntityManager em, boolean closeEm) {
		//logging
		className = this.getClass().getSimpleName();
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		loggerInfo = className + "." + methodName + " - " + myEntity.toString();
		_logger.log(loggerInfo);

		String sQuery = "FROM Endereco";
		
		TypedQuery<Endereco> tQuery = em.createQuery(sQuery, Endereco.class);
		
		List<Endereco> records = (List<Endereco>) ((List<?>)tQuery.getResultList());
		
		return records;
	}
}
