package com.selimovic.coworkingspacesel.repository;

import com.selimovic.coworkingspacesel.model.BookingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends CrudRepository<BookingEntity, UUID> {
    List<BookingEntity> findAll();
    List<BookingEntity> findAllByName(String name);
}
