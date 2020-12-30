package service.employee;


import model.employee.Division;
import repository.employee.DivisionRepository;
import repository.employee.DivisionRepositoryImpl;

import java.util.List;

public class DivisionServiceImpl implements DivisionService {
    DivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> getAllDivision() {
        return divisionRepository.getAllDivision();
    }
}