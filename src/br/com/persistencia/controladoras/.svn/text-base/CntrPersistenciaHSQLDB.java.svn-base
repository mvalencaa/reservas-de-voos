package br.com.persistencia.controladoras;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.3
 */
public class CntrPersistenciaHSQLDB extends CntrPersistencia {

    /** Driver para conexão com o Banco de Dados.*/
    private static String driver = "org.hsqldb.jdbc.JDBCDriver";
    //private static String driver = "org.hsqldb.jdbcDriver";

    /** Variavel para o Singleton. */
    private static CntrPersistenciaHSQLDB instance = null;

    /**
     * Singleton para a controladora de persistencia HSQLDB.
     * @return instance Instancia.
     * @throws ErroPersistencia Exceção.
     */
    public static CntrPersistenciaHSQLDB getInstancia()
            throws ErroPersistencia {
        if (instance == null) {
            instance = new CntrPersistenciaHSQLDB();
        }
        return instance;
    }

    /**
     * Construtor.
     * @throws ErroPersistencia Exceção.
     */
    public CntrPersistenciaHSQLDB() throws ErroPersistencia {
        super();
    }

    @Override
    protected final void criarDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro na carga do Driver");
        }
    }
}
