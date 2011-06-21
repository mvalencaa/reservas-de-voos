package br.com.negocio.comandos;

import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.3
 */
public class CmdCadastrarAeroportoChegada extends CmdCadastrar {

    /**
     * Construtor que recebe o código do aeroporto e o número do voo e
     * cadastra um novo relacionamento no banco de dados.
     *
     * @param aeroportoCodigo Código do aeroporto.
     * @param vooNro Número do voo.
     */
    public CmdCadastrarAeroportoChegada(final String aeroportoCodigo,
            final String vooNro) {
        comandoSQL = "INSERT INTO AEROPORTO_CHEGADA VALUES"
                + "('" + vooNro + "',"
                + "'" + aeroportoCodigo + "')";
    }

    @Override
    public void stubBD() throws ErroPersistencia {

    }

}
