package com.example.services;

import com.example.models.FileInfo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: acorn
 * Date: 10/10/12
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */

@Path("/file")
@Produces(MediaType.APPLICATION_JSON)
public class FileResource {
  @GET
  @Path("/{filename}")
  public FileInfo getFileInfo(@PathParam("filename") String filename) {
    BufferedReader br = null;
    try {
      File aFile = new File(filename);
      if (aFile.canRead()) {
        br = new BufferedReader(new FileReader(aFile));
        return new FileInfo(br.readLine());
      } else {
        return new FileInfo();
      }
    } catch (IOException e) {
      e.printStackTrace();
      return new FileInfo();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @POST
  @Path("/{filename}")
  public void postFileInfo(@PathParam("filename") String filename) {
    BufferedWriter bw = null;
    try {
      File aFile = new File(filename);
      if (aFile.canWrite()) {
        bw = new BufferedWriter(new FileWriter(aFile));
        bw.write(new Date().toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bw != null) {
        try {
          bw.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
