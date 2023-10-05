package main.set.Sort.Products;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ProductList {
    private Set<Product> productList;

    public ProductList() {
        productList = new HashSet<>();
    }

    public void addProduct(long code, String name, double price, int quantity) {
        Product newProduct = new Product(code, name, price, quantity);
        productList.add(newProduct);
    }

    public Set<Product> sortByName() {
        Set<Product> sortedProducts = new TreeSet<>(productList);
        return sortedProducts;
    }

    public Set<Product> sortByPrice() {
        Set<Product> sortedProducts = new TreeSet<>(new ComparatorByPrice());
        sortedProducts.addAll(productList);
        return sortedProducts;
    }

    public static void main(String[] args) {
        ProductList products = new ProductList();

        products.addProduct(1L, "Product 9", 15, 5);
        products.addProduct(1L, "Product 10", 1, 3);
        products.addProduct(2L, "Product 2", 30, 2);
        products.addProduct(3L, "Product 5", 7, 7);
        products.addProduct(4L, "Product 1", 5, 1);

        System.out.println("PRODUCTS");
        System.out.println(products.productList);

        System.out.println("\nProducts sorted by name");
        System.out.println(products.sortByName());

        System.out.println("\nProducts sorted by price");
        System.out.println(products.sortByPrice());
    }


}
