package br.com.apresentacao.controladoras;

import br.com.apresentacao.entidades.Cliente;
import br.com.apresentacao.entidades.Reserva;
import br.com.apresentacao.entidades.Voo;
import br.com.apresentacao.telas.TelaCliente;
import br.com.apresentacao.telas.TelaConsultaVoo;
import br.com.apresentacao.telas.TelaDeReservas;
import br.com.apresentacao.telas.TelaNovaReserva;
import br.com.apresentacao.telas.TelaVoos;
import br.com.apresentacao.validacao.ValidaCodReserva;
import br.com.negocio.controladoras.ErroCadastro;
import br.com.negocio.controladoras.INegocioCliente;
import br.com.negocio.controladoras.INegocioReserva;
import br.com.negocio.controladoras.INegocioVoos;
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
public class CntrInteracaoCliente implements IInteracaoCliente {

    /** Tela de cliente. */
    private TelaCliente telaCliente;
    /** Cliente logado.*/
    private Cliente cliente;
    /** Tela de reservas. */
    private TelaDeReservas telaDeReservas;
    /** Tela nova reserva. */
    private TelaNovaReserva telaNovaReserva;
    /** Tela de voos. */
    private TelaVoos telaVoos;
    /** Tela de voos. */
    private TelaConsultaVoo telaConsultaVoo;
    /** Controladora de negócio para cliente correspondente. */
    private INegocioCliente cntrNegocioCliente;
    /** Controladora de negócio correspondente. */
    private INegocioReserva cntrNegocioReserva;
    /** Controladora de negócio correspondente. */
    private INegocioVoos cntrNegocioVoo;
    /** Numero de digitos da reserva.*/
    private static final int MAX_DIGITOS = 5;
    /** Multiplicador de randomicos.*/
    private static final int MULTIPLICADOR = 122;

    /**
     * Inicializa a tela de cliente.
     */
    public final void executar() {
        telaCliente = new TelaCliente();
        telaCliente.setControladora(this);
    }

    /**
     * Seta a controladora correspondente.
     *
     * @param cntrNegocio Controladora a ser setada.
     */
    public final void setControladoraCliente(
            final INegocioCliente cntrNegocio) {
        this.cntrNegocioCliente = cntrNegocio;
    }

    /**
     * Seta a controladora correspondente.
     *
     * @param cntrNegocio Controladora a ser setada.
     */
    public final void setControladoraReserva(
            final INegocioReserva cntrNegocio) {
        this.cntrNegocioReserva = cntrNegocio;
    }

     /**
     * Seta a controladora correspondente.
     *
     * @param cntrNegocio Controladora a ser setada.
     */
    public final void setControladoraVoos(final INegocioVoos cntrNegocio) {
        this.cntrNegocioVoo = cntrNegocio;
    }

