package beginner;

import java.util.Scanner;
import java.util.Arrays;

class GreedyKnapsack  {
    private void run() {

        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int W = keyboard.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(keyboard.nextInt(), keyboard.nextInt());
        }
        Arrays.sort(items);
        double result = 0;
        for (Item item : items) {
            if (item.weight <= W) {
                result += item.cost;
                W -= item.weight;
            } else {
                result += (double) item.cost * W / item.weight;
                break;
            }
        }
        System.out.println(result);
    }
    class Item implements Comparable<Item> {
        private int cost;
        private int weight;

        Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        public int compareTo(Item o) {
            double r1 = (double) this.cost / this.weight;
            double r2 = (double) o.cost / o.weight;
            return -Double.compare(r1, r2);
        }


        public String toString() {
            return "Item [" +
                    "cost = " + cost +
                    " weight = " + weight +
                    "]";
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new GreedyKnapsack().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + "ms");
    }


}

