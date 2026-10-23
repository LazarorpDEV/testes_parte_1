package br.com.lazaro;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class GrupoPessoasTest {
    @Test
    void deveRetornarSomenteMulheres() {
        List<Pessoa> pessoas = GrupoPessoas.lerPessoas(
                "Lazaro-M, Ana-F, Gabriel-M, Maria-F");

        // O teste chama o mesmo filtro usado pelo programa no console.
        List<Pessoa> mulheres = GrupoPessoas.filtrarMulheres(pessoas);

        assertFalse(mulheres.isEmpty(), "O filtro deve manter as mulheres do grupo.");
        assertTrue(mulheres.stream().allMatch(pessoa -> "F".equals(pessoa.getSexo())),
                "A lista deve conter somente pessoas cadastradas com sexo feminino.");
        assertEquals(List.of("Ana", "Maria"), mulheres.stream()
                .map(Pessoa::getNome).collect(Collectors.toList()));
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaMulheres() {
        List<Pessoa> pessoas = GrupoPessoas.lerPessoas("Lazaro-M, Gabriel-M");
        assertTrue(GrupoPessoas.filtrarMulheres(pessoas).isEmpty());
    }

    @Test
    void deveAceitarSexoPorExtensoEMinusculo() {
        List<Pessoa> pessoas = GrupoPessoas.lerPessoas(
                "Ana-feminino, Gabriel-masculino, Maria-f");
        List<Pessoa> mulheres = GrupoPessoas.filtrarMulheres(pessoas);
        assertEquals(List.of("Ana", "Maria"), mulheres.stream()
                .map(Pessoa::getNome).collect(Collectors.toList()));
    }
}
