package com.selimovic.coworkingspacesel.controller;

import com.selimovic.coworkingspacesel.model.MemberEntity;
import com.selimovic.coworkingspacesel.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @GetMapping
    ResponseEntity<List<MemberEntity>> getMembers() {
        return ResponseEntity.ok(this.memberService.all());
    }

    @Operation(
            summary = "get clients by Id",
            description = "return client by id"
    )
    @GetMapping("/{id}")
    ResponseEntity<MemberEntity> getMemberById(@PathVariable(name = "id") UUID memberId){
        return ResponseEntity.ok(this.memberService.oneById(memberId));
    }

    @Operation(
            summary = "update client",
            description = "update a specific client"
    )
    @PutMapping("/{id}")
    ResponseEntity<MemberEntity> updateUserById(@PathVariable(name = "id") UUID memberId, @RequestBody MemberEntity member){
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