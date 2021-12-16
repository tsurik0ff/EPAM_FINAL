<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Profile | Online-shop</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>

<div class="container">
    <c:if test="${sessionScope.user == null}">
        <div class="row justify-content-center">
            <div class="alert alert-danger fade show " role="alert">
                <fmt:message bundle="${loc}" key="language.noRights"/>
            </div>
        </div>
    </c:if>
    <c:if test="${sessionScope.user != null}">
        <div class="p-3 p-md-4 border rounded-3 my-sm-3">
            <div class="col"></div>
            <div class="col-6">
                <h2><fmt:message bundle="${loc}" key="language.profile"/></h2>
            </div>
            <table class="table">
                <tr>

                    <td width="300px">
                        <h4 class="text">
                            <fmt:message bundle="${loc}" key="language.name"/>:
                        </h4>
                        <h4 class="text">
                            <fmt:message bundle="${loc}" key="language.surname"/>:
                        </h4>
                        <h4 class="text">
                            <fmt:message bundle="${loc}" key="language.patronymic"/>:
                        </h4>
                    </td>
                    <td><h4><c:out value="${userInformation.name}"/></h4>
                        <h4><c:out value="${userInformation.surname}"/></h4>
                        <h4><c:out value="${userInformation.patronymic}"/></h4>
                    </td>
                </tr>
                <tr>

                    <td width="300px"><h4 class="text><fmt:message bundle="${loc}"
                                                                            key="language.mobilePhone"/>:</h4></td>
                    <td><h4>+<c:out value="${userInformation.phone}"/></h4></td>
                </tr>
                <tr>

                    <td width="300px"><h4 class="text"><fmt:message bundle="${loc}"
                                                                            key="language.emailAddress"/>:</h4></td>
                    <td><h4>${sessionScope.user.email}</h4></td>
                </tr>
            </table>
        </div>
    </c:if>
</div>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>