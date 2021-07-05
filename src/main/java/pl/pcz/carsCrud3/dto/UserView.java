package pl.pcz.carsCrud3.dto;

import lombok.Data;

@Data
public class UserView {

    private Long id;

    private String name;

    private String surname;

    private int age;
}
