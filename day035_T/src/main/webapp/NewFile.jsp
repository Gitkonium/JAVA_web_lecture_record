<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 처리 01</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$.ajax({
		type : "GET",
		url : "json/data.json",
		dataType : "json",
		success : function(data){
			var elem = "";
			
			$.each(data, function(index, data){
				elem += "<tr>";
				
				elem += "<td>"+(index+1)+"</td>";
				elem += "<td>"+data.name+"</td>";
				elem += "<td>"+data.content+"</td>";
				
				elem += "</tr>";
			});
			
			$("table tbody").append(elem);
		},
		error : function(){
			console.log("에러발생!");
		}
	});
</script>
	<table border="1">
		<thead>
            <tr>
            	<th>화면에 보이는 번호</th>
                <th>이름</th>
                <th>내용</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
	</table>
</body>
</html>