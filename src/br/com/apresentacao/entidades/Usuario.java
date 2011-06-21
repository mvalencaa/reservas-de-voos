package br.com.apresentacao.entidades;

import br.com.apresentacao.validacao.ValidaNome;
import br.com.apresentacao.validacao.ValidaTelefone;

/**
 * Classe que representa um usuário.
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class Usuario {

    /** Nome do usuário. */
    private String nome;
    /** Telefone do usuário. */
    private String telefone;

    /**
     * Constroi um novo usuário.
     *
     * @param nome Nome do usuário.
     * @param telefone Telefone do usuário.
     */
    public Usuario(final String nome, final String telefone) {
        this.nome = ValidaNome.validar(nome);
        this.telefone = ValidaTelefone.validar(telefone);
    }

    /**
     * Retorna o nome do usuário.
     * @return Nome da pessoa.
     */
    public final String getNome() {
        return nome;
    }

    /**
     * Altera o nome do usuário.
     * @param nome Novo nome
     */
    public final void setNome(final String nome) {
        this.nome =  ValidaNome.validar(nome);
    }

    /**
     * Retorna o telefone do usuário.
     * @return Telefone do usuário.
     */
    public final String getTelefone() {
        return telefone;
    }

    /**
     * Altera o telefone do usuário.
     * @param telefone Novo telefone.
     */
    public final void setTelefone(final String telefone) {
        this.telefone = ValidaTelefone.validar(telefone);
    }

}
