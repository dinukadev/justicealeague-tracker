package com.justiceleague.justiceleaguetracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * This class holds the information about a given super hero.
 *
 * @author dinuka
 */
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuperHero implements Serializable {

    private static final long serialVersionUID = -473675443402321380L;

    @JsonProperty("name")
    private String name;

    @JsonProperty("power")
    private List<String> superPower = new LinkedList<>();

    @JsonProperty("primaryLocation")
    private String primaryLocation;

    public SuperHero(@JsonProperty("name") String name, @JsonProperty("power") List<String> superPower,
                     @JsonProperty("primaryLocation") String primaryLocation) {
        this.name = name;
        this.superPower = superPower;
        this.primaryLocation = primaryLocation;
    }

    public String getName() {
        return name;
    }

    public List<String> getSuperPower() {
        return superPower;
    }

    public String getPrimaryLocation() {
        return primaryLocation;
    }


}
