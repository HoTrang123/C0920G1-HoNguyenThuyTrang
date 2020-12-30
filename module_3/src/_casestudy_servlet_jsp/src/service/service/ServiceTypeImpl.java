package service.service;

import model.service.ServiceType;
import repository.service.ServiceTypeRepository;
import repository.service.ServiceTypeRepositoryImpl;

import java.util.List;

public class ServiceTypeImpl implements ServiceTypeI {
    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();
    @Override
//    public List<ServiceType> getAll() {
//        return serviceTypeRepository.getAll();
//    }
    public List<ServiceType> getAll(){
        return serviceTypeRepository.getAll();
    }
}
