class ListaDuplamenteEncadeada {

    private Palavra inicio;
    private Palavra fim;
    private int nElementos;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.nElementos = 0;
    }

    public boolean estaVazia() {
        return this.nElementos == 0;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public void imprime() {
        System.out.print("[");
        Palavra cursor = this.inicio;
        for (int i = 0; i < this.nElementos; i++) {
            System.out.print(cursor.palavra + " ");
            cursor = cursor.proximo;
        }
        System.out.println("]");
    }

    public void imprimeInverso() {
        System.out.print("[");
        Palavra cursor = this.fim;
        for (int i = 0; i < this.nElementos; i++) {
            System.out.print(cursor.palavra + " ");
            cursor = cursor.anterior;
        }
        System.out.println("]");
    }

    public void insereInicio(String elemento, int linha) {

        Palavra novo = new Palavra(elemento, linha);

        if (this.estaVazia()) {
            this.fim = novo;
        } else {
            novo.proximo = this.inicio;
            this.inicio.anterior = novo;
        }

        this.inicio = novo;
        this.nElementos++;

    }

    public String removeInicio() {

        if (this.estaVazia()) {
            System.out.println("Lista vazia. Não é possível remover.");
            return null;
        }

        Palavra palavraRemovido = this.inicio;

        if (this.nElementos == 1) {
            this.inicio = null;
            this.fim = null;
        } else {
            this.inicio = palavraRemovido.proximo;
            this.inicio.anterior = null;

            palavraRemovido.proximo = null;
        }

        this.nElementos--;

        return palavraRemovido.palavra;
    }

    public void insereFinal(String elemento, int linha) {

        Palavra novo = new Palavra(elemento, linha);

        if (this.estaVazia()) {
            this.inicio = novo;
        } else {
            this.fim.proximo = novo;
            novo.anterior = this.fim;
        }

        this.fim = novo;

        this.nElementos++;
    }

    public String removeFinal() {

        if (this.estaVazia()) {
            System.out.println("Lista vazia. Não é possível remover.");
            return null;
        }

        Palavra palavraRemovido = this.fim;

        if (this.nElementos == 1) {

            this.inicio = null;
            this.fim = null;
        } else {

            this.fim = palavraRemovido.anterior;

            palavraRemovido.anterior.proximo = null;
            palavraRemovido.anterior = null;
        }

        this.nElementos--;

        return palavraRemovido.palavra;
    }

    public void inserePosicao(String elemento, int linha, int pos) {

        if (pos < 0) {
            System.out.println("Posição negativa. Não é possível inserir.");
            return;
        } else if (pos > this.nElementos) {
            System.out.println("Posição inválida. Não é possível inserir.");
            return;
        }

        if (pos == 0) {
            this.insereInicio(elemento, linha);
            return;
        } else if (pos == this.nElementos) {
            this.insereFinal(elemento, linha);
            return;
        }

        Palavra novo = new Palavra(elemento, linha);
        Palavra cursor = this.inicio;
        for (int i = 1; i <= pos; i++) {
            cursor = cursor.proximo;
        }

        novo.anterior = cursor.anterior;
        novo.proximo = cursor;

        cursor.anterior.proximo = novo;
        cursor.anterior = novo;

        this.nElementos++;

    }

    public String removePosicao(int pos) {

        if (this.estaVazia()) {
            System.out.println("Lista vazia. Não é possível remover.");
            return null;
        } else if (pos < 0) {
            System.out.println("Posição Negativa. Não é possível remover");
            return null;
        } else if (pos >= this.nElementos) {
            System.out.println("Posição inválida. Não é possível remover.");
            return null;
        }

        if (pos == 0) {
            return this.removeInicio();
        } else if (pos == this.nElementos - 1) {
            return this.removeFinal();
        }

        Palavra cursor = this.inicio;
        for (int i = 1; i <= pos; i++) {
            cursor = cursor.proximo;
        }

        Palavra palavraRemovido = cursor;

        palavraRemovido.anterior.proximo = palavraRemovido.proximo;
        palavraRemovido.proximo.anterior = palavraRemovido.anterior;

        palavraRemovido.anterior = null;
        palavraRemovido.proximo = null;

        this.nElementos--;

        return palavraRemovido.palavra;
    }

    public void insereOrdenado(String elemento, int linha) {

        if (this.estaVazia()) {
            this.insereInicio(elemento, linha);
            return;
        }

        boolean flagInseriu = false;

        Palavra cursor = this.inicio;
        for (int i = 0; i < this.nElementos; i++) {
            if (cursor.palavra.compareTo(elemento) > 0) {
                this.inserePosicao(elemento, linha, i);
                flagInseriu = true;
                break;
            }
            cursor = cursor.proximo;
        }

        if (!flagInseriu) {
            this.insereFinal(elemento, linha);
        }
    }

    public boolean removeElemento(String elemento) {

        Palavra cursor = this.inicio;
        int i;
        for (i = 0; i < this.nElementos; i++) {
            if (cursor.palavra.equals(elemento)) {
                break;
            }
            cursor = cursor.proximo;
        }

        if (i == this.nElementos) {
            return false;
        }

        this.removePosicao(i);

        return true;

    }

    public String acesse(int pos) {

        if (pos < 0 || pos >= this.nElementos) {
            return null;
        }

        Palavra cursor = this.inicio;
        for (int i = 0; i < pos; i++) {
            cursor = cursor.proximo;
        }

        return cursor.palavra;

    }

    public boolean contem(String elemento) {
        Palavra cursor = this.inicio;
        for (int i = 0; i < this.nElementos; i++) {
            if (cursor.palavra.equals(elemento)) {
                return true;
            }
            cursor = cursor.proximo;
        }

        return false;
    }

}