<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/resource/common/jsp/include.inc.jsp" %>
<%@ include file="/WEB-INF/resource/common/jsp/statics.css.jsp" %>
<%@ include file="/WEB-INF/resource/common/jsp/statics.js.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head lang="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <meta name="format-detection" content="telephone=no">
    <meta charset="UTF-8">
    <meta name="description" content="Violate Responsive Admin Template">
    <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
    <title>后台管理系统</title>
</head>
<body id="skin-cloth">
<header id="header" class="media">
    <a href="" id="menu-toggle"></a>
    <a class="logo pull-left" href="index.html">SUPER ADMIN 1.0</a>

    <div class="media-body">
        <div class="media" id="top-menu">
            <div id="time" class="pull-right">
                <span id="hours"></span>
                :
                <span id="min"></span>
                :
                <span id="sec"></span>
            </div>
        </div>
    </div>
</header>
<div class="clearfix"></div>
<section id="main" class="p-relative" role="main">
    <!-- Sidebar -->
    <aside id="sidebar">
        <!-- Sidbar Widgets -->
        <div class="side-widgets overflow">
            <!-- Profile Menu -->
            <div class="text-center s-widget m-b-25 dropdown" id="profile-menu">
                <a href="" data-toggle="dropdown">
                    <img class="profile-pic" src="img/profile-pic.jpg" alt="">
                </a>
                <h4 class="m-0">Malinda Hollaway</h4>
            </div>

            <!-- Calendar -->
            <div class="s-widget m-b-25">
                <div id="sidebar-calendar"></div>
            </div>
        </div>
        <!-- Side Menu -->
        <ul class="list-unstyled side-menu" id="first-level-menu">
            <li class="dropdown">
                <a class="sa-side-ui" href="">
                    <span class="menu-item">User Interface</span>
                </a>
                <ul class="list-unstyled menu-item">
                    <li><a href="buttons.html" class="submenu">Buttons</a></li>
                    <li><a href="labels.html" class="submenu">Labels</a></li>
                    <li><a href="images-icons.html" class="submenu">Images &amp; Icons</a></li>
                    <li><a href="alerts.html">Alerts</a></li>
                    <li><a href="media.html">Media</a></li>
                    <li><a href="components.html">Components</a></li>
                    <li><a href="other-components.html">Others</a></li>
                </ul>
            </li>
        </ul>
    </aside>
    <!-- Content -->
    <section id="content" class="container">

    </section>
    <br/><br/>
</section>
<script type="text/javascript">
    // 初始化左侧菜单
    $(function () {
        var url = "";
        $.post(url, function (data) {
            $.each(data.data, function () {
                var $li = $("<li class='dropdown'><a class='sa-side-ui' href = ''><span class='menu-item'>User Interface<span/></a></li>");
                renderSubMenu(this.children,$li);
            });
        });
    });

    // 渲染二级菜单
    var renderSubMenu = function (data, $menu) {
        var $ul = $("<ul class='list-unstyled menu-item'></ul>");
        $.each(data,function() {
            var $li = $("<li><a href='buttons.html' class='submenu'>Buttons</a></li>");
        });
        $li.appendTo($ul);
        $ul.appendTo($menu);

        $menu.find(".submenu").on("click",function() {
            var $this = $(this);
            $("#first-level-menu").find("li").each(function() {
                $menuLi = $(this);
                $menuLi.hasClass('active') && $menuLi.removeClass('active').parent().parent().removeClass('active');

                // 加载页面
                loadContent($("#content"),this.url);
            });
        });
    };

    var loadContent = function(obj,url) {
        $.get(${contextPath} + url).done(function(data) {
            obj.html(data);
        });
    }
</script>
</body>
</html>
