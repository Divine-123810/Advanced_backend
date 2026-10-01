public class CoffeeOrder {


        String customerName;
        String drinkType;
        boolean isIced;
        double basePrice;

        public CoffeeOrder(String customerName, String drinkType,
                           boolean isIced, double basePrice) {
            this.customerName = customerName;
            this.drinkType = drinkType;
            this.isIced = isIced;
            this.basePrice = basePrice;
        }
    }

