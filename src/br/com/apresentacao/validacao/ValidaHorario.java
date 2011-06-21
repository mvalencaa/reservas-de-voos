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
public final class ValidaHorario {

    /**
     * Construtor.
     */
    private ValidaHorario() { }

    /**
     * Verifica se um horário está de acordo com o esperado,
     * isto é:
     * <ul>
     *  <li> Não deve ser <code>null</code>; </li>
     *  <li> Não deve ser vazio; </li>
     *  <li> Deve obedecer a seguinte estrutura: HH:MM:SS. </li>
     * </ul>
     *
     * @param horario String que representa um horário.
     * @return <code>true</code> se o horário é válido.
     */
    public static String validar(final String horario) {

        if ((horario == null) || (horario.isEmpty())) {
            throw new IllegalArgumentException("Horário " + horario
                    + " inválido...");
        }

        try {
            Calendar horarioFormatado = Calendar.getInstance();
            SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
            formato.setLenient(false);
            horarioFormatado.setTime(formato.parse(horario));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Horário " + horario
                    + " inválido...");
        }

        return horario;
    }
}
