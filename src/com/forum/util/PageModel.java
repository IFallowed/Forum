package com.forum.util;

import java.util.List;


/**
 * 分页模型
 * @author Administrator
 *
 */
public class PageModel<E> {
	//所有的内容都是和分页相关
	/**
	 * 数据集
	 */
	private List<E> dataList;
	
	/**
	 * 总页数
	 */
//	private int totalPage;
	
	/**
	 * 每页显示的条目
	 */
	private int pageSize;
	
	/**
	 * 总记录数
	 */
	private int cnt;
	
	
	/**
	 * 当前页码
	 */
	private int pageNo;
	
	/**
	 * 首页
	 */
//	private int firstNo;
	
	/**
	 * 末页
	 */
//	private int lastNo;
	
	/**
	 * 下一页
	 */
//	private int nextNo;
	
	/**
	 * 上一页
	 */
//	private int preNo;

	public List<E> getDataList() {
		return dataList;
	}

	public void setDataList(List<E> dataList) {
		this.dataList = dataList;
	}

	public int getTotalPage() {
		return this.cnt%this.pageSize == 0 ? this.cnt/this.pageSize : this.cnt/this.pageSize + 1;
		
	}

//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getFirstNo() {
		return 1;
	}

//	public void setFirstNo(int firstNo) {
//		this.firstNo = firstNo;
//	}

	public int getLastNo() {
		return this.getTotalPage();
	}

//	public void setLastNo(int lastNo) {
//		this.lastNo = lastNo;
//	}

	public int getNextNo() {
		if(this.pageNo == this.getTotalPage()){
			return this.getTotalPage();
		}else{
			return this.pageNo + 1;
		}
	}

//	public void setNextNo(int nextNo) {
//		this.nextNo = nextNo;
//	}

	public int getPreNo() {
		if(this.pageNo == 1){
			return 1;
		}else{
			
			return this.pageNo - 1;
		}
	}

//	public void setPreNo(int preNo) {
//		this.preNo = preNo;
//	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
	
	
}
