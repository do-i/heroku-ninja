package org.djd.fun.taiga.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/14/12
 * Time: 6:46 PM
 * TODO Use Builder pattern to make this a immutable model.
 */
@XmlRootElement
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

  /**
   * Intellij generated method.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CtaStopsModel)) return false;

    CtaStopsModel that = (CtaStopsModel) o;

    if (ada != that.ada) return false;
    if (blue != that.blue) return false;
    if (brn != that.brn) return false;
    if (green != that.green) return false;
    if (Float.compare(that.lat, lat) != 0) return false;
    if (Float.compare(that.lon, lon) != 0) return false;
    if (orange != that.orange) return false;
    if (parentStopId != that.parentStopId) return false;
    if (pink != that.pink) return false;
    if (purple != that.purple) return false;
    if (purpleExp != that.purpleExp) return false;
    if (red != that.red) return false;
    if (stopId != that.stopId) return false;
    if (yellow != that.yellow) return false;
    if (directionId != null ? !directionId.equals(that.directionId) : that.directionId != null)
      return false;
    if (stationDescName != null ? !stationDescName.equals(that.stationDescName) : that.stationDescName != null)
      return false;
    if (stationName != null ? !stationName.equals(that.stationName) : that.stationName != null)
      return false;
    if (stopName != null ? !stopName.equals(that.stopName) : that.stopName != null) return false;

    return true;
  }

  /**
   * Intellij generated method.
   */
  @Override
  public int hashCode() {
    int result = stopId;
    result = 31 * result + (directionId != null ? directionId.hashCode() : 0);
    result = 31 * result + (stopName != null ? stopName.hashCode() : 0);
    result = 31 * result + (lon != +0.0f ? Float.floatToIntBits(lon) : 0);
    result = 31 * result + (lat != +0.0f ? Float.floatToIntBits(lat) : 0);
    result = 31 * result + (stationName != null ? stationName.hashCode() : 0);
    result = 31 * result + (stationDescName != null ? stationDescName.hashCode() : 0);
    result = 31 * result + parentStopId;
    result = 31 * result + ada;
    result = 31 * result + red;
    result = 31 * result + blue;
    result = 31 * result + brn;
    result = 31 * result + green;
    result = 31 * result + purple;
    result = 31 * result + purpleExp;
    result = 31 * result + yellow;
    result = 31 * result + pink;
    result = 31 * result + orange;
    return result;
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
