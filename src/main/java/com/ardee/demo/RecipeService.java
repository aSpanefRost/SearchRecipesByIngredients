package com.ardee.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository repo;

    public List<Recipe> listAll() {
        return  repo.findAll();
    }

public List<Recipe> listSelective(Set<String> ingredients) {
    System.out.println(ingredients);
        int size_ingredient=ingredients.size();
        List<Recipe> rec=repo.findAll();
        for(String s:ingredients) {
            System.out.println(s);
            int size = rec.size();
            for (int i = 0; i < size; i++) {
                String ss = rec.get(i).getIngredients();
                if (ss != null && !ss.equals("")) {
                    if (ss.contains(s)) {
                    }
                    else
                    {
                        rec.remove(i);
                        i--;
                        size--;
                    }
                }
                else
                {
                    rec.remove(i);
                    i--;
                    size--;
                }
            }
            System.out.println(rec.size());
            if(rec.size()==0) return rec;
        }
       Collections.shuffle(rec);
    List<Recipe> recipe=new ArrayList<>();
    for(int i=0;i<Math.min(500,rec.size());i++)
    {
        recipe.add(rec.get(i));
    }
       return recipe;
    }


}
