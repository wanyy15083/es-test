package com.frotly.es.estest;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by songyigui on 2018/2/28.
 */
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);
}
