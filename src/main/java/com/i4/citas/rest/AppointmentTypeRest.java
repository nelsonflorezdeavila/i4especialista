package com.i4.citas.rest;

import com.i4.citas.entity.dto.AppointmentTypeDTO;
import com.i4.citas.service.AppointmentTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/v1/appointment-types")
@AllArgsConstructor
public class AppointmentTypeRest {

    private final AppointmentTypeService service;

    @PostMapping
    public Mono<Void> save(@RequestBody @Valid AppointmentTypeDTO dto) {
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }

    @GetMapping("/{id}")
    public Mono<AppointmentTypeDTO> findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @GetMapping
    public Flux<AppointmentTypeDTO> all() {
        return service.all();
    }
}
