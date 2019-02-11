console.log("Member module..........")

var memberService = (function(){
//json 받아오기 
	function getList(callback, error){
		
		$.getJSON('/open/member/list.json', function(data){
			if(callback){
				callback(data);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	// 삭제 
	function remove(idx, callback, error){
		$.ajax({
			type : 'delete',
			url : '/open/member/delete/' + idx,
			success : function(deleteResult, status, xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	//업뎃
	function update(member, callback, error){
		$.ajax({
			type : 'put',
			url : '/open/member/modify/' + member.idx,
			data : JSON.stringify(member),
			contentType : 'application/json; charset=utf-8',
			success : function(result, status, er){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error) {
					error(er);
				}
			}
		});
	}
//종료
	return {
		getList : getList,
		remove : remove,
		update : update
	};
	
})();