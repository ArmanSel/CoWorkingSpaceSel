package com.selimovic.coworkingspacesel.controller;

import com.selimovic.coworkingspacesel.model.MemberEntity;
import com.selimovic.coworkingspacesel.service.MemberService;
import org.springframework.security.access.prepost.PreAuthorize;
import com.selimovic.coworkingspacesel.repository.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Client Management", description = "Client management endpoints")
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @Operation(
            summary = "get all clients",
            description = "return all clients"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    ResponseEntity<List<MemberEntity>> getMembers() {
        return ResponseEntity.ok(this.memberService.all());
    }

    @Operation(
            summary = "get clients by Id",
            description = "return client by id"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    ResponseEntity<MemberEntity> getMemberById(@PathVariable(name = "id") UUID memberId){
        return ResponseEntity.ok(this.memberService.oneById(memberId));
    }

    @Operation(
            summary = "update client",
            description = "update a specific client"
    )
    @PutMapping("/{id}")
    ResponseEntity<MemberEntity> updateUserById(@PathVariable(name = "id") UUID memberId, @RequestBody MemberEntity updatedMember) {
        val member = memberService.oneById(memberId);
        member.setNewsletter(updatedMember.getNewsletter());
        return ResponseEntity.ok(this.memberService.update(member, memberId));
    }

    @Operation(
            summary = "delete client",
            description = "delete a specific client"
    )
    @DeleteMapping("/{id}")
    ResponseEntity<String> updateUserById(@PathVariable(name = "id") UUID memberId){
        this.memberService.delete(memberId);
        return ResponseEntity.ok("Successfully deleted client by their id " + memberId);
    }
}