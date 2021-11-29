from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

# Restrict to a particular path.
class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

# Create server
with SimpleXMLRPCServer(('localhost', 3000),
                        requestHandler=RequestHandler) as server:
    server.register_introspection_functions()

    # server.register_instance(MyFuncs())
    def Subtracao(x,y):
        return float(x) - float(y)
    server.register_function(Subtracao,'Subtracao')

    # Run the server's main loop
    server.serve_forever()