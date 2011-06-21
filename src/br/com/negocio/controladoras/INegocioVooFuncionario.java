package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Aeroporto;
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
public interface INegocioVooFuncionario extends INegocioVoos {

     /**
     * Assinatura do método responsável por incluir um novo voo.
     *
     * @param voo Novo voo a ser incluído.
     */
    void incluirVoo(Voo voo) throws ErroPersistencia;

    /**
     * Assinatura do método responsável por remover um voo.
     *
     * @param codigos Codigos dos voos a ser removido.
     */
    void removerVoo(List<String> codigos) throws ErroPersistencia;

    /**
     * Assinatura do método responsável por editar um voo.
     *
     * @param voo Voo a ser editado.
     */
    void editarVoo(Voo voo) throws ErroPersistencia;

    List<Aeroporto> consultarAeroportos() throws ErroPersistencia;

    void incluirAeroporto(Aeroporto aeroporto) throws ErroPersistencia;

    void removerAeroporto(List<String> codigos) throws ErroPersistencia;

    void editarAeroporto(Aeroporto aeroporto, int indice)
            throws ErroPersistencia;

}
