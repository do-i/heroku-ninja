package org.djd.fun.taiga.model;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 6:46 PM
 * TODO Use Builder pattern to make this a immutable model.
 */
public class CtaStopsModel {

  private int stopId;             // STOP_ID
  private String directionId;     // DIRECTION_ID
  private String stopName;        // STOP_NAME
  private float lon;              // LON
  private float lat;              // LAT,
  private String stationName;     // STATION_NAME,
  private String stationDescName; // STATION_DESCRIPTIVE_NAME,
  private int parentStopId;       // PARENT_STOP_ID,
  private int ada;            // ADA,
  private int red;            // Red,
  private int blue;           // Blue,
  private int brn;            // Brn,
  private int green;          // G,
  private int purple;         // P,
  private int purpleExp;      // Pexp,
  private int yellow;         // Y,
  private int pink;           // Pink,
  private int orange;         // Org

  public int getStopId() {
    return stopId;
  }

  public void setStopId(int stopId) {
    this.stopId = stopId;
  }

  public String getDirectionId() {
    return directionId;
  }

  public void setDirectionId(String directionId) {
    this.directionId = directionId;
  }

  public String getStopName() {
    return stopName;
  }

  public void setStopName(String stopName) {
    this.stopName = stopName;
  }

  public float getLon() {
    return lon;
  }

  public void setLon(float lon) {
    this.lon = lon;
  }

  public float getLat() {
    return lat;
  }

  public void setLat(float lat) {
    this.lat = lat;
  }

  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getStationDescName() {
    return stationDescName;
  }

  public void setStationDescName(String stationDescName) {
    this.stationDescName = stationDescName;
  }

  public int getParentStopId() {
    return parentStopId;
  }

  public void setParentStopId(int parentStopId) {
    this.parentStopId = parentStopId;
  }

  public int getAda() {
    return ada;
  }

  public void setAda(int ada) {
    this.ada = ada;
  }

  public int getRed() {
    return red;
  }

  public void setRed(int red) {
    this.red = red;
  }

  public int getBlue() {
    return blue;
  }

  public void setBlue(int blue) {
    this.blue = blue;
  }

  public int getBrn() {
    return brn;
  }

  public void setBrn(int brn) {
    this.brn = brn;
  }

  public int getGreen() {
    return green;
  }

  public void setGreen(int green) {
    this.green = green;
  }

  public int getPurple() {
    return purple;
  }

  public void setPurple(int purple) {
    this.purple = purple;
  }

  public int getPurpleExp() {
    return purpleExp;
  }

  public void setPurpleExp(int purpleExp) {
    this.purpleExp = purpleExp;
  }

  public int getYellow() {
    return yellow;
  }

  public void setYellow(int yellow) {
    this.yellow = yellow;
  }

  public int getPink() {
    return pink;
  }

  public void setPink(int pink) {
    this.pink = pink;
  }

  public int getOrange() {
    return orange;
  }

  public void setOrange(int orange) {
    this.orange = orange;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("CtaStopsModel");
    sb.append("{stopId=").append(stopId);
    sb.append(", directionId='").append(directionId).append('\'');
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
