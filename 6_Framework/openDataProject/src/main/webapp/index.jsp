<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<title>대기오염 공공데이터</title>
</head>
<body>
	
	<h1>실시간 대기오염 정보</h1>
	
	지역 : 
	<select id="location">
      <option>서울</option>
      <option>부산</option>
      <option>대전</option>
   </select>
   
   <button id="btn1">해당 지역 대기 오염 정보</button>
   <br><br>
   
   <table border="1" id="result1">
      <thead>
         <tr>
            <th>측정소명</th>
            <th>측정일시</th>
            <th>통합대기환경수치</th>
            <th>미세먼지농도</th>
            <th>아황산가스농도</th>
            <th>일산화탄소농도</th>
            <th>이산화탄소농도</th>
            <th>오존농도</th>
         </tr>
      </thead>
      <tbody></tbody>
   </table>
   
   <script>
   
   $(function(){
	   $("#btn1").click(function(){
			
		   $.ajax({
				url : "air",
				data : { location : $("#location").val()},
				success : function(data) {
					// console.log(data);
					// console.log(data.response.body.items);
					
					const itemArr = data.response.body.items;
					
					let value = "";
					
					for(let item of itemArr){
						console.log(item);
						value += "<tr>"
									+"<td>"+ item.stationName +"</td>"
									+"<td>"+ item.dataTime +"</td>"
									+"<td>"+ item.khaiValue +"</td>"
									+"<td>"+ item.pm10Value +"</td>"
									+"<td>"+ item.so2Value +"</td>"
									+"<td>"+ item.coValue +"</td>"
									+"<td>"+ item.no2Value +"</td>"
									+"<td>"+ item.o3Value +"</td>"
								+"</tr>"
					}
					
					$("#result1 > tbody").html(value);
						
				}, error : function() {
					console.log("통신 실패");
				}
			   
			   
			   
			   
		   })
		   
		   
	   })
	   
	   
   })
   
   
   
   
   </script>
</body>
</html>