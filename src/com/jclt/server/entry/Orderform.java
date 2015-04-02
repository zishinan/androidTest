package com.jclt.server.entry;


@Entry
public class Orderform
{
	private String products;
	private Long id;
	private String phone;
	private String time;
	private Integer price;
	private Integer state;
	private String addr;
	private User user;

	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public Long getId()
	{
		return this.id;
	}
	public void setId(Long id)
	{
		this.id=id;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getTime()
	{
		return this.time;
	}
	public void setTime(String time)
	{
		this.time=time;
	}
	public Integer getPrice()
	{
		return this.price;
	}
	public void setPrice(Integer price)
	{
		this.price=price;
	}
	public Integer getState()
	{
		return this.state;
	}
	public void setState(Integer state)
	{
		this.state=state;
	}
	public String getAddr()
	{
		return this.addr;
	}
	public void setAddr(String addr)
	{
		this.addr=addr;
	}
	public User getUser()
	{
		return this.user;
	}
	public void setUser(User user)
	{
		this.user=user;
	}

}