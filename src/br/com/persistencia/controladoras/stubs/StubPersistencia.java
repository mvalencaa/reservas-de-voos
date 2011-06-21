package br.com.persistencia.controladoras.stubs;

import br.com.negocio.comandos.CmdBD;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.controladoras.IPersistencia;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class StubPersistencia implements IPersistencia {

    /**
     * Cenário 1:
     * A primeira reserva a ser cadastrada é cadastrada com sucesso ao selecio-
     * nar 5 voos. A segunda tentativa de cadastrar
     * uma reserva dirá que um dos voos selecionados não tem vaga, e a
     * terceira tentativa de cadastrar uma reserva dirá que um cliente não
     * pode realizar mais que duas reservas.
     *
     * Cenário2:
     * Rode novamente o programa e selecione 6 voos para testar a regra de
     * negócio de 5 voos por reserva. Depois selecione o número de voos que
     * gostaria, e a reserva será cadastrada, desde que tenha selecionado no
     * máximo 5 voos.
     *
     * @param cmd Comando de consulta, remoção, edição ou cadastrar.
     * @throws ErroPersistencia Erro lançado.
     */
    public final void executar(final CmdBD cmd) throws ErroPersistencia {
        cmd.stubBD();
    }

}
