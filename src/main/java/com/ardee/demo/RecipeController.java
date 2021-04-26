package com.ardee.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

    @RequestMapping("/search")
    public String homePage(Model model,@Param("keyword") String keyword){

        Set<String> ingredients = new HashSet<>();

        if(keyword==null)
        {
            List<Recipe> listRecipe=service.listAll();
            model.addAttribute("listrecipe", listRecipe);
            model.addAttribute("keyword", keyword);
            System.out.print("Get / ");
            System.out.println(listRecipe.size());
            return "recipes";
        }
        String[] stringarray = keyword.split("\\+");
        for(int i=0; i< stringarray.length; i++)
        {
            ingredients.add(stringarray[i].toLowerCase());
        }
        List<Recipe> listRecipe=service.listSelective(ingredients);
        int n=listRecipe.size();
        System.out.println(n);
        model.addAttribute("listrecipe", listRecipe);
        model.addAttribute("numrecipe",n);
        System.out.print("Get / ");
        System.out.println(listRecipe.size());
        return "recipes";

    }


}
