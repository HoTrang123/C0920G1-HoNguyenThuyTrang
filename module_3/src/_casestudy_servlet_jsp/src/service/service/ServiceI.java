package service.service;

import model.service.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceI {

    List<Service> getAll();
    void insertService(Service service) throws SQLException;
    boolean deleteService(String id) throws SQLException;
}
