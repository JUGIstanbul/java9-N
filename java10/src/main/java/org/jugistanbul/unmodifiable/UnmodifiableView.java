package org.jugistanbul.unmodifiable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 4.04.2020
 **/

public class UnmodifiableView
{

    public static void main(String[] args){

        //Before Java 10
        var cities = getListCities();
        var unmodifiableCities = Collections.unmodifiableList(cities);
        var citiesPopulation = getCitiesPopulationMap(cities);

        cities.set(0, new City("Adana", fetchPopulation("Adana")));
        citiesPopulation.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("\n");

        try {
            unmodifiableCities.forEach(c -> System.out.println(c.getName() + " : " + citiesPopulation.get(c.getName()).intValue()));
        } catch (NullPointerException nlp){
            System.out.println("Thrown NullPointerException! \n");
        }

        //With Java 10
        cities = getListCities();
        unmodifiableCities = List.copyOf(cities);
        var newCitiesPopulation = getCitiesPopulationMap(cities);

        cities.set(0, new City("Adana", fetchPopulation("Adana")));
        unmodifiableCities.forEach(c ->
            System.out.println(c.getName() + " : " + newCitiesPopulation.get(c.getName()).intValue()));


        System.out.println("\n");

        //To Unmodifiable List
        var numberList = Arrays.asList(1, 2, 3, 4)
                .stream().collect(Collectors.toUnmodifiableList());
        var lastCitiesPopulationMap = getCitiesPopulationMap(cities);

        try {
            numberList.add(5);
            lastCitiesPopulationMap.put("Erzurum", 767_484);
        } catch (UnsupportedOperationException ue){
            System.out.println("Thrown UnsupportedOperationException!");
        }

    }

    private static ArrayList<City> getListCities(){
        return new ArrayList<>(List.of(new City("İstanbul", fetchPopulation("İstanbul")),
                new City("İzmir", fetchPopulation("İzmir")), new City("Ankara", fetchPopulation("Ankara"))));
    }

    private static Map<String, Integer> getCitiesPopulationMap(final List<City> cities){
        return cities.stream().collect(Collectors.toMap(City::getName, City::getPopulation));
    }

    private static Integer fetchPopulation(final String city){
        switch (city){
            case "İstanbul":
                return 15_520_00;
            case "İzmir":
                return 4_280_000;
            case "Ankara":
                return 5_445_000;
            default:
                return 0;
        }
    }
}

class City
{
    private String name;
    private Integer population;

    public City(String name, Integer population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
