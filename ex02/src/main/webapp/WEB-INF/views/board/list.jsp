<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- jstl날짜 -->
<%@ include file="../includes/header.jsp"%>
<!-- 헤더를 가져오는 지시어 -->
<meta charset="UTF-8">




<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">게시판</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<div class="row">
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					게시글 목록 페이지
					<buttom type="button" class="btn btn-xs btn-primary pull-right"
						id="regBtn">글등록</buttom>
				</div>

				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>글 번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>수정일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="board">

									<tr>
										<td><a href="get?bno=${board.bno }">${board.bno }</a></td>
										<td><a href="get?bno=${board.bno }">${board.title }</a></td>
										<td><a href="get?bno=${board.bno }">${board.writer }</a></td>
										<td><a href="get?bno=${board.bno }"><fmt:formatDate
													pattern="yyyy년MM월dd일" value="${board.regdate }" /></a></td>
										<td><a href="get?bno=${board.bno }"><fmt:formatDate
													pattern="yyyy년MM월dd일" value="${board.updatedate }" /></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /.table-responsive -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>

	</div>
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">게시물 등록 알림</h4>
			</div>
			<div class="modal-body">게시물 ${result } 번이 등록되었습니다.</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- jQuery -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script
	src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script
	src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/resources/dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
	$(document).ready(function() {
		$('#dataTables-example').DataTable({
			responsive : true
		});
	});
</script>
<script>
	$(document).ready(function() {
		var result = "${result}";
// 		checkModal(result);
// 		history.replaceState({}, null, null);
// 		function checkModal(result) {
// 			if (result == "" || history.state){
// 				return;
// 			}
// 			if (result != "" || !history.state) {
// 				console.log("등록된 번호는");
// 				console.log(result);
// 			}
// 			$("#myModal").modal("show");

// 		}
		
		if(result==""||history.state){
			console.log("모달창 금지");
		} else{
			$("#myModal").modal("show");
		}


		history.replaceState({}, null, null);

		$("#regBtn").on("click", function() {
			self.location = "/board/register";
		});

	});
</script>


</body>

</html>
