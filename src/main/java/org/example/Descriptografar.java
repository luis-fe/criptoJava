package org.example;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Descriptografar {

    public static String descriptografar(String mensagemCriptografada, String chaveTexto) throws Exception {
        byte[] chave = derivarChave(chaveTexto, 16);

        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(chave, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] decodedBytes = Base64.getDecoder().decode(mensagemCriptografada);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    private static byte[] derivarChave(String texto, int comprimento) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] chave = sha.digest(texto.getBytes(StandardCharsets.UTF_8));
        return Arrays.copyOf(chave, comprimento);
    }
}
