package gt.edu.umg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.edu.umg.demo.model.TcMenu;

@Repository
public interface TcMenuRepository extends JpaRepository<TcMenu, Long> {
    
}