package org.djd.fun.taiga.dao.postgre;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.BeforeClass;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/25/12
 * Time: 11:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractDbUnit {
  protected static IDatabaseConnection databaseConnection;
  protected static FlatXmlDataFileLoader loader;

  @BeforeClass
  public static void setUpBeforeClass() throws SQLException, DatabaseUnitException {
    databaseConnection = new DatabaseConnection(DriverManager.
        getConnection("jdbc:postgresql://localhost:5432/linuxdb", "linuxpoison", "password"));
    loader = new FlatXmlDataFileLoader();
  }
}