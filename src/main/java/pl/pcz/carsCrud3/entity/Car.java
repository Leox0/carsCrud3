package pl.pcz.carsCrud3.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String year;
    @NotNull
    private String username;
    @NotNull
    private String surname;
    @NotNull
    private int age;
    @NotNull
    private Long userId;

}
