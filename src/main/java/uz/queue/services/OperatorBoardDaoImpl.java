package uz.queue.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.queue.models.OperatorBoard;
import uz.queue.repositories.OperatorBoardRepository;
import uz.queue.services.dao.OperatorBoardDAO;

import java.util.List;
@Service
public class OperatorBoardDaoImpl implements OperatorBoardDAO {
    @Autowired
    private OperatorBoardRepository operatorBoardRepository;
    @Override
    public List<OperatorBoard> getAll() {
        return operatorBoardRepository.findAll();
    }

    @Override
    public OperatorBoard getById(int id) {
        return operatorBoardRepository.findById(id);
    }

    @Override
    public OperatorBoard getByIdenfication(String identification) {
        return operatorBoardRepository.findByIdentification(identification);
    }

    @Override
    public OperatorBoard getByUrl(String link) {
        return operatorBoardRepository.findByUrl(link);
    }

    @Override
    public void saveOperatorBoard(OperatorBoard operatorBoard) {
    operatorBoardRepository.save(operatorBoard);
    }

    @Override
    public void editOperatorBoard(OperatorBoard operatorBoard) {

        OperatorBoard temp=operatorBoardRepository.findById(operatorBoard.getId());
        temp.setIdentification(operatorBoard.getIdentification());
        temp.setLink(operatorBoard.getLink());
        operatorBoardRepository.save(temp);
    }

    @Override
    public void deleteOperatorBoard(OperatorBoard operatorBoard) {
        operatorBoardRepository.delete(operatorBoard);
    }
}
