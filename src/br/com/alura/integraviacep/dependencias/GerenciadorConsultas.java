package br.com.alura.integraviacep.dependencias;

import br.com.alura.integraviacep.modelos.Cep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorConsultas {
    public  void escreverArquivo(Cep cep) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrevaArquivoAgora = new FileWriter(cep.cep() + ".json");
        escrevaArquivoAgora.write(gson.toJson(cep));
        escrevaArquivoAgora.close();
    }
}
