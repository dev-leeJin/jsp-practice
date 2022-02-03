<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Integer> lotto = new ArrayList<>();
	while(true){
		int rn = (int)(Math.random() * 45) +1;
		//contains(): 리스트 내부에 해당 객체가 존재하면 true를 리턴.
		if (!lotto.contains(rn)) {
			lotto.add(rn);
			}
			if(lotto.size() == 6){
				break;
			}
		}
		//리스트의 오름차 정렬방법.
		Collections.sort(lotto);
		
		//<%@ (directive(지시자))는 import를 사용할 때 사용하고 ctrl+space를 누르면 자동 완성 된다.
		//(자바와는 다르게 문자열로 지정) *은 모든 import 사용 가능.(sql로 import할 경우 하나하나 따로 해야함.)
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로또번호 생성 결과</h1>
	<p>
		이번주 로또는 이 번호다 ! <br>
		<%
			for(Integer num : lotto){
				out.println(num +"");
				Thread.sleep(700); //CPU를 잠시 멈추는 메서드 (0.7초 후에 출력(700))
				out.flush(); //브라우저의 출력 버퍼를 비우는 메서드.(적지 않으면 다 출력되는걸 기다렸다가 출력)
				}
		%>
	</p>
</body>
</html>