package com.company.school.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@JmixEntity
@Table(name = "STUDENT_COURSE", indexes = {
        @Index(name = "IDX_STUDENT_COURSE_STUDENT", columnList = "STUDENT_ID"),
        @Index(name = "IDX_STUDENT_COURSE_COURSE", columnList = "COURSE_ID")
})
@Entity
public class StudentCourse {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Student student;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @JoinColumn(name = "COURSE_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Course course;

    @Column(name = "GRADE", nullable = false)
    @NotNull
    private Integer grade;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
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