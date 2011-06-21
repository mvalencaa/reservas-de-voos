package br.com.apresentacao.controladoras;

import br.com.apresentacao.entidades.Aeroporto;
import br.com.apresentacao.entidades.Funcionario;
import br.com.negocio.controladoras.INegocioFuncionario;
import br.com.negocio.controladoras.INegocioVooFuncionario;
import java.util.List;

/**
 * @author Bruno Pessanha de Carvalho;
 * @author Marcela Gomes Correa;
 * @author Marcelo Valença de Almeida.
 * @version 0.2
 */
public interface IInteracaoFuncionario extends ICntrInteracao {

    /**
     * Controladora de negócio.
     * @param cntrNegocioFuncionario Controladora Funcionario
     */
    void setControladoraFuncionario(INegocioFuncionario cntrNegocioFuncionario);

    /**
     * Controladora de negócio.
     * @param cntrNegocioVoos Controladora Voo.
     */
    //void setControladoraVoo(INegocioVooFuncionario cntrNegocioVoos);

    /**
     * Controladora de negócio.
     * @param cntrNegocioVoos Controladora Voo.
     */
    void setControladoraVoo(INegocioVooFuncionario cntrNegocioVoos);

    /**
     * Realiza o login do funcionário.
     *
     * @param matricula Matrícula do usuário utilizada no momento do login.
     */
    void login(String matricula);

    /**
     * Cadastra novo Funcionário.
     * @param funcionario Funcionario.
     */
    void cadastrarFuncionario(Funcionario funcionario);

    /**
     * Realiza as alterações realizadas pelo funcionario.
     * @param nome Nome do funcionario.
     * @param telefone Telefone do funcionario.
     * @param matric Matricula do Funcionario.
     */
    void salvarAlteracoes(String nome, String telefone, String matric);

    /**
     * Cria ou edita voo existente com os seguintes dados.
     * @param codVoo Código do Voo.
     * @param cidadeSaida Cidade de Saída.
     * @param saidaSigla Sigla da Cidade de saída.
     * @param dataSaida Data da saída do voo.
     * @param horaSaida Hora de saída do voo.
     * @param cidadeChegada Cidade de Chegada.
     * @param chegadaSigla Sigla da Cidade de chegada.
     * @param dataChegada Data da chegada do voo.
     * @param horaChegada Hora de chegada do voo.
     * @param editar informa se o voo ja existe ou é um novo voo
     */
    void cadastrarVoo(String codVoo, int vagas, String cidadeSaida,
            String saidaSigla, String dataSaida, String horaSaida,
            String cidadeChegada, String chegadaSigla, String dataChegada,
            String horaChegada, boolean editar);

    /**
     * Lista novo voo.
     */
    void listarVoo();

    /**
     * Edita voo.
     * @param indice Indice do array.
     */
    void editarVoo(int []indice);

    /**
     * Remove voo.
     * @param indice Array de indices de voos seleciondos.
     */
     void removerVoo(int []indice);

    /**
     * Cria ou edita aeroporto existente com os seguintes dados.
     * @param codAero Código do Aeroporo.
     * @param cidade Cidade do Aeroporto.
     * @param editar Informa se é uma edição ou um cadastro de aeroporto.
     * @param indice Informa qual é o voo selecionado.
     */
    void cadastrarAeroporto(String codAero, String cidade, boolean editar,
            int indice);

    /**
     * Mostra os aeroportos cadastrados e opçoes para editar, remover e
     * incluir aeroportos.
     */
    void listarAeroporto();

    /**
     * Retorna lista de aeroportos;
     * @return aeroportos.
     */
    public List<Aeroporto> getAeroportos();

    /**
     * Edita aeroporto.
     * @param indice Indice do aeroporto a ser editado
     */
    void editarAeroporto(int []indice);

    /**
     * Remove cidade.
     * @param indice dos Aeroportos a serem removidos.
     */
     void removerAeroporto(int []indice);

}
