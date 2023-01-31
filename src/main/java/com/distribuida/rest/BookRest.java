package com.distribuida.rest;

import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import io.helidon.dbclient.DbClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.Response.Status.ACCEPTED;

@ApplicationScoped
@Path("/book")

public class BookRest {
    @Inject
    private BookService bookService;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Book findOneById(@PathParam("id") long id) throws ExecutionException, InterruptedException {
        return this.bookService.encontrarLibro(id);
    }

    @GET
    @Produces(APPLICATION_JSON)
    public Response findAll() throws ExecutionException, InterruptedException {
        return Response.status(ACCEPTED).entity(bookService.encontrarTodos()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Map<String, Long> update(@PathParam("id") long id, Book book) {
        return Map.of("rowsChanged", this.bookService.actualizar(id, book));
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Map<String, Long> save(Book book) {
        return Map.of("rowsChanged", this.bookService.guardar(book));
    }

    @DELETE
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Map<String, Long> delete(@PathParam("id") long id) {
        return Map.of("rowsChanged", this.bookService.eliminar(id));
    }
}