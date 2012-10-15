package org.djd.fun.taiga.dao.postgre;

import com.google.common.collect.ImmutableList;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.dao.util.ConnectionUtil;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostgreCtaStopsDaoTest {

  @Test public void createTable_noArg_success() throws DaoException {
    PostgreCtaStopsDao postgreCtaStopsDao = new PostgreCtaStopsDao();
    postgreCtaStopsDao.createTable();
  }

  @Test public void insertAll_oneRow_success() throws DaoException {
    PostgreCtaStopsDao postgreCtaStopsDao = new PostgreCtaStopsDao();
    postgreCtaStopsDao.createTable();
    postgreCtaStopsDao.insertAll(createModels());
  }

  @Test public void selectAll_noArg_success() throws DaoException {
    PostgreCtaStopsDao postgreCtaStopsDao = new PostgreCtaStopsDao();
    postgreCtaStopsDao.createTable();
    postgreCtaStopsDao.insertAll(createModels());
    List<CtaStopsModel> ctaStopsModels = postgreCtaStopsDao.selectAll();
    assertEquals(1, ctaStopsModels.size());

    System.out.println(ctaStopsModels);

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