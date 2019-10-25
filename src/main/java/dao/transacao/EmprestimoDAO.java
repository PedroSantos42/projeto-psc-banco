package dao.transacao;

import java.util.List;

import contract.IEntity;
import contract.dao.IEmprestimoDAO;
import dao.AbstractDAO;
import model.transacao.Emprestimo;
import model.transacao.Transacao;
import util.UtilJPA;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmprestimoDAO extends AbstractDAO implements IEmprestimoDAO {
	
	@Override
	public List<Emprestimo> listAllEmprestimo(Emprestimo emprestimo){
		return listAllEmprestimo(emprestimo, UtilJPA.getEntityManager() , true);
	}
	
	private List<Emprestimo> listAllEmprestimo(IEntity myEntity, EntityManager em, boolean closeEm){
		// logging
		className = this.getClass().getSimpleName();
		methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		loggerInfo = className + "." + methodName + " - " + myEntity.toString();
		_logger.log(loggerInfo);
		
		String sQuery = "FROM Transacao WHERE tipo_transacao = 'Emprestimo'";
		TypedQuery<Transacao> tQuery = em.createQuery(sQuery, Transacao.class);
		List<Emprestimo> records = (List<Emprestimo>) ((List<?>)) tQuery.getResultList();
		
		if(closeEm)
			em.close();
		return records;
	}
}
