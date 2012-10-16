package org.djd.fun.taiga.resource;

import com.sun.jersey.api.NotFoundException;
import org.djd.fun.taiga.dao.DaoException;
import org.djd.fun.taiga.dao.WayOfDao;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.djd.fun.taiga.model.CuteResponse;
import org.djd.fun.taiga.model.SomeData;
import org.djd.fun.taiga.service.CtaLStopsService;
import org.djd.fun.taiga.service.ServiceException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

/**
 * TODO add authentication mechanism to @POST method
 */
@Path("/admin")
@Produces({MediaType.APPLICATION_JSON})
public class CtaLStopsResource {

  private final CtaLStopsService ctaLStopsService;

  public CtaLStopsResource() {
    this(new CtaLStopsService());
  }

  /**
   * for unit test
   *
   * @param ctaLStopsService
   */
  public CtaLStopsResource(CtaLStopsService ctaLStopsService) {
    this.ctaLStopsService = ctaLStopsService;
  }

  @POST
  public CuteResponse seed() {
    try {
      ctaLStopsService.seed();
      return new CuteResponse.Builder().statusCode(200).message("Database was successfully seeded.")
          .build();
    } catch (ServiceException e) {
      throw new WebApplicationException(INTERNAL_SERVER_ERROR);
    }
  }

  @GET
  public List<CtaStopsModel> fetchAll() {
    try {
      return ctaLStopsService.fetch();
    } catch (ServiceException e) {
      throw new NotFoundException("Could not find any logs.");
    }
  }
}