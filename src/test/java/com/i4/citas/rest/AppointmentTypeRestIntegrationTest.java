package com.i4.citas.rest;

import com.i4.citas.entity.dto.AppointmentTypeDTO;
import com.i4.citas.service.AppointmentTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = AppointmentTypeRest.class)
class AppointmentTypeRestIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private AppointmentTypeService service;

    private AppointmentTypeDTO dto;

    @BeforeEach
    public void setUp() {
        dto = new AppointmentTypeDTO(1, "Test", "The characteristics of someone or something", (short) 5, "Color");
    }

    @Test
    void save_shouldReturnStatusCreated() {
        given(service.save(dto)).willReturn(Mono.empty());

        webTestClient.post()
                .uri("/api/v1/appointment-types")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(dto), AppointmentTypeDTO.class)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void deleteById_shouldReturnStatusNoContent() {
        given(service.deleteById(1)).willReturn(Mono.empty());

        webTestClient.delete()
                .uri("/api/v1/appointment-types/1")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void findById_shouldReturnStatusOk() {
        given(service.findById(1)).willReturn(Mono.just(dto));

        webTestClient.get()
                .uri("/api/v1/appointment-types/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(1)
                .jsonPath("$.name").isEqualTo("Test");
    }

    @Test
    void all_shouldReturnStatusOk() {
        given(service.all()).willReturn(Flux.fromIterable(List.of(dto)));

        webTestClient.get()
                .uri("/api/v1/appointment-types")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].id").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo("Test");
    }
}
