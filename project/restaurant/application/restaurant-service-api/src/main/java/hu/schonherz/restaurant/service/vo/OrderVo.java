package hu.schonherz.restaurant.service.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import hu.schonherz.restaurant.type.PayType;

/**
 * Created by tothd on 2015. 12. 16..
 */
public class OrderVo extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String address;

	private Date deadline;

	private PayType payType;

	private List<ItemVo> items;

	private Integer totalPrice;

	private OrderState orderState;

	private Long globalId;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public List<ItemVo> getItems() {
		return items;
	}

	public void setItems(List<ItemVo> items) {
		this.items = items;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public Long getGlobalId() {
		return globalId;
	}

	public void setGlobalId(Long globalId) {
		this.globalId = globalId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OrderVo)) {
			return false;
		}
		OrderVo other = (OrderVo) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (deadline == null) {
			if (other.deadline != null) {
				return false;
			}
		} else if (!deadline.equals(other.deadline)) {
			return false;
		}
		return true;
	}

}
