package org.djd.fun.taiga.dao;

import org.djd.fun.taiga.dao.util.ConnectionUtil;
import org.djd.fun.taiga.model.SomeData;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/13/12
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class WayOfDao {

  private ConnectionUtil connectionUtil;

  public WayOfDao() {
    this(new ConnectionUtil());
  }

  /**
   * TODO use Guice injection
   * @param connectionUtil
   */
  public WayOfDao(ConnectionUtil connectionUtil) {
    this.connectionUtil = connectionUtil;
  }

  public void deleteAll() throws DaoException {
    Connection connection = connectionUtil.getConnection();
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("DROP TABLE IF EXISTS logs");
      stmt.executeUpdate("CREATE TABLE logs ( id SERIAL, log TEXT)");
    } catch (SQLException e) {
      throw new DaoException(e);
    } finally {
      try {
        if (connection != null)
          connection.close();
      } catch (SQLException e) {
        throw new DaoException(e);
      }
    }
  }

  public int add(String logText) throws DaoException {
    Connection connection = connectionUtil.getConnection();
    try {
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format("INSERT INTO logs(id, log) VALUES (DEFAULT, '%s')", logText));
    } catch (SQLException e) {
      throw new DaoException(e);
    } finally {
      try {
        if (connection != null)
          connection.close();
      } catch (SQLException e) {
        throw new DaoException(e);
      }
    }
  }

  public int update(int id, SomeData someData) throws DaoException {
    Connection connection = connectionUtil.getConnection();
    try {
      Statement stmt = connection.createStatement();
      return stmt.executeUpdate(String.format("UPDATE logs SET log='%s' WHERE id=%d",
          someData.getContent(), someData.getId()));
    } catch (SQLException e) {
      throw new DaoException(e);
    } finally {
      try {
        if (connection != null)
          connection.close();
      } catch (SQLException e) {
        throw new DaoException(e);
      }
    }
  }

  public List<SomeData> getAll() throws DaoException {
    List<SomeData> result = new ArrayList<SomeData>();
    Connection connection = connectionUtil.getConnection();
    try {
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT id, log FROM logs ORDER BY id ASC");
      while (rs.next()) {
        result.add(new SomeData(rs.getInt("id"), rs.getString("log")));
      }
    } catch (SQLException e) {
      throw new DaoException(e);
    } finally {
      try {
        if (connection != null)
          connection.close();
      } catch (SQLException e) {
        throw new DaoException(e);
      }
    }
    return result;
  }
}