<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jstl -->
<%@ include file="../includes/header.jsp"%>
<!-- 헤더 불러오기 -->
<meta charset="UTF-8">


<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">글 수정 페이지</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">글 수정</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form role="form" action="modify" method="post">
								<div class="form-group">
									<label>글 번호</label> <input class="form-control"
										value="${board.bno}" readonly="readonly">

								</div>
								<div class="form-group">
									<label>글 제목</label> <input class="form-control" name="title"
										value="${board.title}">

								</div>
								<div class="form-group">
									<label>작성자</label> <input class="form-control" name="writer"
										value="${board.writer}" readonly="readonly">
								</div>

								<div class="form-group">
									<label>글 내용</label>
									<textarea class="form-control" rows="3" placeholder="내용을 입력하세요"
										name="content">${board.content}</textarea>
								</div>

								<button type="submit" class="btn btn-primary btn-outline">수정완료</button>
								<button type="button" class="btn btn-danger btn-outline"
									id="delBtn">삭제하기</button>
								<button type="button" class="btn btn-success btn-outline"
									onclick="location.href='list'">목록으로</button>
							</form>
						</div>

					</div>
					<!-- /.row (nested) -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../dist/js/sb-admin-2.js"></script>

<script>
	$(document).ready(function() {
		var formObj=$("form")
		
		$("#delBtn").on("click", function() {
			formObj.attr("action","remove");
			formObj.submit();
		});
	});
</script>
</body>

</html>
