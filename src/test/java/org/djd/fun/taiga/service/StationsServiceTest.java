package org.djd.fun.taiga.service;

import org.djd.fun.taiga.dao.csvfile.CtaLStopsDao;
import org.djd.fun.taiga.dao.csvfile.StationsOrderedDao;
import org.djd.fun.taiga.dao.postgre.PostgreCtaStopsDao;
import org.djd.fun.taiga.dao.postgre.PostgreStationsDao;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.djd.fun.taiga.model.StationsOrderedModel;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/15/12
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class StationsServiceTest {

  private StationsService stationsService;

  @Before
  public void init() throws ServiceException {
    stationsService = new StationsService(
        new StationsOrderedDao("sample/small_stations_sequence.csv"), new PostgreStationsDao());
    stationsService.seed();
  }

  @Test
  public void fetch_noArg_success() throws ServiceException {
    List<StationsOrderedModel> stationsOrderedModels = stationsService.fetch();
    assertEquals(26, stationsOrderedModels.size());
  }

  @Test
  public void fetchByColor_Blue_10() throws ServiceException {
    List<StationsOrderedModel> stationsOrderedModels = stationsService.fetchByColor("Blue");
    assertEquals(10, stationsOrderedModels.size());
    for (StationsOrderedModel model : stationsOrderedModels) {
      assertEquals("Blue", model.getColor());
    }
  }
}