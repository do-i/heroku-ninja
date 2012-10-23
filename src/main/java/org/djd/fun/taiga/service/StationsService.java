package org.djd.fun.taiga.service;

import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.dao.csvfile.CtaLStopsDao;
import org.djd.fun.taiga.dao.csvfile.StationsOrderedDao;
import org.djd.fun.taiga.dao.postgre.PostgreCtaStopsDao;
import org.djd.fun.taiga.dao.postgre.PostgreStationsDao;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.djd.fun.taiga.model.StationsOrderedModel;

import java.util.List;

/**
 * Read data from {@link org.djd.fun.taiga.dao.csvfile.CtaLStopsDao} and write to {@link org.djd.fun.taiga.dao.postgre.PostgreCtaStopsDao}
 * <p/>
 * User: acorn
 * Date: 10/14/12
 * Time: 11:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class StationsService {

  private final StationsOrderedDao stationsOrderedDao;
  private final PostgreStationsDao postgreStationsDao;

  public StationsService() {
    this(new StationsOrderedDao(), new PostgreStationsDao());
  }

  /**
   * This is for unit test. and future injection.
   *
   * @param stationsOrderedDao
   * @param postgreStationsDao
   */
  public StationsService(StationsOrderedDao stationsOrderedDao, PostgreStationsDao postgreStationsDao) {
    this.stationsOrderedDao = stationsOrderedDao;
    this.postgreStationsDao = postgreStationsDao;
  }

  public void seed() throws ServiceException {
    try {
      postgreStationsDao.createTable();
      postgreStationsDao.insertAll(stationsOrderedDao.loadFile());
    } catch (DaoException e) {
      throw new ServiceException(e);
    }
  }

  public List<StationsOrderedModel> fetch() throws ServiceException {
    try {
      return postgreStationsDao.selectAll();
    } catch (DaoException e) {
      throw new ServiceException(e);
    }
  }
}
