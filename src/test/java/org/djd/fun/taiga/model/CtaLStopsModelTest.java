package org.djd.fun.taiga.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class CtaLStopsModelTest {
  @Test
  public void create_validArg_success() {
    String[] data = {"30162", "W", "18th (54th/Cermak-bound)", "-87.669147", "41.857908", "18th",
        "18th (Pink Line)", "40830", "1", "0", "0", "0", "0", "0", "0", "0", "1", "0"};
    CtaLStopsGuavaModel model = new CtaLStopsGuavaModel(data);
    assertTrue(model.ada);
    assertFalse(model.red);
  }

  @Test(expected = IllegalStateException.class)
  public void create_invalidArg_error() {
    String[] badData = {"W", "18th (54th/Cermak-bound)", "-87.669147", "41.857908", "18th",
        "18th (Pink Line)", "40830", "1", "0", "0", "0", "0", "0", "0", "0", "1", "0"};
    new CtaLStopsGuavaModel(badData);
  }
}
