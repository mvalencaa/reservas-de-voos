package br.com.negocio.controladoras.stubs;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Funcionario;
import br.com.apresentacao.entidades.Voo;
import br.com.negocio.controladoras.ErroEdicao;
import br.com.negocio.controladoras.INegocioFuncionario;
import br.com.negocio.controladoras.INegocioVooFuncionario;
import br.com.persistencia.controladoras.ErroPersistencia;
import br.com.persistencia.controladoras.IPersistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class StubFuncionario implements INegocioFuncionario,
        INegocioVooFuncionario {

    /**Funcionario para servir de stub.*/
    private Funcionario funcionario;
    /**Voo a ser editado.*/
    private Voo voo;
    /**Lista de voos.*/
    private List<Voo> voos;
    /**Aeroporto a ser editado.*/
    private Aeroporto aero;
    /**Lista aeroportos.*/
    private List<Aeroporto> aeros;

    /**
     * Cadastra um novo funcionário.
     *
     * @param funcionario Funcionário a ser cadastrado.
     */
    public final void cadastrar(final Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * Consulta um novo funionário.
     *
     * @param matricula Matrícula do funcionário a ser retornado.
     * @return Funcionário consultado.
     */
    public final Funcionario consultar(final String matricula) {
        if (matricula.equals("00000")) {
            throw new NullPointerException("Funcionario nao encontrado.");
        }
        Funcionario func = new Funcionario(funcionario.getNome(),
                funcionario.getTelefone(), funcionario.getMatricula());
        return func;
    }

    /**
     * Adiciona um novo voo ao banco de dados.
     *
     * @param voo Voo a ser adicionado.
     */
    public final void incluirVoo(final Voo voo) {
        voos.add(voo);
    }

    /**
     * Remove um voo do banco de dados.
     *
     * @param codigos Lista de códigos dos voos a serem removidos do banco de
     * dados.
     */
    public final void removerVoo(final List<String> codigos) {
        for (int i = 0; i < voos.size(); i++) {
            for (String string : codigos) {
                if (voos.get(i).getNumero().equals(string)) {
                    voos.remove(i);
                }
            }
        }
    }

    /**
     * Edita um voo no banco de dados.
     *
     * @param voo Voo a ser editado.
     */
    public final void editarVoo(final Voo voo) {
        for (int i = 0; i < voos.size(); i++) {
            if (voos.get(i).getNumero().equals(voo.getNumero())) {
                voos.remove(i);
                voos.add(voo);
                break;
            }
        }
    }

    /**
     * Consulta um voo no banco de dados.
     *
     * @param cidOrigem Cidade de origem do voo.
     * @param cidDestino Cidade de destino do voo.
     * @param dataSaida Data de saída do voo.
     * @return Lista de voos com as características passadas.
     * @throws ErroPersistencia Exceção lançada na ocorrência de um erro.
     */
    public final List<Voo> consultarVoos(final String cidOrigem,
            final String cidDestino, final String dataSaida)
            throws ErroPersistencia {
        return voos;
    }

    /**
     * Método que inicializa as entidades.
     */
    public void executar() {
        funcionario = new Funcionario("Elvis Presley", "6197533579", "12345");
        aero = new Aeroporto("Braslia", "BSB");
        aeros = new ArrayList<Aeroporto>();
        aeros.add(aero);
        aero = new Aeroporto("Rio de Janeiro", "RJO");
        aeros.add(aero);
        aero = new Aeroporto("Goiania", "GYN");
        aeros.add(aero);

        voo = new Voo("XYZ837", 15, "15:00:00", "11:00:00", "08/08/2010",
                "08/08/2011", aeros.get(0), aeros.get(1));
        voos = new ArrayList<Voo>();
        voos.add(voo);
        voos.add(new Voo("ULA129", 14, "15:00:00", "16:30:00", "02/02/2010",
            "02/02/2010", new Aeroporto("Cabo Frio", "CFR"),
            new Aeroporto("Alagoas", "ALG")));
        voos.add(new Voo("KRA363", 5, "13:50:00", "21:50:00", "24/11/2010",
            "25/11/2010", new Aeroporto("Brasília", "BSB"),
            new Aeroporto("Porto Velho", "PVH")));
        voos.add(new Voo("OSX275", 3, "15:00:00", "16:30:00", "02/02/2010",
            "02/02/2010", aeros.get(2),
            new Aeroporto("Maceio", "MCO")));
    }

    /**
     * Retorna uma lista com todos os voos cadastrados no sistema.
     *
     * @return Lista de todos os voos cadastrados.
     * @throws ErroPersistencia Exceção lançada na ocorrência
     * de um erro.
     */
    public List<Voo> consultarVoos() throws ErroPersistencia {
        return voos;
    }

    /**
     * Retorna uma lista com todos os aeroportos cadastrados no sistema.
     *
     * @return Lista de todos os aeroportos cadastrados.
     * @throws ErroPersistencia Exceção lançada na ocorrência de um erro.
     */
    public List<Aeroporto> consultarAeroportos() throws ErroPersistencia {
        return aeros;
    }

    /**
     * Adiciona um novo aeroporto no sistema.
     *
     * @param aeroporto Aeroporto a ser adicionado.
     * @throws ErroPersistencia Exceção lançada na ocorrência de um erro.
     */
    public void incluirAeroporto(Aeroporto aeroporto) throws ErroPersistencia {
        aeros.add(aeroporto);
    }

    /**
     * Remove os aeroportos cujos códigos foram passados como parâmetros.
     *
     * @param codigos Códigos dos aeroportos a serem removidos.
     * @throws ErroPersistencia Exceção lançada na ocorrência de um erro.
     */
    public void removerAeroporto(List<String> codigos) throws ErroPersistencia {
        for (int i = 0; i < aeros.size(); i++) {
            for (String string : codigos) {
                if (aeros.get(i).getCodigo().equals(string)) {
                    aeros.remove(i);
                }
            }
        }
    }

    /**
     * Edita o aeroporto cadastrado no banco.
     *
     * @param aeroporto Aeroporto a ser editado.
     * @param indice Posição do aeroporto a ser editado.
     * @throws ErroPersistencia Exceção lançada na ocorrência de um erro.
     */
    public void editarAeroporto(Aeroporto aeroporto, int indice)
            throws ErroPersistencia {
        aeros.remove(indice);
        aeros.add(aeroporto);
    }

    /**
     * Edita um funcioário cadastrado no sistema.
     *
     * @param funcionario Funcionáro a ser editado.
     * @throws ErroEdicao Execeção lançada na ocorrência de um erro.
     */
    public void editar(Funcionario funcionario) throws ErroEdicao {
        this.funcionario = funcionario;
    }

    /**
     * Seta a controladora de persisência.
     *
     * @param cntrPersistenciaFuncionario Controladora a ser setada.
     */
    public void setControladora(IPersistencia cntrPersistenciaFuncionario) {
    }

}
