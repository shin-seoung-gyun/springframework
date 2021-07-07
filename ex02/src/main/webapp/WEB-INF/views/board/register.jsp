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
			<h1 class="page-header">글 등록</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">글 작성</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form role="form" action="register" method="post">
								<div class="form-group">
									<label>글 제목</label> <input class="form-control" name="title">
									<p class="help-block">글제목을 여기에 입력(10자 이내)</p>
								</div>
								<div class="form-group">
									<label>작성자</label> <input class="form-control"
										placeholder="작성자 입력" name="writer">
								</div>

								<div class="form-group">
									<label>글 내용</label>
									<textarea class="form-control" rows="3" placeholder="내용을 입력하세요"
										name="content"></textarea>
								</div>
<!-- 									추가 -->
								<input type="hidden" value=${cri.pageNum } name="pageNum">
								<input type="hidden" value=${cri.amount } name="amount">


								<button type="submit" class="btn btn-default">등록</button>
								<button type="reset" class="btn btn-default">리셋</button>
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

</body>

</html>
