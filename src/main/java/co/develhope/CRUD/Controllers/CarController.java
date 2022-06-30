package co.develhope.CRUD.Controllers;
import co.develhope.CRUD.Entities.Car;
import co.develhope.CRUD.Repositories.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("")
    public Car createAuto(@RequestBody Car car){
        return carRepository.saveAndFlush(car);
    }

    @GetMapping("")
    public List<Car> getAutoList(){
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getAutoSingola(@PathVariable Long id){
        return carRepository.existsById(id) ? carRepository.getReferenceById(id) : new Car();
    }

    @PutMapping("/{id}")
    public Car modificaAuto(@PathVariable Long id, @RequestParam String tipo){
        Car car;
        if (carRepository.existsById(id)) {
            car = carRepository.getReferenceById(id);
            car.setType(tipo);
            car = carRepository.saveAndFlush(car);
        }
        else {
            car = new Car();
        }
        return car;
    }

    @DeleteMapping("/{id}")
    public void deleteSingolaAuto(@PathVariable long id, HttpServletResponse response){
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }
        else {
            response.setStatus(409);
        }
    }

    @DeleteMapping("")
    public void deleteAllCars(){
        carRepository.deleteAll();
    }

}
