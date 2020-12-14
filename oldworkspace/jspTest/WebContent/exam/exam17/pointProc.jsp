<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
    
<%	
	int counter = Integer.parseInt(request.getParameter("counter"));
	String[] a = new String[counter];
	String[] titles = {"이름", "국어", "영어", "수학", "과학", "역사"};
	String[] names = {"name", "kor", "eng", "mat", "sci", "his"};
	int[] tot = new int[3];
	double[] avg = new double[3];
	
	for(int j=1; j<=3; j++){
		for(int i=0; i<names.length; i++){
			if(j==1){
				a[i] = request.getParameter(names[i]+j);
				if(i==0){}
				else{
					tot[j-1] += Integer.parseInt(a[i]);
				}
			}else if(j==2){
				a[i+6] = request.getParameter(names[i]+j);
				if(i==0){}
				else{
					tot[j-1] += Integer.parseInt(a[i+6]);
				}
			}else {
				a[i+12] = request.getParameter(names[i]+j);
				if(i==0){}
				else{
					tot[j-1] += Integer.parseInt(a[i+12]);
				}
			}
		}
		avg[j-1] = tot[j-1] / 5.0;
	}

	for(int j=1; j<=3; j++){
		for(int i=0; i<names.length; i++){
			if(j==1){
				out.print(titles[i]+"&nbsp;");
				out.print(a[i]+"<br>");
			}else if(j==2){
				out.print(titles[i]+"&nbsp;");
				out.print(a[i+6]+"<br>");
			}else {
				out.print(titles[i]+"&nbsp;");
				out.print(a[i+12]+"<br>");
			}
		}
		out.print("총점 ");
		out.print(tot[j-1]+"<br>");
		out.print("평균 ");
		out.print(avg[j-1]+"<br>");
		out.print("<hr>");
	}
			
			
			
%>


    