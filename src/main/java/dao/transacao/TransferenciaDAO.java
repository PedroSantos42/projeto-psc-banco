package dao.transacao;

import contract.dao.ITransferenciaDAO;
import dao.AbstractDAO;
import java.util.List;

import contract.IEntity;
import model.transacao.Transferencia;
import model.transacao.Emprestimo;
import model.transacao.Transacao;
import util.UtilJPA;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class TransferenciaDAO extends AbstractDAO implements ITransferenciaDAO  {
	
	@Override
	public List<Transferencia> listAllTransferencia(Transferencia transferencia){
		return listAllTransferencia(transferencia, UtilJPA.getEntityManager() , true);
	}
	
	private List<Transferencia> listAllTransferencia(IEntity myEntity, EntityManager em, boolean closeEm){
		// logging
		className = this.getClass().getSimpleName();
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		loggerInfo = className + "." + methodName + " - " + myEntity.toString();
		_logger.log(loggerInfo);
		
		String sQuery = "FROM Transacao WHERE tipo_transacao = 'Transferencia'";
		
		TypedQuery<Transacao> tQuery = em.createQuery(sQuery, Transacao.class);
		
		List<Transferencia> records = (List<Transferencia>) ((List<?>)tQuery.getResultList());
		
		if(closeEm)
			em.close();
		return records;
	}

}
