package org.acgeek.demo;

import org.acgeek.demo.model.Book;
import org.rapidoid.annotation.Valid;
import org.rapidoid.jpa.JPA;
import org.rapidoid.setup.App;
import org.rapidoid.setup.On;

public class Main {
    public static void main(String[] args){
        App.bootstrap(args).jpa();

        On.get("/books").json(() -> JPA.of(Book.class).all());

        On.post("/books").json((@Valid Book b) -> JPA.save(b));
    }
}
