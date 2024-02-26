package com.i4.citas.service;

import com.i4.citas.entity.dto.AppointmentTypeDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AppointmentTypeService {

    Mono<Void> save(AppointmentTypeDTO dto);

    Mono<Void> deleteById(Integer id);

    Mono<AppointmentTypeDTO> findById(Integer id);

    Flux<AppointmentTypeDTO> all();
}
