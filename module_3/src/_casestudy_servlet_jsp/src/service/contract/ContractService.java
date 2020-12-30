package service.contract;

import model.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractService {
    List<Contract> getAll();
    void insert(Contract contract) throws SQLException;
}