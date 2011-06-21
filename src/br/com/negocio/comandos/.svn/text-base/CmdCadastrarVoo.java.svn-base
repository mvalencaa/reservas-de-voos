package br.com.negocio.comandos;

import br.com.apresentacao.entidades.Voo;
import br.com.negocio.controladoras.ErroCadastro;
import br.com.persistencia.controladoras.ErroPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CmdCadastrarVoo extends CmdCadastrar {

    /** Trigger de Erro. */
    private static int erro = 0;

    /**
     * Construtor que recebe um novo Voo cujo os atributos comporão.
     * o comando SQL para inserção no banco de dados.
     *
     * @param voo um objeto que contém os atributos a serem inseridos.
     */
    public CmdCadastrarVoo(final Voo voo) {
        System.out.println("Entrou!");
        if (voo.getNumero().equals("AAA111")) {
            erro = 1;
        } else if (voo.getNumero().equals("BBB222")) {
            erro = 2;
        } else {
            erro = 0;
        }
        if (voo == null) {
            throw new IllegalArgumentException("Voo não informado");
        }
        comandoSQL = "INSERT INTO VOO VALUES"
                    + "('" + voo.getNumero() + "',"
                    + "'" + voo.getNroVagas() + "',"
                    + "'" + voo.getHoraSaida() + "',"
                    + "'" + voo.getHoraChegada() + "',"
                    + "'" + voo.getDataSaida() + "',"
                    + "'" + voo.getDataChegada() + "')";
    }

    @Override
    public final void stubBD() throws ErroPersistencia {
        if (erro == 0) {
            System.out.println("Cadastrado com Sucesso!");
        } else if (erro == 1){
            throw new ErroCadastro("Voo já cadastrado!");
        } else if (erro == 2) {
            throw new ErroPersistencia("Erro de Conexão com o Banco.");
        }
    }
}