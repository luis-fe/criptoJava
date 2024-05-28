package org.example;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Criptografar {

    public static String criptografar(String mensagem, String chaveTexto) throws Exception {
        byte[] chave = derivarChave(chaveTexto, 16);

        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(chave, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encryptedBytes = cipher.doFinal(mensagem.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static byte[] derivarChave(String texto, int comprimento) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] chave = sha.digest(texto.getBytes(StandardCharsets.UTF_8));
        return Arrays.copyOf(chave, comprimento);
    }
}
