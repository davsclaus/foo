package org.foo;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.cdi.Uri;

/**
 * Configures all our Camel routes, components, endpoints and beans
 */
@ContextName("myCdiCamelContext")
public class MyRoutes extends RouteBuilder {

	@Inject
	@Uri("timer:foo?period=4999")
	private Endpoint inputEndpoint;

	@Inject
	@Uri("log:output")
	private Endpoint resultEndpoint;

	@Inject
	@Uri("file:?readLock=none")
	private Endpoint tttt;

	@Override
	public void configure() throws Exception {
		from(inputEndpoint).to("bean:counterBean").to(
				"file:outbox?fileExist=Fail");
	}

}
