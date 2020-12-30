package repository.service;

import model.service.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceRepository {
    List<Service> getAll();
    void insertService(Service service) throws SQLException;
    boolean deleteService(String id) throws SQLException;
}