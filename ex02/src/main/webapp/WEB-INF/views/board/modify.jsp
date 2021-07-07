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
							<form role="form" action="/board/modify" method="post">
								<div class="form-group">
									<label>글 번호</label> 
									<input class="form-control" name="bno" value="${board.bno}" readonly>

								</div>
								<div class="form-group">
									<label>글 제목</label> <input class="form-control" name="title"
										value="${board.title}">

								</div>
								<div class="form-group">
									<label>작성자</label> <input class="form-control" name="writer"
										value="${board.writer}" readonly>
								</div>

								<div class="form-group">
									<label>글 내용</label>
									<textarea class="form-control" rows="3" name="content">${board.content}</textarea>
								</div>
<!-- 								/*추가*/ -->
								<input type="hidden" value=${cri.pageNum } name="pageNum">
								<input type="hidden" value=${cri.amount } name="amount">
								
								
								

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
<script src="/resources/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/resources/dist/js/sb-admin-2.js"></script>

<script>
	$(document).ready(function() {
// 		 onclick="javascript: form.action='/board/remove'; form.submit();"
		
		$("#delBtn").on("click",function() {
			$("form").attr("action","remove");
			$("form").submit();
		});
		
	});
</script>
</body>

</html>
