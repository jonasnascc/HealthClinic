package io.gihub.jonasnascc.HealthClinic.controller;

import io.gihub.jonasnascc.HealthClinic.dto.PatientDto;
import io.gihub.jonasnascc.HealthClinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService service;

    @PostMapping
    public ResponseEntity<?> create (
            @RequestBody PatientDto dto
    ) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("{cpf}")
    public ResponseEntity<?> find (
            @PathVariable String cpf
    ) {
        return ResponseEntity.ok(service.find(cpf));
    }

    @GetMapping
    public ResponseEntity<?> list () {
        return ResponseEntity.ok(service.list());
    }

    @PutMapping("{cpf}")
    public ResponseEntity<?> update (
            @PathVariable String cpf,
            @RequestBody PatientDto dto
    ) {
        return ResponseEntity.ok(service.update(cpf, dto));
    }

    @DeleteMapping("{cpf}")
    public ResponseEntity<?> delete(
            @PathVariable String cpf
    ) {
        return ResponseEntity.ok(service.delete(cpf));
    }
}
