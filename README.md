# Escrevendo um Linter em Java (POC)

Essa é uma POC de como escrever um simples linter em Java, usando a ferramenta de análise estática [spoon](https://github.com/INRIA/spoon).

- Encontrar métodos públicos que não estão documentados. Código [aqui](https://github.com/gustavopintozup/poc-java-linter/blob/main/src/main/java/br/com/stackedu/linter/PublicMethodsWithoutDocsProcessor.java);
- Encontrar blocos `catch` que estão vazios. Código [aqui](https://github.com/gustavopintozup/poc-java-linter/blob/main/src/main/java/br/com/stackedu/linter/TryWithEmptyCatchProcessor.java);


## License

This software is licensed under the MIT License.