package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Voo;
import br.com.negocio.comandos.CmdCadastrarAeroporto;
import br.com.negocio.comandos.CmdCadastrarAeroportoChegada;
import br.com.negocio.comandos.CmdCadastrarAeroportoSaida;
import br.com.negocio.comandos.CmdCadastrarVoo;
import br.com.negocio.comandos.CmdConsultarAeroporto;
import br.com.negocio.comandos.CmdEditarAeroporto;
import br.com.negocio.comandos.CmdEditarVoo;
import br.com.negocio.comandos.CmdRemoverAeroporto;
import br.com.negocio.comandos.CmdRemoverVoo;
import br.com.persistencia.controladoras.ErroPersistencia;
import java.util.List;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CntrNegocioVooFuncionario extends CntrNegocioVoo
        implements INegocioVooFuncionario {

    /**
     * Inclui um novo voo no Banco de dados.
     *
     * @param voo Voo a ser incluído.
     *
     * @throws ErroPersistencia Exceção lançada na ocorrência de um erro.
     */
    public final void incluirVoo(final Voo voo) throws ErroPersistencia {
        CmdCadastrarVoo cmd = new CmdCadastrarVoo(voo);
        cntrPersistencia.executar(cmd);

        CmdCadastrarAeroportoChegada cmdChegada = new
                CmdCadastrarAeroportoChegada(
                voo.getAeroportoChegada().getCodigo(), voo.getNumero());
        cntrPersistencia.executar(cmdChegada);

        CmdCadastrarAeroportoSaida cmdSaida = new
                CmdCadastrarAeroportoSaida(
                voo.getAeroportoSaida().getCodigo(), voo.getNumero());
        cntrPersistencia.executar(cmdSaida);
    }

    /**
     * Remove os voos cujo os códigos estão na lista.
     * @param codigos
     * @throws ErroPersistencia
     */
    public void removerVoo(List<String> codigos) throws ErroPersistencia {
        for (String codigo : codigos) {
            CmdRemoverVoo cmd = new CmdRemoverVoo(codigo);
            cntrPersistencia.executar(cmd);
        }
    }

    public void editarVoo(Voo voo) throws ErroPersistencia {
        CmdEditarVoo cmd = new CmdEditarVoo(voo);
        cntrPersistencia.executar(cmd);
    }

    public void incluirAeroporto(Aeroporto aeroporto) throws ErroPersistencia {
        CmdCadastrarAeroporto cmd = new CmdCadastrarAeroporto(aeroporto);
        cntrPersistencia.executar(cmd);
    }

    public List<Aeroporto> consultarAeroportos() throws ErroPersistencia {
        CmdConsultarAeroporto cmd = new CmdConsultarAeroporto();
        cntrPersistencia.executar(cmd);
        return cmd.getResultado();
    }

    public void removerAeroporto(List<String> codigos) throws ErroPersistencia {
        for (String codigo : codigos) {
            CmdRemoverAeroporto cmd = new CmdRemoverAeroporto(codigo);
            cntrPersistencia.executar(cmd);
        }
    }

    public void editarAeroporto(Aeroporto aeroporto, int indice)
            throws ErroPersistencia {
        CmdEditarAeroporto cmd = new CmdEditarAeroporto(aeroporto);
        cntrPersistencia.executar(cmd);
    }

}
