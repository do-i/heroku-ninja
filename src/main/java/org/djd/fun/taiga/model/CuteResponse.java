package org.djd.fun.taiga.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/15/12
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
public final class CuteResponse {
  public final int statusCode;
  public final String message;

  private CuteResponse(Builder builder) {
    this.statusCode = builder.statusCode;
    this.message = builder.message;
  }

  public static class Builder {
    private int statusCode;
    private String message;

    public Builder statusCode(int statusCode) {
      this.statusCode = statusCode;
      return this;
    }

    public Builder message(String message) {
      this.message = message;
      return this;
    }

    public CuteResponse build() {
      return new CuteResponse(this);
    }
  }
}