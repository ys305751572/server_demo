<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/resource/common/jsp/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
        <meta name="format-detection" content="telephone=no">
        <meta charset="UTF-8">
        <meta name="description" content="Violate Responsive Admin Template">
        <meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
        <title>Super Admin Responsive Template</title>
        <!-- CSS -->
        <%@ include file="/WEB-INF/resource/common/jsp/statics.css.jsp"%>
    </head>
    <body id="skin-blur-violate">
        <section id="login">
            <header>
                <h1>SUPER ADMIN</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla eu risus. Curabitur commodo lorem fringilla enim feugiat commodo sed ac lacus.</p>
            </header>
        
            <div class="clearfix"></div>
            
            <!-- Login -->
            <form class="box tile animated active" id="box-login">
                <h2 class="m-t-0 m-b-15">Login</h2>
                <input type="text" class="login-control m-b-10" placeholder="Username or Email Address">
                <input type="password" class="login-control" placeholder="Password">
               	<div class="checkbox m-b-20">
                    <label>
                       <input type="text" id="captcha" name="captcha" class="text captcha" maxlength="4" autocomplete="off" />
                       	<img id="captchaImage" class="captchaImage" src="${contextPath}/admin/common/captcha.jhtml" title="输入验证码" />
                                                                                  验证码
                    </label>
                </div>
               
                <div class="checkbox m-b-20">
                    <label>
                        <input type="checkbox">
                                                                                  记住账号
                    </label>
                </div>
                <button class="btn btn-sm m-r-5" id="loginBtn">登录</button>
                <small>
                    <a class="box-switcher" data-switch="box-register" href="">注册</a> 或
                    <a class="box-switcher" data-switch="box-reset" href="">忘记密码</a>
                </small>
            </form>
            
            <!-- Register -->
            <form class="box animated tile" id="box-register">
                <h2 class="m-t-0 m-b-15">注册</h2>
                <input type="text" class="login-control m-b-10" placeholder="Full Name">
                <input type="text" class="login-control m-b-10" placeholder="Username">
                <input type="email" class="login-control m-b-10" placeholder="Email Address">    
                <input type="password" class="login-control m-b-10" placeholder="Password">
                <input type="password" class="login-control m-b-20" placeholder="Confirm Password">
                <button class="btn btn-sm m-r-5">注册</button>
                <small><a class="box-switcher" data-switch="box-login" href="">Already have an Account?</a></small>
            </form>
            
            <!-- Forgot Password -->
            <form class="box animated tile" id="box-reset">
                <h2 class="m-t-0 m-b-15">Reset Password</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla eu risus. Curabitur commodo lorem fringilla enim feugiat commodo sed ac lacus.</p>
                <input type="email" class="login-control m-b-20" placeholder="Email Address">    
                <button class="btn btn-sm m-r-5">Reset Password</button>
                <small><a class="box-switcher" data-switch="box-login" href="">Already have an Account?</a></small>
            </form>
        </section>                      
        <%@ include file="/WEB-INF/resource/common/jsp/statics.js.jsp"%>
        <script type="text/javascript">
        	$(function() {
        		var $loginBtn = $("#loginBtn");
        		var $form = $("box-login");
        		
        		$("body").keydown(function(e) {
        			if(e.keyCode == 13) {
        				
        			}
        		});
        		
        		var param = $form.serialize();
        		var doLogin = function() {
        			$.ajax({
        				url : "${contextPath}/login.jhtml",
        				type : "post",
        				dataType : "json",
        				data : param,
        				success : function() {
        					
        				},
        				error:function() {
        					
        				}
        			});
        		}
        	});
        </script>
    </body>
</html>
