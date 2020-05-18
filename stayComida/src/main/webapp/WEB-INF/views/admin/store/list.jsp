<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<%@ include file="/WEB-INF/views/admin/common/common.jspf"%>
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
								<a href="${adminUrl}">
									<i class="flaticon-home"></i>
								</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="${adminUrl}/store/list">매장 관리</a>
							</li>
							<li class="separator">
								<i class="flaticon-right-arrow"></i>
							</li>
							<li class="nav-item">
								<a href="${adminUrl}/store/list">매장 목록</a>
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
											<form id="storeListForm" method="get">
												<input type="hidden" name="page" value="${page}"/>
												<input type="hidden" name="orderby"/>
												<div class="row">
													<div class="col-sm-12 col-md-6">
														${limitSelect}
													</div>
													<div class="col-sm-12 col-md-6">
														<div id="basic-datatables_filter" class="dataTables_filter">
															<label>Search:<input type="text" name="searchword" class="form-control form-control-sm admin-search-word" placeholder="" aria-controls="basic-datatables" value="${searchword}"></label>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-12">
														<table id="basic-datatables" class="display table table-striped table-hover dataTable" role="grid" aria-describedby="basic-datatables_info">
															<thead>
																<tr role="row">
																	<th>No.</th>
																	<th>매장명</th>
																	<th>매장 카테고리</th>
																	<th>위치</th>
																	<th>주소</th>
																	<th>등록날짜</th>
																	<th>관리</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach var="item" items="${storeList.list}">
																	<tr role="row" class="odd">
																		<td>${item.num}</td>
																		<td>${item.store_name}</td>
																		<td>${item.category_name}</td>
																		<td>${item.store_location}</td>
																		<td>${item.store_zipcode} ${item.store_address1} ${item.store_address2}</td>
																		<td>${item.store_created}</td>
																		<td>
																			<button type="button" class="btn btn-sm btn-warning" button-type="go" go-url="${adminUrl}/store/write?ssid=${item.ssid}&redirect=${redirect}">수정</button>
																			<button type="button" class="btn btn-sm btn-danger" button-type="ajax" ajax-type="post" ajax-url="${adminUrl}/store/delete" ajax-data="ssid=${item.ssid}&test=test">삭제</button>
																		</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
												</div>
												<div class="row">
													<div class="col-sm-12 col-md-5">
														<div class="dataTables_info" id="basic-datatables_info" role="status" aria-live="polite">총 ${storeList.count}개</div>
													</div>
													<div class="col-sm-12 col-md-7">
														${paging}
													</div>
												</div>
											</form>
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