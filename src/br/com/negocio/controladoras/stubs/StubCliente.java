package br.com.negocio.controladoras.stubs;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Cliente;
import br.com.apresentacao.entidades.Reserva;
import br.com.apresentacao.entidades.Voo;
import br.com.negocio.controladoras.INegocioCliente;
import br.com.negocio.controladoras.INegocioReserva;
import br.com.negocio.controladoras.INegocioVoos;
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
public class StubCliente implements INegocioCliente, INegocioReserva,
       INegocioVoos {

    /**Cliente que será cadastrado.*/
    private Cliente novoCliente;

    /**Nova reserva criada pelo cliente.*/
    private Reserva novaReserva1;

    /**Nova reserva criada pelo cliente.*/
    private Reserva novaReserva2;

    /**Voo.*/
    private Voo voo;

    /**Stub que simula o cadastro de um cliente.
     * @param cliente O novo cliente a ser cadastrado.
     */
    public final void cadastrar(final Cliente cliente) {
        novoCliente = cliente;
    }

    /**Stub que simula a consulta a um cliente.
     * @param cpf CPF do cliente a ser consultado
     * @return cliente Retorna o cliente padrÃ£o caso o CPF seja diferente de
     * 00000000000.
     */
    public final Cliente consultar(final String cpf) {
        /**CPF que retorna que o Cliente nao existe.*/
        if (cpf.equals("00000000000")) {
            throw new NullPointerException("Cliente nao encontrado.");
        }
        Cliente cliente = new Cliente(novoCliente.getNome(),
                novoCliente.getTelefone(), cpf);
        return cliente;
    }

    /**
     * Stub que simula a edição de um cliente.
     *
     * @param cliente Cliente a ser editado.
     */
    public final void editar(final Cliente cliente) {
        novoCliente = cliente;
    }

    /**
     * Inicializa os objetos necessários.
     */
    public final void executar() {
        List<Voo> voos = new ArrayList<Voo>();
        novoCliente = new Cliente("Michael Jackson", "6192867743",
            "10987654321");
        voo = new Voo("ABC123", 12, "12:00:00", "18:00:00", "08/08/2010",
                "08/08/2011", new Aeroporto("Brasília", "BSB"),
                new Aeroporto("Rio de Janeiro", "RJO"));
        voos.add(voo);
        voo = new Voo("PEA358", 15, "12:00:00", "18:00:00", "08/08/2010",
                "08/08/2011", new Aeroporto("Belo Horizonte", "BHO"),
                new Aeroporto("São Paulo", "SPO"));
        voos.add(voo);
        novaReserva1 = new Reserva("12345", voos, novoCliente);
    }

    /**
     * Efetua uma reserva.
     *
     * @param reserva Reserva a ser efetuada.
     */
    public final void efetuarReserva(final Reserva reserva) {
        if (novaReserva1 == null) {
            novaReserva1 = reserva;
            return;
        }
        if (novaReserva2 != null) {
            throw new IllegalArgumentException(
                    "Cada cliente só pode realizar duas reservas!");
        }
        novaReserva2 = reserva;
    }

    /**
     * Cancela uma reserva.
     *
     * @param codReserva Código da reserva a ser cancelada.
     */
    public final void cancelarReserva(final String codReserva) {
        if ((novaReserva1 != null)
                && (novaReserva1.getCodigo().equals(codReserva))) {
            novaReserva1 = null;
            return;
        }
        if ((novaReserva2 != null)
                && (novaReserva2.getCodigo().equals(codReserva))) {
            novaReserva2 = null;
            return;
        }
        throw new IllegalArgumentException("Reserva não encontrada!");
    }

    /**
     * Retorna uma lista de códigos das reservas de um cliente.
     *
     * @param cpf CPF do cliente.
     * @return Lista de códigos das reservas de um cliente.
     */
    public final List<String> getCodigos(final String cpf) {
        if ((novaReserva1 == null) && (novaReserva2 == null)) {
            throw new IllegalArgumentException(
                    "Não existem reservas cadastradas!");
        }
        List<String> codigos = null;
        codigos.add(novaReserva1.getCodigo());
        if (novaReserva2 != null) {
            codigos.add(novaReserva2.getCodigo());
        }
        return codigos;
    }

    /**
     * Retorna uma lista com todos os voos relacionados à reserva.
     *
     * @param codReserva Códgio da reserva.
     * @return Lista de voos relacionados à reserva.
     */
    public final List<Voo> consultarVoosReserva(final String codReserva) {
        if ((novaReserva1 == null) && (novaReserva2 == null)) {
            throw new IllegalArgumentException(
                    "Não existem reservas cadastradas!");
        }

        List<Voo> voos = new ArrayList<Voo>();

        if ((novaReserva1 != null)
                && (novaReserva1.getCodigo().equals(codReserva))) {
            return novaReserva1.getVoos();
        }

        if ((novaReserva2 != null)
                && (novaReserva2.getCodigo().equals(codReserva))) {
            return novaReserva2.getVoos();
        }

        return null;
    }

    /**
     * Retorna todos os voos cadastrados no sistema.
     *
     * @return Lista de todos os voos cadastrados no sistema.
     */
    public final List<Voo> consultarVoos() {
        List<Voo> voos = new ArrayList<Voo>();
        voos.add(new Voo("HUQ843", 14, "13:50:00", "21:50:00", "24/11/2010",
                "25/11/2010", new Aeroporto("Brasília", "BSB"),
                new Aeroporto("Porto Velho", "PVH")));
        voos.add(new Voo("XYZ837", 13, "15:00:00", "11:00:00", "08/08/2010",
                "08/08/2010", new Aeroporto("Brasília", "BSB"),
                new Aeroporto("Rio de Janeiro", "RJO")));
        return voos;
    }

    /**
     * Retorna os voos correspondentes com os parâmetros passados.
     *
     * @param cidadeOrigem Cidade de origem do voo.
     * @param cidadeDestino Cidade de destino do voo.
     * @param dataSaida Data de saída do voo.
     * @return Lista dos voos correspondentes.
     */
    public final List<Voo> consultarVoos(final String cidadeOrigem,
            final String cidadeDestino, final String dataSaida) {
        List<Voo> voos = new ArrayList<Voo>();
        voos.add(new Voo("KRA363", 15, "13:50:00", "21:50:00", "24/11/2010",
                "25/11/2010", new Aeroporto("Brasília", "BSB"),
                new Aeroporto("Porto Velho", "PVH")));
        voos.add(new Voo("OSX275", 14, "15:00:00", "16:30:00", "02/02/2010",
                "02/02/2010", new Aeroporto("Goiania", "GYN"),
                new Aeroporto("Maceio", "MCO")));
        return voos;
    }

    /**
     * Retorna uma lista com todas as reservas de um cliente.
     *
     * @param cpf CPF do cliente.
     * @return Lista com todas as reservas do cliente.
     */
    public final List<Reserva> consultarReservas(final String cpf) {
        List<Reserva> lista = new ArrayList<Reserva>();
        if (novaReserva1 != null) {
            lista.add(novaReserva1);
        }
        if (novaReserva2 != null) {
            lista.add(novaReserva2);
        }
        return lista;
    }

    /**
     * Seta a controladora de persistência correspondente.
     *
     * @param cntrPersistenciaCliente Controladora em questão.
     */
    public final void setControladora(
            final IPersistencia cntrPersistenciaCliente) {

    }
}
