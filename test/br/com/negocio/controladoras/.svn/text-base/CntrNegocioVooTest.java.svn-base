package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Voo;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.controladoras.IPersistencia;
import br.com.persistencia.controladoras.stubs.StubPersistencia;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CntrNegocioVooTest {

    /**Número de vagas.*/
    private static final int VAGAS = 8;
    /**Voo Valido.*/
    private static Voo vooValido = new Voo("ZYA343", VAGAS, "12:00:00",
            "18:00:00", "08/08/2010", "08/08/2011",
            new Aeroporto("Campinas", "CAM"),
            new Aeroporto("Mato Grosso", "MTG"));
    /**Voo que não será encontrado.*/
    private static Voo vooNaoEncontrado = new Voo("AAA111", VAGAS, "12:00:00",
            "18:00:00", "01/01/2001", "01/01/2001",
            new Aeroporto("Brasília", "BSB"),
            new Aeroporto("Cabo Frio", "CBF"));
    /**Voo que ao ser consultado gerará erro de banco de dados.*/
    private static Voo vooErroBD = new Voo("BBB222", VAGAS, "16:30:00",
            "18:00:00", "02/02/2002", "02/02/2002",
            new Aeroporto("Natal", "NAT"),
            new Aeroporto("São Paulo", "SPO"));


    /**
     * Construtor.
     */
    public CntrNegocioVooTest() {
    }

    /**
     * Teste do método executar da controladora de negócio Voo.
     */
    @Test
    public final void testExecutar() {
        System.out.println("executar");
        try {
            CntrNegocioVoo instance = new CntrNegocioVoo();
            instance.executar();
            assertTrue(true);
        } catch (Exception e) {
            fail("Erro ao executar controladora");
        }
    }

    /**
     * Teste do método que seta a controladora de persistência,
     * não devem ser lançadas nenhuma exceção.
     */
    @Test
    public final void testSetControladora() {
        System.out.println("setControladora");
        try {
            IPersistencia cntrPersistencia = new StubPersistencia();
            CntrNegocioVoo instance = new CntrNegocioVoo();
            instance.setControladora(cntrPersistencia);
            assertTrue(true);
        } catch (Exception e) {
            fail("Erro ao setar controladora de persistencia");
        }
    }

    /**
     * Teste do método que consulta Voos dado 3 argumentos.
     * @throws Exception Exceção.
     */
    @Test
    public final void testConsultarVoos3args() throws Exception {
        System.out.println("consultar");
        CntrNegocioVoo instance = new CntrNegocioVoo();
        instance.setControladora(new StubPersistencia());
        try {
            List<Voo> result = instance.consultarVoos(vooValido.
                    getAeroportoSaida().getCidade(), vooValido.
                    getAeroportoChegada().getCidade(),
                    vooValido.getDataSaida());
            assertTrue(true);
        } catch (ErroConsulta e) {
            fail("Erro ao consultar Voo válido.");
        }
        try {
            instance.consultarVoos(vooErroBD.getAeroportoSaida().getCidade(),
                    vooErroBD.getAeroportoChegada().getCidade(),
                    vooErroBD.getDataSaida());
            fail("Não foi lançada exceção ao consultar voo inválido");
        } catch (ErroPersistencia e) {
            System.out.println("Erro de BD ao consultar voo invalido");
        }

        try {
            instance.consultarVoos(vooNaoEncontrado.getAeroportoSaida().
                    getCidade(), vooNaoEncontrado.getAeroportoChegada().
                    getCidade(), vooNaoEncontrado.getDataSaida());
            fail("Não foi lançada exceção ao consultar voo "
                    + "inexistente");
        } catch (ErroConsulta e) {
            System.out.println("Exceção lançada ao consultar voo"
                    + " inexistente");
        }
    }

    /**
     * Teste do método consultar todos os voos. nenhum voo sera encontrado.
     * @throws Exception Exceção.
     */
    @Test
    public final void testConsultarVoos() throws Exception {
        System.out.println("consultar todos voos");
        CntrNegocioVoo instance = new CntrNegocioVoo();
        instance.setControladora(new StubPersistencia());
        try {
            instance.consultarVoos();
            fail("Erro ao consultar Voos.");
        } catch (ErroConsulta e) {
            System.out.println("Exceção lançada ao nao encontrar voos");
        }
    }

}