package umbcs680.singleton;

import java.util.Iterator;
import java.util.LinkedList;

     class SingletonPrimeGenerator {
        private static SingletonPrimeGenerator instance;
        private long from, to;
        private LinkedList<Long> primes = new LinkedList<>();

        SingletonPrimeGenerator(long from, long to) {
            if (from >= 1 && to > from) {
                this.from = from;
                this.to = to;
            } else {
                throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
            }
        }

        public static SingletonPrimeGenerator getInstance(long from, long to) {
            if (instance == null) {
                instance = new SingletonPrimeGenerator(from, to);
            }
            return instance;
        }

        public LinkedList<Long> getPrimes() {
            return primes;
        }

        private boolean isEven(long n) {
            return n % 2 == 0;
        }

        private boolean isPrime(long n) {
            if (n <= 1) {
                return false;
            }
            if (n > 2 && isEven(n)) {
                return false;
            }
            long i;
            for (i = (long) Math.sqrt(n); n % i != 0 && i >= 1; i--) {}
            return i == 1;
        }

        public void generatePrimes() {
            for (long n = from; n <= to; n++) {
                if (isPrime(n)) {
                    primes.add(n);
                }
            }
        }

        public static void main(String[] args) {
            // Create a singleton instance with a range of 1 to 100
            SingletonPrimeGenerator generator = SingletonPrimeGenerator.getInstance(1, 100);

            // Generate primes within the specified range
            generator.generatePrimes();

            // Get the list of primes and print them
            LinkedList<Long> primes = generator.getPrimes();
            Iterator<Long> iterator = primes.iterator();
            System.out.print("Primes between 1 and 100: ");
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }
