package com.distribuida.db;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private long id;
    private String isbn;
    private String title;
    private double price;
    private Author author;
}
