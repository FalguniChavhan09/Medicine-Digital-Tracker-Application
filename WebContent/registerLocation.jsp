<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
  String lat=request.getParameter("lat");
  String lng=request.getParameter("lng");
  
  System.out.println("lat "+lat);
  System.out.println("lng "+lng);
  %>
<form action="AdvRegister" method="post" onsubmit="return validation()">
				
					 
				    <center>
				
						<label>Address</label>
						<input type="text" placeholder="Address" name="address" required/>
					</div> 
					
				<br>
				<div>
				
				</div>	
					
						<label>Taluka</label>
						<input type="text" placeholder="taluka" name="taluka" required />
					</div> 
					
				<br>
				
					<label>Latitude</label>
						
						<input class="form-control" type="text" value="<%=lat %>" placeholder="lat" name="lat" required/> 
					</div> 
				<br>
					 <label>Longitude</label>
						
						<input class="form-control" type="text" value="<%=lng %>"placeholder="lng" name="lng" required/>
                                            
					</div>
					</div>
					<br/>
				

				<input type="submit" value="Submit"></div>
				</center>
				
				</form>
				




</body>
</html>