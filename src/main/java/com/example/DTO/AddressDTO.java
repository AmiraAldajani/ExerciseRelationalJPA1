package com.example.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    @NotNull(message = "Enter the teacher ID")
    private Integer teacher_id;

    @NotEmpty(message = "Enter the area")
    @Size(max = 30, message = "Area can't be more than 30 characters")
    private String area;

    @NotEmpty(message = "Enter the street")
    @Size(max = 30, message = "Street can't be more than 30 characters")
    private String street;

    @NotNull(message = "Enter the building number")
    @Positive(message = "Building number must be more than 0")
    private Integer buildingNumber;

}
