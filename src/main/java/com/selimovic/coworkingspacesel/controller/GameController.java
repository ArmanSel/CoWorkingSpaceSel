package com.selimovic.coworkingspacesel.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.selimovic.coworkingspacesel.model.GameEntity;
import com.selimovic.coworkingspacesel.service.CategoryService;
import com.selimovic.coworkingspacesel.service.GameService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/games")
@Tag(name = "Bookings", description = "Booking management endpoints")
public class GameController {

    private final GameService gameService;
    private final CategoryService categoryService;

    GameController(GameService gameService, CategoryService categoryService) {
        this.gameService = gameService;
        this.categoryService = categoryService;
    }

    @Operation(
            summary = "Get all bookings",
            description = "Loads all bookings from database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @GetMapping
    List<GameEntity> loadAll(@RequestParam(value = "name", required = false) String gameName) {

        if(gameName != null) {
            return gameService.loadAllByName(gameName);
        }

        return gameService.loadAll();
    }

    @Operation(
            summary = "Get one specific booking by id",
            description = "Loads one specific booking by id from database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @GetMapping("/{id}")
    GameEntity loadOne(@PathVariable UUID id) {
        return gameService.loadOne(id);
    }

    @Operation(
            summary = "Create a new booking",
            description = "Creates a new booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    GameEntity create(@RequestBody GameEntity entity) {
        entity.setCategory(categoryService.loadOne(entity.getCategoryId()));
        return gameService.create(entity);
    }

    @Operation(
            summary = "Update an existing booking",
            description = "Updates one specific and existing booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    GameEntity update(@RequestBody GameEntity updatedGameEntity, @PathVariable UUID id) {
        return gameService.update(updatedGameEntity);
    }

    @Operation(
            summary = "Delete an existing booking",
            description = "Deletes one specific and existing booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        gameService.delete(id);
    }

}
