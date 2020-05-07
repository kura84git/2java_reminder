<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Remind, java.util.List" %>
<%@ page import="java.util.List" %>
<%
/*
//アプリケーションスコープに保存されたリマインドリストを取得
List<Remind> remindList = (List<Remind>)application.getAttribute("remindList");
*/

//リクエストスコープ(2020/05/07[kurahashi])
List<Remind> remindList = (List<Remind>)request.getAttribute("remindList");

//リクエストスコープに保存したエラーメッセージを取得(2020/04/26[mori])
String errorMsg = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reminder</title>
</head>
<body>
<h1>リマインダー</h1>

<p>1234さん、ログイン中</p> <!-- 仮のユーザーID (2020/05/07[kurahashi]) -->

<form action="/2java_reminder/Main" method="post"> <!-- ②リマインド内容をMainサーブレットにdoPost -->
	<p>リマインド内容：<input type="text" name="remind"></p>

	<p>カテゴリ：<input type="text" name="category"></p> <!-- (2020/05/07[kurahashi]) -->
	<p>目標達成日：<input type="date" name="target_date"> <!-- (2020/05/07[kurahashi]) -->
	<p>
			<input type="checkbox" name="important_mark" value="通常" checked="checked">重要度：通常
			<input type="checkbox" name="important_mark" value="重要" >重要度：重要
	</p> <!-- (2020/05/07[kurahashi]) -->

	<p><input type="submit" value="リマインドを保存する！"></p>
</form>
<% if(errorMsg != null){ %><!--  errorLogの追記(2020/04/26[mori]) -->
	<p><%= errorMsg %></p>
<% } %>



<% for(Remind remind : remindList) { %>
	<p><%= remind.getRemind() %>  カテゴリ：<%= remind.getCategory() %>  作成日：<%= remind.getCreated_date() %>  目標達成日：<%= remind.getTarget_date() %>  重要度：<%= remind.getImportant_mark() %></p>
	<!-- (2020/05/07[kurahashi]) -->
<% } %>


</body>
</html>