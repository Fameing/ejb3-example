package com.mydomain;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**Glashfish4 standalone client
 * 
 * @author 
 *
 */

public class GlassfishStandaloneClient {
	private InitialContext ic = null;

	InitialContext ctx;
	{
		try {
			Properties props = new Properties();

			props.setProperty("java.naming.factory.initial",
					"com.sun.enterprise.naming.SerialInitContextFactory");

			props.setProperty("java.naming.factory.url.pkgs",
					"com.sun.enterprise.naming");

			props.setProperty("java.naming.factory.state",
					"com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

			ctx = new InitialContext(props);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		GlassfishStandaloneClient sc = new GlassfishStandaloneClient();
		sc.run();
	}

	private void run() {
		try {
			HelloSessionBeanRemote h = (HelloSessionBeanRemote) ctx
					.lookup("ejb/HelloSessionBean");
			System.out.println(h.getTime());
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
}
