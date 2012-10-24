package org.djd.fun.taiga.dao.postgre;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.dao.util.ConnectionUtil;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.djd.fun.taiga.model.StationsOrderedModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostgreStationsDao {

  private String color;
  private String destination;
  private int sequence;
  private int stopId;
  private String stopName;

  private static final Set<String> colors = ImmutableSet.of("Pink", "Blue", "Yellow", "Red",
      "Green", "Brown", "Orange", "Purple", "PurpleExp");

  private static final String CREATE_TABLE_SQL =
      "CREATE TABLE CTA_STATIONS (COLOR TEXT, DESTINATION TEXT, " +
          "SEQUENCE INTEGER, STOP_ID INTEGER, STOP_NAME TEXT)";

  private static final String INSERT_SQL =
      "INSERT INTO CTA_STATIONS (COLOR, DESTINATION, SEQUENCE, STOP_ID, STOP_NAME) " +
          "VALUES (?,?,?,?,?)";

  private static final String SELECT_SQL =
      "SELECT COLOR, DESTINATION, SEQUENCE, STOP_ID, STOP_NAME FROM CTA_STATIONS";

  private static final String SELECT_BY_COLOR_SQL =
      "SELECT COLOR, DESTINATION, SEQUENCE, STOP_ID, STOP_NAME FROM CTA_STATIONS WHERE COLOR='%s'";

  private static final String SELECT_BY_COLOR_DESTINATION_SQL =
      "SELECT COLOR, DESTINATION, SEQUENCE, STOP_ID, STOP_NAME FROM CTA_STATIONS " +
          "WHERE COLOR='%s' AND DESTINATION='%s'";

  private ConnectionUtil connectionUtil;

  public PostgreStationsDao() {
    this(new ConnectionUtil());
  }

  public PostgreStationsDao(ConnectionUtil connectionUtil) {
    this.connectionUtil = connectionUtil;
  }

  public void createTable() throws DaoException {
    Connection connection = connectionUtil.getConnection();
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("DROP TABLE IF EXISTS CTA_STATIONS");
      stmt.executeUpdate(CREATE_TABLE_SQL);
    } catch (SQLException e) {
      throw new DaoException(e);
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        throw new DaoException(e);
      }
    }
  }

  public void insertAll(List<StationsOrderedModel> stationsOrderedModels) throws DaoException {
    Connection connection = connectionUtil.getConnection();
    try {
      PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
      for (StationsOrderedModel model : stationsOrderedModels) {
        statement.setString(1, model.getColor());
        statement.setString(2, model.getDestination());
        statement.setInt(3, model.getSequence());
        statement.setInt(4, model.getStopId());
        statement.setString(5, model.getStopName());
        statement.executeUpdate();
      }
    } catch (SQLException e) {
      throw new DaoException(e);
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        throw new DaoException(e);
      }
    }
  }

  public List<StationsOrderedModel> selectAll() throws DaoException {
    Connection connection = connectionUtil.getConnection();
    List<StationsOrderedModel> stationsOrderedModels = Lists.newArrayList();
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(SELECT_SQL);
      while (resultSet.next()) {
        StationsOrderedModel stationsOrderedModel = new StationsOrderedModel();
        stationsOrderedModel.setColor(resultSet.getString("COLOR"));
        stationsOrderedModel.setDestination(resultSet.getString("DESTINATION"));
        stationsOrderedModel.setSequence(resultSet.getInt("SEQUENCE"));
        stationsOrderedModel.setStopId(resultSet.getInt("STOP_ID"));
        stationsOrderedModel.setStopName(resultSet.getString("STOP_NAME"));
        stationsOrderedModels.add(stationsOrderedModel);
      }
      return stationsOrderedModels;
    } catch (SQLException e) {
      throw new DaoException(e);
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        throw new DaoException(e);
      }
    }
  }

  public List<StationsOrderedModel> selectByColor(String color) throws DaoException {
    validate(color);
    Connection connection = connectionUtil.getConnection();
    List<StationsOrderedModel> stationsOrderedModels = Lists.newArrayList();
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(String.format(SELECT_BY_COLOR_SQL, color));
      while (resultSet.next()) {
        StationsOrderedModel stationsOrderedModel = new StationsOrderedModel();
        stationsOrderedModel.setColor(resultSet.getString("COLOR"));
        stationsOrderedModel.setDestination(resultSet.getString("DESTINATION"));
        stationsOrderedModel.setSequence(resultSet.getInt("SEQUENCE"));
        stationsOrderedModel.setStopId(resultSet.getInt("STOP_ID"));
        stationsOrderedModel.setStopName(resultSet.getString("STOP_NAME"));
        stationsOrderedModels.add(stationsOrderedModel);
      }
      return stationsOrderedModels;
    } catch (SQLException e) {
      throw new DaoException(e);
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        throw new DaoException(e);
      }
    }
  }

  public List<StationsOrderedModel> selectByColorAndDestination(String color, String destination)
      throws DaoException {
    validate(color);
    Connection connection = connectionUtil.getConnection();
    List<StationsOrderedModel> stationsOrderedModels = Lists.newArrayList();
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(
          String.format(SELECT_BY_COLOR_DESTINATION_SQL, color, destination));
      while (resultSet.next()) {
        StationsOrderedModel stationsOrderedModel = new StationsOrderedModel();
        stationsOrderedModel.setColor(resultSet.getString("COLOR"));
        stationsOrderedModel.setDestination(resultSet.getString("DESTINATION"));
        stationsOrderedModel.setSequence(resultSet.getInt("SEQUENCE"));
        stationsOrderedModel.setStopId(resultSet.getInt("STOP_ID"));
        stationsOrderedModel.setStopName(resultSet.getString("STOP_NAME"));
        stationsOrderedModels.add(stationsOrderedModel);
      }
      return stationsOrderedModels;
    } catch (SQLException e) {
      throw new DaoException(e);
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        throw new DaoException(e);
      }
    }
  }

  private void validate(String color) throws DaoException{
    if (!colors.contains(color)) {
      throw new DaoException(color + " is undefined.");
    }
  }
}