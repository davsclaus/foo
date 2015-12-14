package org.foo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

/**
 * Configures all our Camel routes, components, endpoints and beans
 */
@ContextName("myCdiCamelContext")
public class MyRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
        from("timer:foo")
            .to("seda:b")
            .to("log:c");
	}

}
