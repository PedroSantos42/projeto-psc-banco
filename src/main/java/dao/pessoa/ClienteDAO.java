package dao.pessoa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import contract.IEntity;
import contract.dao.IClienteDAO;
import dao.AbstractDAO;
import model.pessoa.Cliente;
import model.pessoa.Pessoa;
import util.UtilJPA;

public class ClienteDAO extends AbstractDAO implements IClienteDAO {

	@Override
	public List<Cliente> listAllCliente(Cliente cliente) {
		return listAllCliente(cliente, UtilJPA.getEntityManager(), true);
	}
	
	private List<Cliente> listAllCliente(IEntity myEntity, EntityManager em, boolean closeEm) {
		//logging
		className = this.getClass().getSimpleName();
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		loggerInfo = className + "." + methodName + " - " + myEntity.toString();
		_logger.log(loggerInfo);

		String sQuery = "FROM Pessoa WHERE tipo_pessoa = 'Cliente'";
		
		TypedQuery<Pessoa> tQuery = em.createQuery(sQuery, Pessoa.class);
		
		List<Cliente> records = (List<Cliente>) (List<?>) tQuery.getResultList();
		
		if (closeEm)
			em.close();
		
		return records;
	}
}
