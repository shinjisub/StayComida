package com.app.staycomida.admin.func;

import javax.servlet.http.HttpServletRequest;

public class AdminPagination {

	private Integer curPage = 1;

	private int dataCount = 0;

	private int limit = 0;

	private int maxPageCount = 5;

	private Boolean isFirst = true;

	private Boolean isLast = true;

	private Boolean isNext = true;

	private Boolean isPrev = true;
	
	private String activeClass = "active";

	private String openTag = 	"<div class=\"dataTables_paginate paging_simple_numbers\" id=\"basic-datatables_paginate\">" + 
									"<ul class=\"pagination\">";

	private String firstTag = 			"<li class=\"paginate_button page-item previous\">" + 
											"<a href=\"[[url]]\" aria-controls=\"basic-datatables\" class=\"page-link\"><<</a>" + 
										"</li>";

	private String prevTag = 			"<li class=\"paginate_button page-item previous\">" + 
											"<a href=\"[[url]]\" aria-controls=\"basic-datatables\" class=\"page-link\"><</a>" + 
										"</li>";

	private String numTag = 			"<li class=\"paginate_button page-item [[activeClass]]\">" + 
											"<a href=\"[[url]]\" aria-controls=\"basic-datatables\" class=\"page-link\">[[num]]</a>" + 
										"</li>";

	private String nextTag = 			"<li class=\"paginate_button page-item next\">" + 
											"<a href=\"[[url]]\" aria-controls=\"basic-datatables\" class=\"page-link\">></a>" + 
										"</li>";

	private String lastTag = 			"<li class=\"paginate_button page-item next\">" + 
											"<a href=\"[[url]]\" aria-controls=\"basic-datatables\" class=\"page-link\">>></a>" + 
										"</li>";

	private String closeTag =		 "</ul>" + 
								"</div>";

	private String paging = "";

	HttpServletRequest request;

	public AdminPagination(HttpServletRequest request, Integer curPage, Object dataCount) {
		this.request = request;
		this.curPage = curPage == null ? 1 : curPage;
		this.dataCount = (int) dataCount;
		SqlParams sqlParams = new SqlParams();
		this.limit = sqlParams.getDefaultLimit();
		this.setPaging();
	}

	public AdminPagination(HttpServletRequest request, Integer curPage, Object dataCount, Integer limit) {
		this.request = request;
		this.curPage = curPage == null ? 1 : curPage;
		this.dataCount = (int) dataCount;
		SqlParams sqlParams = new SqlParams();
		this.limit = limit == null ? sqlParams.getDefaultLimit() : limit;
		this.setPaging();
	}

	public AdminPagination setMaxPageCount(int maxPageCount) {
		this.maxPageCount = maxPageCount;
		this.setPaging();
		return this;
	}

	public AdminPagination setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
		this.setPaging();
		return this;
	}

	public AdminPagination setIsLast(Boolean isLast) {
		this.isLast = isLast;
		this.setPaging();
		return this;
	}

	public AdminPagination setIsNext(Boolean isNext) {
		this.isNext = isNext;
		this.setPaging();
		return this;
	}

	public AdminPagination setIsPrev(Boolean isPrev) {
		this.isPrev = isPrev;
		this.setPaging();
		return this;
	}

	public AdminPagination setLimit(int limit) {
		this.limit = limit;
		this.setPaging();
		return this;
	}
	
	public Integer getCurPage() {
		return this.curPage;
	}

	public String getRequestUri() {
		return request.getRequestURI().toString();
	}

	public String getQueryString(int setPage) {
		String queryString = "?";
		String[] queryStringArr = (this.request.getQueryString() == null ? null : this.request.getQueryString().split("&"));
		if (queryStringArr != null && queryStringArr.length > 0) {
			for (int i = 0; i < queryStringArr.length; i++) {
				String item = queryStringArr[i];
				if (item.indexOf("page=") != -1) {
					queryStringArr[i] = "page=" + setPage;
				}
			}
			queryString += String.join("&", queryStringArr);
		} else {
			queryString += "page=" + setPage;
		}
		return queryString;
	}

	private void setPaging() {
		String paging = "";
		if (this.dataCount > 0) {
			int maxPage = (this.dataCount / this.limit) + 1;
			
			paging += this.openTag;

			if (this.isFirst) {
				String lastTag = this.firstTag;
				paging += lastTag.replace("[[url]]", this.getRequestUri() + this.getQueryString(1));
			}

			if (this.isPrev) {
				String prevTag = this.prevTag;
				int prevPage = this.curPage - 1 <= 0 ? 1 : this.curPage - 1;
				paging += prevTag.replace("[[url]]", this.getRequestUri() + this.getQueryString(prevPage));
			}

			int halfMaxPageCount = this.maxPageCount / 2;
			int startNum = this.curPage - halfMaxPageCount > 1 ? this.curPage - halfMaxPageCount : 1;
			int endNum = this.curPage + halfMaxPageCount > maxPage ? maxPage : this.curPage + halfMaxPageCount;
			if (maxPage < this.maxPageCount) {
				startNum = 1;
				endNum = maxPage;
			} else {
				if (startNum < halfMaxPageCount && maxPage > this.maxPageCount) {
					endNum = this.maxPageCount;
				}
				if ((endNum - startNum + 1) < this.maxPageCount && maxPage > this.maxPageCount) {
					startNum = maxPage - this.maxPageCount + 1;
				}
			}

			for (int num = startNum; num <= endNum; num++) {
				String numTag = this.numTag;
				numTag = numTag.replace("[[num]]", num + "");
				numTag = numTag.replace("[[url]]", this.getRequestUri() + this.getQueryString(num));
				if (num == this.curPage) {
					numTag = numTag.replace("[[activeClass]]", this.activeClass);
				} else {
					numTag = numTag.replace("[[activeClass]]", "");
				}
				paging += numTag;
			}

			if (this.isNext) {
				String nextTag = this.nextTag;
				int nextPage = this.curPage + 1 >= maxPage ? maxPage : this.curPage + 1;
				paging += nextTag.replace("[[url]]", this.getRequestUri() + this.getQueryString(nextPage));
			}

			if (this.isLast) {
				String lastTag = this.lastTag;
				paging += lastTag.replace("[[url]]", this.getRequestUri() + this.getQueryString(maxPage));
			}

			paging += this.closeTag;

		}
		this.paging = paging;
	}

	public String getPaging() {
		return this.paging;
	}

}
