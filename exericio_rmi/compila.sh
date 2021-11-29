#!/bin/bash

# Compila os arquivos da adicao
javac AdicaoInterface.java
javac AdicaoImple.java
javac AdicaoServer.java

# Compila os arquivos da subtracao
javac SubtracaoInterface.java
javac SubtracaoImple.java
javac SubtracaoServer.java

# Compila o cliente
javac Cliente.java

# Executa alguma operacao no rmi pra cada implementação
rmic AdicaoImple
rmic SubtracaoImple

# # Em terminais separados
# java AdicaoServer
# java SubtracaoServer
# java Cliente