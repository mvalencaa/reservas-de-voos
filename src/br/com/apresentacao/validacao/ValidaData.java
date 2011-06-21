package br.com.apresentacao.validacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public final class ValidaData {

    /**
     * Construtor.
     */
    private ValidaData() { }

    /** Indice para a primeira barra. */
    private static final int INDICE_BARRA = 3;

    /** Indice para o último digito do mês. */
    private static final int INDICE_DIGITO_1 = 5;

    /** Indice para o primeiro dígito do ano. */
    private static final int INDICE_DIGITO_2 = 6;

    /**
     * Verifica se uma data está de acordo com o esperado,
     * isto é:
     * <ul>
     *  <li> Não deve ser <code>null</code>; </li>
     *  <li> Não deve ser vazia; </li>
     *  <li> Deve conter apenas dígitos e '/'; </li>
     *  <li> O caracter '/' deve estar nas posições 2 e 5 da string; </li>
     *  <li> Deve obedecer a seguinte estrutura: DD:MM:AAAA. </li>
     * </ul>
     *
     * @param data String que representa uma data.
     * @return <code>true</code> se a data é válida.
     */
    public static String validar(final String data) {

        if ((data == null) || (data.isEmpty())) {
            throw new IllegalArgumentException("Data inválida...");
        }

        char[] caracteres = data.substring(0, 2).toCharArray();
        for (char c : caracteres) {
            if ((!Character.isDigit(c)) || (c == '/')) {
                throw new IllegalArgumentException("Data " + data.toString()
                        + " inválida...");
            }
        }

        caracteres = data.substring(INDICE_BARRA, INDICE_DIGITO_1).
                toCharArray();
        for (char c : caracteres) {
            if ((!Character.isDigit(c)) || (c == '/')) {
                throw new IllegalArgumentException("Data " + data.toString()
                        + " inválida...");
            }
        }

        caracteres = data.substring(INDICE_DIGITO_2).toCharArray();
        for (char c : caracteres) {
            if ((!Character.isDigit(c)) || (c == '/')) {
                throw new IllegalArgumentException("Data " + data.toString()
                        + " inválida...");
            }
        }

        try {
            Calendar dataFormatada = Calendar.getInstance();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
            dataFormatada.setTime(formato.parse(data));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Data " + data.toString()
                    + " inválida...");
        }

        return data;
    }
}