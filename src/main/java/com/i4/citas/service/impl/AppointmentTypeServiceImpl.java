package com.i4.citas.service.impl;

import com.i4.citas.entity.dto.AppointmentTypeDTO;
import com.i4.citas.entity.model.AppointmentType;
import com.i4.citas.repository.AppointmentTypeRepository;
import com.i4.citas.service.AppointmentTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AppointmentTypeServiceImpl implements AppointmentTypeService {

    private final AppointmentTypeRepository repository;

    @Override
    @Transactional
    public Mono<Void> save(AppointmentTypeDTO dto) {
        return repository.save(AppointmentType.builder()
                        .name(dto.name())
                        .description(dto.description())
                        .duration(dto.duration())
                        .color(dto.color())
                        .build()).then();
    }

    @Override
    @Transactional
    public Mono<Void> deleteById(Integer id) {
        return repository.deleteById(id).then();
    }

    @Override
    public Mono<AppointmentTypeDTO> findById(Integer id) {
        return repository.findById(id).map(e -> AppointmentTypeDTO.builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .duration(e.getDuration())
                .color(e.getColor())
                .build());
    }

    @Override
    public Flux<AppointmentTypeDTO> all() {
        return repository.findAll().map(e -> AppointmentTypeDTO.builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .duration(e.getDuration())
                .color(e.getColor())
                .build());
    }
}
