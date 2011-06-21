package br.com.persistencia.controladoras;

import br.com.persistencia.fabrica.FabricaDeConexoes;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.3
 */
public class CntrPersistenciaHSQLDBTest {

    public CntrPersistenciaHSQLDBTest() {
    }

    /**
     * Teste do metodo getInstancia, da classe CntrPersistenciaHSQLDB.
     */
    @Test
    public void testGetInstancia() throws Exception {
        System.out.println("getInstancia");
        CntrPersistenciaHSQLDB result = CntrPersistenciaHSQLDB.getInstancia();
        assertNotNull(result);
    }

    /**
     * Teste do metodo criar driver, da classe CntrPersistenciaHSQLDB.
     */
    @Test
    public void testCriarDriver() {
        try {
            System.out.println("criarDriver");
            CntrPersistenciaHSQLDB instance = new CntrPersistenciaHSQLDB();
            instance.criarDriver();
            assert(true);
        } catch (ErroPersistencia ex) {
            System.out.println("Erro ao criar driver.");
            fail("The test case is a prototype.");
        }
    }

    /**
     * Teste do metodo SetConnection, da classe CntrPersistenciaHSQLDB.
     */
    @Test
    public void testSetConnection() {
        FabricaDeConexoes fabrica = new FabricaDeConexoes();
        try {
            CntrPersistenciaHSQLDB.setConnection(null);
            assert(true);
        } catch (Exception ex) {
            fail("Erro ao criar conexão com Banco de Dados");
        }
    }

    /**
     * Teste do metodo Executar, da classe CntrPersistenciaHSQLDB.
     */
    @Test
    public void testExecutar() {
        try {
            CntrPersistenciaHSQLDB cntr = new CntrPersistenciaHSQLDB();
            cntr.executar(null);
            fail("Exceção não lançada ao executar comando null");
        } catch (Exception ex) {
            System.out.println("Exceção ao executar comando null");
        }
    }

}