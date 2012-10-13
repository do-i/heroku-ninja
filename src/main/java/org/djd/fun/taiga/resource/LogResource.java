package org.djd.fun.taiga.resource;

import com.sun.jersey.api.NotFoundException;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.dao.WayOfDao;
import org.djd.fun.taiga.model.SomeData;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.FORBIDDEN;

@Path("/logs")
@Produces({MediaType.APPLICATION_JSON})
public class LogResource {

  @POST
  public void create() {
    delete();
  }

  @DELETE
  public void delete() {
    try {
      new WayOfDao().deleteAll();
      // this breaks application.wadl
      // return JResponse.created(UriBuilder.fromPath("/").build()).build();
    } catch (DaoException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      throw new WebApplicationException(FORBIDDEN);
    }
  }

  @GET
  public List<SomeData> get() {
    try {
      return new WayOfDao().getAll();
    } catch (DaoException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      throw new NotFoundException("Could not find any logs.");
    }
  }

  @POST
  @Path("/{somedata}")
  public void add(@PathParam("somedata") String somedata) {
    try {
      int id = new WayOfDao().add(somedata);
      if (id != 1) {
        throw new WebApplicationException(BAD_REQUEST);
      }
      // this breaks application.wadl
      // return JResponse.created(UriBuilder.fromPath("/").build()).build();
    } catch (DaoException e) {
      e.printStackTrace();
      throw new WebApplicationException(FORBIDDEN);
    }
  }

  @PUT
  //@Path("/{id: \\d{1,4}}/{somedata}")
  @Path("/{id}")
  @Consumes({MediaType.APPLICATION_JSON})
  public void add(@PathParam("id") int id, SomeData someData) {
    if( someData.getId() != id) {
      throw new WebApplicationException(BAD_REQUEST);
    }
    try {
      if (new WayOfDao().update(id, someData) != 1) {
        throw new WebApplicationException(BAD_REQUEST);
      }
    } catch (DaoException e) {
      e.printStackTrace();
      throw new WebApplicationException(FORBIDDEN);
    }
  }

}

