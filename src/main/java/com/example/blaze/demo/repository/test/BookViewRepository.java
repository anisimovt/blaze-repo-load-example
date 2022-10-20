package com.example.blaze.demo.repository.test;

import com.blazebit.persistence.spring.data.repository.EntityViewRepository;
import com.example.blaze.demo.view.BookView;

import java.util.UUID;

public interface BookViewRepository extends EntityViewRepository<BookView, UUID> {
}
