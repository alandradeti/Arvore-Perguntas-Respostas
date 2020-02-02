package PerguntasRespostas;
/**
 *
 * @author Ailton Lima de Andrade
 *
 */
import javax.swing.JOptionPane;

public class GameHandle {

    //Realiza a captura das respostas e verifica se e valida.
    public String capturaResposta(NodeTree pergunta) {
        String resp = "";
        do { //Captura a resposta do usuário e verifica se e valida.
            try { //Captura o erro caso o usuário tente cancelar o jogo em andamento.
                resp = JOptionPane.showInputDialog(null, pergunta, "Pergunta", JOptionPane.QUESTION_MESSAGE);
                if ((resp.equalsIgnoreCase("SIM") || resp.equalsIgnoreCase("S") || resp.equalsIgnoreCase("YES") || resp.equalsIgnoreCase("Y"))) {
                    resp = "Sim";
                } else if (resp.equalsIgnoreCase("NÃO") || resp.equalsIgnoreCase("NO") || resp.equalsIgnoreCase("N")) {
                    resp = "Não";
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Resposta inválida!\n"
                            + "Por favor digite somente umas respostas abaixo:\n"
                            + "Para Sim: SIM - S - YES - Y\n"
                            + "Para Não: NÃO - NO - N","ERRO", JOptionPane.WARNING_MESSAGE
                    );
                    resp = "invalida";
                }
            } catch (NullPointerException erro) {
                JOptionPane.showMessageDialog(null, "Para voltar ao menu complete todas as etapas do jogo!","ERRO", JOptionPane.WARNING_MESSAGE);
                resp = "invalida";
            }
        } while (resp.equalsIgnoreCase("invalida"));

        return resp;
    }

    //Realiza o percurso da arvore conforme a resposta do usuário
    public void gamePlay(String[] vetor) {
        //Metodo iterativo que utiliza uma fila auxiliar
        //Instancia das classes
        LinkedList fila = new LinkedList();
        DecisionTree arvore = new DecisionTree();
        //Chamada do metodo inserir
        arvore.setRaiz(arvore.inserir(vetor, arvore.getRaiz(), 0));
        //Atribuição do nodo raiz para o nodo NodeTree node
        NodeTree node = arvore.getRaiz();
        //Criacao das variaveis e instancia de uma NodeTree auxiliar
        NodeTree noAux;
        String resp;
        String msg = "";
        //Adicionando a raiz na fila
        fila.addLast(node);
        while (!fila.isEmpty()) {
            noAux = (NodeTree) fila.removeFirst(); // elimina da fila
            //se o nó da árvore(retirado da fila) tiver filhos
            if (noAux.getFilhoEsquerdo() != null && noAux.getFilhoDireito() != null) {
                //Captura a resposta
                resp = capturaResposta(noAux);
                //Se for "sim" adiciona o Filho Esquerdo a fila. Se for "nao" adiciona o Filho Direito a fila.
                if (noAux.getFilhoEsquerdo() != null && resp.equals("Sim")) {
                    fila.addLast(noAux.getFilhoEsquerdo());
                    msg += noAux.getValue() + "\n";
                } else if (noAux.getFilhoDireito() != null && resp.equals("Não")) {
                    fila.addLast(noAux.getFilhoDireito());
                    msg += noAux.getValue() + "\n";
                }
                msg += resp + "\n";
            } else {//Se nao tiver filhos o no e folha "Resposta"
                //Apresenta a resposta do jogo
                JOptionPane.showMessageDialog(null, noAux.getValue());
                msg += "RESPOSTA: " + noAux.getValue();
            }

        }
        //Apresenta o resultado completo do jogo
        JOptionPane.showMessageDialog(null, msg);
    }

}
