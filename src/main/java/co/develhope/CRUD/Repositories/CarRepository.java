package co.develhope.CRUD.Repositories;

import co.develhope.CRUD.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

}
