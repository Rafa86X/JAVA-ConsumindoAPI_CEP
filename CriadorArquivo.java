package desafio;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class CriadorArquivo {




    public void Criador(Endereco e, String cep) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter escrita = new FileWriter("Infos_CEP-"+cep+"__.json");
        escrita.write(gson.toJson(e));
        escrita.close();
    }
}
