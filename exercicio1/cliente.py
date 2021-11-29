import xmlrpc.client
###############Servidores##################
#s1 - servidor1: soma
#s2 - servidor2: subtração
#s3 - servidor3: multiplicação
#s4 - servidor4: divisão
s1 = xmlrpc.client.ServerProxy('http://localhost:8000')
s2 = xmlrpc.client.ServerProxy('http://localhost:3000')
s3 = xmlrpc.client.ServerProxy('http://localhost:3001')
s4 = xmlrpc.client.ServerProxy('http://localhost:3002')
############################################


operacao = ""
while operacao != "0":
    print("Exercicio RPC\n")
    #Digitar os números para realizar a conta
    v1 = input("Valor1: ")
    v2 = input("Valor2: ")

    operacao_valida=False
    while operacao_valida==False:
        print("Digite o tipo de operação\n")
        print("soma(+),subtração(-),multiplicação(*),divisão(/)")
        operacao = input()

        if operacao == "+":
            operacao_valida=True
            print("Resultado da soma:{}".format(s1.Soma(v1,v2)))
        elif operacao == "-":
            operacao_valida=True
            print("Resultado da subtração:{}".format(s2.Subtracao(v1,v2)))
        elif operacao == "*":
            operacao_valida=True
            print("Resultado da multiplicação:{}".format(s3.Multiplicao(v1,v2)))
        elif operacao == "/":
            operacao_valida=True
            print("Resultado da divisão:{}".format(s4.Divisao(v1,v2)))
        else:
            print("Operação inválida! Digite a operação.")