package com.group.libraryapp.domain.fruit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    List<Fruit> findByName(String name);
    Long countByName(String name);

    List<Fruit> findByPriceGreaterThanEqualAndStatus(long price, int status);
    List<Fruit> findByPriceLessThanEqualAndStatus(long price, int status);
}
