package org.example;
import org.example.Descriptografar;

public class Main {

    public static void main(String[] args) {
        try {
            String chaveTexto = "123";
            String mensagemOriginal = "Texto Secreto 123";

            // Criptografar a mensagem
            String mensagemCriptografada = Criptografar.criptografar(mensagemOriginal, chaveTexto);
            System.out.println("Mensagem criptografada: " + mensagemCriptografada);

            // Descriptografar a mensagem criptografada
            String mensagemDescriptografada = Descriptografar.descriptografar(mensagemCriptografada, chaveTexto);
            System.out.println("Mensagem descriptografada: " + mensagemDescriptografada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
