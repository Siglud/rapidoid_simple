package org.acgeek.demo;

import org.acgeek.demo.model.Book;
import org.rapidoid.annotation.Run;
import org.rapidoid.annotation.Valid;
import org.rapidoid.goodies.Goodies;
import org.rapidoid.jpa.JPA;
import org.rapidoid.setup.App;
import org.rapidoid.setup.On;

@Run
public class Main {
    public static void main(String[] args){
        App.bootstrap(args).jpa().auth();
        App.bootstrap().adminCenter();

        On.get("/books").json(() -> JPA.of(Book.class).all());

        On.post("/books").json((@Valid Book b) -> JPA.save(b));

        On.put("/books/{id}").json((Long id, @Valid Book b) -> JPA.update(b));

        On.delete("/books/{id}").json((Long id) -> {
            JPA.delete(Book.class, id);
            return true;
        });

        On.get("/config").mvc(Goodies.config());
    }
}
