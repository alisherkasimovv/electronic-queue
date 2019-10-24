package uz.queue.services.dao;
import uz.queue.models.OperatorBoard;

import java.util.List;
public interface OperatorBoardDAO {
     List<OperatorBoard> getAll();
     OperatorBoard getById(int id);
     OperatorBoard getByIdenfication(String identification);
     OperatorBoard getByUrl(String link);
     void saveOperatorBoard(OperatorBoard operatorBoard);
     void editOperatorBoard(OperatorBoard operatorBoard);
     void deleteOperatorBoard(OperatorBoard operatorBoard);

}
