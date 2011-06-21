package br.com.apresentacao.validacao;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.1
 */
public class ValidaHorarioTest {
    /** Hora inválida contendo null. */
    private static final String HORA_INVALIDA_NULL = null;
    /** Hora inválida vazia. */
    private static final String HORA_INVALIDA_VAZIA = "";
    /** Hora inválida contendo letras nos minutos. */
    private static final String HORA_INVALIDA_LETRA = "21:as:32";
    /** Hora inválida com formatação inválida. */
    private static final String HORA_INVALIDA_FORMATACAO = "255931";
    /** Hora inválida com hora errada. */
    private static final String HORA_INVALIDA_HORA = "25:59:31";
    /** Hora inválida com minuto errado. */
    private static final String HORA_INVALIDA_MINUTO = "21:64:31";
    /** Hora inválida com segundo errado. */
    private static final String HORA_INVALIDA_SEGUNDO = "25:59:75";
    /** Hora inválida negativa. */
    private static final String HORA_INVALIDA_NEGATIVA = "-25:59:75";
    /** Hora válida. */
    private static final String HORA_VALIDA = "13:59:31";

    /**
     * Construtor.
     */
    public ValidaHorarioTest() {
    }

    /**
     * Teste do método validar, da classe ValidaHorario.
     */
    @Test
    public final void testValidar() {
        System.out.println("Validar horario");

        try {
            ValidaHorario.validar(HORA_INVALIDA_NULL);
            fail("HORA_INVALIDA_NULL não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaHorario.validar(HORA_INVALIDA_VAZIA);
            fail("HORA_INVALIDA_VAZIA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaHorario.validar(HORA_INVALIDA_LETRA);
            fail("HORA_INVALIDA_LETRA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaHorario.validar(HORA_INVALIDA_FORMATACAO);
            fail("HORA_INVALIDA_FORMATACAO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaHorario.validar(HORA_INVALIDA_HORA);
            fail("HORA_INVALIDA_HORA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaHorario.validar(HORA_INVALIDA_MINUTO);
            fail("HORA_INVALIDA_MINUTO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaHorario.validar(HORA_INVALIDA_SEGUNDO);
            fail("HORA_INVALIDA_SEGUNDO não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            ValidaHorario.validar(HORA_INVALIDA_NEGATIVA);
            fail("HORA_INVALIDA_NEGATIVA não lançou exceção...");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(HORA_VALIDA, ValidaHorario.validar(HORA_VALIDA));
    }

}