package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {
    //Id area street buildingNumber
    //Id name age email salary
    @Id
    private Integer id;

    @NotEmpty(message = "Enter the area")
    @Size(max = 30, message = "Area can't be more than 30 characters")
    @Column(columnDefinition = "varchar(30) not null")
    private String area;

    @NotEmpty(message = "Enter the street")
    @Size(max = 30, message = "Street can't be more than 30 characters")
    @Column(columnDefinition = "varchar(30) not null")
    private String street;

    @NotNull(message = "Enter the building number")
    @Positive(message = "Building number must be more than 0")
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
