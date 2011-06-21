package br.com.apresentacao.entidades;

import br.com.apresentacao.validacao.ValidaMatricula;

/**
 * Classe que representa um funcionario.
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class Funcionario extends Usuario {

    /** Matricula do funcionario. */
    private final String matricula;

    /**
     * Constroi um novo funcionario.
     *
     * @param nome Nome do funcionario.
     * @param telefone Telefone do funcionario.
     * @param matricula Matricula do funcionario.
     */
    public Funcionario(final String nome, final String telefone,
            final String matricula) {
        super(nome, telefone);
        this.matricula = ValidaMatricula.validar(matricula);
    }

    /**
     * Retorna a matricula do funcionario.
     * @return Matricula do funcionario.
     */
    public final String getMatricula() {
        return matricula;
    }

}
