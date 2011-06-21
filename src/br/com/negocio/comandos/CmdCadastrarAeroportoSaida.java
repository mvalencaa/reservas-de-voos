package br.com.negocio.comandos;

import br.com.persistencia.controladoras.ErroPersistencia;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdCadastrarAeroportoSaida extends CmdCadastrar {

    /**
     * Construtor que recebe o código do aeroporto e o número do voo e
     * cadastra um novo relacionamento no banco de dados.
     *
     * @param aeroportoCodigo Código do aeroporto.
     * @param vooNro Número do voo.
     */
    public CmdCadastrarAeroportoSaida(final String aeroportoCodigo,
            final String vooNro) {
        comandoSQL = "INSERT INTO AEROPORTO_SAIDA VALUES"
                + "('" + vooNro + "',"
                + "'" + aeroportoCodigo + "')";
    }

    @Override
    public void stubBD() throws ErroPersistencia {

    }
}
