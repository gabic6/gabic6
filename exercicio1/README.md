# Exercicio RPC

## Implemente uma calculadora básica (4 operações) usando RPC, em qualquer linguagem de programação. Cada operação básica deve estar em uma aplicação diferente, ou seja, cada operação deve chamar um procedimento remoto, implementado em uma aplicação separada. Descreva os problemas que podem ser enfrentados por essa abordagem de RPC para a programação de sistemas distribuídos.
---
**Desafios:**

- Stub do cliente pode ter uma arquitetura diferente do stub do servidor;
  - Pode ocorrer problema com a ordenação de bytes;
  - As duas arquiteturas podem representar de forma diferente os caracteres;
    - tipos distintos de representar o conjunto de dados;
- A passagem de ponteiros do servidor para o cliente, por exemplo, pode sofrer problemas, uma vez que o espaço de endereçamento é diferente;
  - pois o mesmo espaço onde está sendo requerido não é o mesmo onde é enviado;

---
**Desafios (Thiago):**
- Diferença de arquiteturas
  - Espaço de endereçamento de ponteiros;
- Passagem de parâmetros por valor
  - Diferentes tipos de codificação de caracteres;
  - Tipo dos dados do parâmetro.
- Passagem de parâmetros por referência
  - Ponteiros só fazem sentido no espaço de endereçamento local;
  - Uma solução é copiar todos os dados apontados e enviar para o servidor.

As diferenças de arquitetura podem gerar um trabalho a mais nos stubs para conversão dos dados para garantir a compatibilidade das chamadas. Também pode ser que todos os computadores de uma rede fiquem limitados pelo que tem a pior arquitetura.

Passar parâmetros também pode gerar problemas. Se o parâmetro for do tipo String a codificação de caracteres de um sistema operacional pode ser diferente do outro. Também há problemas de identificação do tipo de dado recebido, sendo uma solução mandar um parâmetro adicional indicado o tipo desse parâmetro. 

Na passagem por referência o problema é devido a que os ponteiros só fazem sentido no espaço de endereçamento local, e que uma solução, que os dados apontados por eles devem ser copiados inteiramente, pode não ser muito prática. Se um ponteiro aponta para um vetor de 1 milhão de posições, enviar todo o vetor pode ser muito custoso.


<!-- Exemplo de um servidor
```python
from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

# Restrict to a particular path.
class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

# Create server
with SimpleXMLRPCServer(('localhost', 8000),
                        requestHandler=RequestHandler) as server:
    server.register_introspection_functions()

    # Register a function under a different name
    def Soma(x, y):
        return float(x) + float(y)
    server.register_function(Soma, 'Soma')


    # Run the server's main loop
    server.serve_forever()
``` -->