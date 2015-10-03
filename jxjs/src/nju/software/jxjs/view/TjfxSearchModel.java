package nju.software.jxjs.view;

import java.util.Date;

public class TjfxSearchModel
{
	private Date startDate;
	
	private Date endDate;
	
	private String condition;
	
	public TjfxSearchModel()
	{
	}

	public TjfxSearchModel(Date startDate, Date endDate, String condition)
	{
		this.startDate = startDate;
		this.endDate = endDate;
		this.condition = condition;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public String getCondition()
	{
		return condition;
	}

	public void setCondition(String condition)
	{
		this.condition = condition;
	}
	
}
