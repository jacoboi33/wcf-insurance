package com.app.wcf.dao;

import com.app.wcf.entities.StateDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StateRepository extends CrudRepository<StateDetails, Long>, JpaRepository<CustomerDetails, Long> {

    @Query(value = "select state, " +
            "sum(balance) as total_balance," +
            "min(balance) as min_balance," +
            "max(balance) as max_balance," +
            "avg(balance) as mean_balance from state_details group by state", nativeQuery = true)
    List<?> getStateSummary();
}
