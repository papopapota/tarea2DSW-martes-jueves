package com.example.examen.entity;

import java.time.Instant;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "libro")
public class Libro {

    private ObjectId _id;
    @Field("title")
    private String title;
    private String isbn;
    private int pageCount;
    private Instant publishedDate;
    private String thumbnailUrl;
    private String shortDescription;
    private String longDescription;
    private String status;
    private List<String> authors;
    private List<String> categories;
    
}