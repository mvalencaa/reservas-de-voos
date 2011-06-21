package br.com.apresentacao.entidades;

import br.com.apresentacao.validacao.ValidaCodReserva;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma reserva.
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class Reserva {

    /** Numero maximo de voos permitidos por reserva. */
    private static final byte MAX_NRO_VOOS = 5;
    /** Codigo da reserva. */
    private final String codigo;
    /** Lista que contem os voos relacionados. */
    private List<Voo> voos = new ArrayList<Voo>();
    /** CPF do cliente. */
    private final String cpf;

    /**
     * Constroi uma nova reserva.
     *
     * @param cod Codigo da reserva.
     * @param novoVoo Voo relacionado.
     * @param cliente Cliente da reserva.
     */
    public Reserva(final String cod, final List<Voo> novoVoo,
            final Cliente cliente) {
        this.codigo = ValidaCodReserva.validar(cod);
        this.voos = novoVoo;
        this.cpf = cliente.getCpf();
        //voo.setNroVagas(voo.getNroVagas() - 1);
    }

    /**
     * Acessor do cpf do cliente que fez a reserva.
     * @return cpf CPF do cliente.
     */
    public final String getCpf() {
        return cpf;
    }

   /**
     * Retorna os voos da reserva.
     * @return Codigo da reserva.
     */
    public final List<Voo> getVoos() {
        return voos;
    }

    /**
     * Retorna o codigo da reserva.
     * @return Codigo da reserva.
     */
    public final String getCodigo() {
        return codigo;
    }

    /**
     * Retorna o voo relacionado.
     * @param nroVoo voo relacionado.
     * @return Voo relacionado.
     */
    public final Voo getVoo(final String nroVoo) {
        for (Voo voo : voos) {
            if (voo.getNumero().equals(nroVoo)) {
                return voo;
            }
        }
        return null;
    }

    /**
     * Altera o voo relacionado.
     * @param novoVoo Voo relacionado.
     * @param numero Voo relacionado.
     */
    public final void setVoo(final String numero, final Voo novoVoo) {
        for (int i = 0; i < voos.size(); i++) {
            if ((voos.get(i).getNumero()).equals(numero)) {
                voos.set(i, novoVoo);
                break;
            }
        }
    }

    /**
     * Adiciona um novo voo à reserva.
     * @param novoVoo Voo a ser adicionado.
     */
    public final void addVoo(final Voo novoVoo) {
        if ((novoVoo != null) && (voos.size() < MAX_NRO_VOOS)
                && (!existeVoo(novoVoo))) {
            voos.add(novoVoo);
        } else {
            throw new IllegalArgumentException("Erro ao adicionar o voo...");
        }
    }

    /**
     * Remove um voo à reserva.
     * @param voo Voo a ser removido.
     */
    public final void removeVoo(final Voo voo) {
        if (existeVoo(voo)) {
            for (int i = 0; i < voos.size(); i++) {
                if (voos.get(i).getNumero().equals(voo.getNumero())) {
                    voos.remove(i);
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("Número de voo "
                    + voo.getNumero() + " inexistente...");
        }
    }

    /**
     * Verifica se o voo já foi adicionado à reserva.
     * @param vooChave Voo a ser verificado.
     * @return true or false
     */
    public final boolean existeVoo(final Voo vooChave) {
        for (int i = 0; i < voos.size(); i++) {
            if (voos.get(i).getNumero().equals(vooChave.getNumero())) {
                return true;
            }
        }
        return false;
    }

}
