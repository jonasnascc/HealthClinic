package io.gihub.jonasnascc.HealthClinic.controller;

import io.gihub.jonasnascc.HealthClinic.dto.ExamDto;
import io.gihub.jonasnascc.HealthClinic.dto.ExamStatusDto;
import io.gihub.jonasnascc.HealthClinic.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
public class ExamController {
    private final ExamService service;

    @PostMapping
    public ResponseEntity<?> create (
            @RequestBody ExamDto dto
    ) {
        return ResponseEntity.ok(service.create(dto));
    }


    @GetMapping("{id}")
    public ResponseEntity<?> find (
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.find(id));
    }

    @GetMapping
    public ResponseEntity<?> list () {
        return ResponseEntity.ok(service.list());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update (
            @PathVariable Long id,
            @RequestBody ExamDto dto
    ) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> changeStatus (
            @PathVariable Long id,
            @RequestBody ExamStatusDto dto
    ) {
        service.changeStatus(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete (
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(service.delete(id));
    }
}
