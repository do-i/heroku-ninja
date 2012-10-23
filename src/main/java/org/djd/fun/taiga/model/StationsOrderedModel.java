package org.djd.fun.taiga.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/20/12
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public class StationsOrderedModel {
  private String color;
  private String destination;
  private int sequence;
  private int stopId;
  private String stopName;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public int getSequence() {
    return sequence;
  }

  public void setSequence(int sequence) {
    this.sequence = sequence;
  }

  public int getStopId() {
    return stopId;
  }

  public void setStopId(int stopId) {
    this.stopId = stopId;
  }

  public String getStopName() {
    return stopName;
  }

  public void setStopName(String stopName) {
    this.stopName = stopName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof StationsOrderedModel)) return false;

    StationsOrderedModel that = (StationsOrderedModel) o;

    if (sequence != that.sequence) return false;
    if (stopId != that.stopId) return false;
    if (color != null ? !color.equals(that.color) : that.color != null) return false;
    if (destination != null ? !destination.equals(that.destination) : that.destination != null)
      return false;
    if (stopName != null ? !stopName.equals(that.stopName) : that.stopName != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = color != null ? color.hashCode() : 0;
    result = 31 * result + (destination != null ? destination.hashCode() : 0);
    result = 31 * result + sequence;
    result = 31 * result + stopId;
    result = 31 * result + (stopName != null ? stopName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("StationsOrderedModel");
    sb.append("{color='").append(color).append('\'');
    sb.append(", destination='").append(destination).append('\'');
    sb.append(", sequence=").append(sequence);
    sb.append(", stopId=").append(stopId);
    sb.append(", stopName='").append(stopName).append('\'');
    sb.append('}');
    return sb.toString();
  }
}