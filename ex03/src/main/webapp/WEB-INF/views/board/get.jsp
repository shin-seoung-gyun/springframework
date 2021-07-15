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
			<h1 class="page-header">글 상세</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">글 상세보기</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form role="form" action="register" method="post">
								<div class="form-group">
									<label>글 번호</label> <input class="form-control"
										value="${board.bno}" readonly="readonly">

								</div>
								<div class="form-group">
									<label>글 제목</label> <input class="form-control" name="title"
										value="${board.title}" readonly="readonly">

								</div>
								<div class="form-group">
									<label>작성자</label> <input class="form-control" name="writer"
										value="${board.writer}" readonly="readonly">
								</div>

								<div class="form-group">
									<label>글 내용</label>
									<textarea class="form-control" rows="3" placeholder="내용을 입력하세요"
										name="content" readonly="readonly">${board.content}</textarea>
								</div>

								<button type="button" class="btn btn-primary btn-outline"
									onclick="location.href='modify?bno=${board.bno}&pageNum=${cri.pageNum}&amount=${cri.amount}&type=${cri.type}&keyword=${cri.keyword }'">수정</button>
								<button type="button" class="btn btn-success btn-outline"
									onclick="location.href='list?pageNum=${cri.pageNum}&amount=${cri.amount}&type=${cri.type}&keyword=${cri.keyword }'">목록으로</button>
							</form>
						</div>
						<%-- 댓글 시작 --%>
						<h3>댓글창</h3>
						<input type="text" id="reply" placeholder="댓글을 입력하세요"> <input
							type="text" id="replyer" placeholder="작성자을 입력하세요">
						<button type="button" id="replyRegisterBtn">댓글등록</button>
						<br> <br>
						<div>
							<table border=1>
								<tr>
									<th width=200>내용</th>
									<th width=120>작성자</th>
									<th width=100>작성일</th>
									<th>삭제</th>
									<th>수정</th>
								</tr>

								<tbody class="replyList">

								</tbody>

							</table>
						</div>
						<%-- 댓글 끝--%>

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


<script src="/resources/js/reply.js"></script>

<script>
	//댓글 등록 테스트
	// 	$(document).ready(function(){
	// 	console.log(replyService); 
	// 	console.log("자바스크립트 테스트");
	// 	replyService.add({ reply:"js test", bno:1277970, replyer:"tester" } , 
	// 			function(result){alert("댓글 작성 성공 " +result );
	// 	});
	// 	});

	//목록 테스트
	// 	replyService.getList({bno:1277970, page:1}, function(data){
	// 		for(var i = 0, len = data.length ||0; i<len; i++){
	// 			console.log(data[i]);
	// 		}
	// 	})

	//삭제 테스트
	// 	replyService.remove(21, function(data){

	// 		alert(data);
	// 	},function(){
	// 		alert("또지우니");
	// 	})

	//수정테스트
	// 	replyService.update({rno:23,reply:"수정테스트"}, function(data){
	// 		alert("수정성공"+data);

	// 	})

	//댓글 상세 조회 테스트
	// 	replyService.get(10, function(data){
	// 		console.log(data);
	// 	})
	var bnoValue = '${board.bno}';

	$(document).ready(function() {
		function showList() {
			replyService.getList({bno : bnoValue,page : 1},function(data) {
				var str = '';
				for (var i = 0, len = data.length || 0; i < len; i++) {
				console.log(data[i]);
				str += '<tr><td>'+ data[i].reply+ '</td><td>'+ data[i].replyer
						+ '</td><td>'+ replyService.displayTime(data[i].updateDate)
						+ '</td><td id ="delReplyBtn"><input type="text" value="'
						+ data[i].rno +'" hidden>&nbsp&nbspX </td>'
						+ '<td id ="modifyReplyBtn"><input type="text" value="'
						+ data[i].rno +'" hidden>&nbsp&nbspo </td></tr>';
				}
				// 			str="<tr><td>댓글 내용</td><td>작성자</td><td>2002.02.03</td></tr>";
				$(".replyList").html(str);
			})
		}
		showList();
		$("#replyRegisterBtn").on("click", function() {
			//버튼 클릭 되었을때 실행할 내용.
			var reply = {bno : bnoValue,reply : $("#reply").val(),replyer : $("#replyer").val()};
			replyService.add(reply);
			console.log("리플등록");
			alert("댓글이 등록되었습니다");
			showList();
			$("#reply").val("");
			$("#replyer").val("");
		})

		$("table").on("click", "#delReplyBtn", function() {
			console.log("댓글 삭제버튼 누름");
			var rno = $(this).children("input").val();
			console.log("댓글 번호" + rno);
			replyService.remove(rno, function(data) {
				alert("댓글이 삭제 되었습니다." + data);
				showList();
			});
		})

		$("table").on("click", "#modifyReplyBtn", function() {
			console.log("댓글 수정 시작");
			//수정한 리플 가져오기
			var rno = $(this).children("input").val();//댓글번호 가져오기
			var str = '';
			replyService.get(rno, function(data) {
				console.log(data);
				str = data.reply;
				str = prompt("댓글을 수정해 주세요", str);
				console.log(str);
				//수정하기
				if(str){replyService.update({rno : rno,reply : str},function(){});
				alert("댓글 수정 완료");
				showList();
				}
			});
		})
	})
</script>

</body>

</html>
