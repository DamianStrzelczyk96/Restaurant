package org.restaurant.models.services.dao;

import org.restaurant.models.Meal;
import org.restaurant.models.OrderR;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class OrderDaoImpl implements OrderDao {

    private List<OrderR> orderList;

    public OrderDaoImpl() {
        orderList = new ArrayList<>();
    }

    @Override
    public List<OrderR> getAllOrders() {
        return orderList;
    }

    @Override
    public void addOrder(OrderR order) {
        orderList.add(order);
    }

    @Override
    public void removeOrder(OrderR order) {
        for (OrderR order1 : orderList) {
            if (order1.equals(order)){
                orderList.remove(order);
                break;
            }
        }
    }

    @Override
    public void addMealToOrder(OrderR order, Meal meal) {
        //todo repair


        ArrayList<Meal> ourMeals = (ArrayList<Meal>) order.getMealList();
        ourMeals.add(meal);
        System.out.println(ourMeals);
        order.setMealList(ourMeals);
    }

    @Override
    public void removeMealFromOrder(OrderR order, Meal meal) {
        ArrayList<Meal> ourMeals = (ArrayList<Meal>) order.getMealList();
        ourMeals.remove(meal);
        order.setMealList(ourMeals);
        //todo implement
    }

    @Override
    public boolean checkIfMealAppearInOurOrder(OrderR order, Meal meal){
        //todo repair
        for (int i = 0; i < order.getMealList().size(); i++) {
            if (order.getMealList().get(i).equals(meal)){
                return true;
            }
        }
        return false;
    }
}
