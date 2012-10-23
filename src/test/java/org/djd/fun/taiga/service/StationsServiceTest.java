package org.djd.fun.taiga.service;

import org.djd.fun.taiga.dao.csvfile.CtaLStopsDao;
import org.djd.fun.taiga.dao.csvfile.StationsOrderedDao;
import org.djd.fun.taiga.dao.postgre.PostgreCtaStopsDao;
import org.djd.fun.taiga.dao.postgre.PostgreStationsDao;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.djd.fun.taiga.model.StationsOrderedModel;
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
  @Test
  public void seed_noArg_success() throws ServiceException {
    StationsService stationsService = new StationsService(
        new StationsOrderedDao("sample/small_stations_sequence.csv"), new PostgreStationsDao());
    stationsService.seed();
    List<StationsOrderedModel> stationsOrderedModels = stationsService.fetch();
    assertEquals(26, stationsOrderedModels.size());
  }
}
