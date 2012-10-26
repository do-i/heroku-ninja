package org.djd.fun.taiga.dao.postgre;

import com.google.common.io.Resources;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.dao.postgre.PostgreStationsDao;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/25/12
 * Time: 12:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class SampleDbUnitTest extends AbstractDbUnit {

  private static PostgreStationsDao dao;

  @BeforeClass
  public static void init() {
    dao = new PostgreStationsDao();
  }
  @Test
  public void selectAll() throws DaoException, SQLException, DatabaseUnitException {
    DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, loader.load("/db/full.xml"));
    assertEquals(26, dao.selectAll().size());
  }

  @Test
  public void cleanAll() throws DaoException, SQLException, DatabaseUnitException {
    DatabaseOperation.TRUNCATE_TABLE.execute(databaseConnection, loader.load("/db/full.xml"));
    assertEquals(0, dao.selectAll().size());
  }
}