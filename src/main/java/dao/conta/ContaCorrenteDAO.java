package dao.conta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import contract.IEntity;
import contract.dao.IContaCorrenteDAO;
import dao.AbstractDAO;
import model.conta.Conta;
import model.conta.ContaCorrente;
import util.UtilJPA;

public class ContaCorrenteDAO extends AbstractDAO implements IContaCorrenteDAO {

	@Override
	public List<ContaCorrente> listAllContaCorrente(ContaCorrente contaCorrente) {
		return listAllContaCorrente(contaCorrente, UtilJPA.getEntityManager(), true);
	}

	private List<ContaCorrente> listAllContaCorrente(IEntity myEntity, EntityManager em, boolean closeEm) {
		// logging
		className = this.getClass().getSimpleName();
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		loggerInfo = className + "." + methodName + " - " + myEntity.toString();
		_logger.log(loggerInfo);

		String sQuery = "FROM Conta WHERE tipo_conta = 'ContaCorrente'";

		TypedQuery<Conta> tQuery = em.createQuery(sQuery, Conta.class);

		List<ContaCorrente> records = (List<ContaCorrente>) ((List<?>) tQuery.getResultList());

		if (closeEm)
			em.close();

		return records;
	}

}
