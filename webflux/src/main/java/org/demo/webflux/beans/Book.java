package org.example.vertx.dao;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Book
 *
 * @Author: taomee
 * @Date: 2020/4/11 0011 22:32
 * @Description:
 */



@Entity
@Table(name = "tb_book")
@DataObject
public class Book {

    @Id
    private Long id;

    private String name;

    private String author;

    // Mandatory for JPA entities
    protected Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // Mandatory for data objects
    public Book(JsonObject jsonObject) {
//        BookConverter.fromJson(jsonObject, this);
        Book book = Json.decodeValue(jsonObject.toString(),Book.class);
        this.id = book.id;
        this.author = book.author;
        this.name = book.name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json = JsonObject.mapFrom(this);
        return json;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
