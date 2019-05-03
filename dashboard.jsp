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
		    	<div class="panel"> 
			   		<h2>DASHBOARD</h2>
		   		</div>
		   		<div class="jumbotron jumbotron-flud bg-white mt-1">
			   		<div class="row">
			   		 	<div class="col mx-2 text-left p-1" style="border:solid black 1px;"> Future Enhancement </div>
			   			<div class="col mx-2"> 
			   				<div class="row mb-3 p-1" style="border:solid black 1px;"> Future Enhancement <br/><br/><br/><br/><br/><br/> </div>
			   				<div class="row p-1" style="border:solid black 1px;"> Future Enhancement <br/><br/><br/><br/><br/><br/> </div>
			   			</div>
		   			</div>
		   		</div>
		   	</div>
		</div>
			    
<!-- footer -->
<jsp:include page="footer.jsp"/>