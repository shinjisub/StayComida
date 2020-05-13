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
						<h4 class="page-title">매장 등록</h4>
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
								<a href="/admin/store/write">매장 등록</a>
							</li>
						</ul>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<form id="storeForm">
								<div class="card">
									<div class="card-header">
										<div class="card-title">매장 정보 입력</div>
									</div>
									<div class="card-body">
										<div class="row">
											<div class="col-md-6 col-lg-12">
												<div class="form-group">
													<label for="sftid">매장 카테고리</label>
													<select class="form-control" id="scgid" name="scgid">
														<option value="">- 선택 -</option>
														<c:forEach var="item" items="${categoryList}">
															<option value="${item.scgid}">${item.category_name}</option>
														</c:forEach>
													</select>
												</div>
												<div class="form-group">
													<label for="store_name">매장명</label>
													<input type="text" class="form-control" id="store_name" name="store_name" placeholder="매장명을 입력해주세요.">
												</div>
												<div class="form-group">
													<label for="store_name">주소</label>
													<div class="row">
														<div class="col-lg-6 mb10">
															<div class="input-group">
																<div class="input-group-append">
																	<button type="button" class="btn btn-primary" onclick="addressSearch('store_zipcode', 'store_address1', 'store_address2')">주소검색</button>
																</div>
																<input type="text" class="form-control" id="store_zipcode" name="store_zipcode" placeholder="우편번호">
															</div>
														</div>
														<div class="col-lg-12 mb10">
															<input type="text" class="form-control" id="store_address1" name="store_address1" placeholder="기본주소">
														</div>
														<div class="col-lg-12">
															<input type="text" class="form-control" id="store_address2" name="store_address2" placeholder="상세주소">
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="card-action text-right">
										<button class="btn btn-success" type="button" button-type="submit" form-id="storeForm" submit-url="/admin/store/write/submit">등록</button>
										<button class="btn btn-danger" type="button" onclick="history.back();">취소</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<%@ include file="/WEB-INF/views/admin/common/footer.jspf"%>
			</div>
		</div>
	</div>
</body>
</html>