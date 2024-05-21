package com.group.libraryapp.domain.fruit;

import com.group.libraryapp.dto.fruit.request.FruitAddRequest;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20, name="name")
    private String name;

    @Column(nullable = false, name="warehousingDate")
    private LocalDate warehousingDate;

    @Column(nullable = false, name="price")
    private long price;

    @Column(nullable = false, name="status")
    private int status;

    protected Fruit() { }

    public Fruit(long id, String name, LocalDate warehousingDate, long price, int status) {
        this.id = id;
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.status = status;
    }

    public Fruit(FruitAddRequest request) {
        if (request.getName() == null || request.getName().isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다", name));
        }
        this.name = request.getName();
        this.warehousingDate = request.getWarehousingDate();
        this.price = request.getPrice();
        this.status = 1;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }

    public void updateStatus(int status) {
        this.status = status;
    }
}
