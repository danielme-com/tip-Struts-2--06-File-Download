<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html> 
<html>
	<head>
		<%@include file="/jsp/head.jsp" %>
	</head>
	
	<body>
	
	<s:actionerror cssStyle="font-style:bold;background-color:#ff6e6e;width:95%"/>
	
		<s:form action="fileDownloadResponse" theme="simple">					
			<s:submit key="response"/>
		</s:form>
		<s:form action="fileDownloadStream" theme="simple">					
			<s:submit key="result"/>
		</s:form>
		<%@include file="/jsp/footer.jsp" %>
	</body>
</html>