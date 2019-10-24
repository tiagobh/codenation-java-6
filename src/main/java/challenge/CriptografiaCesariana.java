package challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CriptografiaCesariana implements Criptografia {
    private static final List<Character> ALFABETO = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    private static final int FATOR = 3;

    @Override
    public String criptografar(String texto) {
        validarTexto(texto);
        StringBuilder strRetorno = new StringBuilder();
        for (Character c : getTextoMinusculo(texto).toCharArray()) {
            strRetorno.append(getLetraCriptografada(c));
        }
        return strRetorno.toString();
    }

    @Override
    public String descriptografar(String texto) {
        validarTexto(texto);

        StringBuilder strRetorno = new StringBuilder();
        for (Character c : getTextoMinusculo(texto).toCharArray()) {
            strRetorno.append(getLetraDecriptografada(c));
        }
        return strRetorno.toString();
    }

    private String getTextoMinusculo(String texto){
        return texto.toLowerCase();
    }

    private void validarTexto(String texto){
        if(Objects.isNull(texto)){
            throw new NullPointerException();
        }

        if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private  Character getLetraDecriptografada(Character letra) {
        int posicaoAtual = ALFABETO.indexOf(letra);
        if (posicaoAtual < 0) {
            return letra;
        }
        posicaoAtual -= FATOR;
        if ((posicaoAtual) < 0) {
            posicaoAtual = Math.abs(posicaoAtual);
        }
        return ALFABETO.get(posicaoAtual);
    }

    private  Character getLetraCriptografada(Character letra) {
        int posicaoAtual = ALFABETO.indexOf(letra);
        if (ALFABETO.indexOf(letra) < 0) {
            return letra;
        }
        posicaoAtual += FATOR;
        if (posicaoAtual > ALFABETO.size() - 1) {
            posicaoAtual = posicaoAtual - (ALFABETO.size());
        }
        return ALFABETO.get(posicaoAtual);
    }

}