package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

/*
        {
    "name": "Mute",
    "age": 31,
    "car_list" : [
        {
        "name" : "BNW",
        "car_number": "11가 1234"
`2        },
        {
        "name" : "A4",
        "car_number": "22가 3456"
        }
    ]
}
 */
public class PutRequestDTO  // Post와 같음
{
    String name;
    int age;

    @JsonProperty("car_list")
    List<CarDTO> carList;

    @Override
    public String toString()
    {
        return "PutRequestDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public List<CarDTO> getCarList()
    {
        return carList;
    }

    public void setCarList(List<CarDTO> carList)
    {
        this.carList = carList;
    }
}
