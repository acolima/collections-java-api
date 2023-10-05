package main.map.Search.ProductStock;

import java.util.HashMap;
import java.util.Map;

public class ProductStock {
    private Map<Long, Product> productStock;

    public ProductStock() {
        productStock = new HashMap<>();
    }

    public void addProduct(long code, String name, double price, int quantity) {
        Product newProduct = new Product(name, price, quantity);
        productStock.put(code, newProduct);
    }

    public void displayProducts() {
        if(!productStock.isEmpty()) {
            System.out.println(productStock);
        } else {
            System.out.println("There are no products in stock");
        }
    }

    public double getTotalStockPrice() {
        double totalPrice = 0;

        for(Product p : productStock.values()) {
            totalPrice += p.getPrice() * p.getQuantity();
        }

        return totalPrice;
    }

    public Product getMoreExpensiveProduct() {
        Product product = null;
        double biggestPrice = Integer.MIN_VALUE;

        if(!productStock.isEmpty()) {
            for (Product p : productStock.values()) {
                if(p.getPrice() > biggestPrice) {
                    biggestPrice = p.getPrice();
                    product = p;
                }
            }
        }

        return product;
    }

    public Product getCheaperProduct() {
        Product product = null;
        double smallestPrice = Integer.MAX_VALUE;

        if(!productStock.isEmpty()) {
            for (Product p : productStock.values()) {
                if(p.getPrice() < smallestPrice) {
                    smallestPrice = p.getPrice();
                    product = p;
                }
            }
        }

        return product;
    }

    public Product getProductByQuantity() {
        Product product = null;
        double totalPrice = Integer.MIN_VALUE;

        if(!productStock.isEmpty()) {
            for (Product p : productStock.values()) {
                double total = p.getPrice() * p.getQuantity();
                if(total > totalPrice) {
                    totalPrice = total;
                    product = p;
                }
            }
        }

        return product;
    }

    public static void main(String[] args) {
        ProductStock productList = new ProductStock();

        productList.addProduct(1L, "Product A", 15, 2);
        productList.addProduct(2L, "Product B", 10, 5);
        productList.addProduct(3L, "Product C", 5, 4);
        productList.addProduct(4L, "Product D", 20, 2);

        System.out.println("PRODUCTS IN STOCK");
        productList.displayProducts();

        System.out.println("\nTotal price in stock: $" + productList.getTotalStockPrice());

        System.out.println("\nMore expensive product: " + productList.getMoreExpensiveProduct());
        System.out.println("\nCheaper product: " + productList.getCheaperProduct());

        System.out.println("\nProduct with more stock " + productList.getProductByQuantity());
    }
}
