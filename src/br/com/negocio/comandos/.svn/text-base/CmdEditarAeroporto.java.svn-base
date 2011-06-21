package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdEditarAeroporto extends CmdEditar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe um novo Aeroporto cujos atributos comporão
     * o comando SQL para edição no banco de dados.
     *
     * @param aeroporto Aeroporto a ser editado no banco de dados.
     */
    public CmdEditarAeroporto(final Aeroporto aeroporto) {
        if (aeroporto.getCodigo().equals("BBB")) {
            erro = 1;
        } else {
            erro = 0;
        }
        if (aeroporto == null) {
            throw new IllegalArgumentException("Aeroporto não informado.");
        }
        comandoSQL = "UPDATE AEROPORTO SET (CIDADE)= "
                + "('" + aeroporto.getCidade() + "') WHERE CODIGO ='"
                + aeroporto.getCodigo() + "'";
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Aeroporto editado com Sucesso!");
        } else if (erro == 1){
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }

}
