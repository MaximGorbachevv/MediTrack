package com.poject2.meditrack.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "full_name")
    private String fullname;
    @Column(name = "cabinet")
    private String cabinet;
    @Column(name = "specialty")
    private String specialty;

    public Doctor() {}
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}

