package java8;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test
public class TestOrders {
    public void checkOrders(){
        Order firstOrder = new Order(250, false, "Anton");
        Order secondOrder = new Order(150, true, "Oleg");
        Order thirdOrder = new Order(440, false, "Igor");
        Order fourthOrder = new Order(50, true, "Alex");
        Order fifthOrder = new Order(550, true, "Irina");
        Order sixthOrder = new Order(690, false, "Fred");
        Order seventhOrder = new Order(770, false, "Jack");
        Order eighthOrder = new Order(25, true, "Lina");

        List<Order> orderList = Arrays.asList(firstOrder, secondOrder, thirdOrder, fourthOrder,
                fifthOrder, sixthOrder, seventhOrder, eighthOrder);

        printConditions(orderList, new IOrderCheck() {
            @Override
            public boolean checkConditions(Order order) {
                return order.isVegan;
            }
        });
    }

    public void printConditions(List<Order> orderList, IOrderCheck IOrderCheck){
        for (Order order: orderList) {
            if (IOrderCheck.checkConditions(order)){
                System.out.println(order);
            }
        }
    }
}
