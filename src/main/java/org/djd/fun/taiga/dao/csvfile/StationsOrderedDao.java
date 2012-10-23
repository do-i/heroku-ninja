package org.djd.fun.taiga.dao.csvfile;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.google.common.io.Resources;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.djd.fun.taiga.model.StationsOrderedModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/20/12
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class StationsOrderedDao extends AbstractFileDao {

  private static final String DEFAULT_CSV_FILE_PATH = "input/stations_sequence.csv";
  private static final String[] columns =
      {"color", "destination", "sequence", "stopId", "stopName"};

  public StationsOrderedDao() {
    this(DEFAULT_CSV_FILE_PATH);
  }

  public StationsOrderedDao(String csvFileNamePath) {
    super(csvFileNamePath);
  }

  public List<StationsOrderedModel> loadFile() throws DaoException {
    ColumnPositionMappingStrategy<StationsOrderedModel> mappingStrategy =
        new ColumnPositionMappingStrategy<StationsOrderedModel>();
    mappingStrategy.setType(StationsOrderedModel.class);
    mappingStrategy.setColumnMapping(columns);
    try {
      return new CsvToBean().parse(mappingStrategy, reader());
    } catch (IOException e) {
      throw new DaoException(e);
    }
  }
}