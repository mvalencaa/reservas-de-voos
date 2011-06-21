package br.com.apresentacao.entidades;

import br.com.apresentacao.validacao.ValidaCpf;

/**
 * Classe que representa um cliente.
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class Cliente extends Usuario {

    /** CPF do Cliente. */
    private final String cpf;

    /**
     * Constroi um novo cliente.
     *
     * @param nome Nome do cliente.
     * @param telefone Telefone do cliente.
     * @param cpf CPF do cliente.
     */
    public Cliente(final String nome, final String telefone, final String cpf) {
        super(nome, telefone);
        this.cpf = ValidaCpf.validar(cpf);
    }

    /**
     * Retorna o CPF do cliente.
     * @return CPF do cliente.
     */
    public final String getCpf() {
        return cpf;
    }

}
