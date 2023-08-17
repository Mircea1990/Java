package onlineshop.enteties.impl;

import onlineshop.enteties.Product;

public class DefaultProduct implements Product {

	private int id;
	private String productName;
	private String categoryName;
	private double price;

	public DefaultProduct() {
	}

	public DefaultProduct(int id, String productName, String categoryName, double price) {
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", categoryName=" + categoryName + ", price="
				+ price + "]";
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProductName(String productName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCategoryName() {
		return this.categoryName;
	}

	@Override
	public void setCategoryName(String categoryName) {

	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}
}
