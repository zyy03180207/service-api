package microservice.api;

import java.io.Serializable;

public class PageData implements Serializable{
	private static final long serialVersionUID = 9211203913081904683L;
	private Object[] list;
	private int pageIndex;
	private int pageCount;
	private int pageRecordCount;
	private String amountCount;
	private String feeCount;
	public Object[] getList() {
		return list;
	}
	public void setList(Object[] list) {
		this.list = list;
	}
	
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageRecordCount() {
		return pageRecordCount;
	}
	public void setPageRecordCount(int pageRecordCount) {
		this.pageRecordCount = pageRecordCount;
	}
	public String getAmountCount() {
		return amountCount;
	}
	public void setAmountCount(String amountCount) {
		this.amountCount = amountCount;
	}
	public String getFeeCount() {
		return feeCount;
	}
	public void setFeeCount(String feeCount) {
		this.feeCount = feeCount;
	}
	
	
}
