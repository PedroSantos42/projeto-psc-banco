package dao.conta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import contract.IEntity;
import contract.dao.IContaPoupancaDAO;
import dao.AbstractDAO;
import model.conta.Conta;
import model.conta.ContaPoupanca;
import util.UtilJPA;

public class ContaPoupancaDAO extends AbstractDAO implements IContaPoupancaDAO {

	@Override
	public List<ContaPoupanca> listAllContaPoupanca(ContaPoupanca contaPoupanca) {
		return listAllContaPoupanca(contaPoupanca, UtilJPA.getEntityManager(), true);
	}

	private List<ContaPoupanca> listAllContaPoupanca(IEntity myEntity, EntityManager em, boolean closeEm) {
		// logging
		className = this.getClass().getSimpleName();
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		loggerInfo = className + "." + methodName + " - " + myEntity.toString();
		_logger.log(loggerInfo);

		String sQuery = "FROM Pessoa WHERE tipo_conta = 'ContaPoupanca'";

		TypedQuery<ContaPoupanca> tQuery = em.createQuery(sQuery, ContaPoupanca.class);

		List<ContaPoupanca> records = (List<ContaPoupanca>) ((List<?>) tQuery.getResultList());

		if (closeEm)
			em.close();

		return records;
	}

}
