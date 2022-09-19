package com.selimovic.coworkingspacesel.repository;

import com.selimovic.coworkingspacesel.model.GameEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends CrudRepository<GameEntity, UUID> {
    List<GameEntity> findAll();
}
