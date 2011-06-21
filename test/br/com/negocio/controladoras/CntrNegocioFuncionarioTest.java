package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Funcionario;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.controladoras.IPersistencia;
import br.com.persistencia.controladoras.stubs.StubPersistencia;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CntrNegocioFuncionarioTest {

    /**Funcionário correto.*/
    private static Funcionario funcValido = new Funcionario("Machado de Assis",
            "1234567890", "12345");
    /**Funcionário inválido.*/
    private static Funcionario funcNaoEncontrado = new Funcionario(
            "José de Alencar", "1234567890", "00000");
    /**Funcionário inválido.*/
    private static Funcionario funcErroBD = new Funcionario("José de Alencar",
            "1234567890", "54321");

    /**Construtor.*/
    public CntrNegocioFuncionarioTest() {
    }

    /**
     * Teste do método executar da controladora de negócio.
     */
    @Test
    public final void testExecutar() {
        System.out.println("executar");
        try {
            CntrNegocioFuncionario instance = new CntrNegocioFuncionario();
            instance.executar();
            assertTrue(true);
        } catch (Exception e) {
            fail("Erro ao executar controladora");
        }
    }

    /**
     * Teste do método set controladora.
     */
    @Test
    public final void testSetControladora() {
        System.out.println("setControladora");
        try {
            IPersistencia cntrPersistenciaFuncionario = new StubPersistencia();
            CntrNegocioFuncionario instance = new CntrNegocioFuncionario();
            instance.setControladora(cntrPersistenciaFuncionario);
            assertTrue(true);
        } catch (Exception e) {
            fail("Erro ao setar controladora de persistencia");
        }
    }

    /**
     * Teste do método cadastrar funcionário.
     * @throws Exception Exceção.
     */
    @Test
    public final void testCadastrar() throws Exception {
        System.out.println("cadastrar");
        CntrNegocioFuncionario instance = new CntrNegocioFuncionario();
        instance.setControladora(new StubPersistencia());
        try {
            instance.cadastrar(funcValido);
        } catch (ErroCadastro ex) {
            fail("Erro ao cadastrar funcionário.");
        }

        try {
            instance.cadastrar(funcErroBD);
            fail("Não foi lançada exceção ao cadastrar funcionário"
                    + " invalido");
        } catch (ErroPersistencia ex) {
            System.out.println("Funcionário inválido não cadastrado");
            Assert.assertTrue(true);
        }

        try {
            instance.cadastrar(funcNaoEncontrado);
            fail("Não foi lançada exceção ao cadastrar funcionário "
                    + "invalido");
        } catch (ErroCadastro ex) {
            System.out.println("Funcionário inválido não cadastrado");
            Assert.assertTrue(true);
        }
    }

    /**
     * Teste do método consultar Funcionário.
     * @throws Exception Exceção.
     */
    @Test
    public final void testConsultar() throws Exception {
        System.out.println("consultar");
        CntrNegocioFuncionario instance = new CntrNegocioFuncionario();
        instance.setControladora(new StubPersistencia());
        try {
            Funcionario result = instance.consultar(funcValido.getMatricula());
            assertEquals(result.getMatricula(), "12345");
            assertEquals(result.getNome(), "Clarisse Lispector");
            assertEquals(result.getTelefone(), "1234567890");
        } catch (ErroConsulta e) {
            fail("Erro ao consultar funcionário.");
        }

        try {
            instance.consultar(funcErroBD.getMatricula());
            fail("Não foi lançada exceção ao consultar funcionário "
                    + "inválido");
        } catch (ErroPersistencia e) {
            System.out.println("Erro de BD ao consultar funcionário "
                    + "invalido");
        }

        try {
            instance.consultar(funcNaoEncontrado.getMatricula());
            fail("Não foi lançada exceção ao consultar funcionario "
                    + "inexistente");
        } catch (ErroConsulta e) {
            System.out.println("Erro de consulta ao buscar funcionario"
                    + " inexistente");
        }
    }

    /**
     * Teste do método Editar.
     * @throws Exception Exceção.
     */
    @Test
    public final void testEditar() throws Exception {
        CntrNegocioFuncionario instance = new CntrNegocioFuncionario();
        instance.setControladora(new StubPersistencia());

        try {
            instance.editar(funcValido);
        } catch (ErroEdicao e) {
            fail("Erro ao editar funcionário válido");
        }

        try {
            instance.editar(funcErroBD);
            fail("Não lançou exceção ao editar funcionário inválido.");
        } catch (ErroPersistencia e) {
            System.out.println("Erro de BD ao tentar editar"
                    + " funcionário invalido");
        }
    }

}