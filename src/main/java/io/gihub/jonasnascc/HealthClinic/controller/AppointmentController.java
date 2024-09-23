package io.gihub.jonasnascc.HealthClinic.controller;

import io.gihub.jonasnascc.HealthClinic.dto.AppointmentDto;
import io.gihub.jonasnascc.HealthClinic.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> create (
            @RequestBody AppointmentDto dto
            ) {
        return ResponseEntity.ok(appointmentService.create(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> find (
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(appointmentService.find(id));
    }

    @GetMapping
    public ResponseEntity<?> list () {
        return ResponseEntity.ok(appointmentService.list());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update (
            @PathVariable Long id,
            @RequestBody AppointmentDto dto
    ) {
        return ResponseEntity.ok(appointmentService.update(id, dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete (
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(appointmentService.delete(id));
    }
}
