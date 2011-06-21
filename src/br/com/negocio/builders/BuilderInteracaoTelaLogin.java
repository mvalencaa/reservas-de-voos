package br.com.negocio.builders;

import br.com.apresentacao.controladoras.CntrInteracaoLogin;
import br.com.apresentacao.controladoras.IInteracaoCliente;
import br.com.apresentacao.controladoras.IInteracaoFuncionario;
import br.com.apresentacao.controladoras.IInteracaoSistema;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.3
 */
public final class BuilderInteracaoTelaLogin {

    /**
     * Construtor.
     */
    private BuilderInteracaoTelaLogin() { }

    /**
     * Builder que seta as controladoras de intercao que vão ser utilizadas
     * por cliente e funcionario.
     * @param cntrCliente Controladora.
     * @param cntrFunc Controladora.
     * @return cntrSistema Controladora.
     */
    public static IInteracaoSistema criar(final IInteracaoCliente cntrCliente,
            final IInteracaoFuncionario cntrFunc) {
        IInteracaoSistema cntrSistema = new CntrInteracaoLogin();
        cntrSistema.setCntrInteracaoCliente(cntrCliente);
        cntrSistema.setCntrInteracaoFuncionario(cntrFunc);
        return cntrSistema;
    }
}
