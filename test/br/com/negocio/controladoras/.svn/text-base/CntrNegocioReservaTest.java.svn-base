package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Cliente;
import br.com.apresentacao.entidades.Reserva;
import br.com.apresentacao.entidades.Voo;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.controladoras.IPersistencia;
import br.com.persistencia.controladoras.stubs.StubPersistencia;
import java.util.ArrayList;
import java.util.List;
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
public class CntrNegocioReservaTest {

    /**Lista de voos.*/
    private List<Voo> voos = new ArrayList<Voo>();
    /**Voo.*/
    private static Voo voo;
    /**Número de vagas.*/
    private static final int VAGAS = 8;
    /**Reserva válida.*/
    private static Reserva reservaValida;
    /**Reserva inválida.*/
    private static Reserva reservaNaoEncontrada;
    /**Reserva inválida.*/
    private static Reserva reservaErroBD;
    /**Reserva inválida.*/
    private static Reserva reservasCheias;
    /**Reserva inválida.*/
    private static Reserva reserva6voos;
    /**Reserva inválida.*/
    private static Reserva reservaVooSemVaga;

    /**
     * Construtor.
     */
    public CntrNegocioReservaTest() {
        inicializar();
    }

    /**
     * Método que inicializa as reservas.
     */
    private void inicializar() {
        voo = new Voo("ABC123", VAGAS, "12:00:00", "18:00:00",
        "08/08/2010", "08/08/2011",
        new Aeroporto("Brasília", "BSB"),
        new Aeroporto("Rio de Janeiro", "RJO"));
        voos.add(voo);
        voo = new Voo("PEA358", VAGAS, "12:00:00", "18:00:00", "08/08/2010",
                "08/08/2011", new Aeroporto("Belo Horizonte", "BHO"),
                new Aeroporto("São Paulo", "SPO"));
        voos.add(voo);
        reservaValida = new Reserva("58769", voos, new Cliente(
                "Michael Jackson", "6192867743", "10987654321"));
        reservaNaoEncontrada = new Reserva("00000", voos, new Cliente(
                "Michael Jackson", "6192867743", "00000000000"));
        reservaErroBD = new Reserva("54321", voos, new Cliente(
                "Michael Jackson", "6192867743", "12345123451"));
        reservasCheias = new Reserva("54321", voos, new Cliente(
                "Michael Jackson", "6192867743", "00000000001"));
        voo = new Voo("AAA111", 0, "12:00:00", "18:00:00", "08/08/2010",
                "08/08/2011", new Aeroporto("Belo Horizonte", "BHO"),
                new Aeroporto("São Paulo", "SPO"));
        voos.add(voo);
        reservaVooSemVaga = new Reserva("54321", voos, new Cliente(
                "Michael Jackson", "6192867743", "12345123451"));
        voos.remove(voo);
        reserva6voos = new Reserva("32416", voos, new Cliente(
                "Michael Jackson", "6192867743", "98765432101"));
    }

    /**
     * Teste do método executar da controladora.
     */
    @Test
    public final void testExecutar() {
        System.out.println("executar");
        try {
            CntrNegocioReserva instance = new CntrNegocioReserva();
            instance.executar();
            assertTrue(true);
        } catch (Exception e) {
            fail("Erro ao executar controladora");
        }
    }

    /**
     * Teste do método Set Controladora.
     */
    @Test
    public final void testSetControladora() {
        System.out.println("setControladora");
        try {
            IPersistencia cntrPersistencia = new StubPersistencia();
            CntrNegocioReserva instance = new CntrNegocioReserva();
            instance.setControladora(cntrPersistencia);
            assertTrue(true);
        } catch (Exception e) {
            fail("Erro ao setar controladora de persistencia");
        }
    }

    /**
     * Teste do método de consulta de reservas.
     * @throws Exception Exceção.
     */
    @Test
    public final void testConsultarReservas() throws Exception {
        System.out.println("consultar Reservas");
        CntrNegocioReserva instance = new CntrNegocioReserva();
        instance.setControladora(new StubPersistencia());

        try {
            instance.consultarReservas(reservaValida.getCpf());
            assertTrue(true);
        } catch (ErroConsulta e) {
            fail("Erro ao consultar reserva.");
        }

        try {
            instance.consultarReservas(reservaErroBD.getCpf());
            fail("Não foi lançada exceção ao consultar reserva inválida");
        } catch (ErroPersistencia e) {
            System.out.println("Erro de BD ao consultar reserva invalido");
        }

        try {
            instance.consultarReservas(reservaNaoEncontrada.getCpf());
            fail("Não foi lançada exceção ao consultar reserva "
                    + "inexistente");
        } catch (ErroConsulta e) {
            System.out.println("Erro de consulta ao buscar reserva"
                    + " inexistente");
        }
    }

