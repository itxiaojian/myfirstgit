<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>
<%
	FileSaver fs = new FileSaver(request, response);
	String filename = request.getParameter("filename");
	String err = "";
	if (filename != null && filename.length() > 0) {
		String fileName = "\\" + filename + fs.getFileExtName();
		fs.saveToFile(request.getSession().getServletContext()
				.getRealPath("WordDataTag/doc")
				+ fileName);
	} else {
		err = "<script>alert('未获得文件名称');</script>";
	}
	fs.close();
%>
