package com.teamforone.tech_store.service.admin.impl;

import com.teamforone.tech_store.dto.request.RegisterRequest;
import com.teamforone.tech_store.dto.response.Response;
import com.teamforone.tech_store.model.NhanVien;
import com.teamforone.tech_store.repository.admin.RBAC.NhanVienRepository;
import com.teamforone.tech_store.service.admin.NhanVienService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class NhanVienServiceImpl implements NhanVienService {
    private final NhanVienRepository nhanVienRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Response createNhanVien(RegisterRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        String fullName = request.getFullName();
        String email = request.getEmail();
        String phoneNumber = request.getPhoneNumber();

        Optional<NhanVien> nhanVienByUsername = nhanVienRepository.findByUsername(username);
        Optional<NhanVien> nhanVienByEmail = nhanVienRepository.findByEmail(email);

        if(nhanVienByUsername.isPresent() || nhanVienByEmail.isPresent()) {
            return Response.builder()
                    .status(400)
                    .message("Username or Email already exists")
                    .build();
        }

        NhanVien newNhanVien = NhanVien.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .fullname(fullName)
                .email(email)
                .phone(phoneNumber)
                .build();
        nhanVienRepository.save(newNhanVien);
        return Response.builder()
                .status(HttpStatus.OK.value())
                .message("NhanVien registered successfully")
                .build();
    }
}
