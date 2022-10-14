package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import com.trybe.acc.java.programamilhas.model.TipoLancamento;
import com.trybe.acc.java.programamilhas.service.DominioService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/dominio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DominioResource {

  @Inject
  private DominioService dominioService;

  @GET
  @Path("/tipolancamento")
  public Response listarTipoLancamentos() {
    List<TipoLancamento> tipoLancamentos = dominioService.listarTipoLancamentos();
    return Response.status(Response.Status.OK).entity(tipoLancamentos).build();
  }

  @GET
  @Path("/parceiro")
  public Response listarParceiros() {
    List<Parceiro> parceiros = dominioService.listarParceiros();
    return Response.status(Response.Status.OK).entity(parceiros).build();
  }

  @GET
  @Path("/produto")
  public Response listarProdutos() {
    List<Produto> produtos = dominioService.listarProdutos();
    return Response.status(Response.Status.OK).entity(produtos).build();
  }

}