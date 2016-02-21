package hu.schonherz.administration.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import hu.schonherz.administration.persistence.entities.helper.State;

@Entity
public class Cargo extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8878384846302993044L;
	
	@ManyToOne
	private Restaurant restaurant;
	@OneToOne
	private User courier;
	@OneToMany
	private List<Order> orders;
	@Enumerated(EnumType.STRING)
	private State state;
	@Column(nullable=false, columnDefinition = "DATETIME DEFAULT NOW()", name="Date")
	private Date date;
	@Column(nullable=false)
	private Boolean isDeleted = false;

	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public User getCourier() {
		return courier;
	}
	public void setCourier(User courier) {
		this.courier = courier;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	
	

}
