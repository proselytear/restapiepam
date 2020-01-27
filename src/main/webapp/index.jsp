<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="messages" />

<html lang="${param.lang}">
<head>
    <title>PhraseApp - i18n</title>
</head>
<body>

<ul>
    <li><a href="?lang=en"><fmt:message key="label.lang.en" /></a></li>
    <li><a href="?lang=gr"><fmt:message key="label.lang.de" /></a></li>
</ul>

<h1>
    <fmt:message key="welcome.message" />
</h1>
</body>
</html>