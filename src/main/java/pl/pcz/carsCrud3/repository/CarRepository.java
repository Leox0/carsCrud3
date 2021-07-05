package pl.pcz.carsCrud3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pcz.carsCrud3.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarByUserId(Long userId);
}
