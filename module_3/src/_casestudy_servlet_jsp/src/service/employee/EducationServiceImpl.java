package service.employee;

import model.employee.EducationDegree;
import repository.employee.EducationDegreeRepository;
import repository.employee.EducationDegreeRepositoryImpl;

import java.util.List;

public class EducationServiceImpl implements EducationService {
    EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    @Override
    public List<EducationDegree> getAllEducation() {
        return educationDegreeRepository.getAllEducation();
    }
}