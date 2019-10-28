package gt.edu.umg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.edu.umg.demo.model.TcProduct;

@Repository
public interface TcProductRepository extends JpaRepository<TcProduct, Integer> {
    
}