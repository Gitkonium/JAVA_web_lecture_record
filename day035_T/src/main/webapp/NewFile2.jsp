<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<br><br>
	<img alt="더미 이미지 데이터 01" src="images/test01.jpg"> <br><br>
	<img alt="더미 이미지 데이터 02" src="images/test02.jpg"> <br><br>
	<button id="btn">버튼</button>
<script type="text/javascript">
$(document).ready(function(){
    
    $("#checkIdDupl").on("click",function(){
        // #MID의 값을 가져옵니다.
        var MID = $("#MID").val();
        
        $.ajax({
            type: "POST",
            url: "CheckId",
            data: { 'MID': MID }, // MID 변수의 값을 전달합니다.
            dataType: 'text',
            success: function(data){
                midResult = data;
                
                if(midResult === "suc"){
                    $("#resultDiv").text("사용 가능한 아이디입니다.");
                } else{
                    $("#resultDiv").text("사용 불가능한 아이디입니다.");
                }
        
            },
            error: function(xhr, textStatus, errorThrown){
                console.error('에러발생!');
                console.error('에러의 종류 : ' + textStatus);
            }
        });
    
    });
});
</script>
</body>
</html>