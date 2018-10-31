package com.apap.tutorial7.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.apap.tutorial7.model.DealerModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "car")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "brand", nullable = false)
	private String brand;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "type", nullable = false, unique = true)
	private String type;
	
	@NotNull
	@Column(name = "price", nullable = false)
	private String price;
	
	@NotNull
	@Column(name = "amount", nullable = false)
	private String amount;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="dealer_id", referencedColumnName="id", nullable= false)
	@OnDelete(action=OnDeleteAction.NO_ACTION)
	@JsonIgnoreProperties(ignoreUnknown = true)
	private DealerModel dealer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public DealerModel getDealer() {
		return dealer;
	}

	public void setDealer(DealerModel dealer) {
		this.dealer = dealer;
	}
	
	
}

