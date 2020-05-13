<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<%@ include file="/WEB-INF/views/admin/common/common.jspf" %>
<body data-background-color="dark">
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/admin/common/header.jspf"%>
		<div class="main-panel">
			<div class="content">
				<div class="page-inner">
					<div class="page-header">
						<h4 class="page-title">매장 목록</h4>
						<ul class="breadcrumbs">
							<li class="nav-home">
								<a href="/admin">
									<i class="flaticon-home"></i>
								</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="/admin/store/list">매장 관리</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="/admin/store/list">매장 목록</a>
							</li>
						</ul>
					</div>
					
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">매장 목록</h4>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<div id="basic-datatables_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
											<div class="row">
												<div class="col-sm-12 col-md-6">
													<div class="dataTables_length" id="basic-datatables_length">
													<label>
													Show 
													<select name="basic-datatables_length" aria-controls="basic-datatables" class="form-control form-control-sm">
														<option value="10">10</option>
														<option value="25">25</option>
														<option value="50">50</option>
														<option value="100">100</option>
													</select> 
													entries
													</label>
												</div>
											</div>
											<div class="col-sm-12 col-md-6">
												<div id="basic-datatables_filter" class="dataTables_filter">
													<label>Search:<input type="search" class="form-control form-control-sm" placeholder="" aria-controls="basic-datatables"></label>
												</div>
											</div>
											</div>
												<div class="row">
													<div class="col-sm-12">
														<table id="basic-datatables" class="display table table-striped table-hover dataTable" role="grid" aria-describedby="basic-datatables_info">
															<thead>
																<tr role="row">
																	<th class="sorting_asc">No.</th>
																	<th class="sorting">매장명</th>
																	<th class="sorting">매장 카테고리</th>
																	<th class="sorting">위치</th>
																	<th class="sorting">주소</th>
																	<th class="sorting">등록날짜</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach var="item" items="${storeList}">
																	<tr role="row" class="odd">
																		<td class="sorting_1">1</td>
																		<td>${item.store_name}</td>
																		<td>${item.category_name}</td>
																		<td>${item.store_location}</td>
																		<td>${item.store_zipcode} ${item.store_address1} ${item.store_address2}</td>
																		<td>${item.store_created}</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
												</div>
											<div class="row">
												<div class="col-sm-12 col-md-5">
													<div class="dataTables_info" id="basic-datatables_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div>
												</div>
												<div class="col-sm-12 col-md-7">
													<div class="dataTables_paginate paging_simple_numbers" id="basic-datatables_paginate">
														<ul class="pagination">
															<li class="paginate_button page-item previous disabled" id="basic-datatables_previous">
																<a href="#" aria-controls="basic-datatables" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
															</li>
															<li class="paginate_button page-item active">
																<a href="#" aria-controls="basic-datatables" data-dt-idx="1" tabindex="0" class="page-link">1</a>
															</li>
															<li class="paginate_button page-item">
																<a href="#" aria-controls="basic-datatables" data-dt-idx="2" tabindex="0" class="page-link">2</a>
															</li>
															<li class="paginate_button page-item">
																<a href="#" aria-controls="basic-datatables" data-dt-idx="3" tabindex="0" class="page-link">3</a>
															</li>
															<li class="paginate_button page-item">
																<a href="#" aria-controls="basic-datatables" data-dt-idx="4" tabindex="0" class="page-link">4</a>
															</li>
															<li class="paginate_button page-item ">
																<a href="#" aria-controls="basic-datatables" data-dt-idx="5" tabindex="0" class="page-link">5</a>
															</li>
															<li class="paginate_button page-item ">
																<a href="#" aria-controls="basic-datatables" data-dt-idx="6" tabindex="0" class="page-link">6</a>
															</li>
															<li class="paginate_button page-item next" id="basic-datatables_next">
																<a href="#" aria-controls="basic-datatables" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
															</li>
														</ul>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%@ include file="/WEB-INF/views/admin/common/footer.jspf"%>
			</div>
		</div>
	</div>
</body>
</html>