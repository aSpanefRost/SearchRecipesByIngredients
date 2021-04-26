package com.ardee.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Recipe_Id;
    private String Title;
    private String Source;
    private String Cuisine;
    private String Ingredients;
    private String Links;

    public Recipe() {
    }

    public Recipe(Long Recipe_Id, String Title, String Source, String Cuisine, String Ingredients, String Links) {
        this.Recipe_Id = Recipe_Id;
        this.Title = Title;
        this.Source = Source;
        this.Cuisine = Cuisine;
        this.Ingredients = Ingredients;
        this.Links = Links;
    }

    public long getRecipe_Id() {
        return Recipe_Id;
    }

    public void setRecipe_Id(Long Recipe_Id) {
        this.Recipe_Id = Recipe_Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public String getCuisine() {
        return Cuisine;
    }

    public void setCuisine(String Cuisine) {
        this.Cuisine = Cuisine;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String Ingredients) {
        this.Ingredients = Ingredients;
    }

    public String getLinks() {
        return Links;
    }

    public void setLinks(String Links) {
        this.Links = Links;
    }
}
