public class TrainConsistApp {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Passenger Bogie
    static class PassengerBogie {
        private String type; // Sleeper, AC Chair, First Class
        private int capacity;
        private int passengers;

        public PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public void addPassengers(int count) {
            if (passengers + count <= capacity) {
                passengers += count;
                System.out.println(count + " passengers added to " + type);
            } else {
                System.out.println("Not enough seats in " + type);
            }
        }

        public int getPassengers() {
            return passengers;
        }
    }

    // Goods Bogie
    static class GoodsBogie {
        private String shape;
        private String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargo) {
            try {
                validateCargo(cargo);
                this.cargo = cargo;
                System.out.println("Cargo assigned: " + cargo + " to " + shape);
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Assignment completed for " + shape + "\n");
            }
        }

        private void validateCargo(String cargo) {
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException(
                        "Unsafe! Petroleum cannot go in Rectangular bogie"
                );
            }
        }

        public String getCargo() {
            return cargo;
        }
    }

    public static void main(String[] args) {

        // Passenger bogie usage
        PassengerBogie p1 = new PassengerBogie("Sleeper", 50);
        p1.addPassengers(30);
        p1.addPassengers(25); // exceeds

        // Goods bogie usage
        GoodsBogie g1 = new GoodsBogie("Cylindrical");
        GoodsBogie g2 = new GoodsBogie("Rectangular");

        g1.assignCargo("Petroleum"); // safe
        g2.assignCargo("Petroleum"); // unsafe
        g2.assignCargo("Coal");      // safe

        System.out.println("System running normally...");
    }
}