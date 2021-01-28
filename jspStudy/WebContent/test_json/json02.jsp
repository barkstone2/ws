<%@page import="java.util.regex.Pattern"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
String kor_ = request.getParameter("kor");
String eng_ = request.getParameter("eng");
String mat_ = request.getParameter("mat");
String sci_ = request.getParameter("sci");
String his_ = request.getParameter("his");

int kor = kor_!=null&&!kor_.trim().equals("")&&Pattern.matches("^[0-9]*$", kor_)?Integer.parseInt(kor_):0;
int eng = eng_!=null&&!eng_.trim().equals("")&&Pattern.matches("^[0-9]*$", eng_)?Integer.parseInt(eng_):0;
int mat = mat_!=null&&!mat_.trim().equals("")&&Pattern.matches("^[0-9]*$", mat_)?Integer.parseInt(mat_):0;
int sci = sci_!=null&&!sci_.trim().equals("")&&Pattern.matches("^[0-9]*$", sci_)?Integer.parseInt(sci_):0;
int his = his_!=null&&!his_.trim().equals("")&&Pattern.matches("^[0-9]*$", his_)?Integer.parseInt(his_):0;
int tot = kor + eng + mat + sci + his;
double avg = tot / 5.0d;

JSONObject jsonobj = new JSONObject();
jsonobj.put("name", name);
jsonobj.put("kor", kor);
jsonobj.put("eng", eng);
jsonobj.put("mat", mat);
jsonobj.put("sci", sci);
jsonobj.put("his", his);
jsonobj.put("tot", tot);
jsonobj.put("avg", avg);
String json_sj = jsonobj.toJSONString();
//System.out.println("json: "+json_sj);
out.println(json_sj);

/* 

out.print("name : " +name);
out.print("kor : " +kor);
out.print("eng : " +eng);
out.print("mat : " +mat);
out.print("sci : " +sci);
out.print("his : " +his);
out.print("tot : " +tot);
out.print("avg : " +avg); */
%>
