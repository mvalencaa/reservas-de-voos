package br.com.negocio.controladoras;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Voo;
import br.com.persistencia.controladoras.ErroPersistencia;
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
public class CntrNegocioVooFuncionarioTest {

    /**Número de vagas.*/
    private static final int VAGAS = 8;
    /**Voo Valido.*/
    private static Voo vooValido = new Voo("ZYA343", VAGAS, "12:00:00",
            "18:00:00", "08/08/2010", "08/08/2011",
            new Aeroporto("Campinas", "CAM"),
            new Aeroporto("Mato Grosso", "MTG"));
    /**Voo que não será encontrado ou já está cadastrado.*/
    private static Voo vooNaoEncontrado = new Voo("AAA111", VAGAS, "12:00:00",
            "18:00:00", "01/01/2001", "01/01/2001",
            new Aeroporto("Brasília", "BSB"),
            new Aeroporto("Cabo Frio", "CBF"));
    /**Voo que ao ser consultado gerará erro de banco de dados.*/
    private static Voo vooErroBD = new Voo("BBB222", VAGAS, "16:30:00",
            "18:00:00", "02/02/2002", "02/02/2002",
            new Aeroporto("Natal", "NAT"),
            new Aeroporto("São Paulo", "SPO"));
    /**Aeroporto válido.*/
    private static Aeroporto aeroValido = new Aeroporto("Brasília", "BSB");
    /**Aeroporto inválido.*/
    private static Aeroporto aeroNaoEncontrado = new Aeroporto("Erro1", "AAA");
    /**Aeroporto inválido.*/
    private static Aeroporto aeroErroBD = new Aeroporto("Erro2", "BBB");

    /**
     * Construtor.
     */
    public CntrNegocioVooFuncionarioTest() {
    }

    /**
     * Teste do método incluir Voo.
     * @throws Exception Exceção.
     */
    @Test
    public final void testIncluirVoo() throws Exception {
        System.out.println("cadastrar");
        CntrNegocioVooFuncionario instance = new CntrNegocioVooFuncionario();
        instance.setControladora(new StubPersistencia());

        try {
            instance.incluirVoo(vooValido);
        } catch (ErroCadastro ex) {
            fail("Erro ao cadastrar Voo válido.");
        }

        try {
            instance.incluirVoo(vooErroBD);
            fail("Não foi lançada exceção ao cadastrar voo invalido");
        } catch (ErroPersistencia ex) {
            System.out.println("Voo inválido não cadastrado");
            Assert.assertTrue(true);
        }

        try {
            instance.incluirVoo(vooNaoEncontrado);
            fail("Não foi lançada exceção ao cadastrar Voo invalido");
        } catch (ErroCadastro ex) {
            System.out.println("Voo inválido não cadastrado");
            Assert.assertTrue(true);
        }
    }

    /**
     * Teste do método de remoção de voo.
     * @throws Exception Exceção.
     */
    @Test
    public final void testRemoverVoo() throws Exception {
        System.out.println("Remover Voo");
        CntrNegocioVooFuncionario instance = new CntrNegocioVooFuncionario();
        instance.setControladora(new StubPersistencia());
        List<String> voos = new ArrayList<String>();
        try {
            voos.add(vooValido.getNumero());
            instance.removerVoo(voos);
        } catch (ErroRemove ex) {
            fail("Erro ao remover Voo válido.");
        }

        try {
            voos.add(vooErroBD.getNumero());
            instance.removerVoo(voos);
            fail("Não foi lançada exceção ao remover voo invalido");
        } catch (ErroPersistencia ex) {
            System.out.println("Voo inválido não removido");
            Assert.assertTrue(true);
        }
    }

    /**
     * Teste do método de edição de Voo.
     * @throws Exception Exceção.
     */
    @Test
    public final void testEditarVoo() throws Exception {
        System.out.println("editar Voo");
        CntrNegocioVooFuncionario instance = new CntrNegocioVooFuncionario();
        instance.setControladora(new StubPersistencia());

        try {
            instance.editarVoo(vooValido);
        } catch (ErroEdicao e) {
            fail("Erro ao editar voo válido");
        }

        try {
            instance.editarVoo(vooErroBD);
            fail("Não lançou exceção ao editar voo inválido.");
        } catch (ErroPersistencia e) {
            System.out.println("Erro de BD ao tentar editar voo invalido");
        }
    }

    /**
     * Teste do método de inclusão de aeroporto.
     * @throws Exception Exceção.
     */
    @Test
    public final void testIncluirAeroporto() throws Exception {
        System.out.println("incluir Aeroporto");
        CntrNegocioVooFuncionario instance = new CntrNegocioVooFuncionario();
        instance.setControladora(new StubPersistencia());

        try {
            instance.incluirAeroporto(aeroValido);
        } catch (ErroCadastro ex) {
            fail("Erro ao cadastrar aeroporto válido.");
        }

        try {
            instance.incluirAeroporto(aeroErroBD);
            fail("Não foi lançada exceção ao cadastrar aeroporto invalido");
        } catch (ErroPersistencia ex) {
            System.out.println("Aeroporto inválido não cadastrado");
            Assert.assertTrue(true);
        }

        try {
            instance.incluirAeroporto(aeroNaoEncontrado);
            fail("Não foi lançada exceção ao cadastrar aeroporto invalido");
        } catch (ErroCadastro ex) {
            System.out.println("Aeroporto inválido não cadastrado");
            Assert.assertTrue(true);
        }
    }

    /**
     * Teste do método que consulta todos aeroportos.
     * @throws Exception Exceção.
     */
    @Test
    public final void testConsultarAeroportos() throws Exception {
        System.out.println("consultar todos Aeroportos");
        CntrNegocioVooFuncionario instance = new CntrNegocioVooFuncionario();
        instance.setControladora(new StubPersistencia());
        try {
            instance.consultarAeroportos();
            assertTrue(true);
        } catch (ErroConsulta e) {
            fail("Erro ao consultar Aeroportos.");
        }
    }

    /**
     * Teste do método que remove Aeroportos.
     * @throws Exception Exceção.
     */
    @Test
    public final void testRemoverAeroporto() throws Exception {
        System.out.println("remover Aeroporto");
        CntrNegocioVooFuncionario instance = new CntrNegocioVooFuncionario();
        instance.setControladora(new StubPersistencia());
        List<String> aeros = new ArrayList<String>();
        try {
            aeros.add(aeroValido.getCodigo());
            instance.removerAeroporto(aeros);
        } catch (ErroCadastro ex) {
            fail("Erro ao remover Voo válido.");
        }

        try {
            aeros.add(aeroErroBD.getCodigo());
            instance.removerAeroporto(aeros);
            fail("Não foi lançada exceção ao remover voo invalido");
        } catch (ErroPersistencia ex) {
            System.out.println("Voo inválido não removido");
            Assert.assertTrue(true);
        }
    }

    /**
     * Teste do método que edita um aeroporto.
     * @throws Exception Exceção.
     */
    @Test
    public final void testEditarAeroporto() throws Exception {
        System.out.println("editarAeroporto");
        CntrNegocioVooFuncionario instance = new CntrNegocioVooFuncionario();
        instance.setControladora(new StubPersistencia());

        try {
            instance.editarAeroporto(aeroValido, 1);
        } catch (ErroEdicao e) {
            fail("Erro ao editar aeroporto válido");
        }

        try {
            instance.editarAeroporto(aeroErroBD, 1);
            fail("Não lançou exceção ao editar aeroporto inválido.");
        } catch (ErroPersistencia e) {
            System.out.println("Erro de BD ao tentar editar aeroporto"
                    + " invalido");
        }
    }

}