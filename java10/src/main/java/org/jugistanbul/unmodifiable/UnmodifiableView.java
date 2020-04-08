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

        var cities = getListCities();
        var unmodifiableCities = Collections.unmodifiableList(cities);
        var citiesPopulation = getCitiesPopulationMap(cities);
        citiesPopulation.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println("\n");

        //This change will affect unmodifiableCities
        cities.set(0, new City("Adana", fetchPopulation("Adana")));

        try {
            unmodifiableCities.forEach(c -> System.out.println(c.getName() + " : " + citiesPopulation.get(c.getName()).intValue()));
        } catch (NullPointerException nlp){
            System.out.println("Thrown NullPointerException! \n");
        }

        //With java 10 for the unmodifiable view collections,
        //three new methods came in the Collectors class
        //nd one method in the List class.
        //Collections returned by them methods are not affected by the change in the backing collection.
        cities = getListCities();
        unmodifiableCities = List.copyOf(cities);
        var newCitiesPopulation = getCitiesPopulationMap(cities);

        cities.set(0, new City("Adana", fetchPopulation("Adana")));
        unmodifiableCities.forEach(c ->
            System.out.println(c.getName() + " : " + newCitiesPopulation.get(c.getName()).intValue()));

        System.out.println("\n");

        var numberList = Arrays.asList(1, 2, 3, 4);
        var numberListView = numberList.stream().collect(Collectors.toUnmodifiableList());
        numberList.set(0, 9);
        numberListView.forEach(System.out::println);
    }

    private static List<City> getListCities(){
        return Arrays.asList(new City("İstanbul", fetchPopulation("İstanbul")),
                new City("İzmir", fetchPopulation("İzmir")), new City("Ankara", fetchPopulation("Ankara")));
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
