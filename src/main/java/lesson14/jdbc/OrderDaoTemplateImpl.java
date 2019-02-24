package lesson14.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author spasko
 */
public class OrderDaoTemplateImpl implements OrderDaoTemplate {

	@Override
	public Set<Order> getAllOrders() throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ResultSet rsPr = null;
		Set<Order> orders = new HashSet<>();
		try {
			connection = ConnectToDB.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM  orders");
			rs = stmt.executeQuery();
			showMetadata(rs);

			while (rs.next()) {
				Order order = new Order(rs.getBigDecimal("order_Num"), null, rs.getDate("order_Date"),
						rs.getString("mfr"), rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));

				stmt = connection.prepareStatement("SELECT * FROM  products WHERE product_id=?");
				stmt.setString(1, rs.getString("PRODUCT"));
				rsPr = stmt.executeQuery();
				while (rsPr.next()) {
					Product product = new Product(rsPr.getString("product_Id"), rsPr.getString("mfr_Id"),
							rsPr.getString("description"), rsPr.getBigDecimal("price"),
							rsPr.getBigDecimal("qty_On_Hand"));
					order.setProduct(product);
				}
				orders.add(order);
			}
		} finally {
			if (Objects.nonNull(rsPr))
				rsPr.close();
			rs.close();
			stmt.close();
			connection.close();
		}
		return orders;
	}

	private void showMetadata(ResultSet rs) throws SQLException {
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int i = 1; i <= columnCount; ++i) {
			System.out.println("***************");
			System.out.print("Column Name : " + resultSetMetaData.getColumnLabel(i) + " \n");
			System.out.print("Column Type : " + resultSetMetaData.getColumnType(i) + " \n");
			System.out.print("Column Class Name : " + resultSetMetaData.getColumnClassName(i) + " \n");
			System.out.print("Column Type Name :" + resultSetMetaData.getColumnTypeName(i) + " \n");
		}
	}

	@Override
	public Order findOrderById(BigDecimal id) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Order order = null;
		try {
			connection = ConnectToDB.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM  orders WHERE order_num=?");
			stmt.setBigDecimal(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				order = new Order(rs.getBigDecimal("order_Num"), null, rs.getDate("order_Date"), rs.getString("mfr"),
						rs.getBigDecimal("qty"), rs.getBigDecimal("amount"));
			}
		} finally {
			rs.close();
			stmt.close();
			connection.close();
		}
		return order;
	}

	@Override
	public boolean insertOrder(Order order) throws SQLException {
		CRUDTemplate<Order> ct = (ord, connection) -> {
			PreparedStatement statement;
			String sql = "INSERT INTO orders (order_num, order_date, qty)  VALUES (?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setBigDecimal(1, order.getOrderNum());
			statement.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
			statement.setBigDecimal(3, order.getQty());
			return statement;
		};
		return ct.templateOperation(order);
	}

	@Override
	public boolean updateOrder(Order order) throws SQLException {
		CRUDTemplate<Order> ct = (ord, connection) -> {
			PreparedStatement statement;
			String sql = "UPDATE orders SET qty=?, amount=?  WHERE order_num=?";
			statement = connection.prepareStatement(sql);
			statement.setBigDecimal(3, order.getOrderNum());
			statement.setBigDecimal(1, order.getQty());
			statement.setBigDecimal(2, order.getAmount());
			return statement;
		};
		return ct.templateOperation(order);
	}

	@Override
	public boolean deleteOrder(Order order) throws SQLException {
		CRUDTemplate<Order> ct = (ord, connection) -> {
			PreparedStatement statement;
			String sql = "DELETE orders WHERE order_num=?";
			statement = connection.prepareStatement(sql);
			statement.setBigDecimal(1, order.getOrderNum());
			return statement;
		};
		return ct.templateOperation(order);
	}

	private interface CRUDTemplate<T> {
		public default boolean templateOperation(T t) throws SQLException {
			boolean result = false;
			Connection connection = null;
			PreparedStatement statement = null;
			try {
				connection = ConnectToDB.getConnection();

				statement = returnPrepareStatement(t, connection);

				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					result = true;
				}
			} finally {
				statement.close();
				connection.close();
			}
			return result;
		}

		public PreparedStatement returnPrepareStatement(T order, Connection connection) throws SQLException;

	}

}
