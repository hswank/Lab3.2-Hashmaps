import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class GuenthersMarket {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean customerExit = false;
		
		ArrayList<String> product = new ArrayList<String>();
		product.add("apple");
		product.add("banana");
		product.add("cauliflower");
		product.add("dragonfruit");
		product.add("Elderberry");
		product.add("figs");
		product.add("grapefruit");
		product.add("honeydew");

		ArrayList<Double> price = new ArrayList<Double>();
		price.add(0.99);
		price.add(0.59);
		price.add(1.59);
		price.add(2.19);
		price.add(1.79);
		price.add(2.09);
		price.add(1.99);
		price.add(3.49);

		printMenu(product, price);

		HashMap<String, Double> customerOrder = new HashMap<String, Double>();

		while (!customerExit) {

			System.out.print("What item number would you like to order?");
			int itemNum = input.nextInt();
			if (itemNum > 0 && itemNum < 9) {
				customerOrder.put(product.get(itemNum - 1), price.get(itemNum - 1));
				System.out.printf("Adding %s to cart at $%.2f%n%n", product.get(itemNum-1), price.get(itemNum - 1));

				System.out.print("Would you like to order anything else (y/n)?");
				String userCont = input.next();
				if (userCont.equalsIgnoreCase("n")) {
					customerExit = true;
				}
			} else {
				System.out.printf("Sorry, we don't have those.  Please try again.%n%n");
			}
			
			printMenu(product, price);

		}
		System.out.println("Thanks for your order!");
		System.out.println("Here's what you got:");
		
		for (String key: customerOrder.keySet()) {
			System.out.printf("%-18s$%.2f%n", key, customerOrder.get(key));
		}
		
		System.out.println();
		avgPrice(customerOrder);
		highestPrice(customerOrder);
		lowestPrice(customerOrder);
		
		input.close();
	}

	public static void printMenu(ArrayList<String> product, ArrayList<Double> price) {
		System.out.printf("Welcome To Guenther's Market!%n%n%-20s%s%n", "Item", "Price");
		System.out.println("==============================");

		for (int i = 0; i < product.size(); i++) {
			System.out.printf("%d %-17s $%.2f%n", i + 1, product.get(i), price.get(i));
		}
		
		System.out.println();
	}
	
	public static void avgPrice(HashMap<String, Double> customerOrder) {
		double sum = 0;
		for (String key: customerOrder.keySet()) {
			sum += customerOrder.get(key);
		}
		double total = sum / customerOrder.size();
		System.out.printf("Average price per item in order was $%.2f%n", total);
	}
	
	public static void highestPrice(HashMap<String, Double> customerOrder) {
		double highest = 0;
		for (String key: customerOrder.keySet()) {
			if (customerOrder.get(key) > highest) {
				highest = customerOrder.get(key);
			}
		}
		System.out.printf("Your highest priced item was: $%.2f%n", highest);

	}
	
	public static void lowestPrice(HashMap<String, Double> customerOrder) {
		double min = Collections.min(customerOrder.values());
		System.out.printf("Your lowest priced item was: $%.2f%n", min);
	}

}
