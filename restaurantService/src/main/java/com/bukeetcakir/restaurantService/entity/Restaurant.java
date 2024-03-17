package com.bukeetcakir.restaurantService.entity;

import com.bukeetcakir.restaurantService.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_generator")
    @SequenceGenerator(name = "restaurant_generator", sequenceName = "restaurant_seq", allocationSize = 1)
    private Long Id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "latitude",nullable = false)
    private double latitude;

    @Column(name = "longitude",nullable = false)
    private double longitude;

    @Column(name = "phone-number",nullable = false)
    private String phoneNumber;

    @Column(name = "address",nullable = false)
    private String address;

    @Column (name = "email",nullable = false)
    @Email
    private String email;

    @Column (name = "score")
    private double score;

    @Enumerated(EnumType.STRING)
    @Column (name = "status",nullable = false)
    private Status status;

}
