package io.gihub.jonasnascc.HealthClinic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @UuidGenerator
    private String id;

    private String crm;

    private String cnpj;

    private String name;

    private String surname;

    private String email;

    private String phone;

    private String address;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Appointment> appointments;

    public Doctor(String crm, String cnpj, String name, String surname, String email, String phone, String address) {
        this.crm = crm;
        this.cnpj = cnpj;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
