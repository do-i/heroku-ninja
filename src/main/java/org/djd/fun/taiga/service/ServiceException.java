package org.djd.fun.taiga.service;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/15/12
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class ServiceException extends Exception {
  public ServiceException() {
    super();    //To change body of overridden methods use File | Settings | File Templates.
  }

  public ServiceException(String message) {
    super(message);    //To change body of overridden methods use File | Settings | File Templates.
  }

  public ServiceException(String message, Throwable cause) {
    super(message, cause);    //To change body of overridden methods use File | Settings | File Templates.
  }

  public ServiceException(Throwable cause) {
    super(cause);    //To change body of overridden methods use File | Settings | File Templates.
  }
}
