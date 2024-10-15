package com.salomao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "service_sequence", sequenceName = "service_sequence", allocationSize=1)
public class UsersModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_sequence")
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String phone;
    private String registration;

}
