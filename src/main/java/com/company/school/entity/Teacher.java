package com.company.school.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JmixEntity
@Table(name = "TEACHER", indexes = {
        @Index(name = "IDX_TEACHER_CLASSROOM", columnList = "CLASSROOM_ID")
})
@Entity
public class Teacher {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "AGE", nullable = false)
    @NotNull
    private Integer age;

    @Column(name = "ADDRESS", nullable = false)
    @NotNull
    private String address;

    @Column(name = "PHONENUMBER", nullable = false)
    @NotNull
    private String phonenumber;

    @JoinColumn(name = "CLASSROOM_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Classroom classroom;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}