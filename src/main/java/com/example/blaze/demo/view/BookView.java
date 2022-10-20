package com.example.blaze.demo.view;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.example.blaze.demo.model.Book;

import java.util.UUID;

@EntityView(Book.class)
public interface BookView {
    @IdMapping
    UUID getId();
    String getTitle();
}
