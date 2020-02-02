package PerguntasRespostas;
/**
 *
 * @author Ailton Lima de Andrade
 *
 */
public class NodeTree <E extends Comparable<E>> {
    private E value;
    private NodeTree filhoEsquerdo;
    private NodeTree filhoDireito;

    @Override
    public String toString() {
        return value.toString();
    }
    
    public NodeTree(E valor){
        this.value = valor;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    }
    
    public E getValue(){
        return value;
    }
    
    public void setValue(E value){
        this.value = value;
    }
    
    public NodeTree getFilhoEsquerdo(){
        return filhoEsquerdo;
    }
    
    public void setFilhoEsquerdo(NodeTree filhoEsquerdo){
        this.filhoEsquerdo = filhoEsquerdo;
    }
    
    public NodeTree getFilhoDireito(){
        return filhoDireito;
    }
    
    public void setFilhoDireito(NodeTree filhoDireito){
        this.filhoDireito = filhoDireito;
    }
    
}
