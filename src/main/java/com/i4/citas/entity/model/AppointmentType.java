package com.i4.citas.entity.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("appointment_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AppointmentType implements Persistable<Integer> {

    @Id
    @Column("id")
    private Integer id;

    @Column("name_")
    private String name;

    @Column("description")
    private String description;

    @Column("duration_minutes")
    private short duration;

    @Column("color_hex_code")
    private String color;

    @Transient
    @Builder.Default
    private boolean isNewEntry = true;

    @Override
    public boolean isNew() {
        return this.isNewEntry || id == null;
    }
}
