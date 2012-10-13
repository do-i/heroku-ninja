package org.djd.fun.taiga.model;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SomeData {

  private final int id;
  private final String content;

  public SomeData(@JsonProperty("id") int id, @JsonProperty("content") String content) {
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
