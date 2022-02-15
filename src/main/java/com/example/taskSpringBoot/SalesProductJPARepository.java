package com.example.taskSpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface SalesProductJPARepository extends CrudRepository<SalesPeriod, Integer> {



}
