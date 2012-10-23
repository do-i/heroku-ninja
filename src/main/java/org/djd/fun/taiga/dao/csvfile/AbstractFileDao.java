package org.djd.fun.taiga.dao.csvfile;

import com.google.common.io.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/21/12
 * Time: 12:08 AM
 * To change this template use File | Settings | File Templates.
 */
abstract public class AbstractFileDao {

  private String csvFileNamePath;

  protected AbstractFileDao(String csvFileNamePath) {
    this.csvFileNamePath = csvFileNamePath;
  }

  protected Reader reader() throws IOException {
    URL url = Resources.getResource(csvFileNamePath);
    BufferedReader reader = new BufferedReader(
        Resources.newReaderSupplier(url, Charset.forName("UTF-8")).getInput());
    reader.readLine(); // skip header line.
    return reader;
  }
}