    /**
     * Realiza o login do cliente.
     *
     * @param cpf CPF do cliente utilizado no momento do login.
     */
    public final void login(final String cpf) {
        try {
            cliente = cntrNegocioCliente.consultar(cpf);
            telaCliente.setFieldNome(cliente.getNome());
            telaCliente.setFieldCpf(cliente.getCpf());
            telaCliente.setFieldTelefone(cliente.getTelefone());
            telaCliente.setVisible(true);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, "CPF do cliente inválido.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "CPF do cliente inválido.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "CPF do cliente inválido.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Realiza as alterações realizadas pelo cliente.
     * @param novoCliente Cliente Nome do cliente.
     */
    public final void cadastrarCliente(final Cliente novoCliente) {
        try {
            cntrNegocioCliente.cadastrar(novoCliente);
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado!",
                    null, JOptionPane.INFORMATION_MESSAGE);
        } catch (ErroCadastro ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Realiza as alterações realizadas pelo cliente.
     * @param nome Nome do cliente.
     * @param telefone Telefone do cliente.
     * @param cpf CPF do Cliente.
     */
    public final void salvarAlteracoes(final String nome, final String telefone,
            final String cpf) {
        try {
            cliente = new Cliente(nome, telefone, cpf);
            cntrNegocioCliente.editar(cliente);
            telaCliente.setFieldNome(cliente.getNome());
            telaCliente.setFieldTelefone(cliente.getTelefone());
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

    /**
     * Efetua uma reserva para o cliente.
     */
    public final void efetuarReserva() {
        try {
            telaNovaReserva = new TelaNovaReserva();
            telaNovaReserva.setControladora(this);
            List<Voo> voos = null;
            voos = cntrNegocioVoo.consultarVoos();
            if (voos != null) {
                for (int i = 0; i < voos.size(); i++) {
                    telaNovaReserva.addTable(voos.get(i).getNumero(),
                            voos.get(i).getAeroportoSaida().getCidade(),
                            voos.get(i).getAeroportoChegada().getCidade(),
                            voos.get(i).getHoraSaida(),
                            voos.get(i).getHoraChegada());
                }
            } else {
                telaNovaReserva.setTableDisabled();
            }
            telaNovaReserva.setVisible(true);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Efetua uma reserva para o cliente.
     * @param voosSelecionados Informa quais os voos foram selecionados.
     */
    public final void criarReserva(final int []voosSelecionados) {
        try {
            List<Voo> voos = cntrNegocioVoo.consultarVoos();
            List<Voo> nVoos = new ArrayList<Voo>();
            int random = 0;
            char []cod = {'0', '0', '0', '0', '0'};
            boolean v = false;

            for (int i = 0; i < MAX_DIGITOS; i++) {
                v = false;
                do {
                    random = (int) (Math.random() * MULTIPLICADOR);
                    if (random >= '0' && random <= '9') {
                        v = true;
                    }
                } while (!v);
                cod[i] = (char) random;
            }

            if (voosSelecionados.length > 0) {
                for (int i = 0; i < voosSelecionados.length; i++) {
                    nVoos.add(voos.get(voosSelecionados[i]));
                }

                String codReserva = new String(cod);
                Reserva reserva = new Reserva(codReserva.toString(), nVoos,
                        cliente);

                cntrNegocioReserva.efetuarReserva(reserva);
                JOptionPane.showMessageDialog(null, "Reserva cadastrada!",
                            null, JOptionPane.INFORMATION_MESSAGE);

                telaNovaReserva.dispose();
                telaDeReservas.dispose();
                listarReservas();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione ao menos um"
                        + " voo!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                JOptionPane.ERROR_MESSAGE);
            telaNovaReserva.dispose();
        }
    }

    /**
     * Cancela uma reserva para o cliente.
     * @param reserva Reserva a ser cancelada.
     */
    public final void cancelarReserva(final String reserva) {
        try {
            cntrNegocioReserva.cancelarReserva(ValidaCodReserva.validar(
                    reserva));
            JOptionPane.showMessageDialog(null, "Reserva cancelada!",
                    null, JOptionPane.INFORMATION_MESSAGE);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        telaDeReservas.dispose();
        listarReservas();
    }

    /**
     * Lista as reservas para o cliente.
     */
    public final void listarReservas() {
        try {
            telaDeReservas = new TelaDeReservas();
            telaDeReservas.setControladora(this);
            List<Reserva> listaReserva = null;
            listaReserva = cntrNegocioReserva.consultarReservas(
                    cliente.getCpf());
            if (!listaReserva.isEmpty()) {
                if (listaReserva.get(0) != null) {
                    telaDeReservas.setCodReserva1(
                            listaReserva.get(0).getCodigo());
                    /*List<Voo> voos = cntrNegocioReserva.consultarVoosReserva(
                            listaReserva.get(0).getCodigo());*/
                    List<Voo>voos = listaReserva.get(0).getVoos();
                    for (int i = 0; i < voos.size(); i++) {
                        telaDeReservas.addTable1(voos.get(i).getNumero(),
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
                    telaDeReservas.setCodReserva1(null);
                }
                if (listaReserva.size() > 1) {
                    if (listaReserva.get(1) != null) {
                        telaDeReservas.setCodReserva2(listaReserva.get(1).
                                getCodigo());
                        /*List<Voo> voos = cntrNegocioReserva.
                                consultarVoosReserva(listaReserva.get(1).
                                    getCodigo());*/
                        List<Voo>voos = listaReserva.get(1).getVoos();
                        for (int i = 0; i < voos.size(); i++) {
                            telaDeReservas.addTable2(voos.get(i).getNumero(),
                                    voos.get(i).getAeroportoSaida().getCidade(),
                                    voos.get(i).getAeroportoSaida().getCodigo(),
                                    voos.get(i).getAeroportoChegada().
                                        getCidade(),
                                    voos.get(i).getAeroportoChegada().
                                        getCodigo(),
                                    voos.get(i).getDataSaida(),
                                    voos.get(i).getDataChegada(),
                                    voos.get(i).getHoraSaida(),
                                    voos.get(i).getHoraChegada());
                        }
                    } else {
                        telaDeReservas.setCodReserva2(null);
                    }
                } else {
                    telaDeReservas.setCodReserva2(null);
                }
            } else {
                telaDeReservas.setCodReserva1(null);
                telaDeReservas.setCodReserva2(null);
                telaDeReservas.setTableDisabled();
            }
            telaDeReservas.setVisible(true);
        }  catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Lista os voos para o cliente.
     */
    public final void listarVoos() {
        try {
            /**Lista todos os voos.*/
            telaVoos = new TelaVoos();
            telaVoos.setControladoraCliente(this);
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
            telaVoos.configModoCliente();
            telaVoos.setVisible(true);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Cria tela de consulta de voos.
     */
    public final void consultarVoos() {
        /**Lista todos os voos.*/
        telaConsultaVoo = new TelaConsultaVoo();
        telaConsultaVoo.setControladoraCliente(this);
        telaConsultaVoo.setVisible(true);
    }

    /**
     * Filtrar voos a partir das cidades de origem, destino e data.
     * @param cidadeOrigem Cidade de Origem.
     * @param cidadeDestino Cidade de Destino.
     * @param data Data de saída.
     */
    public final void filtrarVoos(final String cidadeOrigem,
            final String cidadeDestino, final String data) {
        try {
            telaVoos.dispose();
            telaVoos = new TelaVoos();
            telaVoos.setControladoraCliente(this);
            List<Voo> voos = null;
            voos = cntrNegocioVoo.consultarVoos(cidadeOrigem, cidadeDestino,
                    data);
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
            telaConsultaVoo.dispose();
            telaVoos.configModoCliente();
            telaVoos.setVisible(true);
        } catch (ErroPersistencia e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
