
	function check(){
		var mid=$('#mid').val();
		
		$.ajax({
			type : "POST",
			url : "check.do",
			data : { 'mid' : mid },
			dataType : 'text',
			success : function(data){
				if(data=='1'){
					$("#msg").text("사용가능한 ID 입니다! :D");
				}
				else{
					$("#msg").text("중복 ID 입니다... 다른 ID 를 사용해주세요!~~");
				}
			},
			error : function(error){
				console.log('에러발생!');
				console.log('에러의 종류 : '+error);
			}
		});
	}
