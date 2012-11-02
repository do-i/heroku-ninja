package org.djd.fun.taiga.service;

import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.dao.csvfile.CtaLStopsDao;
import org.djd.fun.taiga.dao.postgre.PostgreCtaStopsDao;
import org.djd.fun.taiga.model.CtaStopsModel;

import java.util.List;

/**
 * Read data from {@link CtaLStopsDao} and write to {@link PostgreCtaStopsDao}
 * <p/>
 * User: acorn
 * Date: 10/14/12
 * Time: 11:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class CtaLStopsService {

  private final CtaLStopsDao ctaLStopsDao;
  private final PostgreCtaStopsDao postgreCtaStopsDao;

  public CtaLStopsService() {
    this(new CtaLStopsDao(), new PostgreCtaStopsDao());
  }

  /**
   * This is for unit test. and future injection.
   *
   * @param ctaLStopsDao
   * @param postgreCtaStopsDao
   */
  public CtaLStopsService(CtaLStopsDao ctaLStopsDao, PostgreCtaStopsDao postgreCtaStopsDao) {
    this.ctaLStopsDao = ctaLStopsDao;
    this.postgreCtaStopsDao = postgreCtaStopsDao;
  }

  public void seed() throws ServiceException {
    try {
      postgreCtaStopsDao.createTable();
      postgreCtaStopsDao.insertAll(ctaLStopsDao.loadFile());
    } catch (DaoException e) {
      throw new ServiceException(e);
    }
  }

  public List<CtaStopsModel> fetch() throws ServiceException {
    try {
      return postgreCtaStopsDao.selectAll();
    } catch (DaoException e) {
      throw new ServiceException(e);
    }
  }

  public int fetchParentStopId(int stopId) throws ServiceException {
    try {
      return postgreCtaStopsDao.selectParentStopIdByStopId(stopId);
    } catch (DaoException e) {
      throw new ServiceException(e);
    }
  }


}
