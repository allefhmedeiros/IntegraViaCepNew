package br.com.alura.integraviacep.principal;

import br.com.alura.integraviacep.dependencias.GerenciadorConsultas;
import br.com.alura.integraviacep.dependencias.IntegraViaCep;
import br.com.alura.integraviacep.modelos.Cep;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entradaUsuario = new Scanner(System.in);
        IntegraViaCep novaConsulta = new IntegraViaCep();

        System.out.println("Informe o número do CEP para ser consultado: ");
        var cepInformado = entradaUsuario.nextLine();

        try{
            Cep novoCep = novaConsulta.buscaCep(cepInformado);
            System.out.println(novoCep);
            GerenciadorConsultas escreverArquivo = new GerenciadorConsultas();
            escreverArquivo.escreverArquivo(novoCep);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("A aplicação foi finalizada!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        entradaUsuario.close();
    }
}
