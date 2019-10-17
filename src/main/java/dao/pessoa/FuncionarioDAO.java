package dao.pessoa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import contract.IEntity;
import contract.dao.IFuncionarioDAO;
import dao.AbstractDAO;
import model.pessoa.Funcionario;
import model.pessoa.Pessoa;
import util.UtilJPA;

public class FuncionarioDAO extends AbstractDAO implements IFuncionarioDAO {

	@Override
	public List<Funcionario> listAllFuncionario(Funcionario funcionario) {
		return listAllFuncionario(funcionario, UtilJPA.getEntityManager(), true);
	}
	
	private List<Funcionario> listAllFuncionario(IEntity myEntity, EntityManager em, boolean closeEm) {
		//logging
		className = this.getClass().getSimpleName();
		methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		loggerInfo = className + "." + methodName + " - " + myEntity.toString();
		_logger.log(loggerInfo);
	
		String sQuery = "FROM Pessoa WHERE tipo_pessoa = 'Funcionario'";
		
		TypedQuery<Pessoa> tQuery = em.createQuery(sQuery, Pessoa.class);
		
		return (List<Funcionario>) ((List<?>)tQuery.getResultList());
	}

}
