package gt.edu.umg.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.edu.umg.demo.model.TcProvider;

@Repository
public interface TcProviderRepository extends JpaRepository<TcProvider, Long> {
    
    List<TcProvider> findByStatusId(byte statusId);
    
}