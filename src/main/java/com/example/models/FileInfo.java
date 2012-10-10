package com.example.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FileInfo {

  private final String content;

  public FileInfo() {
    this("No File Content");
  }

  public FileInfo(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }


}
