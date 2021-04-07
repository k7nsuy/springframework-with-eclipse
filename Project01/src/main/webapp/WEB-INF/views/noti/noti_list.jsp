<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- html에서 자바문법을 간편하게 쓰게해준다 -->
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
<!-- css스타일시트 쓰기 위함 -->
<meta charset="UTF-8">
<style>
	.pagination {
	display: flex;
	justify-content: center;
	}
	
	.search {
	display: flex;
	justify-content: space-between;
	margin-bottom: 7px;
	}
	
	.search-text {
	margin-right: 5px;
	height: 40px;
	width: 200px;
	border:2px solid;
	border-radius: 5px;
	}
	
	.search-submit {
	}
</style>
</head>
<body>
	<div style="padding:30px 0 0 0" class="container">
		<h4>공지사항목록</h4>
		<hr />
		<div class="search">
			<div>
				<a href="${pageContext.request.contextPath}/noti/insert" class="btn btn-outline-success">등록</a>
			</div>
			<form action="${pageContext.request.contextPath}/noti/list" method="get" class="search">
				<input class="search-text" type="text" name="txt" placeholder="검색" />
				<input class="btn btn-outline-primary search-submit" type="submit" value="검색" />
			</form>
		</div>

		<table class="table" style="border:1px solid #cccccc">
			<thead>
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>글내용</th>
					<th>등록날짜</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items="${list}">
					<tr>
						<td><a href="${pageContext.request.contextPath}/noti/content?no=${vo.no}">${vo.no}</a></td>
						<td>${vo.title}</td>
						<td>${vo.writer}</td>
						<td>${vo.hit}</td>
						<td>${vo.content}</td>
						<td>${vo.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		
		 <div class="pagination" id="pagination-div"></div>

	<!-- jquery cdn -->		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<!-- twbspagination cdn -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>
	
	<script>
		$(function(){
			    $('#pagination-div').twbsPagination({
				    totalPages: Number('${totPages}'),
		            visiblePages: 10,
		            startPage : Number('${param.page}'),
		            initiateStartPageClick :false,
		            onPageClick: function (event, page) {
		            window.location.href = "${pageContext.request.contextPath}/board/list?txt="+'${param.txt}'+ "&page="+page;
		            }
			    });
			});	
	</script>
		
</body>
</html>

