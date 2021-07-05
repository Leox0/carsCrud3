package pl.pcz.carsCrud3.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarView {

    private Long id;

    private String brand;

    private String model;

    private String year;

    private String username;

    private String surname;

    private int age;
}
