package com.api.swd.port.hibernate;

import com.api.swd.model.hibernate.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HEmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

}
