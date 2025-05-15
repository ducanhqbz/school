package com.company.school.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "STUDENT", indexes = {
        @Index(name = "IDX_STUDENT_CLASSROOM", columnList = "CLASSROOM_ID")
})
@Entity
public class Student {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "DOB", nullable = false)
    @NotNull
    private Date dob;

    @Column(name = "NATIONAL_ID", nullable = false)
    @NotNull
    private String nationalID;

    @Column(name = "VERSION", nullable = false)
    @Version
    private Integer version;

    @Column(name = "ADDRESS", nullable = false)
    @NotNull
    private String address;

    @Column(name = "PHONENUMBER", nullable = false)
    @NotNull
    private String phonenumber;

    @JoinColumn(name = "CLASSROOM_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Classroom classroom;
@Composition
    @OneToMany(mappedBy = "student")
    private List<StudentCourse> studentCourse;

    public List<StudentCourse> getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(List<StudentCourse> studentCourse) {
        this.studentCourse = studentCourse;
    }


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

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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