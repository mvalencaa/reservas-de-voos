package br.com.negocio.builders;

import br.com.apresentacao.controladoras.IInteracaoFuncionario;
import br.com.negocio.controladoras.CntrNegocioFuncionario;
import br.com.negocio.controladoras.CntrNegocioVooFuncionario;
import br.com.persistencia.controladoras.CntrPersistenciaHSQLDB;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.fabrica.FabricaDeConexoes;
import java.sql.SQLException;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.3
 */
public final class BuilderNegocioFuncionario {

    /**
     * Construtor.
     */
    private BuilderNegocioFuncionario() { }

    /**
     * Cria as controladoras de negócio e seta suas controladoras de
     * persistencia e por fim, seta a controladora de negócio na controladora
     * de interacao.
     * @param cntr Controladora de interacao.
     * @throws ErroPersistencia Exceção.
     */
    public static void criar(final IInteracaoFuncionario cntr)
            throws ErroPersistencia {
        CntrNegocioFuncionario cntrNegFunc = new CntrNegocioFuncionario();
        CntrNegocioVooFuncionario cntrNegVoo = new CntrNegocioVooFuncionario();

        FabricaDeConexoes fabrica = new FabricaDeConexoes();
        try {
            CntrPersistenciaHSQLDB.setConnection(fabrica.getConnection());
        } catch (SQLException ex) {
            System.out.println("Erro ao criar conexão com Banco de Dados");
        }

        cntrNegVoo.setControladora(CntrPersistenciaHSQLDB.getInstancia());
        cntrNegFunc.setControladora(CntrPersistenciaHSQLDB.getInstancia());
        cntr.setControladoraFuncionario(cntrNegFunc);
        cntr.setControladoraVoo(cntrNegVoo);
    }
}
