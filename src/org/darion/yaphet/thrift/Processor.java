package org.darion.yaphet.thrift;

import org.apache.thrift.TException;
import org.darion.yaphet.gen.EchoService;
import org.darion.yaphet.gen.Message;

public class Processor implements EchoService.Iface {

	@Override
	public String echo(Message message) throws TException {
		String firstName = message.getFirst_name();
		String lastName = message.getLast_name();
		int age = message.getAge();
		return "Hi ," + firstName + "." + lastName + " you are " + age;
	}

}
