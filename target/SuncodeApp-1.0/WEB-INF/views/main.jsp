<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Suncode</title>

<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script 	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/css/styles.css" />" 	rel="stylesheet">

</head>
<body>
	<h1 id='error' style='color: red;'>
		<%
			String error = request.getParameter("error");
			if (error != null && error.length() != 0) {
				out.print(error);
			} else {
				out.print("&nbsp;");
			}
		%>
	</h1>

	<div id="main-center" class="border">
		<form>
			<select class="btn-lg" id="tableType">
				<option value="kolumna1">kolumna1</option>
				<option value="kolumna2">kolumna2</option>
				<option value="kolumna3">kolumna3</option>
				<option value="kolumna4">kolumna4</option>
			</select>
			<button onclick="send()" type="button" class="btn-lg">Send</button>
		</form>
		</br>

		<h1>Your resoult is:</h1>
		</br>

			<table class="gridTable">
			<h3>Multiple Values :</h3>
						<tbody id="multipleResults">
						</tbody>
					</table>
				
				<table class="gridTable">
			<h3>Single Values :</h3>
						<tbody id="singleResults">
						</tbody>
					</table>
				</div>
				
				
		<script>
			$(document).ready(function() {
				var cleanUp = function() {
					$('#error').html('&nbsp;');
				}
				setTimeout(cleanUp, 2000);
			});
		</script>

		<script src="<c:url value="/resources/js/ajax-reload.js" />">
			
		</script>
</body>
</html>
