<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/fr/common.jspf" %>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${projectNm}</title>
</head>
<body id="page-top" class="regular-navigation">
	<!-- Header -->
	<%@ include file="/WEB-INF/views/common/fr/header.jspf" %>
	<!-- /Header -->

    <section id="the-menu">
        <div class="section-inner">
        	<div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center mb100">
                        <h2 class="section-heading">맛집 리스트</h2>
                        <!-- <hr class="thin-hr"> -->
                        <h3 class="section-subheading secondary-font">Your tastebuds will thank you.</h3>
                    </div>
                </div>
            </div>
            
			<div class="container">
				<div class="row">
			     	<div class="col-md-12 wow fadeIn">
						<h2 class="mb50"><span class="heading-font text-uppercase">고기 맛집 TOP <i style="color: red;">5</i></span></h2>
						<c:forEach var="store" items="${storeList}">
					        <div class="food-menu-item">
					            <div class="row">
					                <div class="col-xs-3">
					                    <img src="${contextPath}/resources/Front_Temp/img/food/meal4.jpg" class="img-responsive">
					                </div>
					                <div class="col-xs-9">
					                    <h3>${store.store_name} (<span class="theme-accent-color">평점 4.5</span>)</h3>
					                    <p>No phone no lights no motor car not a single luxury. Like Robinson Crusoe it's primitive as can be. Like Robinson Crusoe it's primitive as can be</p>
					                </div>
					            </div>
					        </div>
				        </c:forEach>
			        </div>
			    </div>
			</div>
		</div>
	</section>
	
	<!-- FOOTER -->
	<%@ include file="/WEB-INF/views/common/fr/footer.jspf" %>
	<!-- /FOOTER -->
</body>
</html>