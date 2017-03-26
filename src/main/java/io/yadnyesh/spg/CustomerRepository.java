package io.yadnyesh.spg;

import io.yadnyesh.spg.io.yadnyesh.spg.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by z063407 on 3/26/17.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
