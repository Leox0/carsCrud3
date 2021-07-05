package pl.pcz.carsCrud3.dao;

import org.springframework.stereotype.Service;
import pl.pcz.carsCrud3.dto.CarRequest;
import pl.pcz.carsCrud3.dto.CarView;
import pl.pcz.carsCrud3.entity.Car;
import pl.pcz.carsCrud3.repository.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final RestTemplateService restTemplateService;


    public CarService(CarRepository carRepository, RestTemplateService restTemplateService) {
        this.carRepository = carRepository;
        this.restTemplateService = restTemplateService;
    }

    public List<CarView> getAllCars() {
        return carRepository.findAll().stream()
                .map(this::convertCarToCarView)
                .collect(Collectors.toList());
    }

    public List<CarView> findCarsByUserId(Long userId) {
        return carRepository.findCarByUserId(userId)
                .stream()
                .map(e -> convertCarToCarView(e))
                .collect(Collectors.toList());
    }

    public CarView createCar(CarRequest carRequest) {
        Car car = Car.builder()
                .brand(carRequest.getBrand())
                .model(carRequest.getModel())
                .year(carRequest.getYear())
                .username(restTemplateService.getUserInformation(carRequest.getUserId()).getName())
                .surname(restTemplateService.getUserInformation(carRequest.getUserId()).getSurname())
                .age(restTemplateService.getUserInformation(carRequest.getUserId()).getAge())
                .userId(carRequest.getUserId())
                .build();
        carRepository.save(car);
        return convertCarToCarView(car);
    }

    public CarView convertCarToCarView(Car car) {
        return CarView.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .username(car.getUsername())
                .surname(car.getSurname())
                .age(car.getAge())
                .build();
    }
}
