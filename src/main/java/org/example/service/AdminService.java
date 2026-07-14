package org.example.service;

import org.example.model.Admin;
import org.example.repository.AdminRepository;

import java.util.List;

public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin admin) {
        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new IllegalArgumentException("Administrador email's already exists!");
        }
        return adminRepository.save(admin);
    }

    public Admin updatePassword(Long id, String newPassword) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Administrator not found!"));

        if (newPassword == null || newPassword.trim().length() < 6) {
            throw new IllegalArgumentException("Your password needs 6 or more characteres.");
        }

        admin.setPassword(newPassword);
        return adminRepository.save(admin);
    }

    public Admin updateEmail(String newEmail) {
        Admin admin = adminRepository.findByEmail(newEmail);
        admin.setEmail(newEmail);
        return adminRepository.save(admin);
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
}
