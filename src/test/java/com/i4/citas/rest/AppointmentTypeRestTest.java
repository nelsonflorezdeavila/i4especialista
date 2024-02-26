package com.i4.citas.rest;

import com.i4.citas.entity.dto.AppointmentTypeDTO;
import com.i4.citas.entity.model.AppointmentType;
import com.i4.citas.repository.AppointmentTypeRepository;
import com.i4.citas.service.impl.AppointmentTypeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.server.reactive.ChannelSendOperator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.function.Function;

import static org.mockito.Mockito.*;

class AppointmentTypeRestTest {

    /**
     * Method under test: {@link AppointmentTypeRest#save(AppointmentTypeDTO)}
     */
    @Test
    void testSave() {
        // Arrange
        AppointmentTypeRepository repository = mock(AppointmentTypeRepository.class);
        AppointmentType buildResult = AppointmentType.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .duration((short) 1)
                .id(1)
                .name("Name")
                .build();
        Mono<AppointmentType> justResult = Mono.just(buildResult);
        when(repository.save(Mockito.any())).thenReturn(justResult);
        AppointmentTypeRest appointmentTypeRest = new AppointmentTypeRest(new AppointmentTypeServiceImpl(repository));

        // Act
        appointmentTypeRest
                .save(new AppointmentTypeDTO(1, "Name", "The characteristics of someone or something", (short) 1, "Color"));

        // Assert
        verify(repository).save(Mockito.any());
    }

    /**
     * Method under test: {@link AppointmentTypeRest#deleteById(Integer)}
     */
    @Test
    void testDeleteById() {
        // Arrange
        AppointmentTypeRepository repository = mock(AppointmentTypeRepository.class);
        Flux<?> source = Flux.fromIterable(new ArrayList<>());
        when(repository.deleteById(Mockito.<Integer>any()))
                .thenReturn(new ChannelSendOperator<>(source, mock(Function.class)));

        // Act
        (new AppointmentTypeRest(new AppointmentTypeServiceImpl(repository))).deleteById(1);

        // Assert
        verify(repository).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link AppointmentTypeRest#findById(Integer)}
     */
    @Test
    void testFindById() {
        // Arrange
        AppointmentTypeRepository repository = mock(AppointmentTypeRepository.class);
        AppointmentType buildResult = AppointmentType.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .duration((short) 1)
                .id(1)
                .name("Name")
                .build();
        Mono<AppointmentType> justResult = Mono.just(buildResult);
        when(repository.findById(Mockito.<Integer>any())).thenReturn(justResult);

        // Act
        (new AppointmentTypeRest(new AppointmentTypeServiceImpl(repository))).findById(1);

        // Assert
        verify(repository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link AppointmentTypeRest#all()}
     */
    @Test
    void testAll() {
        // Arrange
        AppointmentTypeRepository repository = mock(AppointmentTypeRepository.class);
        Flux<AppointmentType> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(repository.findAll()).thenReturn(fromIterableResult);

        // Act
        (new AppointmentTypeRest(new AppointmentTypeServiceImpl(repository))).all();

        // Assert
        verify(repository).findAll();
    }
}
