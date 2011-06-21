package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Cliente;
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
public class CntrNegocioClienteTest {

    /**Cliente correto.*/
    private static Cliente clienteValido = new Cliente("Machado de Assis",
            "1234567890", "12345678901");
    /**Cliente inválido.*/
    private static Cliente clienteNaoEncontrado = new Cliente(
            "José de Alencar", "1234567890", "00000000000");
    /**Cliente inválido.*/
    private static Cliente clienteErroBD = new Cliente("José de Alencar",
            "1234567890", "12345123451");

    /**
     * Construtor.
     */
    public CntrNegocioClienteTest() {
    }

    /**
     * Teste do método executar da controladora.
     */
    @Test
    public final void testExecutar() {
        System.out.println("executar");
        try {
            CntrNegocioCliente instance = new CntrNegocioCliente();
            instance.executar();
            assertTrue(true);
        } catch (Exception e) {
            fail("Erro ao executar controladora");
        }
    }

    /**
     * Teste do método que seta a controladora de persistência.
     */
    @Test
    public final void testSetControladora() {
        System.out.println("set Controladora");
        try {
            IPersistencia cntrPersistenciaCliente = new StubPersistencia();
            CntrNegocioCliente instance = new CntrNegocioCliente();
            instance.setControladora(cntrPersistenciaCliente);
            assertTrue(true);
        } catch (Exception e) {
            fail("Erro ao setar controladora de persistencia");
        }
    }

    /**
     * Teste do método cadastrar cliente.
     */
    @Test
    public final void testCadastrar() {
        System.out.println("cadastrar");
        CntrNegocioCliente instance = new CntrNegocioCliente();
        instance.setControladora(new StubPersistencia());
        try {
            instance.cadastrar(clienteValido);
        } catch (ErroCadastro ex) {
            fail("Erro ao cadastrar cliente.");
        }

        try {
            instance.cadastrar(clienteErroBD);
            fail("Não foi lançada exceção ao cadastrar cliente invalido");
        } catch (ErroPersistencia ex) {
            System.out.println("Cliente inválido não cadastrado");
            Assert.assertTrue(true);
        }

        try {
            instance.cadastrar(clienteNaoEncontrado);
            fail("Não foi lançada exceção ao cadastrar cliente invalido");
        } catch (ErroCadastro ex) {
            System.out.println("Cliente inválido não cadastrado");
            Assert.assertTrue(true);
        }
    }

    /**
     * Teste do método consultar cliente.
     */
    @Test
    public final void testConsultar() {
        System.out.println("consultar");
        CntrNegocioCliente instance = new CntrNegocioCliente();
        instance.setControladora(new StubPersistencia());
        try {
            Cliente result = instance.consultar(clienteValido.getCpf());
            assertEquals(result.getCpf(), "12345678901");
            assertEquals(result.getNome(), "Clarisse Lispector");
            assertEquals(result.getTelefone(), "1234567890");
        } catch (ErroConsulta e) {
            fail("Erro ao consultar cliente.");
        }

        try {
            instance.consultar(clienteErroBD.getCpf());
            fail("Não foi lançada exceção ao consultar cliente inválido");
        } catch (ErroPersistencia e) {
            System.out.println("Erro de BD ao consultar cliente invalido");
        }

        try {
            instance.consultar(clienteNaoEncontrado.getCpf());
            fail("Não foi lançada exceção ao consultar cliente "
                    + "inexistente");
        } catch (ErroConsulta e) {
            System.out.println("Erro de consulta ao buscar cliente"
                    + " inexistente");
        }
    }

    /**
     * Teste do método de edição de cliente.
     * @throws Exception Exceção.
     */
    @Test
    public final void testEditar() throws Exception {
        CntrNegocioCliente instance = new CntrNegocioCliente();
        instance.setControladora(new StubPersistencia());

        try {
            instance.editar(clienteValido);
        } catch (ErroEdicao e) {
            fail("Erro ao editar cliente válido");
        }

        try {
            instance.editar(clienteErroBD);
            fail("Não lançou exceção ao editar cliente inválido.");
        } catch (ErroPersistencia e) {
            System.out.println("Erro de BD ao tentar editar cliente invalido");
        }
    }
}