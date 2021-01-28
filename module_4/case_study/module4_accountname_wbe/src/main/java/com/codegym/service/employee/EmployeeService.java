package com.codegym.service.employee;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.TypeCustomer;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Employee findById(Integer id);

    void save(Employee employee);

    void update(Employee employee);

    void remove(Integer id);

    List<Division> findAllDivision();

    List<EducationDegree> findAllEducationDegree();

    List<Position> findAllPosition();

    Page<Employee> findByNameContaining (Pageable pageable, String name);
}
