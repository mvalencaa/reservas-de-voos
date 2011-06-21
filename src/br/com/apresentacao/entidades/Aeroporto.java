package br.com.apresentacao.entidades;

import br.com.apresentacao.validacao.ValidaCodAeroporto;
import br.com.apresentacao.validacao.ValidaNome;

/**
 * Classe que representa um aeroporto.
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class Aeroporto {

    /** Codigo do aeroporto. */
    private final String codigo;
    /** Cidade do aeroporto. */
    private final String cidade;

    /**
     * Constroi um novo aeroporto.
     *
     * @param cidade Cidade do aeroporto.
     */
    public Aeroporto(String cidade, String codigo) {
        this.codigo = ValidaCodAeroporto.validar(codigo);
        this.cidade = ValidaNome.validar(cidade);
    }

    /**
     * Retorna a cidade do aeroporto.
     * @return Cidade do aeroporto.
     */
    public final String getCidade() {
        return cidade;
    }

    /**
     * Retorna o codigo do aeroporto.
     * @return Codigo do aeroporto.
     */
    public final String getCodigo() {
        return codigo;
    }

}
