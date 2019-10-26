package uz.queue.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.queue.models.OperatorBoard;
import uz.queue.repositories.OperatorBoardRepository;
import uz.queue.services.dao.interfaces.OperatorBoardDAO;

import java.util.List;

@Service
public class OperatorBoardDAOImpl implements OperatorBoardDAO {

    private OperatorBoardRepository repository;

    @Autowired
    public OperatorBoardDAOImpl(OperatorBoardRepository operatorBoardRepository) {
        this.repository = operatorBoardRepository;
    }

    @Override
    public List<OperatorBoard> getAll() {
        return repository.findAll();
    }

    @Override
    public OperatorBoard getById(int id) {
        return repository.findById(id);
    }

    @Override
    public OperatorBoard getByIdentification(String identification) {
        return repository.findByIdentification(identification);
    }

    @Override
    public OperatorBoard getByUrl(String link) {
        return repository.findByLink(link);
    }

    @Override
    public void saveOperatorBoard(OperatorBoard operatorBoard) {
        repository.save(operatorBoard);
    }

    @Override
    public void editOperatorBoard(OperatorBoard operatorBoard) {

        OperatorBoard temp = repository.findById(operatorBoard.getId());
        temp.setIdentification(operatorBoard.getIdentification());
        temp.setLink(operatorBoard.getLink());
        repository.save(temp);
    }

    @Override
    public void deleteOperatorBoard(OperatorBoard operatorBoard) {
        repository.delete(operatorBoard);
    }
}
