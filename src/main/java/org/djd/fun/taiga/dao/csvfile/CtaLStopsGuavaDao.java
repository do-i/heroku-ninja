package org.djd.fun.taiga.dao.csvfile;

import au.com.bytecode.opencsv.CSVParser;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.model.CtaLStopsGuavaModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class CtaLStopsGuavaDao {

  private List<CtaLStopsGuavaModel> ctaLStopsModels;

  public List<CtaLStopsGuavaModel> loadFile() throws DaoException {
    URL url = Resources.getResource("input/cta_L_stops.csv");
    try {
      ctaLStopsModels = Resources.readLines(url, Charsets.UTF_8, new MyLineProcessor());
      return ctaLStopsModels;
    } catch (IOException e) {
      throw new DaoException(e);
    }
  }

  public List<CtaLStopsGuavaModel> ctaLStopsModels() {
    return ctaLStopsModels;
  }

  /**
   * Assume the first line is a header and thus skips.
   */
  private class MyLineProcessor implements LineProcessor<List<CtaLStopsGuavaModel>> {

    private CSVParser parser = new CSVParser();
    private boolean headerLine = true;
    private ImmutableList.Builder<CtaLStopsGuavaModel> ctaLStopsModelListBuilder =
        new ImmutableList.Builder<CtaLStopsGuavaModel>();

    @Override
    public boolean processLine(String line) throws IOException {
      if(headerLine) {
        headerLine = false;
      } else {
        ctaLStopsModelListBuilder.add(new CtaLStopsGuavaModel(parser.parseLine(line)));
      }
      return true;
    }

    @Override
    public List<CtaLStopsGuavaModel> getResult() {
      return ctaLStopsModelListBuilder.build();
    }
  }
}