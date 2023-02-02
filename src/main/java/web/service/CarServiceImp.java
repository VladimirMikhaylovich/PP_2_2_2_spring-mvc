package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CarServiceImp implements CarService {

    List<Car> carList = Stream.of(new Car("Ford", "White", "1998")
                    , new Car("Audi", "green", "2005")
                    , new Car("Mercedes-Benz", "Silver", "2014")
                    , new Car("Lada", "Red", "2002")
                    , new Car("BMW", "Blue", "1990"))
            .collect(Collectors.toList());

    @Override
    public List<Car> getAllCars() {
        return carList;
    }

    @Override
    public List<Car> getAllCarsByCount(int count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
