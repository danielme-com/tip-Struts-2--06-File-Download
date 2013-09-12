<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<html>
	<head>
		<%@include file="/jsp/head.jsp" %>
	</head>
	
	<body>
	
	<s:actionerror cssStyle="font-style:bold;background-color:#ff6e6e;width:95%"/>
	
		<s:form action="fileDownloadAction" theme="simple">					
			<s:submit key="response" method="response"/>
			<s:submit key="result" method="resultStream"/>
		</s:form>
		<%@include file="/jsp/footer.jsp" %>
	</body>
</html>