package com.i4.citas.service.impl;

import com.i4.citas.entity.dto.AppointmentTypeDTO;
import com.i4.citas.entity.model.AppointmentType;
import com.i4.citas.repository.AppointmentTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.server.reactive.ChannelSendOperator;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.*;

import java.util.ArrayList;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AppointmentTypeServiceImpl.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AppointmentTypeServiceImplTest {

    @MockBean
    private AppointmentTypeRepository appointmentTypeRepository;

    @Autowired
    private AppointmentTypeServiceImpl appointmentTypeServiceImpl;

    /**
     * Method under test:
     * {@link AppointmentTypeServiceImpl#save(AppointmentTypeDTO)}
     */
    @Test
    void testSave() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
        AppointmentTypeServiceImpl appointmentTypeServiceImpl = new AppointmentTypeServiceImpl(repository);

        // Act
        appointmentTypeServiceImpl
                .save(new AppointmentTypeDTO(1, "Name", "The characteristics of someone or something", (short) 1, "Color"));

        // Assert
        verify(repository).save(Mockito.any());
    }

    /**
     * Method under test: {@link AppointmentTypeServiceImpl#deleteById(Integer)}
     */
    @Test
    void testDeleteById() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        AppointmentTypeRepository repository = mock(AppointmentTypeRepository.class);
        Flux<?> source = Flux.fromIterable(new ArrayList<>());
        when(repository.deleteById(Mockito.<Integer>any()))
                .thenReturn(new ChannelSendOperator<>(source, mock(Function.class)));

        // Act
        (new AppointmentTypeServiceImpl(repository)).deleteById(1);

        // Assert
        verify(repository).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link AppointmentTypeServiceImpl#findById(Integer)}
     */
    @Test
    void testFindById() {
        // Arrange
        AppointmentType buildResult = AppointmentType.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .duration((short) 1)
                .id(1)
                .name("Name")
                .build();
        Mono<AppointmentType> justResult = Mono.just(buildResult);
        when(appointmentTypeRepository.findById(Mockito.<Integer>any())).thenReturn(justResult);

        // Act
        appointmentTypeServiceImpl.findById(1);

        // Assert
        verify(appointmentTypeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link AppointmentTypeServiceImpl#findById(Integer)}
     */
    @Test
    void testFindById2() {
        // Arrange
        Mono<AppointmentType> mono = mock(Mono.class);
        Mono<Object> justResult = Mono.just("Data");
        when(mono.map(Mockito.<Function<AppointmentType, Object>>any())).thenReturn(justResult);
        when(appointmentTypeRepository.findById(Mockito.<Integer>any())).thenReturn(mono);

        // Act
        Mono<AppointmentTypeDTO> actualFindByIdResult = appointmentTypeServiceImpl.findById(1);

        // Assert
        verify(appointmentTypeRepository).findById(Mockito.<Integer>any());
        verify(mono).map(Mockito.<Function<AppointmentType, Object>>any());
        assertSame(justResult, actualFindByIdResult);
    }

    /**
     * Method under test: {@link AppointmentTypeServiceImpl#all()}
     */
    @Test
    void testAll() {
        // Arrange
        Flux<AppointmentType> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(appointmentTypeRepository.findAll()).thenReturn(fromIterableResult);

        // Act
        appointmentTypeServiceImpl.all();

        // Assert
        verify(appointmentTypeRepository).findAll();
    }

    /**
     * Method under test: {@link AppointmentTypeServiceImpl#all()}
     */
    @Test
    void testAll2() {
        // Arrange
        DirectProcessor<AppointmentType> createResult = DirectProcessor.create();
        when(appointmentTypeRepository.findAll()).thenReturn(createResult);

        // Act
        appointmentTypeServiceImpl.all();

        // Assert
        verify(appointmentTypeRepository).findAll();
    }

    /**
     * Method under test: {@link AppointmentTypeServiceImpl#all()}
     */
    @Test
    void testAll3() {
        // Arrange
        Flux<AppointmentType> flux = mock(Flux.class);
        Flux<Object> fromIterableResult = Flux.fromIterable(new ArrayList<>());
        when(flux.map(Mockito.<Function<AppointmentType, Object>>any())).thenReturn(fromIterableResult);
        when(appointmentTypeRepository.findAll()).thenReturn(flux);

        // Act
        Flux<AppointmentTypeDTO> actualAllResult = appointmentTypeServiceImpl.all();

        // Assert
        verify(appointmentTypeRepository).findAll();
        verify(flux).map(Mockito.<Function<AppointmentType, Object>>any());
        assertSame(fromIterableResult, actualAllResult);
    }
}
