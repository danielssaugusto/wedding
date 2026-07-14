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

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }
}
