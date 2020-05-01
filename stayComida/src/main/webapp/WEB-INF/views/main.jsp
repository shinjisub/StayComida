<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jspf" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" type="image/png" href="${contextPath}/resources/img/logo/favicon_staycomidaLogo.ico"/>
	<title>${projectNm}</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$('input[name=search-input]').keyup(function(e){
			let keyWordData = this.value;
			$.ajax({
				url : '/getMainKeyWordList.ajax',
			    type: 'GET',
			    data: { keyword: keyWordData },
			    dataType: 'json',
			    success: function (resp) {
			    	let html = '';
			    	console.log('getMainKeyWordList.ajax', resp);
			    	if(resp.resultCode == 100){
				    	$.each(resp.keyWordList, function(idx, e){
				    		html += '<p style="border: 1px solid red;">'+e.foodtype_name+'</p>';
				    	});
				    	
				    	$('#storeList').empty();
				    	$('#storeList').html(html);
			    	} else {
			    		alert('데이터 오류...');
			    	}
			    }
			})
		});
	});
</script>
<body class="mr0 pd0">
	<%@ include file="/WEB-INF/views/common/header.jspf" %>
	<div>
		<div style="height: 350px; background-image: url('https://mp-seoul-image-production-s3.mangoplate.com/d8e852bf7058841a7a0694af93af1b9a.jpg');">
			<h1 style="position: relative; top: 153px; left: 395px;">솔직한 리뷰, 음식종류별 평점 Stay Comida</h1>
			<input type="text" id="search-input" name="search-input" class="form-control text-left" style="position: relative; top: 190px; left:395px; width: 650px;" placeholder="지역 또는 음식명 찾기">
		</div>
		<div style="min-height: 500px; height: auto;">
			<h2>Stay Comida 맛집목록</h2>
			<div class="container" id="storeList">
				
			</div>
		</div>
	</div>	
	<%@ include file="/WEB-INF/views/common/footer.jspf" %>
</body>
</html>