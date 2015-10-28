package org.darion.yaphet.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.darion.yaphet.gen.EchoService;
import org.darion.yaphet.gen.Message;

public class Client {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 8989;

	public static void main(String[] args) throws TTransportException {
		TTransport transport = new TSocket(HOST, PORT);
		TProtocol protocol = new TBinaryProtocol(transport);
		EchoService.Client client = new EchoService.Client(protocol);

		transport.open();
		try {
			System.out.println(client.echo(new Message("darion", "yaphet", 25)));
		} catch (TException e) {
			System.out.println(e.getMessage());
		}
		transport.close();
	}
}
