package contract.dao;

import java.util.List;
import model.transacao.Transferencia;

public interface ITransferenciaDAO {
	List<Transferencia> listAllTransferencia(Transferencia Transferencia);

}
