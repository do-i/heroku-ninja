package org.djd.fun.taiga.dao.csvfile;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.model.CtaStopsModel;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class CtaLStopsDao extends AbstractFileDao {

  private static final String DEFAULT_CSV_FILE_PATH = "input/cta_L_stops.csv";
  private static final String[] columns = {
      "stopId", "directionId", "stopName", "lon", "lat", "stationName", "stationDescName",
      "parentStopId", "ada", "red", "blue", "brn", "green", "purple", "purpleExp", "yellow", "pink",
      "orange"};

  public CtaLStopsDao() {
    this(DEFAULT_CSV_FILE_PATH);
  }

  public CtaLStopsDao(String csvFileNamePath) {
    super(csvFileNamePath);
  }

  public List<CtaStopsModel> loadFile() throws DaoException {
    ColumnPositionMappingStrategy<CtaStopsModel> mappingStrategy = new ColumnPositionMappingStrategy<CtaStopsModel>();
    mappingStrategy.setType(CtaStopsModel.class);
    mappingStrategy.setColumnMapping(columns);
    try {
      return new CsvToBean().parse(mappingStrategy, reader());
    } catch (IOException e) {
      throw new DaoException(e);
    }
  }
}