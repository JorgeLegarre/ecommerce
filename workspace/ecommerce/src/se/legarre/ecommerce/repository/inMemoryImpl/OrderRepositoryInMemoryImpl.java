package se.legarre.ecommerce.repository.inMemoryImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import se.legarre.ecommerce.model.OrderModel;
import se.legarre.ecommerce.repository.OrderRepository;

public final class OrderRepositoryInMemoryImpl implements OrderRepository
{
	private static int orderIdCounter = 1000;

	private Map<String, OrderModel> orders;

	public OrderRepositoryInMemoryImpl()
	{
		orders = new LinkedHashMap<String, OrderModel>();
	}

	@Override
	public String placeOrder(OrderModel order)
	{
		String idToSave = isNewOrder(order.getId()) ? getNextId() : order.getId();

		orders.put(idToSave, new OrderModel(idToSave, order));

		return idToSave;
	}

	@Override
	public List<OrderModel> getAllOrders()
	{
		List<OrderModel> listOrders = new ArrayList<OrderModel>();

		for (OrderModel order : orders.values())
		{
			listOrders.add(new OrderModel(order));
		}

		return listOrders;
	}

	@Override
	public OrderModel getOrder(String orderId)
	{
		OrderModel order = orders.get(orderId);

		return (order == null) ? null : new OrderModel(order);
	}

	@Override
	public void removeOrder(String orderId)
	{
		orders.remove(orderId);
	}

	private boolean isNewOrder(String orderId)
	{
		return OrderModel.DEFAULT_ID.equals(orderId);
	}

	private String getNextId()
	{
		orderIdCounter++;
		return "O" + orderIdCounter;
	}
}
