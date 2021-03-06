package model;

import exception.DuplicateCountryException;

import java.util.ArrayList;
import java.util.List;

public class Country implements Comparable<Country> {
    private String countryName;
    private String capital;
    private String continent;

    public Country() {
    }

    public Country(String countryName, String capital, String continent) {
        this.countryName = countryName;
        this.capital = capital;
        this.continent = continent;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public static List<Country> addCountry(Country newCountry, List<Country> countries) throws DuplicateCountryException {
        List<Country> allCountries = new ArrayList<>();
        boolean exists = false;
        if (countries == null) {
            allCountries.add(newCountry);
        } else {
            for (Country country : countries) {
                if (newCountry.getCountryName().equals(country.getCountryName())) {
                    allCountries.add(newCountry);
                    exists = true;
                } else {
                    allCountries.add(country);
                }
            }
            if (!exists) {
                allCountries.add(newCountry);
            } else {
                throw new DuplicateCountryException();
            }
        }
        return allCountries;
    }

    @Override
    public int compareTo(Country country) {
        String name = country.getCountryName();
        return this.countryName.compareTo(name);
    }
}
