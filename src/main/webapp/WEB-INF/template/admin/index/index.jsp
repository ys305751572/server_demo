<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/resource/common/jsp/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <head lang="zh-CN">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">
        <meta name="description" content="Violate Responsive Admin Template">
        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
        <title>后台管理系统</title>
        <%@ include file="/WEB-INF/resource/common/jsp/statics.css.jsp" %>
    </head>
    <body id="skin-cloth">
        <div class="clearfix"></div>
        <section id="main" class="p-relative" role="main"> <!-- Sidebar -->
        <%@ include file="menu.jsp" %>
            <!-- Content -->
            <section id="content" class="container">
              	<iframe id="iframe" name="iframe" src="index.jhtml" frameborder="0"></iframe>
            </section>
        </section>
        <%@ include file="/WEB-INF/resource/common/jsp/statics.js.jsp" %>
    </body>
</html>
