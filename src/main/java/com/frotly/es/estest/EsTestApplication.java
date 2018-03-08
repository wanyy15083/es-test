package com.frotly.es.estest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsTestApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(EsTestApplication.class, "--debug").close();
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.deleteAll();
        saveCustomers();
        fetchAllCustomers();
        fetchIndividualCustomers();
    }

    private void saveCustomers() {
        this.repository.save(new Customer("Alice", "Smith"));
        this.repository.save(new Customer("Bob", "Smith"));
    }

    private void fetchAllCustomers() {
        System.out.println("findAll:");
        System.out.println("----------------");
        for (Customer customer : this.repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();
    }

    private void fetchIndividualCustomers() {
        System.out.println("findByFirstName('Alice'):");
        System.out.println("----------------");
        System.out.println(this.repository.findByFirstName("Alice"));

        System.out.println("findByLastName('Smith'):");
        System.out.println("----------------");
        for (Customer customer : this.repository.findByLastName("Smith")) {
            System.out.println(customer);
        }
    }
}
