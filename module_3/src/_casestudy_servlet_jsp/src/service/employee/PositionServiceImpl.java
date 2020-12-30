package service.employee;

import model.employee.Position;
import repository.employee.PositionRepository;
import repository.employee.PositionRepositoryImpl;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> getAllPosition() {
        return positionRepository.getAllPosition();
    }
}