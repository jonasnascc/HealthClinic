package io.gihub.jonasnascc.HealthClinic.controller;

import io.gihub.jonasnascc.HealthClinic.dto.DoctorDto;
import io.gihub.jonasnascc.HealthClinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<?> create (
            @RequestBody DoctorDto dto
            ) {
        return ResponseEntity.ok(doctorService.create(dto));
    }

    @GetMapping("{crm}")
    public ResponseEntity<?> find (
            @PathVariable String crm
    ) {
        return ResponseEntity.ok(doctorService.find(crm));
    }

    @GetMapping
    public ResponseEntity<?> list () {
        return ResponseEntity.ok(doctorService.list());
    }

    @PutMapping("{crm}")
    public ResponseEntity<?> update (
            @PathVariable String crm,
            @RequestBody DoctorDto dto
    ) {
        return ResponseEntity.ok(doctorService.update(crm, dto));
    }

    @DeleteMapping("{crm}")
    public ResponseEntity<?> delete (
            @PathVariable String crm
    ) {
        return ResponseEntity.ok(doctorService.delete(crm));
    }
}
