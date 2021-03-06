package br.com.negocio.builders;

import br.com.apresentacao.controladoras.IInteracaoCliente;
import br.com.negocio.controladoras.CntrNegocioCliente;
import br.com.negocio.controladoras.CntrNegocioReserva;
import br.com.negocio.controladoras.CntrNegocioVoo;
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
public final class BuilderNegocioCliente {

    /**
     * Construtor.
     */
    private BuilderNegocioCliente() { }

    /**
     * Cria as controladoras de negócio e seta suas controladoras de
     * persistencia e por fim, seta a controladora de negócio na controladora
     * de interacao.
     * @param cntr Controladora de interacao.
     * @throws ErroPersistencia Exceção.
     */
    public static void criar(final IInteracaoCliente cntr)
            throws ErroPersistencia {
        CntrNegocioCliente cntrNegCliente = new CntrNegocioCliente();
        CntrNegocioVoo cntrNegVoo = new CntrNegocioVoo();
        CntrNegocioReserva cntrNegReserva = new CntrNegocioReserva();

        FabricaDeConexoes fabrica = new FabricaDeConexoes();
        try {
            CntrPersistenciaHSQLDB.setConnection(fabrica.getConnection());
        } catch (SQLException ex) {
            System.out.println("Erro ao criar conexão com Banco de Dados");
        }

        cntrNegVoo.setControladora(CntrPersistenciaHSQLDB.getInstancia());
        cntrNegCliente.setControladora(CntrPersistenciaHSQLDB.getInstancia());
        cntrNegReserva.setControladora(CntrPersistenciaHSQLDB.getInstancia());
        cntr.setControladoraCliente(cntrNegCliente);
        cntr.setControladoraVoos(cntrNegVoo);
        cntr.setControladoraReserva(cntrNegReserva);
    }
}
