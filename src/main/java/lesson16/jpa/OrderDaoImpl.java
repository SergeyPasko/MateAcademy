package lesson16.jpa;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lesson16.entry.Orders;

/**
 * @author spasko
 */
public class OrderDaoImpl implements OrderDao {
	private static EntityManagerFactory factory;

	static {
		Locale.setDefault(Locale.ENGLISH);
		factory = Persistence.createEntityManagerFactory("PERSISTENCE");
	}

	private static final Logger LOG = LogManager.getLogger(OrderDaoImpl.class);

	private EntityManager entityManager = factory.createEntityManager();

	@Override
	public boolean insertOrder(Orders transientInstance) {
		LOG.debug("persisting Orders instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(transientInstance);
			entityManager.getTransaction().commit();
			LOG.debug("persist successful");
			return true;
		} catch (RuntimeException re) {
			if (entityManager != null) {
				System.out.println("Transaction is being rolled back.");
				entityManager.getTransaction().rollback();
			}
			LOG.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public boolean deleteOrder(BigDecimal id) {
		LOG.debug("removing Orders instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(Orders.class, id));
			entityManager.getTransaction().commit();
			LOG.debug("remove successful");
			return true;
		} catch (RuntimeException re) {
			if (entityManager != null) {
				System.out.println("Transaction is being rolled back.");
				entityManager.getTransaction().rollback();
			}
			LOG.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public boolean updateOrder(Orders detachedInstance) {
		LOG.debug("merging Orders instance");
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(detachedInstance);
			entityManager.getTransaction().commit();
			LOG.debug("merge successful");
			return true;
		} catch (RuntimeException re) {
			if (entityManager != null) {
				System.out.println("Transaction is being rolled back.");
				entityManager.getTransaction().rollback();
			}
			LOG.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Orders findOrderById(BigDecimal id) {
		LOG.debug("getting Orders instance with id: " + id);
		try {
			Orders instance = entityManager.find(Orders.class, id);
			LOG.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			LOG.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Set<Orders> getAllOrders() throws SQLException {
		LOG.debug("getting all Orders instances");
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Orders> cq = cb.createQuery(Orders.class);
			Root<Orders> rootEntry = cq.from(Orders.class);
			CriteriaQuery<Orders> all = cq.select(rootEntry);
			TypedQuery<Orders> allQuery = entityManager.createQuery(all);
			return new HashSet<>(allQuery.getResultList());
		} catch (RuntimeException re) {
			LOG.error("getAll failed", re);
			throw re;
		}

	}

}
