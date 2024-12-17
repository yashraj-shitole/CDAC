package com.store.pojo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEnitity {

	
	private  int quantity;
	
	@Column(name = "order_date")
	private LocalDate orderDate;
	
	
	@ManyToOne
	@JoinColumn()
	private User user;
	

	@OneToMany
	@JoinColumn(name = "order_id")
	private List<Product> products;
	
	
}
