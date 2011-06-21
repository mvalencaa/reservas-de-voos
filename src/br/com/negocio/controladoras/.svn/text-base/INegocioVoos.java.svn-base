package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Voo;
import br.com.persistencia.controladoras.ErroPersistencia;
import java.util.List;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public interface INegocioVoos {

    /** Assinatura do método executar. */
    void executar();

    /**
     * Assinatura do método responsável por retornar uma lista de voos
     * correspondentes com os parâmetros passados.
     *
     * @param cidadeOrigem Cidade de origem do voo.
     * @param cidadeDestino Cidade de destino do voo.
     * @param dataSaida Data de saída do voo.
     * @return Lista de voos correspondentes com os parâmetros passados.
     */
    List<Voo> consultarVoos(String cidadeOrigem, String cidadeDestino,
            String dataSaida) throws ErroPersistencia;

    /**
     * Assinatura do método responsável por retornar uma lista de todos
     * os voos.
     * @return Lista de voos correspondentes com os parâmetros passados.
     */
    List<Voo> consultarVoos() throws ErroPersistencia;
}
