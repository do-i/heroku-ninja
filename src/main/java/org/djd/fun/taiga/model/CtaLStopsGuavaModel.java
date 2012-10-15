package org.djd.fun.taiga.model;

import com.google.common.base.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class CtaLStopsGuavaModel {
  enum Direction {
    N, E, S, W
  }

  //STOP_ID,DIRECTION_ID,STOP_NAME,LON,LAT,
  //  STATION_NAME,STATION_DESCRIPTIVE_NAME,
  //    PARENT_STOP_ID,ADA,Red,Blue,Brn,G,P,Pexp,Y,Pink,Org
  //30162,W,18th (54th/Cermak-bound),-87.669147,41.857908,
  //  18th,18th (Pink Line),
  //    40830,1,0,0,0,0,0,0,0,1,0

  public final int stopId;             // STOP_ID
  public final Direction directionId;  // DIRECTION_ID
  public final String stopName;        // STOP_NAME
  public final float lon;              // LON
  public final float lat;              // LAT,
  public final String stationName;     // STATION_NAME,
  public final String stationDescName; // STATION_DESCRIPTIVE_NAME,
  public final int parentStopId;       // PARENT_STOP_ID,
  public final boolean ada;            // ADA,
  public final boolean red;            // Red,
  public final boolean blue;           // Blue,
  public final boolean brn;            // Brn,
  public final boolean green;          // G,
  public final boolean purple;         // P,
  public final boolean purpleExp;      // Pexp,
  public final boolean yellow;         // Y,
  public final boolean pink;           // Pink,
  public final boolean orange;         // Org

  public CtaLStopsGuavaModel(String[] tokens) {
    validate(tokens);
    stopId = Integer.parseInt(tokens[0]);
    directionId = Direction.valueOf(tokens[1]);
    stopName = tokens[2];
    lon = Float.parseFloat(tokens[3]);
    lat = Float.parseFloat(tokens[4]);
    stationName = tokens[5];
    stationDescName = tokens[6];
    parentStopId = Integer.parseInt(tokens[7]);
    ada = "1".equals(tokens[8]);
    red = "1".equals(tokens[9]);
    blue = "1".equals(tokens[10]);
    brn = "1".equals(tokens[11]);
    green = "1".equals(tokens[12]);
    purple = "1".equals(tokens[13]);
    purpleExp = "1".equals(tokens[14]);
    yellow = "1".equals(tokens[15]);
    pink = "1".equals(tokens[16]);
    orange = "1".equals(tokens[17]);
  }

  private void validate(String[] tokens) {
    if(18 != tokens.length) {
      throw new IllegalStateException("Invalid number of fields. Expected 18. Actual " + tokens.length);
    }
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("CtaLStopsGuavaModel");
    sb.append("{stopId=").append(stopId);
    sb.append(", directionId=").append(directionId);
    sb.append(", stopName='").append(stopName).append('\'');
    sb.append(", lon=").append(lon);
    sb.append(", lat=").append(lat);
    sb.append(", stationName='").append(stationName).append('\'');
    sb.append(", stationDescName='").append(stationDescName).append('\'');
    sb.append(", parentStopId=").append(parentStopId);
    sb.append(", ada=").append(ada);
    sb.append(", red=").append(red);
    sb.append(", blue=").append(blue);
    sb.append(", brn=").append(brn);
    sb.append(", green=").append(green);
    sb.append(", purple=").append(purple);
    sb.append(", purpleExp=").append(purpleExp);
    sb.append(", yellow=").append(yellow);
    sb.append(", pink=").append(pink);
    sb.append(", orange=").append(orange);
    sb.append('}');
    return sb.toString();
  }
}

