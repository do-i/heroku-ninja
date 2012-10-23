package org.djd.fun.taiga.dao.csvfile;

import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.djd.fun.taiga.model.StationsOrderedModel;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class StationsOrderedDaoTest {

  @Test
  public void loadFile_noArgs_success() throws IOException, DaoException {
    List<StationsOrderedModel> stations = new StationsOrderedDao("sample/small_stations_sequence.csv").loadFile();
    assertNotNull(stations);
    assertEquals(26, stations.size());
    System.out.print(stations);
  }
}