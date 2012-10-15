package org.djd.fun.taiga.dao.csvfile;

import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.model.CtaStopsModel;
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
public class CtaLStopsDaoTest {
  @Test
  public void loadFile_noArgs_success() throws IOException, DaoException {
    List<CtaStopsModel> stops = new CtaLStopsDao("sample/small_cta_L_stops.csv").loadFile();
    assertNotNull(stops);
    assertEquals(4, stops.size());
  }

  @Test(expected = RuntimeException.class)
  public void loadFile_blankLine_error() throws IOException, DaoException {
    try {
      new CtaLStopsDao("sample/blankLine_cta_L_stops.csv").loadFile();
    } catch (RuntimeException e) {
      assertEquals("Error parsing CSV!", e.getMessage());
      throw e;
    }
  }

  @Test(expected = RuntimeException.class)
  public void loadFile_missingField_error() throws IOException, DaoException {
    try {
      new CtaLStopsDao("sample/missingToken_cta_L_stops.csv").loadFile();
    } catch (RuntimeException e) {
      assertEquals("Error parsing CSV!", e.getMessage());
      throw e;
    }
  }
}