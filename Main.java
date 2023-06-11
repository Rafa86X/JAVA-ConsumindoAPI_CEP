package desafio;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner leitura = new Scanner(System.in);
        while (true){

            System.out.println("Digite um cep valido: ");
            var busca = leitura.nextLine();
            if(busca.equals("sair")){
                break;
            }

            BuscaCEP buscaX = new BuscaCEP(busca);
            try {
                CriadorArquivo arquivo = new CriadorArquivo();
                arquivo.Criador(buscaX.Busca(),busca);
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }



        System.out.println("Até a proxima!");


    }
}