    /**
     * Teste de cancelar reserva.
     * @throws Exception Exceção.
     */
    @Test
    public final void testCancelarReserva() throws Exception {
        System.out.println("cancelarReserva");
        CntrNegocioReserva instance = new CntrNegocioReserva();
        instance.setControladora(new StubPersistencia());
        try {
            instance.cancelarReserva(reservaValida.getCodigo());
        } catch (ErroRemove ex) {
            fail("Erro ao cancelar reserva válida.");
        }

        try {
            instance.cancelarReserva(reservaErroBD.getCodigo());
            fail("Não foi lançada exceção ao remover reserva invalida");
        } catch (ErroPersistencia ex) {
            System.out.println("Reserva inválida não removida");
            Assert.assertTrue(true);
        }

        try {
            instance.cancelarReserva(reservaNaoEncontrada.getCodigo());
            fail("Não foi lançada exceção ao remover reserva invalida");
        } catch (ErroPersistencia ex) {
            System.out.println("Reserva inválida não removida");
            Assert.assertTrue(true);
        }
    }

    /**
     * Teste do método de cadastrar reservas.
     * @throws Exception Exceção.
     */
    @Test
    public final void testEfetuarReserva() throws Exception {
        System.out.println("efetuarReserva");
        CntrNegocioReserva instance = new CntrNegocioReserva();
        instance.setControladora(new StubPersistencia());

        try {
            instance.efetuarReserva(reservaValida);
        } catch (ErroCadastro ex) {
            fail("Erro ao efetuar reserva válida.");
        }

        try {
            instance.efetuarReserva(reservaErroBD);
            fail("Não foi lançada exceção ao efetuar reserva invalida");
        } catch (ErroPersistencia ex) {
            System.out.println("Reserva inválida não efetuada.");
        }

        try {
            instance.efetuarReserva(reservaNaoEncontrada);
            fail("Não foi lançada exceção ao efetuar reserva invalida");
        } catch (ErroCadastro ex) {
            System.out.println("Reserva inválida não efetuada.");
        }

        try {
            instance.efetuarReserva(reservasCheias);
            fail("Não foi lançada exceção ao efetuar reserva invalida");
        } catch (IllegalArgumentException ex) {
            System.out.println("Reserva inválida não efetuada.");
        }

        try {
            voos.add(voo);
            voos.add(voo);
            voos.add(voo);
            voos.add(voo);
            instance.efetuarReserva(reserva6voos);
            fail("Não foi lançada exceção ao efetuar reserva invalida");
        } catch (IllegalArgumentException ex) {
            System.out.println("Reserva inválida não efetuada.");
        }

        try {
            instance.efetuarReserva(reservaVooSemVaga);
            fail("Não foi lançada exceção ao efetuar reserva invalida");
        } catch (ErroCadastro ex) {
            System.out.println("Reserva inválida não efetuada.");
        }
    }

    /**
     * Teste do método que retorna os códigos das reservas do cliente.
     * @throws Exception Exceção.
     */
    @Test
    public final void testGetCodigos() throws Exception {
        System.out.println("get Codigos");
        CntrNegocioReserva instance = new CntrNegocioReserva();
        instance.setControladora(new StubPersistencia());

        try {
            instance.getCodigos(reservaValida.getCpf());
        } catch (ErroConsulta ex) {
            fail("Erro ao consultar codigos de uma reserva válida.");
        }

        try {
            instance.getCodigos(reservaErroBD.getCpf());
            fail("Não foi lançada exceção ao consultar reserva invalida");
        } catch (ErroPersistencia ex) {
            System.out.println("Erro ao consultar reserva inválida");
        }
    }

    /**
     * Teste do método que retorna uma lista de voos de uma reserva.
     * @throws Exception Exceção.
     */
    @Test
    public final void testConsultarVoosReserva() throws Exception {
        System.out.println("consultar Voos de uma Reserva");
        CntrNegocioReserva instance = new CntrNegocioReserva();
        instance.setControladora(new StubPersistencia());

        try {
            instance.consultarVoosReserva(reservaValida.getCodigo());
        } catch (ErroConsulta ex) {
            fail("Erro ao consultar voos de uma reserva válida.");
        }

        try {
            instance.consultarVoosReserva(reservaErroBD.getCodigo());
            fail("Não foi lançada exceção ao consultar reserva invalida");
        } catch (ErroPersistencia ex) {
            System.out.println("Erro ao consultar voos de reserva inválida");
        }
    }

}