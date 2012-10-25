package org.djd.fun.taiga.dao.postgre;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/25/12
 * Time: 12:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataMakerUtil {
  public static void main(String[] args) throws Exception {
    Connection jdbcConnection = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/linuxdb", "linuxpoison", "password");
    IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
    FlatXmlDataSet.write(connection.createDataSet(), new FileOutputStream("full.xml"));
  }
}