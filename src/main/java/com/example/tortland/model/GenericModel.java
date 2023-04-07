package com.example.tortland.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class GenericModel {

    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    private Long id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_when")
    private Date createdWhen;

    @Column(name = "updated_when")
    private Date updatedWhen;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "deleted_when")
    private Date deletedWhen;

    @Column(name = "deleted_by")
    private String deletedBy;

    @PrePersist
    private void init() {
//        createdWhen = new Date(System.currentTimeMillis());
        createdWhen = Date.valueOf(LocalDate.now());
    }
}
