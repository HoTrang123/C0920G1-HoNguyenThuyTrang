package com.codegym.service.employee.impl;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.repository.employee.DivisionRepository;
import com.codegym.repository.employee.EducationDegreeRepository;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.repository.employee.PositionRepository;
import com.codegym.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DivisionRepository divisionRepository;

    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void remove(Integer id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return this.positionRepository.findAll();
    }

    @Override
    public Page<Employee> findByNameContaining(Pageable pageable, String name) {
        return employeeRepository.findByNameContaining(pageable, name);
    }
}
