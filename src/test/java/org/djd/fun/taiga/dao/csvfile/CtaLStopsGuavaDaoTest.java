package org.djd.fun.taiga.dao.csvfile;

import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.model.CtaLStopsGuavaModel;
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
public class CtaLStopsGuavaDaoTest {
  @Test
  public void loadFile_noArgs_success() throws IOException, DaoException {
    List<CtaLStopsGuavaModel> stops = new CtaLStopsGuavaDao().loadFile();
    assertNotNull(stops);
    assertEquals(298, stops.size());
  }

  @Test
  public void ctaLStopsModels_noArgs_success() throws DaoException {
    CtaLStopsGuavaDao ctaLStopsGuavaDao = new CtaLStopsGuavaDao();
    assertEquals(ctaLStopsGuavaDao.loadFile(), ctaLStopsGuavaDao.ctaLStopsModels());
  }
}