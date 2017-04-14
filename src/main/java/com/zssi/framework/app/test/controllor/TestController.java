package com.zssi.framework.app.test.controllor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zssi.framework.app.sys.bo.SysZzjgBO;


@Controller
@RequestMapping(value="/test")
public class TestController extends BaseController {
	
	@Autowired
	private SysZzjgBO zzjg;
	
	/**
	 * 打开Word在线编辑
	 * @author liujiansen
	 * @date 2015年10月27日
	 * @return
	 */
	@RequestMapping(value="/testWordOnLine")
	public ModelAndView openPage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("/test/Word");
		modelAndView.addObject("fileName", "1450361034894.doc");
		return modelAndView;
	}
	
	@RequestMapping(value="/wordDy")
	public ModelAndView wordDy(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView("/test/wordDy");
		return modelAndView;
	}
	
	/**
	 * 保存
	 * @author liujiansen
	 * @date 2015年10月27日
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/save")
	public void save(HttpServletRequest request,HttpServletResponse response){
		FileSaver fs=new FileSaver(request,response);
		System.out.println(request.getSession().getServletContext().getRealPath("")+"/"+fs.getFileName());
		fs.saveToFile(request.getSession().getServletContext().getRealPath("")+"/"+fs.getFileName());
		fs.close();
	}
	
	/**
	 * 打开Word在线转PDF页面
	 * @author liujiansen
	 * @date 2015年10月27日
	 * @return
	 */
	@RequestMapping(value="/openWTPPage")
	public ModelAndView openWTPPage(){
		ModelAndView modelAndView = new ModelAndView("/test/WordToPDF");
		return modelAndView;
	}
	
	/**
	 * 保存word为pdf
	 * @author liujiansen
	 * @date 2015年10月27日
	 * @return
	 */
	@RequestMapping(value="/saveToPdfPage")
	public ModelAndView saveToPdfPage(String fileName){
		ModelAndView modelAndView = new ModelAndView("/test/OpenPDF");
		if(fileName!=null&&!"".equals(fileName)){
			modelAndView.addObject("fileName", fileName);
		}
		return modelAndView;
	}
	/**
	 * 保存页面
	 * @author liujiansen
	 * @date 2015年10月27日
	 * @return
	 */
//	@RequestMapping(value="/savePage")
//	public ModelAndView savePage(){
//		ModelAndView modelAndView = new ModelAndView("/test/SaveFile");
//		return modelAndView;
//	}

	//2）后台action和service的处理
	// 2.1 action中主要判断optype的值,
	// 如果是optype=getchildtree，则根据父节点生成子节点列表的jason字符串返回
	// 如果是optype=gettext,则根据传进来的id值获取对应的显示text值返回
	@RequestMapping(value="/xlsList")
	@ResponseBody
	public String execute(HttpServletRequest httpservletrequest,HttpServletResponse httpservletresponse) {
		String optype = httpservletrequest.getParameter("optype");
		String str="";
		if ("getchildtree".equals(optype)) {
			// 获取子节点列表的jason字符串
			str=zzjg.getjson_getchildtree(httpservletrequest, httpservletresponse);
		} else if ("gettext".equals(optype)) {
			// 获取当前id值对应的text显示值
			str=zzjg.getjson_gettext(httpservletrequest, httpservletresponse);
		}
		return str;

	}
	/**
	 * 
	 * @author liangkaidi
	 * @date 2015-12-25
	 * @param httpservletrequest
	 * @param httpservletresponse
	 * @return
	 */
	@RequestMapping(value="/ssksList")
	@ResponseBody
	public String ssks(HttpServletRequest httpservletrequest,HttpServletResponse httpservletresponse) {
		String optype = httpservletrequest.getParameter("optype");
		String str="";
		if ("getchildtree".equals(optype)) {
			// 获取子节点列表的jason字符串
			str=zzjg.getjson_getchildtreessks(httpservletrequest, httpservletresponse);
		} else if ("gettext".equals(optype)) {
			// 获取当前id值对应的text显示值
			str=zzjg.getjson_gettext(httpservletrequest, httpservletresponse);
		}
		return str;

	}
	
	//获取业务科室
	@RequestMapping(value="/xlsList1")
	@ResponseBody
	public String execute1(HttpServletRequest httpservletrequest,HttpServletResponse httpservletresponse) {
		String optype = httpservletrequest.getParameter("optype");
		String str="";
		if ("getchildtree".equals(optype)) {
			// 获取子节点列表的jason字符串
			str=zzjg.getjson_getchildtree1(httpservletrequest, httpservletresponse);
		} else if ("gettext".equals(optype)) {
			// 获取当前id值对应的text显示值
			str=zzjg.getjson_gettext(httpservletrequest, httpservletresponse);
		}
		return str;

	}

}
