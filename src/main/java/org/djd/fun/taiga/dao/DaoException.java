package org.djd.fun.taiga.dao;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/13/12
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class DaoException extends Exception {
  public DaoException() {
    super();    //To change body of overridden methods use File | Settings | File Templates.
  }

  public DaoException(String message) {
    super(message);    //To change body of overridden methods use File | Settings | File Templates.
  }

  public DaoException(String message, Throwable cause) {
    super(message, cause);    //To change body of overridden methods use File | Settings | File Templates.
  }

  public DaoException(Throwable cause) {
    super(cause);    //To change body of overridden methods use File | Settings | File Templates.
  }

  protected DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);    //To change body of overridden methods use File | Settings | File Templates.
  }
}
