package org.djd.fun.taiga.dao.postgre;

import com.google.common.collect.Lists;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.dao.util.ConnectionUtil;
import org.djd.fun.taiga.model.CtaStopsModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostgreCtaStopsDao {
  private static final String CREATE_TABLE_SQL =
      "CREATE TABLE CTA_L_STOPS (STOP_ID INTEGER PRIMARY KEY, DIRECTION_ID TEXT, " +
          "STOP_NAME TEXT, LON REAL, LAT REAL, STATION_NAME TEXT, STATIONDESC_NAME TEXT, " +
          "PARENTSTOP_ID INTEGER, ADA INTEGER, RED INTEGER, BLUE INTEGER, BRN INTEGER, " +
          "GREEN INTEGER, PURPLE INTEGER, PURPLE_EXP INTEGER, YELLOW INTEGER, PINK INTEGER," +
          "ORANGE INTEGER)";

  private static final String INSERT_SQL =
      "INSERT INTO CTA_L_STOPS (STOP_ID,DIRECTION_ID,STOP_NAME,LON,LAT,STATION_NAME," +
          "STATIONDESC_NAME,PARENTSTOP_ID,ADA,RED,BLUE,BRN,GREEN,PURPLE,PURPLE_EXP,YELLOW," +
          "PINK,ORANGE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

  private static final String SELECT_SQL = "SELECT STOP_ID,DIRECTION_ID,STOP_NAME,LON,LAT," +
      "STATION_NAME,STATIONDESC_NAME,PARENTSTOP_ID,ADA,RED,BLUE,BRN,GREEN,PURPLE,PURPLE_EXP," +
      "YELLOW,PINK,ORANGE FROM CTA_L_STOPS";

  private static final String SELECT_PARENTSTOP_ID_BY_STOP_ID =
      "SELECT PARENTSTOP_ID FROM CTA_L_STOPS WHERE STOP_ID=";


  private ConnectionUtil connectionUtil;

  public PostgreCtaStopsDao() {
    this(new ConnectionUtil());
  }

  public PostgreCtaStopsDao(ConnectionUtil connectionUtil) {
    this.connectionUtil = connectionUtil;
  }

  public void createTable() throws DaoException {
    Connection connection = connectionUtil.getConnection();
    try {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("DROP TABLE IF EXISTS CTA_L_STOPS");
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

  public void insertAll(List<CtaStopsModel> ctaStopsModels) throws DaoException {
    Connection connection = connectionUtil.getConnection();
    try {
      PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
      for (CtaStopsModel model : ctaStopsModels) {
        statement.setInt(1, model.getStopId());
        statement.setString(2, model.getDirectionId());
        statement.setString(3, model.getStopName());
        statement.setFloat(4, model.getLon());
        statement.setFloat(5, model.getLat());
        statement.setString(6, model.getStationName());
        statement.setString(7, model.getStationDescName());
        statement.setInt(8, model.getParentStopId());
        statement.setInt(9, model.getAda());
        statement.setInt(10, model.getRed());
        statement.setInt(11, model.getBlue());
        statement.setInt(12, model.getBrn());
        statement.setInt(13, model.getGreen());
        statement.setInt(14, model.getPurple());
        statement.setInt(15, model.getPurpleExp());
        statement.setInt(16, model.getYellow());
        statement.setInt(17, model.getPink());
        statement.setInt(18, model.getOrange());
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

  public List<CtaStopsModel> selectAll() throws DaoException {
    Connection connection = connectionUtil.getConnection();
    List<CtaStopsModel> ctaStopsModels = Lists.newArrayList();
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(SELECT_SQL);
      while (resultSet.next()) {
        CtaStopsModel ctaStopsModel = new CtaStopsModel();
        ctaStopsModel.setStopId(resultSet.getInt("STOP_ID"));
        ctaStopsModel.setDirectionId(resultSet.getString("DIRECTION_ID"));
        ctaStopsModel.setStopName(resultSet.getString("STOP_NAME"));
        ctaStopsModel.setLon(resultSet.getFloat("LON"));
        ctaStopsModel.setLat(resultSet.getFloat("LAT"));
        ctaStopsModel.setStationName(resultSet.getString("STATION_NAME"));
        ctaStopsModel.setStationDescName(resultSet.getString("STATIONDESC_NAME"));
        ctaStopsModel.setParentStopId(resultSet.getInt("PARENTSTOP_ID"));
        ctaStopsModel.setAda(resultSet.getInt("ADA"));
        ctaStopsModel.setRed(resultSet.getInt("RED"));
        ctaStopsModel.setBlue(resultSet.getInt("BLUE"));
        ctaStopsModel.setBrn(resultSet.getInt("BRN"));
        ctaStopsModel.setGreen(resultSet.getInt("GREEN"));
        ctaStopsModel.setPurple(resultSet.getInt("PURPLE"));
        ctaStopsModel.setPurpleExp(resultSet.getInt("PURPLE_EXP"));
        ctaStopsModel.setYellow(resultSet.getInt("YELLOW"));
        ctaStopsModel.setPink(resultSet.getInt("PINK"));
        ctaStopsModel.setOrange(resultSet.getInt("ORANGE"));
        ctaStopsModels.add(ctaStopsModel);
      }
      return ctaStopsModels;
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

  public int selectParentStopIdByStopId(int stopId) throws DaoException {
    Connection connection = connectionUtil.getConnection();
    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(SELECT_PARENTSTOP_ID_BY_STOP_ID + stopId);
      if (resultSet.next()) {
        return resultSet.getInt("PARENTSTOP_ID");
      }
      throw new DaoException("Invalid stopId " + stopId);
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
}
