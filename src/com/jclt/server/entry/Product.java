package com.jclt.server.entry;


@Entry
public class Product
{
	private Long id;
	private Integer isDelete;
	private Integer price;
	private Dir dir;
	private String name;
	private Smalldir smalldir;
	private Integer saleCount;
	private Integer disPrice;
	private String url;

	public Long getId()
	{
		return this.id;
	}
	public void setId(Long id)
	{
		this.id=id;
	}
	public Integer getIsDelete()
	{
		return this.isDelete;
	}
	public void setIsDelete(Integer isDelete)
	{
		this.isDelete=isDelete;
	}
	public Integer getPrice()
	{
		return this.price;
	}
	public void setPrice(Integer price)
	{
		this.price=price;
	}
	public Dir getDir()
	{
		return this.dir;
	}
	public void setDir(Dir dir)
	{
		this.dir=dir;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public Smalldir getSmalldir()
	{
		return this.smalldir;
	}
	public void setSmalldir(Smalldir smalldir)
	{
		this.smalldir=smalldir;
	}
	public Integer getSaleCount()
	{
		return this.saleCount;
	}
	public void setSaleCount(Integer saleCount)
	{
		this.saleCount=saleCount;
	}
	public Integer getDisPrice()
	{
		return this.disPrice;
	}
	public void setDisPrice(Integer disPrice)
	{
		this.disPrice=disPrice;
	}
	public String getUrl()
	{
		return this.url;
	}
	public void setUrl(String url)
	{
		this.url=url;
	}

}