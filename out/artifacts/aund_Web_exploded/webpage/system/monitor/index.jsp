<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery"></t:base>
<script type="text/javascript">
    $(function(){
		var tagert_URL = "<%=request.getContextPath()%>/monitoring";
		window.location.href = tagert_URL;
    });
</script>