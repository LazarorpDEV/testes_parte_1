# Testes parte 1 — JUnit

Atividade EBAC: filtrar as mulheres de uma lista e testar o resultado com JUnit 5.
Esta é uma versão completa de referência; o código original da tarefa de strings não estava disponível para adaptação direta.

## Requisitos e execução

Instale JDK 17 ou superior e Apache Maven. Abra esta pasta no VS Code.
Na primeira execução, o Maven precisa de internet para baixar as dependências.

Execute os testes na pasta que contém o pom.xml:

```powershell
mvn test
```

O resultado esperado é: `Tests run: 3, Failures: 0, Errors: 0`.

Para executar o programa:

```powershell
mvn compile
java -cp target/classes br.com.lazaro.GrupoPessoas
```

Quando o programa pedir os dados, digite:

```text
Lazaro-M, Ana-F, Gabriel-M, Maria-F
```

Ele deve imprimir Ana e Maria. Também aceita Feminino/Masculino, letras minúsculas e espaços ao redor dos valores.

## O que o teste verifica

O teste principal usa uma entrada mista, chama o filtro real e verifica se a lista não está vazia, se todas as pessoas têm sexo F e se os nomes retornados são exatamente Ana e Maria. Os outros dois testes cobrem um grupo sem mulheres e a entrada com sexo por extenso/minúsculo.

A validação usa o sexo informado no cadastro; não tenta deduzir o gênero pelo nome.

## Publicar no GitHub

Se usar um repositório de atividades já existente, copie esta pasta `testes_parte_1` para dentro dele. No terminal, na raiz desse repositório:

```powershell
git add testes_parte_1
git commit -m "Adiciona testes JUnit para o filtro de mulheres"
git push
```

Se preferir um repositório novo, crie no GitHub um repositório vazio chamado `testes_parte_1`, sem README ou outros arquivos. Dentro da pasta local `testes_parte_1`, execute:

```powershell
git init
git add .
git commit -m "Adiciona testes JUnit para o filtro de mulheres"
git branch -M main
git remote add origin https://github.com/LazarorpDEV/testes_parte_1.git
git push -u origin main
```

Depois do push, envie o link do repositório na plataforma EBAC.
