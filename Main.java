//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.function.Supplier;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.function.Consumer;
import java.util.Random;

public class Main {

    public static void main(String[] args) {


        Supplier<Integer> ticketMachine = () -> {
            Random random = new Random();
            return random.nextInt(100) + 1;
        };


        Predicate<CoffeeOrder> isIcedDrink =
                order -> order.isIced == true;


        Function<CoffeeOrder, Double> baseCashier = order -> {

            double price = order.basePrice;

            if (isIcedDrink.test(order)) {
                price = price + 0.75;
            }

            return price;
        };


        UnaryOperator<Double> happyHourDiscount =
                price -> price * 0.8;


        Consumer<CoffeeOrder> baristaPrinter = order -> {

            String temperature;

            if (order.isIced) {
                temperature = "(ICED)";
            } else {
                temperature = "(HOT)";
            }

            System.out.println("----- BARISTA TICKET -----");
            System.out.println("Customer: " + order.customerName);
            System.out.println("Drink: " + order.drinkType + " " + temperature);
            System.out.println("--------------------------");
        };


        CoffeeOrder order = new CoffeeOrder(
                "Alice",
                "Iced Matcha Latte",
                true,
                5.00
        );


        int ticketNumber = ticketMachine.get();

        System.out.println("Ticket Number: " + ticketNumber);

      
        double finalPrice =
                baseCashier
                        .andThen(happyHourDiscount)
                        .apply(order);

        System.out.printf("Final Price: $%.2f%n", finalPrice);


        baristaPrinter.accept(order);
    }
}
