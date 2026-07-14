package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.Admin;
import org.example.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AdminService {
    Scanner sc = new Scanner(System.in);
    AdminRepository adminRepository;

    public Admin createAdmin(Admin admin) {
        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new IllegalArgumentException("Email already exists!");
        }

        if (admin.getPassword() != null) {
            admin.setPassword(admin.getPassword());
        }

        return adminRepository.save(admin);
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found!"));
    }

    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin existingAdmin = findById(id);

        existingAdmin.setFullName(adminDetails.getFullName());
        existingAdmin.setEmail(adminDetails.getEmail());

        return adminRepository.save(existingAdmin);
    }

    public void deleteAdmin(Long id) {
        Admin admin = findById(id);
        adminRepository.delete(admin);
    }
}