package desafio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class BuscaCEP {

    private  String cep;

    public BuscaCEP(String cep) {
        this.cep = cep;
    }

    public Endereco Busca(){

        URI enderecoCep = URI.create("https://viacep.com.br/ws/" + this.cep + "/json/");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(enderecoCep)
                .build();
            try {
                HttpResponse<String> response = HttpClient.newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());
                Endereco enderecResposta = new Gson().fromJson(response.body(), Endereco.class);
                return enderecResposta;
            } catch (Exception e) {
                throw new RuntimeException("Não foi possivel obter endereço apartir deste CEP.");
            }


        }


    }
