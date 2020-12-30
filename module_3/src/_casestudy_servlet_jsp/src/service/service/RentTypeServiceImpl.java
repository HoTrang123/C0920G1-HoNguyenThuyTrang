package service.service;

import model.service.RentType;
import repository.service.RentTypeRepository;
import repository.service.RentTypeRepositoryImpl;

import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    RentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> getAll() {
        return rentTypeRepository.getAll();
    }
}