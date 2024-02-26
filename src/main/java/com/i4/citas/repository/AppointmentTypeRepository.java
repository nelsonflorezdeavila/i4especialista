package com.i4.citas.repository;

import com.i4.citas.entity.model.AppointmentType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentTypeRepository extends ReactiveCrudRepository<AppointmentType, Integer> {
}
