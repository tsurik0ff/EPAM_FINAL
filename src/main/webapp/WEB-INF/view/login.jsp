<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/header.jsp"/>
<head>
    <title>Log In | Online-shop</title>
    <jsp:include page="fragments/headerLinks.jsp"/>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.language" var="loc"/>
<fmt:setBundle basename="information" var="info"/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col"></div>
        <div class="col-6 my-sm-3">
            <c:if test="${sessionScope.user != null}">
                <div class="alert alert-danger fade show " role="alert">
                    <fmt:message bundle="${loc}" key="language.alreadyLoggedIn"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.user == null}">

                <h1 class="mt-5 fw-bold"><fmt:message bundle="${loc}" key="language.signIn"/></h1>

                <c:if test="${errorMessage=='true'}">
                    <div class="alert alert-danger fade show" role="alert">
                        <fmt:message bundle="${loc}" key="language.loginError"/>
                    </div>
                </c:if>

                <form action="${pageContext.request.contextPath}/online-shop?command=checkLogin" method="post">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label"><fmt:message bundle="${loc}"
                                                                                        key="language.emailAddress"/></label>
                        <div class="input-group w-100">
                            <input name="email" type="email" style="border-color:black" class="form-control" id="exampleInputEmail1"
                                   aria-describedby="emailHelp" placeholder="name@example.com">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="passwordInput" class="form-label"><fmt:message bundle="${loc}"
                                                                                   key="language.password"/></label>
                        <div class="input-group w-100">
                            <input name="password" style="border-color:black" type="password" class="form-control" id="passwordInput"
                                   placeholder="password">
                        </div>
                    </div>
                    <button type="submit" class="btn btn" style="background-color:deepskyblue"><fmt:message bundle="${loc}"
                                                                               key="language.signIn"/></button>
                </form>
                <hr class="dropdown-divider">
                <p class="text-muted" style="color:black"><fmt:message bundle="${loc}" key="language.noAccount"/> <a
                        href="/online-shop?command=logUp" style="color:black"><fmt:message bundle="${loc}" key="language.logUp"/></a></p>
                <a href="/online-shop?command=main" style="color:black"><fmt:message bundle="${loc}" key="language.home"/></a>
            </c:if>
        </div>
        <div class="col"></div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
<jsp:include page="fragments/footer.jsp"/>
</html>

