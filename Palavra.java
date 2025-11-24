public class Palavra {
    public String palavra;
    public int linha;
    public int ocorrencias;
    public Palavra proximo;
    public Palavra anterior;

    public Palavra(String elemento, int linha) {
        this.palavra = elemento;
        this.ocorrencias = 1;
        this.linha = linha;
        this.proximo = null;
        this.anterior = null;
    }
}
