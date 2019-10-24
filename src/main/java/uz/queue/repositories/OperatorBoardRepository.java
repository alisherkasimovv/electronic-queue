package uz.queue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.queue.models.OperatorBoard;

public interface OperatorBoardRepository extends JpaRepository<OperatorBoard,Integer> {

    OperatorBoard findById(int id);
    OperatorBoard findByUrl(String link);
    OperatorBoard findByIdentification(String identification);


}
