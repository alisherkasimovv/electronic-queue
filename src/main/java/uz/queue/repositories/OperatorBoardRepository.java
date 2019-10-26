package uz.queue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import uz.queue.models.OperatorBoard;

@Service
public interface OperatorBoardRepository extends JpaRepository<OperatorBoard,Integer> {

    OperatorBoard findById(int id);
    OperatorBoard findByLink(String link);
    OperatorBoard findByIdentification(String identification);

}
