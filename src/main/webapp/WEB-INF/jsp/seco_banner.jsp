<%@ page language="java" contentType="text/html; 
	charset=UTF-8" pageEncoding="UTF-8"%>	
	
	<div class="bnr">
	<%	for(int i=0; i<4; i++){
		int bnrNum = 1 + (int)(Math.random() * 42); %>	
		<img src="images/bnr/bnr<%=bnrNum %>.png" alt="広告">
	<%} %>
	</div>
