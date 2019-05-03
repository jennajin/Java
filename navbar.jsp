<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
      <a class="navbar-brand" href="dashboard.jsp">XYZ Co.</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="tab1.jsp">Tab1</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="tab2.jsp">Tab2</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="tab3.jsp">Tab3</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="tab4.jsp">Tab4</a>
          </li>
          
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <span class="text-white mr-3"> Welcome, <%=session.getAttribute("firstname") %> !</span>
          <a href="Logout" class="btn btn-outline-success my-2 my-sm-0">Logout</a>
        </form>
      </div>
    </nav>