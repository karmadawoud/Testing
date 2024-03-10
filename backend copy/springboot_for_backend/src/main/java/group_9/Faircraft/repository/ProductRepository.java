package group_9.Faircraft.repository;

import group_9.Faircraft.Model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product WHERE "
			+ "p.productName LIKE CONCAT('%' ,:query, '%')"
			+ "p.productDescription LiKE CONCAT('%', :query, '%')")
	List<Product> searchProduct(String query);
}

