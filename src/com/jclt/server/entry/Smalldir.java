package com.jclt.server.entry;


@Entry
public class Smalldir
{
	private Long id;
	private Integer sort;
	private Dir dir;
	private String name;

	public Long getId()
	{
		return this.id;
	}
	public void setId(Long id)
	{
		this.id=id;
	}
	public Integer getSort()
	{
		return this.sort;
	}
	public void setSort(Integer sort)
	{
		this.sort=sort;
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

}