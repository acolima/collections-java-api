package main.list.BasicOperations.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> cart;

    public Cart() {
        cart = new ArrayList<>();
    }

    public void addItem(String name, double price, int quantity){
        Item newItem = new Item(name, price, quantity);

        cart.add(newItem);
    }

    public void removeItem(String name){
        cart.removeIf(item -> item.getName().equalsIgnoreCase(name));
    }

    public double getTotalPrice() {
        double total = 0;
        for(Item item : cart) {
            total += item.getPrice() * item.getQuantity();
        }

        return total;
    }

    public void showItems() {
        System.out.println(cart);
    }

    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addItem("Book", 39.90, 2);
        cart.addItem("Pencil", 5.90, 4);
        cart.showItems();

        cart.removeItem("Pencil");
        cart.showItems();

        System.out.printf("Total price: R$%.2f %n", cart.getTotalPrice());
    }
}
