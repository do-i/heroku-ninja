package org.djd.fun.taiga.service;

import org.djd.fun.taiga.dao.csvfile.CtaLStopsDao;
import org.djd.fun.taiga.dao.postgre.PostgreCtaStopsDao;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.junit.Assert;
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
public class CtaLStopsServiceTest {
  @Test
  public void seed_noArg_success() throws ServiceException {
    CtaLStopsService ctaLStopsService = new CtaLStopsService(
        new CtaLStopsDao("sample/small_cta_L_stops.csv"), new PostgreCtaStopsDao());
    ctaLStopsService.seed();
    List<CtaStopsModel> ctaStopsModels = ctaLStopsService.fetch();
    assertEquals(4, ctaStopsModels.size());
  }
}
