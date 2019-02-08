<%@page import="lesson10.xmljson.MateGroup"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>JSP Page</title>
</head>
<body>
	<h1>Hello Mate!</h1>
	<FORM METHOD="GET" action="/MateAcademy/jsp">
		Please enter groupId: <BR>
		<TEXTAREA NAME="groupId" ROWS="1"></TEXTAREA>
		<BR> <INPUT TYPE="SUBMIT" VALUE="Submit">
	</FORM>

	<%
		MateGroup mateGroup = (MateGroup) request.getAttribute("model");
		if (mateGroup != null) {
	%>
	<h3>You have selected mateGroup:</h3>
	<h5>
		Id=<%=mateGroup.getId()%></h5>
	<table border="2">
		<tr>
			<th>Student</th>
			<th>Year of born</th>
		</tr>
		<c:forEach items="<%=mateGroup.getStudents()%>" var="student"
			varStatus="status">
			<tr>
				<td>${student.name}</td>
				<td>${student.yearOfBorn}</td>
			</tr>
		</c:forEach>
	</table>
	<h5>room on ${model.room.street} street, in ${model.room.city}</h5>
	<ul>
		<li><%=mateGroup.getHumanResources()%></li>
	</ul>
	<%=mateGroup%>
	<%
		}
	%>
</body>
</html>



