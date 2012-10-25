package org.djd.fun.taiga.dao.postgre;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.djd.fun.taiga.model.StationsOrderedModel;
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
public class PostgreStationsDaoTest {

  private PostgreStationsDao postgreStationsDao;

  @Before
  public void init() {
    postgreStationsDao = new PostgreStationsDao();
  }

  @Test
  public void createTable_noArg_success() throws DaoException {
    postgreStationsDao.createTable();
  }

  @Test
  public void insertAll_oneRow_success() throws DaoException {
    postgreStationsDao.createTable();
    postgreStationsDao.insertAll(createModels());
  }

  @Test
  public void selectAll_noArg_success() throws DaoException {
    List<StationsOrderedModel> stationsOrderedModels = seedForSelect();
    List<StationsOrderedModel> ctaStopsModelsFetched = postgreStationsDao.selectAll();
    assertEquals(2, ctaStopsModelsFetched.size());
    assertTrue(Objects.equal(stationsOrderedModels, ctaStopsModelsFetched));
  }

  @Test
  public void selectByColor_Yellow_success() throws DaoException {
    List<StationsOrderedModel> stationsOrderedModels = seedForSelect();
    List<StationsOrderedModel> ctaStopsModelsFetched = postgreStationsDao.selectByColor("Yellow");
    assertEquals(1, ctaStopsModelsFetched.size());
  }

  @Test
  public void selectByColorAndDestination_RedHoward_success() throws DaoException {
    List<StationsOrderedModel> stationsOrderedModels = seedForSelect();
    List<StationsOrderedModel> ctaStopsModelsFetched =
        postgreStationsDao.selectByColorAndDestination("Red","Howard");
    assertEquals(1, ctaStopsModelsFetched.size());
  }

  private List<StationsOrderedModel> seedForSelect() throws DaoException {
    postgreStationsDao.createTable();
    List<StationsOrderedModel> stationsOrderedModels = createModels();
    postgreStationsDao.insertAll(stationsOrderedModels);
    return stationsOrderedModels;
  }

  private List<StationsOrderedModel> createModels() {
    StationsOrderedModel stationsOrderedModel = new StationsOrderedModel();
    stationsOrderedModel.setColor("Yellow");
    stationsOrderedModel.setDestination("95th/Dan Ryan");
    stationsOrderedModel.setSequence(1);
    stationsOrderedModel.setStopId(30089);
    stationsOrderedModel.setStopName("95th/Dan Ryan (95th-bound)");
    StationsOrderedModel stationsOrderedModel2 = new StationsOrderedModel();
    stationsOrderedModel2.setColor("Red");
    stationsOrderedModel2.setDestination("Howard");
    stationsOrderedModel2.setSequence(1);
    stationsOrderedModel2.setStopId(30088);
    stationsOrderedModel2.setStopName("95th/Dan Ryan (95th-bound)");
    return ImmutableList.of(stationsOrderedModel, stationsOrderedModel2);
  }
}