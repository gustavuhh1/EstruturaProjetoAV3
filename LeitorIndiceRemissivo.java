import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorIndiceRemissivo {

    public void lerArquivo() {

        StringBuilder conteudo = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("stdin.txt"))) {

            String linha;
            int numeroLinha = 1;

            while ((linha = br.readLine()) != null) {
                // Remove pontuação e divide palavras entre os espaços
                String[] palavras = linha.replaceAll("[,.]", "").split(" ");

                System.out.println("----------" + numeroLinha + "----------");
                for (String palavra : palavras) {
                    if (palavra.isEmpty()) {
                        continue;
                    }

                    String normalizada = palavra.toLowerCase();

                    // Por enquanto só mostra no console
                    System.out.println(normalizada);
                    conteudo.append(normalizada).append(" ");
                }
                numeroLinha++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
