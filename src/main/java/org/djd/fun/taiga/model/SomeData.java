package org.djd.fun.taiga.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SomeData {

  private final int id;
  private final String content;

  public SomeData(int id, String content) {
    this.id = id;
    this.content = content;
  }

  public int getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
