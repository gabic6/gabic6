from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

# Restrict to a particular path.
class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

# Create server
with SimpleXMLRPCServer(('localhost', 3002),
                        requestHandler=RequestHandler) as server:
    server.register_introspection_functions()

    def Divisao(x,y):
        if y !="0":
            return float(x)/float(y)
        else:
            return "Erro. Divisão por 0!"
    server.register_function(Divisao,'Divisao')

    # Run the server's main loop
    server.serve_forever()