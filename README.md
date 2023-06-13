# Trabalho 2 - Compiladores

João Victor Bueno de Caldas - 769657

Marcus Vinicius Soares de Oliveira - 770026

A extensão "Maven for Java" e o pacote "Extension Pack for Java" foram utilizadas na execução do compilador.

Para compilar o programa, deve-se executar no terminal, dentro do diretório "alguma-sintático", o comando **mvn package**.

Para executar o programa, basta executar o comando **java -jar C:\Compiladores\T2\trabalho-2\alguma-sintatico\target\alguma-sintatico-1.0-SNAPSHOT-jar-with-dependencies.jar [ENTRADA] [SAIDA]** sendo que [ENTRADA] é o endereço do programa a ser analisado e [SAIDA] é o endereço do arquivo no qual vai ser impressa a saída.

Por exemplo: quando o comando **java -jar C:\Compiladores\T2\trabalho-2\alguma-sintatico\target\alguma-sintatico-1.0-SNAPSHOT-jar-with-dependencies.jar C:\entrada\texto.txt C:\saida\texto.txt** é executado, o compilador analisa a sintaxe do programa escrito no arquivo "texto.txt" localizado em "C:\entrada" e imprime o resultado da análise (se encontrou um erro sintático ou não) no arquivo "texto.txt" localizado em "C:\saida".
