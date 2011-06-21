package br.com.apresentacao.controladoras;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Funcionario;
import br.com.apresentacao.entidades.Voo;
import br.com.apresentacao.telas.NovaTelaNovoVoo;
import br.com.apresentacao.telas.TelaAeroporto;
import br.com.apresentacao.telas.TelaFuncionario;
import br.com.apresentacao.telas.TelaNovoAeroporto;
import br.com.apresentacao.telas.TelaVoos;
import br.com.negocio.controladoras.ErroCadastro;
import br.com.negocio.controladoras.INegocioFuncionario;
import br.com.negocio.controladoras.INegocioVooFuncionario;
import br.com.persistencia.controladoras.ErroPersistencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public class CntrInteracaoFuncionario implements IInteracaoFuncionario {

    /** Tela de funcionário. */
    private TelaFuncionario telaFuncionario;
    /** Controladora de negócio correspondente. */
    private INegocioFuncionario cntrNegocioFunc;
    /** Controladora de negócio correspondente. */
    private INegocioVooFuncionario cntrNegocioVoo;
    /** Tela de voos. */
    private TelaVoos telaVoos;
    /** Tela de Edição de voo. */
    private NovaTelaNovoVoo telaEditaVoo;
    /** Tela de Aeroportos.*/
    private TelaAeroporto telaAero;
    /** Tela de Aeroportos.*/
    private TelaNovoAeroporto telaEditaAero;
    /** Número de digitos e letras para código do voo.*/
    private static final int MAX_DIGITOS = 3;
    /** Multiplicador de randomicos.*/
    private static final int MULTIPLICADOR = 122;

    /**
     * Inicializa a tela de funcionário.
     */
    public final void executar() {
        telaFuncionario = new TelaFuncionario();
        telaFuncionario.setControladora(this);
    }

    /**
     * Seta a controladora correspondente.
     *
     * @param cntrNegocio Controladora a ser setada.
     */
    public final void setControladoraFuncionario(final INegocioFuncionario
            cntrNegocio) {
        this.cntrNegocioFunc = cntrNegocio;
    }

    /**
     * Seta a controladora correspondente.
     *
     * @param cntrNegocioVoos Controladora a ser setada.
     */
    public final void setControladoraVoo(final INegocioVooFuncionario
            cntrNegocioVoos) {
        this.cntrNegocioVoo = cntrNegocioVoos;
    }

    /**
     * Realiza o login do funcionário.
     *
     * @param matricula Matrícula do usuário utilizada no momento do login.
     */
    public final void login(final String matricula) {
        try {
            Funcionario funcionario = cntrNegocioFunc.consultar(matricula);
            telaFuncionario.setFieldNome(funcionario.getNome());
            telaFuncionario.setFieldMatricula(funcionario.getMatricula());
            telaFuncionario.setFieldTelefone(funcionario.getTelefone());
            telaFuncionario.setVisible(true);
        }  catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null,
                    "Matrícula do funcionário inválida.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null,
                    "Matrícula do funcionário inválida.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null,
                    "Matrícula do funcionário inválida.", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Realiza as alterações realizadas pelo funcionario.
     * @param nome Nome do funcionario.
     * @param telefone Telefone do funcionario.
     * @param matric Matricula do Funcionario.
     */
    public final void salvarAlteracoes(final String nome, final String telefone,
            final String matric) {
        try {
            Funcionario funcionario = new Funcionario(nome, telefone, matric);
            cntrNegocioFunc.editar(funcionario);
            telaFuncionario.setFieldNome(funcionario.getNome());
            telaFuncionario.setFieldTelefone(funcionario.getTelefone());
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!",
                    null, JOptionPane.INFORMATION_MESSAGE);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**Lita todos os voos para o funcionario.*/
    public final void listarVoo() {
        try {
            /**Lista todos os voos.*/
            telaVoos = new TelaVoos();
            telaVoos.setControladoraFuncionario(this);
            List<Voo> voos = null;
            voos = cntrNegocioVoo.consultarVoos();
            if (voos != null) {
                for (int i = 0; i < voos.size(); i++) {
                    telaVoos.addTable(voos.get(i).getNumero(),
                            voos.get(i).getAeroportoSaida().getCidade(),
                            voos.get(i).getAeroportoSaida().getCodigo(),
                            voos.get(i).getAeroportoChegada().getCidade(),
                            voos.get(i).getAeroportoChegada().getCodigo(),
                            voos.get(i).getDataSaida(),
                            voos.get(i).getDataChegada(),
                            voos.get(i).getHoraSaida(),
                            voos.get(i).getHoraChegada());
                }
            } else {
                telaVoos.setTableDisabled();
            }
            telaVoos.setVisible(true);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Cria ou edita voo existente com os seguintes dados.
     * @param cidadeSaida Cidade de Saída.
     * @param saidaSigla Sigla da Cidade de saída.
     * @param dataSaida Data da saída do voo.
     * @param horaSaida Hora de saída do voo.
     * @param cidadeChegada Cidade de Chegada.
     * @param chegadaSigla Sigla da Cidade de chegada.
     * @param dataChegada Data da chegada do voo.
     * @param horaChegada Hora de chegada do voo.
     * @param editar Diz se é uma edição ou um novo voo.
     */
    public final void cadastrarVoo(String codVoo, final int vagas,
            final String cidadeSaida, final String saidaSigla,
            final String dataSaida, final String horaSaida,
            final String cidadeChegada, final String chegadaSigla,
            final String dataChegada, final String horaChegada,
            final boolean editar) {
        try {
            if (!editar) {
                int random = 0;
                char []cod = {'A', 'A', 'A', '0', '0', '0'};
                boolean v = false;

                for (int i = 0; i < MAX_DIGITOS; i++) {
                    v = false;
                    do {
                        random = (int) (Math.random() * MULTIPLICADOR);
                        if (random >= 'A' && random <= 'Z') {
                            v = true;
                        }
                    } while (!v);
                    cod[i] = (char) random;
                }
                for (int i = MAX_DIGITOS; i < 2 * MAX_DIGITOS; i++) {
                    v = false;
                    do {
                        random = (int) (Math.random() * MULTIPLICADOR);
                        if (random >= '0' && random <= '9') {
                            v = true;
                        }
                    } while (!v);
                    cod[i] = (char) random;
                }
                codVoo = new String(cod);
            }

            Voo voo = new Voo(codVoo, vagas, horaSaida, horaChegada, dataSaida,
                    dataChegada, new Aeroporto(cidadeSaida, saidaSigla),
                    new Aeroporto(cidadeChegada, chegadaSigla));
            if (editar) {
                cntrNegocioVoo.editarVoo(voo);
            } else {
                cntrNegocioVoo.incluirVoo(voo);
            }

            JOptionPane.showMessageDialog(null, "Voo cadastrado com sucesso!",
                null, JOptionPane.INFORMATION_MESSAGE);

            telaEditaVoo.dispose();
            telaVoos.dispose();
            listarVoo();

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Edita voo.
     * @param indice Indice do Voo a ser editado se for negativo, um novo voo
     * será criado.
     */
    public final void editarVoo(final int[] indice) {
        try {
            telaEditaVoo = new NovaTelaNovoVoo();
            telaEditaVoo.setControladora(this);
            /*Edição de voos*/
            if (indice.length == 0) {
                JOptionPane.showMessageDialog(null, "Selecione um voo!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (indice[0] >= 0) {
                List<Voo> voos = cntrNegocioVoo.consultarVoos();
                telaEditaVoo.setDadosVoo(voos.get(indice[0]));
            }
            telaEditaVoo.setVisible(true);

        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Remove voo.
     * @param indice Indice da lista do voo a ser removido
     */
    public final void removerVoo(final int []indice) {
        try {
            List<Voo> voos = cntrNegocioVoo.consultarVoos();
            List<String> codigos = new ArrayList<String>();

            if (indice.length == 0) {
                JOptionPane.showMessageDialog(null, "Selecione um voo!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < indice.length; i++) {
                codigos.add(voos.get(indice[i]).getNumero());
            }

            cntrNegocioVoo.removerVoo(codigos);

            JOptionPane.showMessageDialog(null, "Voo(s) removido(s)"
                    + "com sucesso!",
                null, JOptionPane.INFORMATION_MESSAGE);
            telaVoos.dispose();
            listarVoo();
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Lista todos os Aeroportos.
     */
    public final void listarAeroporto() {
        try {
            /**Lista todos os voos.*/
            telaAero = new TelaAeroporto();
            telaAero.setControladoraFuncionario(this);
            List<Aeroporto> aeros = null;
            aeros = cntrNegocioVoo.consultarAeroportos();
            if (aeros != null) {
                for (int i = 0; i < aeros.size(); i++) {
                    telaAero.addTable(aeros.get(i).getCodigo(),
                            aeros.get(i).getCidade());
                }
            }
            telaAero.setVisible(true);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Retorna uma lista de aeroportos.
     * @return
     */
    public List<Aeroporto> getAeroportos() {
        try {
            return cntrNegocioVoo.consultarAeroportos();
        } catch (ErroPersistencia ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Cria ou edita aeroporto existente com os seguintes dados.
     * @param codAero Código do Aeroporo.
     * @param cidade Cidade do Aeroporto.
     * @param editar Informa se é uma edição ou um cadastro de aeroporto.
     * @param indice Indice do voo que sera editado.
     */
    public final void cadastrarAeroporto(final String codAero,
            final String cidade, final boolean editar, final int indice) {
        try {
            Aeroporto aero = new Aeroporto(cidade, codAero);
            if (editar) {
                cntrNegocioVoo.editarAeroporto(aero, indice);
            } else {
                cntrNegocioVoo.incluirAeroporto(aero);
            }

            JOptionPane.showMessageDialog(null, "Aeroporto cadastrado com"
                    + "sucesso!",
                null, JOptionPane.INFORMATION_MESSAGE);

            telaEditaAero.dispose();
            telaAero.dispose();
            listarAeroporto();

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Edita Aeroporto.
     * @param indice Indice do Aeroporto a ser editado se for negativo,
     * um novo aeroporto será criado.
     */
    public final void editarAeroporto(final int[] indice) {
        try {
            telaEditaAero = new TelaNovoAeroporto();
            telaEditaAero.setControladora(this);
            /*Edição de Aeroportos*/
            if (indice.length == 0) {
                JOptionPane.showMessageDialog(null, "Selecione um Aeroporto!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (indice[0] >= 0) {
                List<Aeroporto> aeros = cntrNegocioVoo.consultarAeroportos();
                telaEditaAero.setIndice(indice[0]);
                telaEditaAero.setDadosAeroporto(aeros.get(indice[0]));
            }
            telaEditaAero.setVisible(true);

        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Remove Aeroporto.
     * @param indice dos Aeroportos a serem removidos.
     */
    public final void removerAeroporto(final int[] indice) {
        try {
            List<Aeroporto> aeros = cntrNegocioVoo.consultarAeroportos();
            List<String> codigos = new ArrayList<String>();

            if (indice.length == 0) {
                JOptionPane.showMessageDialog(null, "Selecione um Aeroporto!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i = 0; i < indice.length; i++) {
                codigos.add(aeros.get(indice[i]).getCodigo());
            }

            cntrNegocioVoo.removerAeroporto(codigos);

            JOptionPane.showMessageDialog(null, "Aeroporto(s) removido(s)"
                    + "com sucesso!",
                null, JOptionPane.INFORMATION_MESSAGE);
            telaAero.dispose();
            listarAeroporto();
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

     /**
     * Cadastra Funcionario.
     * @param funcionario objeto a ser cadastrado.
     */
    public final void cadastrarFuncionario(final Funcionario funcionario) {
        try {
            cntrNegocioFunc.cadastrar(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado!\n"
                + "Matrícula: " + funcionario.getMatricula(),
                null, JOptionPane.INFORMATION_MESSAGE);
        } catch (ErroCadastro e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
