package org.djd.fun.taiga.resource;

import com.sun.jersey.api.NotFoundException;
import org.djd.fun.taiga.model.CtaStopsModel;
import org.djd.fun.taiga.model.CuteResponse;
import org.djd.fun.taiga.model.StationsOrderedModel;
import org.djd.fun.taiga.service.CtaLStopsService;
import org.djd.fun.taiga.service.ServiceException;
import org.djd.fun.taiga.service.StationsService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

/**
 * TODO add authentication mechanism to @POST method
 */
@Path("/stations")
@Produces({MediaType.APPLICATION_JSON})
public class StationsResource {

  private final StationsService stationsService;

  public StationsResource() {
    this(new StationsService());
  }

  /**
   * for unit test
   *
   * @param stationsService
   */
  public StationsResource(StationsService stationsService) {
    this.stationsService = stationsService;
  }

  @POST
  public CuteResponse seed() {
    try {
      stationsService.seed();
      return new CuteResponse.Builder().statusCode(200).message("Database was successfully seeded.")
          .build();
    } catch (ServiceException e) {
      throw new WebApplicationException(INTERNAL_SERVER_ERROR);
    }
  }

  @GET
  public List<StationsOrderedModel> fetchAll() {
    try {
      return stationsService.fetch();
    } catch (ServiceException e) {
      throw new NotFoundException("Could not find any stations.");
    }
  }

  @GET
  @Path("/{color:\\w+}")
  public List<StationsOrderedModel> fetchByColor(@PathParam("color") String color) {
    try {
      return stationsService.fetchByColor(color);
    } catch (ServiceException e) {
      throw new NotFoundException("Could not find any stations.");
    }
  }

  @GET
  @Path("/{color:\\w+}/{destination:\\w+}")
  public List<StationsOrderedModel> fetchByColorAndDestination(
      @PathParam("color") String color,
      @PathParam("destination") String destination) {
    try {
      return stationsService.fetchByColorAndDestination(color, destination);
    } catch (ServiceException e) {
      throw new NotFoundException("Could not find any stations.");
    }
  }
}