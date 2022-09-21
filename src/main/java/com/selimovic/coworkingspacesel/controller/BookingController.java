package com.selimovic.coworkingspacesel.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.selimovic.coworkingspacesel.model.BookingEntity;
import com.selimovic.coworkingspacesel.service.BookingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookings")
@Tag(name = "Bookings", description = "Booking management endpoints")
public class BookingController {

    private final BookingService bookingService;

    BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Operation(
            summary = "Get all bookings",
            description = "Loads all bookings from database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @GetMapping
    List<BookingEntity> loadAll(@RequestParam(value = "bookingName", required = false) String bookingName) {

        if (bookingName != null) {
            return bookingService.loadAllByName(bookingName);
        }

        return bookingService.loadAll();
    }

    @Operation(
            summary = "Get one specific booking by id",
            description = "Loads one specific booking by id from database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @GetMapping("/{id}")
    BookingEntity loadOne(@PathVariable UUID id) {
        return bookingService.loadOne(id);
    }

    @Operation(
            summary = "Create a new booking",
            description = "Creates a new booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PostMapping
    BookingEntity create(@RequestBody BookingEntity entity) {
        return bookingService.create(entity);
    }

    @Operation(
            summary = "Update an existing booking",
            description = "Updates one specific and existing booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PutMapping("/{id}")
    BookingEntity update(@RequestBody BookingEntity updatedBookingEntity, @PathVariable UUID id) {
        return bookingService.update(updatedBookingEntity);
    }

    @Operation(
            summary = "Delete an existing booking",
            description = "Deletes one specific and existing booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        bookingService.delete(id);
    }

    @Operation(
            summary = "Approve an existing booking",
            description = "Approves one specific and existing booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/statusapprove/{id}")
    BookingEntity updateStatusapprove(@RequestBody BookingEntity updatedBookingEntityStatus, @PathVariable UUID id) {
        return bookingService.update(updatedBookingEntityStatus);
    }
    @Operation(
            summary = "Deny an existing booking",
            description = "Denies one specific and existing booking in database.",
            security = {@SecurityRequirement(name = "JWT Auth")}
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/statusdeny/{id}")
    BookingEntity updateStatusdeny(@RequestBody BookingEntity updatedBookingEntityStatus, @PathVariable UUID id) {
        return bookingService.update(updatedBookingEntityStatus);
    }

}