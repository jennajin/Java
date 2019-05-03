 <%
if(session.getAttribute("firstname") == null){
	response.sendRedirect("requiredlogin.jsp");
}
%>

<!-- header -->
<jsp:include page="header.jsp"/>


<!-- body -->
<div class="container">
	<div class="dashboard-div mt-5 text-center mb-5">
		<div class="dashboard-div mt-5 text-center mb-5">
			<div class="panel">
				<h2>Tab 3</h2>
			 </div>
			 <img class="img_construction" src="images/underconstruction.png" />
		</div>
	</div>
</div>

<!-- footer -->
<jsp:include page="footer.jsp"/>