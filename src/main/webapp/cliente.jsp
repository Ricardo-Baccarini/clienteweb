<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="br.com.fabricadeprogramador.model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function confirma(parametroi) {
		if (window.confirm("Deseja mesmo excluir?")) {
			location.href = "cliente?i=" + parametroi;
		}
	}
</script>
</head>

<body>

	<div>
		<%
			Object msg = request.getAttribute("msg");
			if (msg != null) {
				String msgStr = (String) msg;
				out.print(msgStr);
			}
		%>
	</div>
	<form method="post" action="cliente">
		E-mail: <input type="text" value="" name="e-mail" /> <input
			type="submit" value="Save">
	</form>

	<%
		List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
		int i = 0;
		for (Cliente c : lista) {
			out.print(c.getEmail() + "<a href='javascript:confirma(" + i + ")'> excluir </a> <br/>");
			i++;
		}
	%>

</body>
</html>