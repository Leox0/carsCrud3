package pl.pcz.carsCrud3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pcz.carsCrud3.dao.CarService;
import pl.pcz.carsCrud3.dto.CarRequest;
import pl.pcz.carsCrud3.dto.CarView;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarController {

    public final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarView>> getAllCars() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carService.getAllCars());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CarView>> getCarsByUserId(@PathVariable Long userId) {
        List<CarView> carList = carService.findCarsByUserId(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(carList);
    }

    @PostMapping
    public ResponseEntity<CarView> createCar(@RequestBody CarRequest carRequest) {
        CarView carView = carService.createCar(carRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carView);

    }


}
