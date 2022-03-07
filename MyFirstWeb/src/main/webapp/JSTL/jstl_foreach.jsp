<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 태그라이브러리 지정을 해 주세요. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--

	int total = 0;
	for(int i =1; i <101; i++){
		total += i;
	}
	out.print("<h1>1부터 100까지 총합은 :" +total+"</h1>");
--%>
	<!-- begin은 시작값, end 끝값(포함함), step 증가숫자, var 태그내에서 쓸 변수명 -->
	<c:forEach begin="1" end ="100" step="1" var="number">
		<c:set var="total" value="${total + number }"></c:set>
	</c:forEach>
	<h1>1~100까지의 누적합 : ${total }</h1>
	
	<hr/>
	<h1>구구단 4단 출력</h1>
	<!-- foreach문을 이용해서 구구단 4단을 출력해보세요. 
	begin="1" end="9" var="dan"-->
	<c:forEach begin="1" end="9" var="dan">
		4 X ${dan} = ${4 * dan }<hr/>
	</c:forEach>
	<hr/>
	<!-- 중첩 foreach를 이용해서 2~9단까지 출력해주세요. -->
	<c:forEach var="dan" begin="2" end="9" step="1">
		<c:forEach var="hang" begin="1" end="9" step="1">
			<c:out value="${dan } X ${hang } = ${dan*hang }"/><br/>
		</c:forEach>
			<hr/>
	</c:forEach>
	
	
	<hr/>
	<h1>숫자가 아닌 요소를 반복하는 JSTL</h1>
	<%-- arr변수 내에 과일 5개이름을 배열로 저장하는 구문 --%>
	<c:set var="arr" value='<%= new String[] {"사과", "딸기", "망고", "바나나", "포도"} %>'/>
	<%-- c:forEach는 향상된 for문처럼 쓸 수도 있습니다 --%>
	<c:forEach var="i" items="${arr }">
		${i } &nbsp;
	</c:forEach>
	<%--
		// 위의 코드는 아래의 코드를 대행한다. // begin, end, step가 있으면 for문처럼 쓰고 var,item을 쓰면 
										   향상된 for문처럼 쓴다. 
		String[] arr = {"사과","딸기","망고","바나나","포도"};
		for(String i : arr){
			out.println(i + "&nbsp;");
		}
	 --%>
	 
	 <!-- int 배열에 10, 20, 30, 40, 50을 넣어주시고
	 c:forEach문을 이용해 화면에 출력해주세요. 변수명은 마음대로 만들어주셔도 됩니다. -->
	 <hr/>
	 <c:set var="arr1" value="<%= new int[] {10, 20, 30, 40, 50} %>" />
	 <c:forEach var= "a" items="${arr1 }">
	 	${a } &nbsp;
	 </c:forEach>
</body>
</html>