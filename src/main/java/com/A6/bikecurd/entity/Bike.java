package com.A6.bikecurd.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Bike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String model;
	private String brand;
	private String color;
	private String imageUrl;
	private String description;
	private Double price;
	public Long getId() {
		return id;}
	public void setId(Long id) {
		this.id = id;}
	public String getModel() {
		return model;	}
	public void setModel(String model) {
		this.model = model;}
	public String getBrand() {
		return brand;	}
	public void setBrand(String brand) {
		this.brand = brand;}
	public String getColor() {
		return color;	}
	public void setColor(String color) {
		this.color = color;	}
	public String getImageUrl() {
		return imageUrl;	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;	}
	public String getDescription() {
		return description;	}
	public void setDescription(String description) {
		this.description = description;	}
	public Double getPrice() {
		return price;	}
	public void setPrice(Double price) {
		this.price = price;	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", model=" + model + ", brand=" + brand + ", color=" + color + ", imageUrl="
				+ imageUrl + ", description=" + description + ", price=" + price + "]";
	}}
