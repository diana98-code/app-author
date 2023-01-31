package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface BookService {
    List<Book> encontrarTodos() throws ExecutionException, InterruptedException;

    Book encontrarLibro(long id) throws ExecutionException, InterruptedException;

    long guardar(Book book);
    long actualizar(long id, Book book);
    long eliminar(long id);
}
