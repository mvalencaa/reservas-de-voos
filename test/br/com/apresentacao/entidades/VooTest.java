package br.com.apresentacao.entidades;

import org.junit.Before;
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
public class VooTest {

    /** Voo. */
    private static Voo voo;
    /** Cliente. */
    private static Cliente cliente;
    /** Aeroporto de saída. */
    private static Aeroporto aeroportoSaida;
    /** Aeroporto de chegada. */
    private static Aeroporto aeroportoChegada;
    /** Hora de saída inicial. */
    private static String horaSaida;
    /** Hora de chegada inicial. */
    private static String horaChegada;
    /** Data de saída inicial. */
    private static String dataSaida;
    /** Data de chegada inicial. */
    private static String dataChegada;
    /** Número de vagas inicial. */
    private final int nroVagasInicial = 150;
    /** Número de vagas após uma reserva. */
    private final int nroVagasFinal = 149;
    /** Número de vagas para testes. */
    private final int nroVagasNovo = 48;

    /** Construtor. */
    public VooTest() {
    }

    /** Configura a classe.
     * @throws Exception Exceção.
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     * Inicializa o objeto voo antes da execução dos métodos de teste.
     * @throws Exception Exceção.
     */
    @Before
    public final void setUp() throws Exception {

        aeroportoSaida = new Aeroporto("Brasília", "BRB");
        aeroportoChegada = new Aeroporto("Goiânia", "GYN");

        horaSaida = "13:30:00";
        horaChegada = "15:00:00";
        dataSaida = "12/03/2010";
        dataChegada = "12/03/2010";

        voo = new Voo("ABC123", nroVagasInicial, horaSaida, horaChegada,
                dataSaida, dataChegada, aeroportoSaida, aeroportoChegada);
    }

    /**
     * Teste do método GetDataChegada.
     */
    @Test
    public final void testGetDataChegada() {
        System.out.println("getDataChegada");

        String expResult = dataChegada;
        String result = voo.getDataChegada();
        assertSame(expResult, result);
    }

