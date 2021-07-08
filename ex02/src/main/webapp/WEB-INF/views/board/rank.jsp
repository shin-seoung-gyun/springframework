<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- jstl날짜 -->
<%@ include file="../includes/header.jsp"%>
<!-- 헤더 불러오기 -->
<meta charset="UTF-8">

<!-- /#page-wrapper -->
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">랭킹</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>순위</th>
					<th>작성자</th>
					<th>글개수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ranking}" var="board">

					<tr>
						<td>${board.rownum }</td>
						<td>${board.writer }</td>
						<td>${board.rankNum }</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<!-- /.row -->
	<div class="row">
		<!-- /.col-lg-6 -->
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">랭킹 도넛 차트</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div id="morris-donut-chart"></div>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->

<!-- jQuery -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="/resources/vendor/raphael/raphael.min.js"></script>
<script src="/resources/vendor/morrisjs/morris.min.js"></script>
<!-- 외부스크립트를 가져와서 실행하면 됨. -->
<script>
	Morris.Donut({
	    element: 'morris-donut-chart',
	    data: [
	    	<c:forEach items="${ranking}" var="temp1">
	    	{
		        label: "${temp1.writer}",
		        value: "${temp1.rankNum}"
		    },
	    	</c:forEach>
	    	],
	    resize: true
	});
</script>

<!-- Custom Theme JavaScript -->
<script src="/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
