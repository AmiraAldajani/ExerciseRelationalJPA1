package com.example.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {

    @Id
    @NotNull(message = "Enter an ID")
    private Integer id;

    @NotEmpty(message = "Name cant be null")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "Enter the age")
    @Min(value = 22, message = "Age must be 22 or more")
    @Column(columnDefinition = "int not null")
    private Integer age;

    @NotEmpty(message = "Enter the email")
    @Email(message = "Email must be a valid email format")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;

    @NotNull(message = "Enter the salary")
    @Positive(message = "Salary must be more than 0")
    @Column(columnDefinition = "double not null")
    private Double salary;

    // orphanRemoval: when teacher.setAddress(null) is saved, the address row gets deleted
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher", orphanRemoval = true)
    @PrimaryKeyJoinColumn // two tables 1 ID
    private Address address;

}
