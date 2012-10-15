package org.djd.fun.taiga.dao.util;

import org.djd.fun.taiga.dao.DaoException;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionUtil {

  public static final String DEFAULT_URL = "postgres://linuxpoison:password@localhost:5432/linuxdb";
  public static final String DATABASE_URL = "HEROKU_POSTGRESQL_ROSE_URL";

  public Connection getConnection() throws DaoException {
    try {
      URI dbUri = uri();
      String username = dbUri.getUserInfo().split(":")[0];
      String password = dbUri.getUserInfo().split(":")[1];
      String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

      return DriverManager.getConnection(dbUrl, username, password);
    } catch (SQLException e) {
      throw new DaoException(e);
    }
  }

  private URI uri() throws DaoException {
    String path = System.getenv(DATABASE_URL);
    if (path == null) {
      path = System.getProperty(DATABASE_URL);
      if (path == null) {
        path = DEFAULT_URL;
      }
    }
    try {
      return new URI(path);
    } catch (URISyntaxException e) {
      throw new DaoException(e);
    }
  }
}
