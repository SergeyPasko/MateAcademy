package lesson21.springdata.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lesson21.springdata.entity.Orders;

/**
 * @author spasko
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, BigDecimal> {
	@Cacheable("orderCashed")
	List<Orders> findByQtyBetween(BigDecimal minQty, BigDecimal maxQty);
}
