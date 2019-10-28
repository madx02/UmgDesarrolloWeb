package gt.edu.umg.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.edu.umg.demo.model.TcDetail;
import gt.edu.umg.demo.model.TcOrder;

@Repository
public interface TcDetailRepository extends JpaRepository<TcDetail, Integer> {
    //List<TcDetail> findByTcOrder(TcOrder tcOrder);
}