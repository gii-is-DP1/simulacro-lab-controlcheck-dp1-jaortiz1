package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
public class Product extends BaseEntity{
	 @Size(min = 3, max = 50)
    String name;
	@Min(0)
    double price;
	@ManyToOne
    ProductType productType;
}
