/**
 * 게시글 리플과 관련된 javascript 모듈화+
 */

console.log("Reply Module..............");

var replyService = (function() {

	function add(reply, callback, error) {
		console.log("reply.......");
		$.ajax({
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(result, status, xhr) {
				if (error) {
					error(er);
				}
			}
		})
	}

	function getList(param, callback, error) {
		var bno = param.bno;
		var page = param.page || 1;

		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
				function(data) {
					if (callback) {
						callback(data);
					}
				}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
	
	
	function remove(rno, callback,error){
		$.ajax({
			type : 'delete',
			url : '/replies/'+rno,
			success : function(data){
				callback(data);
			},
			error : function(){
				error();
			}
		})	
	}
	
	function update(reply, callback, error){
		console.log("댓글 수정 스크립트 시작");
		$.ajax({
			type:'put',
			url:'/replies/'+reply.rno,
			data : JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success: function(result){
				callback(result);
			}			
		});
	}
	
	function get(rno, callback){
		$.get("/replies/"+rno+".json", function(result){
			callback(result);
		});
	}
	
	function displayTime(timeValue){
		var dateObj = new Date(timeValue);
		var year=dateObj.getFullYear();//네자리수 연도
		var month=dateObj.getMonth()+1;//월은 0부터 시작해서 1을 더해줘야함
		var day=dateObj.getDate();
		var hour = dateObj.getHours();
		var minute = dateObj.getMinutes();
		var second = dateObj.getSeconds();
		
		return year+"/"+month+"/"+day;
		
		
	}
	
	
	
	return {
		add : add,
		getList : getList,
		remove : remove,
		update : update,
		get : get,
		displayTime : displayTime
	};
})();
