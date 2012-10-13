package org.djd.fun.taiga.resource;

import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.dao.WayOfDao;
import org.djd.fun.taiga.model.SomeData;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.TimeZone;

@Path("/logs")
@Produces(MediaType.APPLICATION_JSON)
public class LogResource {

  @POST
  public void create() throws DaoException {
    delete();
  }

  @DELETE
  public void delete() throws DaoException {
    new WayOfDao().deleteAll();
  }

  @GET
  public List<SomeData> get() throws DaoException {
    return new WayOfDao().getAll();
  }

  @POST
  @Path("/{somedata}")
  public void add(@PathParam("somedata") String somedata) throws DaoException {
    new WayOfDao().add(somedata);
  }
}

