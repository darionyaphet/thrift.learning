package org.darion.yaphet.thrift;

import org.apache.log4j.Logger;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.darion.yaphet.gen.EchoService;

public class SimpleServer {

	private static final Logger LOG = Logger.getLogger(SimpleServer.class);

	public static void main(String[] args) throws TTransportException {

		TServerSocket serverSocket = new TServerSocket(8989);
		EchoService.Processor<EchoService.Iface> processor = new EchoService.Processor<EchoService.Iface>(
				new Processor());
		Args arg = new Args(serverSocket);
		TProtocolFactory inputProtocol = new TBinaryProtocol.Factory(true, true);
		TProtocolFactory outputProtocol = new TBinaryProtocol.Factory(true, true);
		arg.inputProtocolFactory(inputProtocol);
		arg.outputProtocolFactory(outputProtocol);

		TServer server = new TSimpleServer(arg);
		server.serve();
	}
}
