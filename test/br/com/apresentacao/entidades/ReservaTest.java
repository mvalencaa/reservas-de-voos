package br.com.apresentacao.entidades;

import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class ReservaTest {

    /** Voo. */
    private static Voo voo;
    /** Cliente. */
    private static Cliente cliente;
    /** Reserva. */
    private static Reserva reserva;
    /** Aeroporto de saída. */
    private static Aeroporto aeroportoSaida;
    /** Aeroporto de Chegada. */
    private static Aeroporto aeroportoChegada;
    /** Novo Aeroporto de saída. */
    private static Aeroporto novoAeroportoSaida;
    /** Novo Aeroporto de Chegada. */
    private static Aeroporto novoAeroportoChegada;
    /** Hora de saída inicial. */
    private static String horaSaida;
    /** Hora de chegada inicial. */
    private static String horaChegada;
    /** Data de saída inicial. */
    private static String dataSaida;
    /** Data de chegada inicial. */
    private static String dataChegada;
    /** Vagas em um voo.*/
    private static final int VAGAS = 88;

    /** Construtor. */
    public ReservaTest() {
    }


    /** Configura a classe.
     * @throws Exception Exceção.
     */
    @BeforeClass
    public static void setUpClass() throws Exception {

        aeroportoSaida = new Aeroporto("Brasília", "BSB");
        aeroportoChegada = new Aeroporto("Goiânia", "GYN");

        novoAeroportoSaida = new Aeroporto("Goiânia", "GYN");
        novoAeroportoChegada = new Aeroporto("Brasília", "BSB");

        horaSaida = "13:30:00";
        horaChegada = "15:00:00";
        dataSaida = "12/02/2010";
        dataChegada = "12/02/2010";

        voo = new Voo("ABC123", VAGAS, horaSaida, horaChegada, dataSaida,
                dataChegada, aeroportoSaida, aeroportoChegada);
        List<Voo> voos = new ArrayList<Voo>();
        voos.add(voo);
        cliente = new Cliente("Bruno Pessanha", "6199998888", "11122233300");
        reserva = new Reserva("12345", voos, cliente);
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testGetCodigo() {
        System.out.println("getCodigo");

        String expResult = "12345";
        String result = reserva.getCodigo();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testGetVoo() {
        System.out.println("getVoo");

        Voo expResult = voo;
        Voo result = reserva.getVoo("ABC123");
        assertEquals(expResult, result);
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testSetVoo() {
        System.out.println("setVoo");

        Voo novoVoo = new Voo("ABC123", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, novoAeroportoSaida,
                novoAeroportoChegada);
        reserva.setVoo("ABC123", novoVoo);

        assertEquals(novoVoo, reserva.getVoo("ABC123"));
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testAddVoo() {
        System.out.println("addVoo");

        try {
            reserva.addVoo(null);
            fail("adição de voo null não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Voo novoVoo = new Voo("ABC124", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
        reserva.addVoo(novoVoo);
        assertEquals(novoVoo, reserva.getVoo(novoVoo.getNumero()));

        try {
            novoVoo = new Voo("ABC124", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
            reserva.addVoo(novoVoo);
            fail("adição de voo repetido não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            novoVoo = new Voo("JHL701", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
            reserva.addVoo(novoVoo);
            assertEquals(novoVoo, reserva.getVoo(novoVoo.getNumero()));

            novoVoo = new Voo("MNO345", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
            reserva.addVoo(novoVoo);
            assertEquals(novoVoo, reserva.getVoo(novoVoo.getNumero()));

            novoVoo = new Voo("PQR678", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
            reserva.addVoo(novoVoo);

            novoVoo = new Voo("STU901", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
            reserva.addVoo(novoVoo);

            novoVoo = new Voo("VWX012", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
            reserva.addVoo(novoVoo);
            fail("adição de 6o voo não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testExisteVoo() {
        System.out.println("ExisteVoo");

        assertTrue(reserva.existeVoo(voo));
        Voo novoVoo = new Voo("BLA248", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
        assertFalse(reserva.existeVoo(novoVoo));
    }

    /**
     * Teste do método validar.
     */
    @Test
    public final void testRemoveVoo() {
        System.out.println("RemoveVoo");

        Voo vooTemp = new Voo("HUE428", VAGAS, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
        try {
            reserva.removeVoo(vooTemp);
            fail("vooTemp não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        reserva.removeVoo(voo);
        assertFalse(reserva.existeVoo(voo));
    }

}
