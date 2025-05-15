package com.company.school.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CLASSROOM", indexes = {
        @Index(name = "IDX_CLASSROOM_SCHOOL", columnList = "SCHOOL_ID")
})
@Entity
public class Classroom {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "SCHOOL_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private School school;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Composition
    @OneToMany(mappedBy = "classroom")
    private List<Student> student;

    @Composition
    @OneToMany(mappedBy = "classroom")
    private List<Teacher> teacher;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}