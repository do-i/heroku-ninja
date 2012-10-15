package org.djd.fun.taiga;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * This class launches the web application in an embedded Jetty container.
 * This is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 */
public class Main {

  private static final String DEFAULT_PORT = "8080";
  private static final String CONTEXT_PATH = "/";
  private static final String WEBAPP_DIR_LOCATION = "src/main/webapp/";
  private static final String WEB_INF_WEB_XML = WEBAPP_DIR_LOCATION + "WEB-INF/web.xml";

  public static void main(String[] args) throws Exception {
    Server server = server();
    server.setHandler(webAppContext());
    server.start();
    server.join();
  }

  private static Server server() {
    String port = System.getenv("PORT");
    if (port == null || port.isEmpty()) {
      port = DEFAULT_PORT;
    }
    return new Server(Integer.valueOf(port));
  }

  private static WebAppContext webAppContext() {
    WebAppContext root = new WebAppContext();
    root.setContextPath(CONTEXT_PATH);
    root.setResourceBase(WEBAPP_DIR_LOCATION);
    root.setDescriptor(WEB_INF_WEB_XML);
    root.setParentLoaderPriority(true);
    return root;
  }
}

