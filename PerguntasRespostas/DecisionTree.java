package PerguntasRespostas;
/**
 *
 * @author Ailton Lima de Andrade
 *
 */
public class DecisionTree<E extends Comparable<E>> {

    private NodeTree raiz;

    public DecisionTree() { //método construtor
        raiz = null;
    }

    //Verificar se está vázia
    public boolean isEmpty() {
        return (raiz == null);
    }

    //Setter 
    public void setRaiz(NodeTree araiz) {
        raiz = araiz;
    }

    //Getter
    public NodeTree getRaiz() {
        return raiz;
    }
    
    //Inserir Recursivo (Arvore Cheia)
    public NodeTree inserir(String[] vetor, NodeTree node, int i) {
        if (i < vetor.length) {
            NodeTree temp = new NodeTree(vetor[i]);
            node = temp;
            
            // Inserir Filho Esquerdo
            node.setFilhoEsquerdo(inserir(vetor, node.getFilhoEsquerdo(), 2 * i + 1));
            
            // Inserir Filho Direito
            node.setFilhoDireito(inserir(vetor, node.getFilhoDireito(), 2 * i + 2));
        }
        return node;
    }

}
