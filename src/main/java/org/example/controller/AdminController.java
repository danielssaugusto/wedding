package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CreateGuestsListRequest;
import org.example.model.Admin;
import org.example.service.AdminService;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    // Endpoint para criar um Admin enviando os dados no corpo da requisição (JSON)
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin novoAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(novoAdmin, HttpStatus.CREATED);
    }

    // Endpoint para buscar um Admin pelo ID na URL (ex: /api/admins/1)
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.findById(id));
    }
}