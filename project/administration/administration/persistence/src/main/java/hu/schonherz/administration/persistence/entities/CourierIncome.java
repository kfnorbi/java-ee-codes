package hu.schonherz.administration.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CourierIncome extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4375462293564464326L;

	@ManyToOne
	private User courier;
	private String courierName;
	private Date date;
	private Integer cash;
	private Integer szepCard;
	private Integer crediCard;
	private Integer voucher;
	private Integer actualCash;
	private Integer actualVoucher;

	public User getCourier() {
		return courier;
	}

	public void setCourier(User courier) {
		this.courier = courier;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getCash() {
		return cash;
	}

	public void setCash(Integer cash) {
		this.cash = cash;
	}

	public Integer getSzepCard() {
		return szepCard;
	}

	public void setSzepCard(Integer szepCard) {
		this.szepCard = szepCard;
	}

	public Integer getCrediCard() {
		return crediCard;
	}

	public void setCrediCard(Integer crediCard) {
		this.crediCard = crediCard;
	}

	public Integer getVoucher() {
		return voucher;
	}

	public void setVoucher(Integer voucher) {
		this.voucher = voucher;
	}

	public Integer getActualCash() {
		return actualCash;
	}

	public void setActualCash(Integer actualCash) {
		this.actualCash = actualCash;
	}

	public Integer getActualVoucher() {
		return actualVoucher;
	}

	public void setActualVoucher(Integer actualVoucher) {
		this.actualVoucher = actualVoucher;
	}

}
