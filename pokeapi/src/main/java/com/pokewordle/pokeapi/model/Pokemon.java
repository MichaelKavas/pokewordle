package com.pokewordle.pokeapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number")
    private Integer number;
    
    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "gen")
    private Integer gen;

    @Column(name = "type1")
    private String type1;

    @Column(name = "type2")
    private String type2;

    @Column(name = "height")
    private Integer height;

    @Column(name = "weight")
    private Integer weight;

    public Pokemon() {
    }

    public Pokemon(Integer number, String name, String image, Integer gen, String type1, String type2, Integer height, Integer weight) {
        this.number = number;
        this.name = name;
        this.image = image;
        this.gen = gen;
        this.type1 = type1;
        this.type2 = type2;
        this.height = height;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getGen() {
        return gen;
    }

    public void setGen(Integer gen) {
        this.gen = gen;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pokemon [id=" + id + ", number=" + number + ", name=" + name + ", image=" + image + ", gen=" + gen + ", type1=" + type1 + ", type2=" + type2 + ", height=" + height + ", weight=" + weight + "]";
    }
}
