package service.service;

import repository.service.ServiceRepository;
import repository.service.ServiceRepositoryImpl;
import model.service.Service;

import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements ServiceI {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    @Override
    public List<Service> getAll() {
        return serviceRepository.getAll();
    }

    @Override
    public void insertService(Service service) throws SQLException {
        serviceRepository.insertService( service);
    }


    @Override
    public boolean deleteService(String id) throws SQLException {
        return serviceRepository.deleteService(id);
    }
}