    /**
     * Teste do método SetDataChegada.
     */
    @Test
    public final void testSetDataChegada() {
        System.out.println("setDataChegada");

        String novaDataChegada;

        try {
            novaDataChegada = "11-03-2010";
            voo.setDataChegada(novaDataChegada);
            fail("testSetDataChegada não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            novaDataChegada = "12/03/2010";
            voo.setDataChegada(novaDataChegada);
            assertEquals(novaDataChegada, voo.getDataChegada());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            novaDataChegada = "13/03/2010";
            voo.setDataChegada(novaDataChegada);
            assertEquals(novaDataChegada, voo.getDataChegada());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Teste do método GetDataSaida.
     */
    @Test
    public final void testGetDataSaida() {
        System.out.println("getDataSaida");

        String expResult = dataSaida;
        String result = voo.getDataSaida();

        assertEquals(expResult, result);
    }

    /**
     * Teste do método SetDataSaida.
     */
    @Test
    public final void testSetDataSaida() {
        System.out.println("setDataSaida");

        String novaDataSaida;

        try {
            String dataSaidaTemp;
            dataSaidaTemp = "11/03/2010";

            Voo vooTemp = new Voo("DEF456", nroVagasInicial, horaSaida,
                    horaChegada, dataSaida, dataChegada, aeroportoSaida,
                    aeroportoChegada);

            novaDataSaida = "13/03/2010";
            vooTemp.setDataSaida(novaDataSaida);
            assertEquals(novaDataSaida, vooTemp.getDataSaida());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            novaDataSaida = "11/03/2010";
            voo.setDataSaida(novaDataSaida);
            assertEquals(novaDataSaida, voo.getDataSaida());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            novaDataSaida = "12/03/2010";
            voo.setDataSaida(novaDataSaida);
            assertEquals(novaDataSaida, voo.getDataSaida());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            novaDataSaida = "13/03/2010";
            voo.setDataSaida(novaDataSaida);
            assertEquals(novaDataSaida, voo.getDataSaida());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Teste do método GetHoraChegada.
     */
    @Test
    public final void testGetHoraChegada() {
        System.out.println("getHoraChegada");

        String expResult = horaChegada;
        String result = voo.getHoraChegada();

        assertEquals(expResult, result);
    }

    /**
     * Teste do método SetHoraChegada.
     */
    @Test
    public final void testSetHoraChegada() {
        System.out.println("setHoraChegada");

        String novaHoraChegada;

        try {
            novaHoraChegada = "13:00";
            voo.setHoraChegada(novaHoraChegada);
            fail("testSetHoraChegada não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            novaHoraChegada = "14:00:00";
            voo.setHoraChegada(novaHoraChegada);
            assertEquals(novaHoraChegada, voo.getHoraChegada());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            novaHoraChegada = "15:00:00";
            voo.setHoraChegada(novaHoraChegada);
            assertEquals(novaHoraChegada, voo.getHoraChegada());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            String dataChegadaTemp;
            dataChegadaTemp = "13/03/2010";

            Voo vooTemp = new Voo("DEF456", nroVagasInicial, horaSaida,
                    horaChegada, dataSaida, dataChegada, aeroportoSaida,
                    aeroportoChegada);

            novaHoraChegada = "15:00:00";
            vooTemp.setHoraChegada(novaHoraChegada);
            assertEquals(novaHoraChegada, voo.getHoraChegada());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Teste do método GetHoraSaida.
     */
    @Test
    public final void testGetHoraSaida() {
        System.out.println("getHoraSaida");

        String expResult = horaSaida;
        String result = voo.getHoraSaida();

        assertEquals(expResult, result);
    }

    /**
     * Teste do método SetHoraSaida.
     */
    @Test
    public final void testSetHoraSaida() {
        System.out.println("setHoraSaida");

        String novaHoraSaida;

        try {
            novaHoraSaida = "13:00:00";
            voo.setHoraSaida(novaHoraSaida);
            assertEquals(novaHoraSaida, voo.getHoraSaida());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            novaHoraSaida = "13:30:00";
            voo.setHoraSaida(novaHoraSaida);
            assertEquals(novaHoraSaida, voo.getHoraSaida());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            novaHoraSaida = "14:00:00";
            voo.setHoraSaida(novaHoraSaida);
            assertEquals(novaHoraSaida, voo.getHoraSaida());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Teste do método GetNumero.
     */
    @Test
    public final void testGetNumero() {
        System.out.println("getNumero");

        String expResult = "ABC123";
        String result = voo.getNumero();

        assertEquals(expResult, result);
    }

    /**
     * Teste do método GetNroVagas.
     */
    @Test
    public final void testGetNroVagas() {
        System.out.println("getNroVagas");

        cliente = new Cliente("Bruno Pessanha", "1112223330", "99998888000");

        int expResult = nroVagasInicial;
        int result = voo.getNroVagas();
        assertEquals(expResult, result);
    }

    /**
     * Teste do método SetNroVagasar.
     */
    @Test
    public final void testSetNroVagas() {
        System.out.println("setNroVagas");

        voo.setNroVagas(nroVagasNovo);
        assertEquals(nroVagasNovo, voo.getNroVagas());
    }

    /**
     * Teste do método GetAeroporto.
     */
    @Test
    public final void testGetAeroportoChegada() {
        System.out.println("getAeroportoChegada");

        assertEquals(aeroportoChegada, voo.getAeroportoChegada());
    }

    /**
     * Teste do método SetAeroportoChegada.
     */
    @Test
    public final void testSetAeroportoChegada() {
        System.out.println("setAeroportoChegada");

        Aeroporto aeroportoChegadaTemp = new Aeroporto("Manaus", "MAN");
        voo.setAeroportoChegada(aeroportoChegadaTemp);

        assertEquals(aeroportoChegadaTemp, voo.getAeroportoChegada());
    }

    /**
     * Teste do método GetAeroportoSaida.
     */
    @Test
    public final void testGetAeroportoSaida() {
        System.out.println("getAeroportoSaida");

        assertEquals(aeroportoSaida, voo.getAeroportoSaida());
    }

    /**
     * Teste do método SetAeroportoSaida.
     */
    @Test
    public final void testSetAeroportoSaida() {
        System.out.println("setAeroportoSaida");

        Aeroporto aeroportoSaidaTemp = new Aeroporto("Brasília", "BSB");
        voo.setAeroportoSaida(aeroportoSaidaTemp);

        assertEquals(aeroportoSaidaTemp, voo.getAeroportoSaida());
    }

}