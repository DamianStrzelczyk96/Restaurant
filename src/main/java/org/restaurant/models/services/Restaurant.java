package org.restaurant.models.services;

import org.restaurant.models.Meal;
import org.restaurant.models.MealDatabase;
import org.restaurant.models.OrderR;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Restaurant {

    private List<Meal> menu = new MealDatabase().getMeals();

    public boolean checkIfMealExist(String mealName){
        for (Meal meal : menu) {
            if (mealName.equals(meal.getName())){
                return true;
            }
        }
        return false;
    }

     public int calculateOrderPrice(OrderR orderR){
        int sum = 0;
        ArrayList<Meal> menu = new ArrayList<>(orderR.getMealList());
         for (Meal meal:menu
              ) { sum = sum + meal.getPrice();

         }
        //todo implement
        return sum;
    }

    public Meal getMeal(String mealName){
        Meal test = new Meal();
        MealDatabase mealDatabase = new MealDatabase();
        for (Meal meal:mealDatabase.getMeals()
             ) {
            if (mealName.equals(meal.getName())) {
              test = meal;
            }

        }
        //todo implement
        return test;
    }

    public List<Meal> getMenu() {
        return menu;
    }
}
