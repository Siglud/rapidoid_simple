package org.acgeek.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue
    public Long id;

    @NotNull
    public String title;

    public int year;
}
