package pl.pcz.carsCrud3.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CarRequest {

    private String brand;

    private String model;

    private String year;

    private Long userId;
}
