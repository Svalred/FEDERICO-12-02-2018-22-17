<%-- main.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<title>北京蓝源进销存系统(教学版)-系统主页</title>
	<%-- jquery lib --%>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>
<body>
	<div styleclass="container">
		<div styleclass="head">
			<div styleclass="head-left">
				<span style="font-weight:bold; color:#1f4906">欢迎您-</span><br />
				<span style="color:#4a940d">${sessionScope['loginEm'].name}</span>
			</div>
			<div class="head-right">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="32%">
							<a href="page_emp_changePwd.action" target="main">
								<img src="images/head-l.gif"	border="0" />
							</a>
						</td>
						<td width="26%">
							<a href="emp_logout.action">
								<img src="images/head-m.gif"	border="0" />
							</a>
						</td>
						<td width="7%">&nbsp;</td>
						<td width="35%"><a href="#"><img src="images/head-r.gif"
								border="0" />
						</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<!--"head"end-->

		<div styleclass="content">
			<div styleclass="left">
				<div style="margin-left:2px;">
					<img src="images/left-top.gif" width="162" height="25" />
				</div>
				<div styleclass="left-bottom">
					<%@include file="/tools/menu.jsp"%>
				</div>
				<!--"left-bottom"end-->
			</div>
			<!--"left"end-->

			<iframe id="frame-contect" src="pages_context.action"
				style="width:848px;float:right;height:530px" scrolling="no"
				name="main" frameborder="0"></iframe>
			<!--"content-right"end-->
		</div>
		<!--"content"end-->
		<div styleclass="footer">
			<div style="margin-top:5px;">
				<table width="98%" border="0" cellpadding="0" cellspacing="0"
					align="center">
					<tr>
						<td width="82%"><img src="images/icon_1.gif" />&nbsp; <a
							styleclass="lanyo" href="www.itcast.cn">传智播客 蓝源信息技术 2014</a></td>
						<td width="18%" valign="middle"><img src="images/icon_2.gif" />&nbsp;
							<a styleclass="lanyo" href="#">如有疑问请与技术人员联系</a></td>
					</tr>
				</table>
			</div>

		</div>
		<!--"footer"end-->
	</div>
	<!--"container"end-->
	<%@include file="/tools/mask.jsp"%>
</body>
</html>
<%-- end of main.jsp --%>