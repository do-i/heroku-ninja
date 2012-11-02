package org.djd.fun.taiga.dao.postgre;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * TODO mock database using http://dbunit.sourceforge.net/
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostgreCtaStopsDaoTest {

  private PostgreCtaStopsDao postgreCtaStopsDao;

  @Before
  public void init() {
    postgreCtaStopsDao = new PostgreCtaStopsDao();
  }

  @Test
  public void createTable_noArg_success() throws DaoException {
    postgreCtaStopsDao.createTable();
  }

  @Test
  public void insertAll_oneRow_success() throws DaoException {
    postgreCtaStopsDao.createTable();
    postgreCtaStopsDao.insertAll(createModels());
  }

  @Test
  public void selectAll_noArg_success() throws DaoException {
    postgreCtaStopsDao.createTable();
    List<CtaStopsModel> ctaStopsModelsOriginal = createModels();
    postgreCtaStopsDao.insertAll(ctaStopsModelsOriginal);
    List<CtaStopsModel> ctaStopsModelsFetched = postgreCtaStopsDao.selectAll();
    assertEquals(1, ctaStopsModelsFetched.size());
    assertTrue(Objects.equal(ctaStopsModelsOriginal, ctaStopsModelsFetched));
  }

  @Test
  public void selectParentStopIdByStopId_30089_40450() throws DaoException {
    postgreCtaStopsDao.createTable();
    List<CtaStopsModel> ctaStopsModelsOriginal = createModels();
    postgreCtaStopsDao.insertAll(ctaStopsModelsOriginal);
    int parentStopId = postgreCtaStopsDao.selectParentStopIdByStopId(30089);
    assertEquals(40450, parentStopId);
  }

  @Test(expected = DaoException.class)
  public void selectParentStopIdByStopId_invalidStopId_error() throws DaoException {
    postgreCtaStopsDao.createTable();
    List<CtaStopsModel> ctaStopsModelsOriginal = createModels();
    postgreCtaStopsDao.insertAll(ctaStopsModelsOriginal);
    try {
      postgreCtaStopsDao.selectParentStopIdByStopId(69);
    } catch (DaoException e) {
      assertEquals("Invalid stopId 69", e.getMessage());
      throw e;
    }
  }


  private List<CtaStopsModel> createModels() {
    CtaStopsModel ctaStopsModel = new CtaStopsModel();
    ctaStopsModel.setStopId(30089);
    ctaStopsModel.setDirectionId("S");
    ctaStopsModel.setStopName("95th/Dan Ryan (95th-bound)");
    ctaStopsModel.setLon(-87.624342f);
    ctaStopsModel.setLat(41.722377f);
    ctaStopsModel.setStationName("95th/Dan Ryan");
    ctaStopsModel.setStationDescName("95th/Dan Ryan (Red Line)");
    ctaStopsModel.setParentStopId(40450);
    ctaStopsModel.setAda(1);
    ctaStopsModel.setRed(1);
    ctaStopsModel.setBlue(0);
    ctaStopsModel.setBrn(0);
    ctaStopsModel.setGreen(0);
    ctaStopsModel.setPurple(0);
    ctaStopsModel.setPurpleExp(0);
    ctaStopsModel.setPink(0);
    ctaStopsModel.setYellow(0);
    ctaStopsModel.setOrange(0);
    return ImmutableList.of(ctaStopsModel);
  }
}