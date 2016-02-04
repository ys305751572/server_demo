<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/resource/common/jsp/include.inc.jsp"%>
<form>
	<body id="skin-blur-violate">
		<!-- Breadcrumb -->
		<ol class="breadcrumb hidden-xs">
			<li><a href="#">Home</a></li>
			<li><a href="#">Library</a></li>
			<li class="active">Data</li>
		</ol>
		<h4 class="page-title">TABLES</h4>
		<!-- Table Hover -->
		<div class="block-area" id="tableHover">
			<h3 class="block-title">Table with Hover Style</h3>
			<div class="table-responsive overflow">
				<table class="table table-bordered table-hover tile">
					<thead>
						<tr>
							<th>No.</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Username</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Jhon</td>
							<td>Makinton</td>
							<td>@makinton</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Malinda</td>
							<td>Hollaway</td>
							<td>@hollway</td>
						</tr>
						<tr>
							<td>3</td>
							<td>Wayn</td>
							<td>Parnel</td>
							<td>@wayne123</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$(function(){
			findPageMenuByCurrentUser();
		});
	</script>
</form>

