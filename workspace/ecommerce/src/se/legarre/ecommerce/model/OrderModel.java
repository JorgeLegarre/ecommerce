package se.legarre.ecommerce.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import se.legarre.ecommerce.utils.DateUtils;

public final class OrderModel
{
	public final static String DEFAULT_ID = "";

	private final String id;
	private final String username;
	private final long orderDate;
	private final Map<String, DetailModel> detailLines;

	private OrderModel(String orderId, String username, long orderDate, List<DetailModel> details)
	{
		this.id = orderId;
		this.username = username;
		this.orderDate = orderDate;
		this.detailLines = new LinkedHashMap<String, DetailModel>();

		for (DetailModel detail : details)
		{
			detailLines.put(detail.getProductId(), new DetailModel(detail));
		}
	}

	public OrderModel(String username, List<DetailModel> details)
	{
		this(DEFAULT_ID, username, DateUtils.getCurrentDate(), details);
	}

	public OrderModel(String orderId, OrderModel other)
	{
		this(orderId, other.username, other.orderDate, new ArrayList<DetailModel>(other.detailLines.values()));
	}

	public OrderModel(OrderModel other)
	{
		this(other.getId(), other);
	}

	public String getId()
	{
		return id;
	}

	public String getUsername()
	{
		return username;
	}

	public long getOrderDate()
	{
		return orderDate;
	}

	public List<DetailModel> getDetails()
	{
		List<DetailModel> listDetails = new ArrayList<DetailModel>();
		for (DetailModel detail : detailLines.values())
		{
			listDetails.add(new DetailModel(detail));
		}
		return listDetails;
	}

	public double getTotal()
	{
		double total = 0;
		for (DetailModel detail : detailLines.values())
		{
			total += detail.getSubtotal();
		}

		return total;
	}

	/** Eclipse generated */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/** Eclipse generated */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		OrderModel other = (OrderModel) obj;
		if (id == null)
		{
			if (other.id != null) return false;
		}
		else if (!id.equals(other.id)) return false;
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder toString = new StringBuilder();
		toString.append("orderId: ");
		toString.append(id);

		toString.append(", username: ");
		toString.append(username);

		toString.append(", orderDate: ");
		toString.append(DateUtils.formatDate(orderDate));

		toString.append(", Details: {");
		boolean isNotFirst = false;
		for (DetailModel detail : detailLines.values())
		{
			if (isNotFirst)
			{
				toString.append(", ");
			}
			else
			{
				isNotFirst = true;
			}
			toString.append("[productId: ");
			toString.append(detail.getProductId());
			toString.append(", quantity: ");
			toString.append(detail.getQuantity());
			toString.append(", unitPrice: ");
			toString.append(detail.getUnitPrice());
			toString.append(", subtotal: ");
			toString.append(detail.getSubtotal());
			toString.append("]");
		}
		toString.append(", total: ");
		toString.append(getTotal());
		toString.append("}");

		return toString.toString();
	}
}
