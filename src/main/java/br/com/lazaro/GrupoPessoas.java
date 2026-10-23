package br.com.lazaro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrupoPessoas {
    public static List<Pessoa> lerPessoas(String entrada) {
        List<Pessoa> pessoas = new ArrayList<>();
        if (entrada.isBlank()) {
            return pessoas;
        }

        for (String cadastro : entrada.split(",", -1)) {
            String[] dados = cadastro.trim().split("-", -1);
            if (dados.length != 2 || dados[0].trim().isEmpty()) {
                throw new IllegalArgumentException("Use o formato Nome-F ou Nome-M.");
            }
            String nome = dados[0].trim();
            String sexo = dados[1].trim();
            if (sexo.equalsIgnoreCase("F") || sexo.equalsIgnoreCase("Feminino")) {
                sexo = "F";
            } else if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("Masculino")) {
                sexo = "M";
            } else {
                throw new IllegalArgumentException("Sexo inválido: " + sexo);
            }
            pessoas.add(new Pessoa(nome, sexo));
        }
        return pessoas;
    }

    public static List<Pessoa> filtrarMulheres(List<Pessoa> pessoas) {
        return pessoas.stream()
                .filter(pessoa -> "F".equalsIgnoreCase(pessoa.getSexo()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite as pessoas separadas por vírgula:");
            System.out.println("Exemplo: Lazaro-M, Ana-F, Gabriel-M, Maria-F");
            try {
                List<Pessoa> mulheres = filtrarMulheres(lerPessoas(scanner.nextLine()));
                if (mulheres.isEmpty()) {
                    System.out.println("Nenhuma mulher encontrada.");
                } else {
                    System.out.println("Mulheres do grupo:");
                    mulheres.forEach(pessoa -> System.out.println(pessoa.getNome()));
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
