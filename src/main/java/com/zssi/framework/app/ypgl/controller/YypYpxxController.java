package com.zssi.framework.app.ypgl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.model.YcwBgsf;
import com.zssi.framework.app.cwgl.service.YcwBgsfService;
import com.zssi.framework.app.jybzgl.model.YjyXmxx;
import com.zssi.framework.app.mass.service.MassInfoService;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ResponseData;
import com.zssi.framework.app.wxpt.service.WglXgxxService;
import com.zssi.framework.app.ypgl.model.YypGh;
import com.zssi.framework.app.ypgl.model.YypLy;
import com.zssi.framework.app.ypgl.model.YypTy;
import com.zssi.framework.app.ypgl.model.YypYpxx;
import com.zssi.framework.app.ypgl.service.YypGhService;
import com.zssi.framework.app.ypgl.service.YypLyService;
import com.zssi.framework.app.ypgl.service.YypSfxmmxService;
import com.zssi.framework.app.ypgl.service.YypTyService;
import com.zssi.framework.app.ypgl.service.YypYpxxService;

/**
 * 
 * @author wangyong
 * @date 2015年9月24日
 */
@Controller
@RequestMapping("/ypgl/YYpYpxx")
public class YypYpxxController extends BaseController{
	
	protected final transient Logger logger = LoggerFactory
			.getPresentationLog(YypYpxxController.class);
	
	@Autowired
	private YypYpxxService yypYpxxService;
	@Autowired
	private YypLyService Lyservice;
	@Autowired
	private YypGhService Ghservice;
	@Autowired
	private YypTyService Tyservice;
	@Autowired
	private YcwBgsfService bgsfService;
	@Autowired
	private YypSfxmmxService sfxmmxService;
	@Autowired
	private WglXgxxService wglXgxxService;
	@Autowired
	MassInfoService massInfoService;
	
	/**
	 * 后台：样品信息
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/getYpxxList")
	@ResponseBody
	public Pagination<Map<String, Object>> getYpxxList(Integer start,Integer limit,String canshu,String bgbh,String ypbh,String ypmc,String yplx,
			String ypdj,String ypzt,String ggxh,String szcs,String scrqpc,String jyks,String ywks,String cyry,String cydd,String cyrq,String sb,
			String jyfydd,String yhxtk,String jylx,String jyhth,String jcfyry,String dyrq,String djsj,String wcqx,String wtdw,String wtlxr,
			String sjhm,String sjdw,String lxr,String scdw,String scdwlxr,String gcmc,String gclxr,String sgdw,String gcsjdw,String jsdw,
			String jldw,String jlr,String jzdw,String jzr,String slr){
		return yypYpxxService.getYpxxList(start, limit,canshu,bgbh,ypbh,ypmc,yplx,ypdj,ypzt,ggxh,szcs,scrqpc,jyks,ywks,cyry,cydd,cyrq,sb,jyfydd,
				yhxtk,jylx,jyhth,jcfyry,dyrq,djsj,wcqx,wtdw,wtlxr,sjhm,sjdw,lxr,scdw,scdwlxr,gcmc,gclxr,sgdw,gcsjdw,jsdw,jldw,jlr,jzdw,jzr,slr);
	}
	
	/**
	 * 
	 * @author wangyong
	 * @date 2015年9月24日
	 * @return
	 */
	@RequestMapping(value = "/YpxxPage")
	public ModelAndView openPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypYpxxList");
		return modelAndView;
	}
	
	@RequestMapping(value = "/YpxgPage")
	public ModelAndView openYpxgPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypYpxgList");
		return modelAndView;
	}
	
	/**
	 * 样品检验费用修改跳转
	 * @author liusong
	 * @date 2016-1-6
	 * @return
	 */
	@RequestMapping(value = "/ypfyUpdate")
	public ModelAndView openYpfyPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/jsp/ypfyUpdate");
		return modelAndView;
	}
	
	/**
	 * 查询报告编号的检验费用
	 * @author liusong
	 * @date 2016-1-6
	 * @return
	 */
	@RequestMapping(value="/getValue")
	@ResponseBody
	public List<Map<String, Object>> getValue(String bgbh) {
		return yypYpxxService.getValue(bgbh);
	}
	
	/**
	 * 保存修改的检验费用
	 * @author liusong
	 * @date 2016-1-6
	 * @return
	 */
	@RequestMapping(value="/saveValue" , method = RequestMethod.POST)
	@ResponseBody
	public String saveValue(HttpServletRequest request) {
		return yypYpxxService.saveValue(request);
	}
	
	/**
	 * 跳转样品查询连接
	 * @author liusong
	 * @date 2016-1-6
	 * @return
	 */
	@RequestMapping(value = "/YpcxPage")
	public ModelAndView ypcxPage(){
		ModelAndView modelAndView = new ModelAndView("/ypgl/yypYpcxList");
		return modelAndView;
	}
	
	/**
	 * 样品登记页面
	 * @author wangyong
	 * @date 2015年12月9日
	 * @return
	 */
	@RequestMapping(value = "/YpdjPage")
	public ModelAndView openYpdjPage(){
		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxAdd");
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> ybzh = yypYpxxService.getDicByJylx("bmzh");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("ybzh",ybzh);
		mav.addObject("cydw",cydw);
		mav.addObject("rwly",rwly);
		return mav;
	}
	
	/**
	 * 抽样登记页面
	 * @author wangyong
	 * @date 2016年3月11日
	 * @return
	 */
	@RequestMapping(value = "/CydjPage")
	public ModelAndView openCydjPage(){
		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypcyAdd");
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> ybzh = yypYpxxService.getDicByJylx("bmzh");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		List<Map<String, Object>> jjlx = yypYpxxService.getDicByJylx("jjlx");
		List<Map<String, Object>> zslx = yypYpxxService.getDicByJylx("zslx");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("ybzh",ybzh);
		mav.addObject("cydw",cydw);
		mav.addObject("rwly",rwly);
		mav.addObject("jjlx",jjlx);
		mav.addObject("zslx",zslx);
		return mav;
	}
	
	/**
	 * 样品类别（行业信息表）
	 * @author duanpeijun
	 * @date 2015年9月28日
	 * @param str
	 * @return
	 */
	@RequestMapping(value = "/getHymc", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getHymc() {
		return yypYpxxService.getHymc();
	}
	
	/**
	 * 检验类型（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByJylx", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByJylx(String zdzl) {
		return yypYpxxService.getDicByJylx("jylx");
	}
	
	/**
	 * 样品状态（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByYpzt", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByYpzt(String zdzl) {
		return yypYpxxService.getDicByJylx("ypzt");
	}

	/**
	 * 报告发送方式（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByBgfsfs", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByBgfsfs(String zdzl) {
		return yypYpxxService.getDicByJylx("bgfsfs");
	}
	
	/**
	 * 检验后须退库（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByYhxtk", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByYhxtk(String zdzl) {
		return yypYpxxService.getDicByJylx("yhxtk");
	}
	
	/**
	 * 检验费用待定（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByJyfydd", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByJyfydd(String zdzl) {
		return yypYpxxService.getDicByJylx("jyfydd");
	}
	
	/**
	 * 来样方式（数据字典）
	 * @author duanpeijun
	 * @date 2015年9月29日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByLyfs", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByLyfs(String zdzl) {
		return yypYpxxService.getDicByJylx("lyfs");
	}
	
	/**
	 * 样品检测状态（数据字典）
	 * @author wangyong
	 * @date 2015年12月3日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByYpjyzt", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByJyzt(String zdzl) {
		return yypYpxxService.getDicByJylx("ypjyzt");
	}
	
	/**
	 * 部门字号（数据字典）
	 * @author wangyong
	 * @date 2015年12月4日
	 * @param zdzl
	 * @return
	 */
	@RequestMapping(value = "/getDicByBmzh", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getDicByBmzh(String zdzl) {
		return yypYpxxService.getDicByJylx("bmzh");
	}
	
	/**
	 * 领用
	 * @author duanpeijun
	 * @date 2015年9月28日
	 * @param entity
	 * @param id
	 * @param Ly
	 * @return
	 */
	@RequestMapping(value = "/Lyong", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData Lyong(YypYpxx entity,YjyXmxx xmxx, String id,YypLy Ly,HttpServletRequest request) {
		Lyservice.save(Ly);
		YypYpxx ypxxEntity = yypYpxxService.getYpxxById(Integer.parseInt(id));
		if (ypxxEntity == null) {
	          return new ResponseData(false, "记录不存在");
	      }
//		Integer i1 = Integer.parseInt(entity.getYpsl());
//		Integer zlysl = Integer.parseInt(request.getParameter("zlysl"));
//		System.out.println(zlysl);
//		Integer i4 = entity.getLysl();
//		System.out.println("-----------样品数量----->"+i1);
//		Integer i2 = Integer.parseInt(Ly.getLysl());
//		System.out.println("---------领用数量------->"+i2);
//		Integer i3 = i1 - i2 ;
//		System.out.println("---------剩余数量------->"+i3);
//		ypxxEntity.setLysl(zlysl+i2);
//		ypxxEntity.setYpsl(i3);
		ypxxEntity.setLysl(entity.getLysl());
		yypYpxxService.update(ypxxEntity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 归还
	 * @author duanpeijun
	 * @date 2015年9月28日
	 * @param entity
	 * @param id
	 * @param Gh
	 * @return
	 */
	@RequestMapping(value = "/Ghuan", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData Ghuan(YypYpxx entity, String id,YypGh Gh,HttpServletRequest request) {
		Ghservice.save(Gh);
//		YypYpxx ypxxEntity = yypYpxxService.getYpxxById(Integer.parseInt(id));
//		if (ypxxEntity == null) {
//	          return new ResponseData(false, "记录不存在");
//	      }
//		Integer zlysl = Integer.parseInt(request.getParameter("zlysl"));
		
		/*Integer i1 = entity.getYpsl();
//		System.out.println("-----------样品数量----->"+i1);
		Integer i2 = Gh.getGhsl();
//		System.out.println("---------归还数量------->"+i2);
		Integer i3 = i1 + i2 ;
//		System.out.println("---------归还后样品数量------->"+i3);
		ypxxEntity.setYpsl(i3);
		ypxxEntity.setLysl(zlysl-i2);*/
		//yypYpxxService.update(ypxxEntity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 退样
	 * @author duanpeijun
	 * @date 2015年9月28日
	 * @param entity
	 * @param id
	 * @param Ty
	 * @return
	 */
	@RequestMapping(value = "/Tyang", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData Tyang(YypYpxx entity, String id,YypTy Ty) {
		Tyservice.save(Ty);
		YypYpxx ypxxEntity = yypYpxxService.getYpxxById(Integer.parseInt(id));
		if (ypxxEntity == null) {
	          return new ResponseData(false, "记录不存在");
	      }
		/*Integer i1 = entity.getYpsl();
//		System.out.println("-----------样品数量----->"+i1);
		Integer i2 = Ty.getTysl();
//		System.out.println("---------领用数量------->"+i2);
		Integer i3 = i1 - i2 ;
//		System.out.println("---------剩余数量------->"+i3);
		ypxxEntity.setYpsl(i3);*/
		yypYpxxService.update(ypxxEntity);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param model
	 * @param entity
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/save")
	@ResponseBody
	public String save(ModelMap model,YypYpxx entity,YcwBgsf entity1,
			HttpServletRequest request,HttpServletResponse response){
	String result = yypYpxxService.saveYpxx(request,entity,entity1);
	
	String jyks = entity.getJyksbh();
    //String bgbh=entity.getBgbh();
    String ypmc=entity.getYpmc();
//	  List<Map<String, Object>> toUserfprlist=wglXgxxService.getopenId(jyks);
//	 String content= "["+result+"]"+"["+ypmc+"]"+"检验任务需要分配，请注意查看！";
//		String msgtype="text";
//		if (toUserfprlist.size()!=0) {
//			for (int i = 0; i < toUserfprlist.size(); i++) {
//				if(toUserfprlist.get(i).get("wxh") != null){
//				String toUser= toUserfprlist.get(i).get("wxh").toString();
//				ResponseData  res = massInfoService.massPreviewrwfp(msgtype,toUser,content);
//			}
//		}
//		}
		if("0".equals(result)) {
			return "0";
   
		}else {
			return result;
		}
	}
	
	/**
	 * 样品复制的保存方法
	 * @author wangyong
	 * @date 2016年1月22日
	 * @param model
	 * @param entity
	 * @param entity1
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value="/ypfzSave")
	@ResponseBody
	public String ypfzSave(ModelMap model,YypYpxx entity,YcwBgsf entity1,
			HttpServletRequest request,HttpServletResponse response){
		
		String result = yypYpxxService.ypfzSave(request, entity, entity1);

		String jyks = entity.getJyksbh();
	    //String bgbh=entity.getBgbh();
	    String ypmc=entity.getYpmc();
		  List<Map<String, Object>> toUserfprlist=wglXgxxService.getopenId(jyks);
		 String content= "["+result+"]"+"["+ypmc+"]"+"检验任务需要分配，请注意查看！";
			String msgtype="text";
			if (toUserfprlist.size()!=0) {
				for (int i = 0; i < toUserfprlist.size(); i++) {
					String toUser= toUserfprlist.get(i).get("wxh").toString();
				ResponseData  res = massInfoService.massPreviewrwfp(msgtype,toUser,content);
//				System.out.println("*******************"+toUser);
//				if(!res.isSuccess()){
//					return res;
//				}
			}
			}
			if("0".equals(result)) {
				return "0";
	   
			}else {
				return result;
			}
	}
	
	/**
	 * 更新
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData update(HttpServletRequest request,YypYpxx entity, YcwBgsf entity1,String id) {
		String result = yypYpxxService.up(request,entity, id,entity1);//样品更新完后要更新对应报告编号的报告收费信息
		if("1".equals(result)) {
			return ResponseData.SUCCESS_NO_DATA;
		}else {
			return ResponseData.FAILED_NO_DATA;
		}
}
           
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年9月24日
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseData delete(Integer[] ids,String[] bgbhs){
		
		yypYpxxService.delete(ids,bgbhs);
		System.out.println(bgbhs);
		return ResponseData.SUCCESS_NO_DATA;
	}
	
	/**
	 * 检验项目导出Excel
	 * @author duanpeijun
	 * @throws Exception 
	 * @date 2015年10月22日
	 */
	@RequestMapping(value = "/export")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,String code) throws Exception{
		yypYpxxService.exportExcel(request,response,code);
	}
	
	/**
	 * 检验项目导入EXCEL数据
	 * @author duanpeijun
	 * @date 2015年10月22日
	 * @param fileData
	 * @return
	 */
	@RequestMapping(value="/upload")
    @ResponseBody
    public String jyxmupload(@RequestParam("fileData") MultipartFile fileData)
    {
        String message = yypYpxxService.importMember(fileData);
        if (message == null)
            return "{\"success\":true}";
        else
            return "{\"success\":false,\"message\":\""+message+"\"}";
    }
	
	/**
	 * 点击增加按钮跳转到新增窗口的jsp页面
	 * @author wangyong
	 * @date 2015年11月13日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxxAddView")
	public ModelAndView ypxxAddView(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxAdd");
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> bmzh = yypYpxxService.getDicByJylx("bmzh");
		
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("bmzh",bmzh);
		
		/********新增时生成二维码图片***********/
		String ypbh=request.getParameter("ypbh");
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		String url=str+"/toSbDetail?ypbh="+ypbh;
		mav.addObject("url", url);
		return mav;
	}
	
	/**
	 * 点击修改按钮跳转到修改窗口的jsp页面
	 * @author wangyong
	 * @date 2015年11月17日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxxUpdateView")
	public ModelAndView ypxxUpdateView(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "";
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String djlx = request.getParameter("djlx");
		String bgbh = request.getParameter("ypbh");
		String sfzt = request.getParameter("sfzt");
		System.out.println(djlx);
//		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxOnLook");
		if (djlx.equals("0")) {
			url = "/ypgl/jsp/ypxxUpdate";
		} else if(djlx.equals("1")){
			url = "/ypgl/jsp/gcypxxUpdate";
		} else if(djlx.equals("2")){
			url = "/ypgl/jsp/syypxxUpdate";
		}else if(djlx.equals("3")){
			url = "/ypgl/jsp/cyypUpdate";
		}
		mav.setViewName(url);
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
		}
		List<Map<String, Object>> ysfxm = sfxmmxService.getYsfxm(bgbh);
		if (ysfxm != null) {
			mav.addObject("ysfxm", ysfxm);
			int ysfxmLen = ysfxm.size();
			mav.addObject("ysfxmLen", ysfxmLen);
			System.out.println(ysfxm.size());
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		List<Map<String, Object>> jjlx = yypYpxxService.getDicByJylx("jjlx");
		List<Map<String, Object>> zslx = yypYpxxService.getDicByJylx("zslx");
		List<Map<String, Object>> cydd = yypYpxxService.getDicByJylx("cydd");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("cydw",cydw);
		mav.addObject("rwly",rwly);
		mav.addObject("jjlx",jjlx);
		mav.addObject("zslx",zslx);
		mav.addObject("sfzt",sfzt);
		mav.addObject("cydd",cydd);
		return mav;
	}
	
	/**
	 * 点击修改按钮跳转到修改窗口的jsp页面
	 * @author wangyong
	 * @date 2015年11月17日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxgApproveView")
	public ModelAndView ypxgApproveView(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "";
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String djlx = request.getParameter("djlx");
		String bgbh = request.getParameter("ypbh");
		String sfzt = request.getParameter("sfzt");
//		System.out.println(djlx);
//		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxOnLook");
		if (djlx.equals("0")) {
			url = "/ypgl/jsp/approveUpdate";
		} else if(djlx.equals("1")){
			url = "/ypgl/jsp/apgcypUpdate";
		} else if(djlx.equals("2")){
			url = "/ypgl/jsp/apsyypUpdate";
		}else if(djlx.equals("3")){
			url = "/ypgl/jsp/apcyypUpdate";
		}
		mav.setViewName(url);
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
		}
		List<Map<String, Object>> ysfxm = sfxmmxService.getYsfxm(bgbh);
		if (ysfxm != null) {
			mav.addObject("ysfxm", ysfxm);
			int ysfxmLen = ysfxm.size();
			mav.addObject("ysfxmLen", ysfxmLen);
			System.out.println(ysfxm.size());
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		List<Map<String, Object>> jjlx = yypYpxxService.getDicByJylx("jjlx");
		List<Map<String, Object>> zslx = yypYpxxService.getDicByJylx("zslx");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("cydw",cydw);
		mav.addObject("rwly",rwly);
		mav.addObject("jjlx",jjlx);
		mav.addObject("zslx",zslx);
		mav.addObject("sfzt",sfzt);
		return mav;
	}
	
	@RequestMapping(value = "/getSfbzxx")
	public ModelAndView getSfbzxx(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ydmb/jsp/ydmbAdd");
		return mav;
	}
	
	/**
	 * 点击查看按钮跳转都查看的jsp页面
	 * @author wangyong
	 * @date 2015年11月23日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxxOnLookView")
	public ModelAndView ypxxOnLookView(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "";
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String ypbh=request.getParameter("ypbh");
		String djlx = request.getParameter("djlx");
		String kobe = request.getParameter("kobe");
		System.out.println(djlx);
//		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxOnLook");
		if (djlx.equals("0")) {
			url = "/ypgl/jsp/ypxxOnLook";
		} else if(djlx.equals("1")){
			url = "/ypgl/jsp/gcypxxOnLook";
		} else if(djlx.equals("2")){
			url = "/ypgl/jsp/syypxxOnLook";
		} else if(djlx.equals("3")){
			url = "/ypgl/jsp/cyypOnLook";
		}
		mav.setViewName(url);
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			String ewmurl=str+"/toSbDetail?ypbh="+ypbh;
			mav.addObject("url", ewmurl);
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		List<Map<String, Object>> jjlx = yypYpxxService.getDicByJylx("jjlx");
		List<Map<String, Object>> zslx = yypYpxxService.getDicByJylx("zslx");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("rwly",rwly);
		mav.addObject("jjlx",jjlx);
		mav.addObject("zslx",zslx);
		mav.addObject("kobe",kobe);
		return mav;
		
	}
	
	/**
	 * 点击领用按钮跳转到领用的jsp页面
	 * @author wangyong
	 * @date 2015年11月23日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxxLyongView")
	public ModelAndView ypxxLyongView(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "";
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String ypbh=request.getParameter("ypbh");
		String djlx = request.getParameter("djlx");
		System.out.println(djlx);
//		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxOnLook");
		if (djlx.equals("0")) {
			url = "/ypgl/jsp/ypxxLyong";
		} else if(djlx.equals("1")){
			url = "/ypgl/jsp/gcypxxLyong";
		} else if(djlx.equals("2")){
			url = "/ypgl/jsp/syypxxLyong";
		}
		mav.setViewName(url);
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			String ewmurl=str+"/toSbDetail?ypbh="+ypbh;
			mav.addObject("url", ewmurl);
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("rwly",rwly);
		return mav;
	}
	
	/**
	 * 点击归还按钮跳转到样品归还的jsp页面
	 * @author wangyong
	 * @date 2015年11月25日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxxGhuanView")
	public ModelAndView ypxxGhuanView(HttpServletRequest request,
			HttpServletResponse response) {
//		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxGhuan");
//		//通过id获得该条样品的所有信息反馈到前台jsp页面
//		String id = request.getParameter("id");
//		String djlx = request.getParameter("djlx");
//		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
//		if (ypxx != null) {
//			mav.addObject("ypxx", ypxx);
//		}
//		//通过ypbh获得该条样品的所有的领用数量用于归还时的表单校验
//		String ypbh = request.getParameter("ypbh");
//		List<Map<String, Object>> yply = Lyservice.getYply(ypbh);
//		System.out.println(yply);
//		Integer lysl = 0;
//		for (int i = 0; i < yply.size(); i++) {
//			Map<String, Object> map=(Map<String, Object>)yply.get(i);
//	        Iterator<String> iterator = map.keySet().iterator();
//	        while (iterator.hasNext()){
//	        	 String key = (String)iterator.next();
//	        	 //System.out.println(map.get(key));
//	        	 Object obj = map.get(key);
//	        	 Integer lyslInteger = Integer.parseInt(obj.toString());
//	        	 //System.out.println(lyslInteger);
//	        	 lysl += lyslInteger;
//	             //System.out.println(lysl);
//	        }
//		}
//		mav.addObject("lysl",lysl);
		
		String url = "";
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String ypbh=request.getParameter("ypbh");
		String djlx = request.getParameter("djlx");
		System.out.println(djlx);
//		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxOnLook");
		if (djlx.equals("0")) {
			url = "/ypgl/jsp/ypxxGhuan";
		} else if(djlx.equals("1")){
			url = "/ypgl/jsp/gcypxxGhuan";
		} else if(djlx.equals("2")){
			url = "/ypgl/jsp/syypxxGhuan";
		}
		mav.setViewName(url);
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			String ewmurl=str+"/toSbDetail?ypbh="+ypbh;
			mav.addObject("url", ewmurl);
		}
		
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("rwly",rwly);
		return mav;
	}
	
	/**
	 * 点击退样按钮跳转到样品退样的jsp页面
	 * @author wangyong
	 * @date 2015年11月25日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypxxTyangView")
	public ModelAndView ypxxTyangView(HttpServletRequest request,
			HttpServletResponse response) {
		String url = "";
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String ypbh=request.getParameter("ypbh");
		String djlx = request.getParameter("djlx");
		System.out.println(djlx);
		if (djlx.equals("0")) {
			url = "/ypgl/jsp/ypxxTyang";
		} else if(djlx.equals("1")){
			url = "/ypgl/jsp/gcypxxTyang";
		} else if(djlx.equals("2")){
			url = "/ypgl/jsp/syypxxTyang";
		}
		mav.setViewName(url);
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			String ewmurl=str+"/toSbDetail?ypbh="+ypbh;
			mav.addObject("url", ewmurl);
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("rwly",rwly);
		return mav;
	}
	
	/**
	 * 样品信息标签
	 * @author duanpeijun
	 * @date 2015年12月01日
	 * @return
	 */
	@RequestMapping(value = "/ypewmPage")
	public ModelAndView openBqPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/ypewm");
		String ypbh=request.getParameter("ypbh");
		List<Map<String,Object>> list = yypYpxxService.getYpewm(ypbh);
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		if(list.size()!=0){
			String url=str+"/toSbDetail?ypbh="+ypbh;
			mav.addObject("url", url);
			mav.addObject("map", list.get(0));
		}
		return mav;
	}
	
	/**
	 * 样品明细
	 * @author duanpeijun
	 * @date 2015年12月01日
	 * @return
	 */
	@RequestMapping(value = "/toSbDetail")
	public ModelAndView toSbDetail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/ewmxx");
		String ypbh=request.getParameter("ypbh");
		List<Map<String,Object>> list=yypYpxxService.getYpewm(ypbh);
		if(list.size()!=0){
			mav.addObject("map", list.get(0));
		}
		return mav;
	}
	
	/**
	 * 通过前台传来的部门编号获取样品编号中间的字号
	 * @author wangyong
	 * @date 2015年12月2日
	 * @param n
	 * @return
	 */
	@RequestMapping(value = "/findZh")
	@ResponseBody
	public String findBz(String jyksbh,String zhmc){
		return yypYpxxService.findZh(jyksbh, zhmc);
	}
	
	/**
	 * 跳转到收费标准信息页面
	 * @author wangyong
	 * @date 2015年12月11日
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
//	@RequestMapping(value = "/Sfxmmx")
//	@ResponseBody
//	public ModelAndView ypjybz(HttpServletRequest request,
//			HttpServletResponse response, String id) {
//		ModelAndView mav = new ModelAndView("/ypgl/jsp/sfxmmx");
//		if (id != null) {
//			mav.addObject("id", id);
//		}
//		//List<Map<String, Object>> Sfbzbh = yypYpxxService.getSfbzbh();
//		List<Map<String, Object>> Sfxmmx = yypYpxxService.getSfxmmx();
//		if (Sfxmmx != null) {
//			mav.addObject("Sfxmmx", Sfxmmx);
//		}
//		return mav;
//	}
	
	@RequestMapping(value = "/Sfxmmx")
	@ResponseBody
	public List<Map<String, Object>> ypjybz(HttpServletRequest request,
			HttpServletResponse response) {
		String cpmccx = request.getParameter("cpmccx");
		String xmmccx = request.getParameter("xmmccx");
		String zxxjyyj = request.getParameter("zxxjyyj");
		String jzcs = request.getParameter("jzcs");
		System.out.println(cpmccx+"-------------"+xmmccx);
		List<Map<String, Object>> Sfxmmx = yypYpxxService.getSfxmmx(cpmccx,xmmccx,jzcs,zxxjyyj);
		return Sfxmmx;
	}
	
	/**
	 * 流转单页面
	 * @author liujiansen
	 * @date 2015年12月14日
	 * @return
	 */
	@RequestMapping(value = "/YpLzdPage")
	public ModelAndView YpxxLzdPage(HttpServletRequest request,HttpServletResponse response){
		String bgbh=request.getParameter("ypbh");
		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxLzd");
		List<Map<String,Object>> ypxx=yypYpxxService.getYpByBh(bgbh);
		if(ypxx.size()!=0){
			mav.addObject("ypxx", ypxx.get(0));
			if(ypxx.get(0).get("zh")!=null&&ypxx.get(0).get("djlx")!=null){
				List<Map<String,Object>> ypzh=yypYpxxService.getZhmc(ypxx.get(0).get("zh").toString(),ypxx.get(0).get("djlx").toString());
				if(ypzh.size()!=0){
					mav.addObject("zhmc", ypzh.get(0).get("zhmc"));
					mav.addObject("zhfl", ypzh.get(0).get("zhfl"));
					String mc=ypzh.get(0).get("zhfl").toString();
					List<Map<String,Object>> rztb=yypYpxxService.getRztb(mc);
					if(rztb.size()!=0){
						mav.addObject("rztb", rztb);
					}
				}
			}
			List<Map<String,Object>> jyxm=yypYpxxService.getJyyj(bgbh);
			if(jyxm.size()!=0){
				mav.addObject("jyxm", jyxm);
			}
		}
		return mav;
	}
	
	/**
	 * 样品抽样单页面
	 * @author duanpeijun
	 * @date 2016年3月12日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/YpCydPage")
	public ModelAndView YpCydPage(HttpServletRequest request,HttpServletResponse response){
		String bgbh=request.getParameter("ypbh");
		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxCyd");
		List<Map<String,Object>> ypxx=yypYpxxService.getYpByBh(bgbh);
		List<Map<String, Object>> jjlx = yypYpxxService.getDicByJylx("jjlx");
		List<Map<String, Object>> zslx = yypYpxxService.getDicByJylx("zslx");
		if(ypxx.size()!=0){
			mav.addObject("ypxx", ypxx.get(0));
			if(ypxx.get(0).get("zh")!=null&&ypxx.get(0).get("djlx")!=null){
				List<Map<String,Object>> ypzh=yypYpxxService.getZhmc(ypxx.get(0).get("zh").toString(),ypxx.get(0).get("djlx").toString());
				if(ypzh.size()!=0){
					mav.addObject("zhmc", ypzh.get(0).get("zhmc"));
					mav.addObject("zhfl", ypzh.get(0).get("zhfl"));
					String mc=ypzh.get(0).get("zhfl").toString();
					List<Map<String,Object>> rztb=yypYpxxService.getRztb(mc);
					if(rztb.size()!=0){
						mav.addObject("rztb", rztb);
					}
				}
			}
			List<Map<String,Object>> jyxm=yypYpxxService.getJyyj(bgbh);
			if(jyxm.size()!=0){
				mav.addObject("jyxm", jyxm);
			}
		}
		String cydbh = "No.A";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	    Date date = new Date();
	    String str = sdf.format(date);
	    str = str.substring(2,4);
	    cydbh += str+((String) ypxx.get(0).get("cydbh"));
		mav.addObject("jjlx",jjlx);
		mav.addObject("zslx",zslx);
		mav.addObject("cydbh",cydbh);
		return mav;
	}
	
	/**
	 * 样品复制时获取样品信息列表	
	 * @author wangyong
	 * @date 2015年12月21日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypfzList")
	@ResponseBody
		public List<Map<String, Object>> ypfzList(HttpServletRequest request,
				HttpServletResponse response) {
			String ypbhcx = request.getParameter("ypbhcx");
			String ypmccx = request.getParameter("ypmccx");
			String djlx = request.getParameter("djlx");
			String ypjzcs = request.getParameter("ypjzcs");
			List<Map<String, Object>> list = yypYpxxService.ypfzList(ypbhcx, ypmccx,djlx,ypjzcs);
			return list;
    }
	
	/**
	 * 一般样品复制页面
	 * @author wangyong
	 * @date 2015年12月24日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ypfzPageView")
	public ModelAndView ypfzPageView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypfz");
		String id = request.getParameter("id");
		String djlx = "0";
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			mav.addObject("fzypbh", ypxx.get(0).get("ypbh"));
			String bgbh = (String) ypxx.get(0).get("ypbh");
			System.out.println(bgbh);
			List<Map<String, Object>> ysfxm = sfxmmxService.getYsfxm(bgbh);
			if (ysfxm != null) {
				mav.addObject("ysfxm", ysfxm);
				int ysfxmLen = ysfxm.size();
				mav.addObject("ysfxmLen", ysfxmLen);
				//System.out.println(ysfxm.size());
			}
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> ybzh = yypYpxxService.getDicByJylx("bmzh");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("ybzh",ybzh);
		mav.addObject("cydw",cydw);
		mav.addObject("rwly",rwly);
		return mav;
	}
	
	/**
	 * 一般样品修改复制页面
	 * @author wangyong
	 * @date 2015年12月24日
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/xgfzPageView")
	public ModelAndView xgfzPageView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//ModelAndView mav = new ModelAndView("/ypgl/jsp/xgfzUpdate");
		String id = request.getParameter("id");
		String djlx = request.getParameter("djlx");
		String djsj = request.getParameter("djsj");
		String ypjyzt1 = request.getParameter("ypjyzt");
		String oldId = request.getParameter("oldId");
		String jyks = request.getParameter("jyks");
		jyks = new String(jyks.getBytes("ISO-8859-1"),"UTF-8");
		String zh = request.getParameter("zh");
		zh = new String(zh.getBytes("ISO-8859-1"),"UTF-8");
		String ypbh = request.getParameter("ypbh");
		String jyksbh = request.getParameter("jyksbh");
		String url = "";
		ModelAndView mav = new ModelAndView();
		
//		System.out.println("-----"+jyks+"----"+zh+"------"+ypbh+"------"+jyksbh);
//		System.out.println("-----------"+djlx+"-----------"+ypjyzt1+"-----------"+djsj);
		if (djlx.equals("0")) {
			url = "/ypgl/jsp/xgfzUpdate";
		} else if(djlx.equals("1")){
			url = "/ypgl/jsp/gcxgfzUpdate";
		} else if(djlx.equals("2")){
			url = "/ypgl/jsp/syxgfzUpdate";
		}
		mav.setViewName(url);
		
		YypYpxx ypxx = yypYpxxService.getYpxxById(Integer.parseInt(id));
		String bgbhString = ypxx.getBgbh(); 
		List<Map<String,Object>> list = yypYpxxService.getYpByBh(bgbhString);
		ypxx.setId(Integer.parseInt(oldId));
		ypxx.setYpjyzt(Integer.parseInt(ypjyzt1));
		ypxx.setJyks(jyks);
		ypxx.setJyksbh(jyksbh);
		ypxx.setZh(zh);
		ypxx.setYpbh(ypbh);
		ypxx.setBgbh(ypbh);
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			mav.addObject("list", list);
			List<Map<String, Object>> ysfxm = sfxmmxService.getYsfxm(bgbhString);
			if (ysfxm != null) {
				mav.addObject("ysfxm", ysfxm);
				int ysfxmLen = ysfxm.size();
				mav.addObject("ysfxmLen", ysfxmLen);
			}
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> ybzh = yypYpxxService.getDicByJylx("bmzh");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		List<Map<String, Object>> cydd = yypYpxxService.getDicByJylx("cydd");
		
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("ybzh",ybzh);
		mav.addObject("cydw",cydw);
		SysYh yh =AppUtil.getCurrentUser();
	    mav.addObject("djry",yh.getXm());
		mav.addObject("djsj",djsj);
		mav.addObject("rwly",rwly);
		mav.addObject("cydd",cydd);
		return mav;
	}
	
	/**
	 * 工程类样品复制页面
	 * @author wangyong
	 * @date 2015年12月24日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/gcypfzPageView")
	public ModelAndView gcypfzPageView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/jsp/gcypfz");
		String id = request.getParameter("id");
		String djlx = "1";
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			mav.addObject("fzypbh", ypxx.get(0).get("ypbh"));
			String bgbh = (String) ypxx.get(0).get("ypbh");
			System.out.println(bgbh);
			List<Map<String, Object>> ysfxm = sfxmmxService.getYsfxm(bgbh);
			if (ysfxm != null) {
				mav.addObject("ysfxm", ysfxm);
				int ysfxmLen = ysfxm.size();
				mav.addObject("ysfxmLen", ysfxmLen);
				//System.out.println(ysfxm.size());
			}
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> gczh = yypYpxxService.getGczh();
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("gczh",gczh);
		mav.addObject("cydw",cydw);
		return mav;
	}
	
	/**
	 * 检验协议书页面
	 * @author liujiansen
	 * @date 2015年12月25日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/YpJyxysPage")
	public ModelAndView YpJyxysPage(HttpServletRequest request,HttpServletResponse response){
		String bgbh=request.getParameter("ypbh");
		ModelAndView mav = new ModelAndView("/ypgl/jsp/ypxxXys");
		List<Map<String,Object>> ypxx=yypYpxxService.getYpByBh(bgbh);
		if(ypxx.size()!=0){
			mav.addObject("ypxx", ypxx.get(0));
			if(ypxx.get(0).get("zh")!=null&&ypxx.get(0).get("djlx")!=null){
				List<Map<String,Object>> ypzh=yypYpxxService.getZhmc(ypxx.get(0).get("zh").toString(),ypxx.get(0).get("djlx").toString());
				if(ypzh.size()!=0){
					mav.addObject("zh", ypzh.get(0).get("zh"));
					mav.addObject("zhfl", ypzh.get(0).get("zhfl"));
					String mc=ypzh.get(0).get("zhfl").toString();
					List<Map<String,Object>> rztb=yypYpxxService.getRztb(mc);
					if(rztb.size()!=0){
						mav.addObject("rztb", rztb);
					}
				}
			}
			List<Map<String,Object>> jyxm=yypYpxxService.getJyyj(bgbh);
			if(jyxm.size()!=0){
				mav.addObject("jyxm", jyxm);
			}
		}
		return mav;
	}
	
	/**
	 * 工程类样品登记页面
	 * @author wangyong
	 * @date 2015年12月24日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/gcypxxAddView")
	public ModelAndView gcypxxAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/jsp/gcypxxAdd");
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> bmzh = yypYpxxService.getDicByJylx("bmzh");
		List<Map<String, Object>> gczh = yypYpxxService.getGczh();
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("bmzh",bmzh);
		mav.addObject("gczh",gczh);
		mav.addObject("cydw",cydw);
		/********新增时生成二维码图片***********/
		String ypbh=request.getParameter("ypbh");
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		String url=str+"/toSbDetail?ypbh="+ypbh;
		mav.addObject("url", url);
		return mav;
	}
	
	/**
	 * 验证样品编号和报告编号是否已存在
	 * @author wangyong
	 * @date 2015年12月28日
	 * @param bgbh
	 * @return
	 */
	@RequestMapping(value="yzbgbh")
	@ResponseBody
	public String yzbgbh(String yzbgbh){
		return yypYpxxService.yzbgbh(yzbgbh);
	}
	
	/**
	 * 食药局类样品登记页面
	 * @author wangyong
	 * @date 2015年12月24日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/syypxxAddView")
	public ModelAndView syypxxAddView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/jsp/syypxxAdd");
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> bmzh = yypYpxxService.getDicByJylx("bmzh");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		List<Map<String, Object>> cydd = yypYpxxService.getDicByJylx("cydd");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("bmzh",bmzh);
		mav.addObject("cydw",cydw);
		mav.addObject("rwly",rwly);
		mav.addObject("cydd",cydd);
		/********新增时生成二维码图片***********/
		String ypbh=request.getParameter("ypbh");
		String xMurl=request.getRequestURL().toString();
		String str=xMurl.substring(0, xMurl.lastIndexOf("/"));
		String url=str+"/toSbDetail?ypbh="+ypbh;
		mav.addObject("url", url);
		return mav;
	}
	
	/**
	 * 食药类样品复制页面
	 * @author wangyong
	 * @date 2016年1月3日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/syypfzPageView")
	public ModelAndView syypfzPageView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/jsp/syypfz");
		String id = request.getParameter("id");
		String djlx = "2";
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			mav.addObject("fzypbh", ypxx.get(0).get("ypbh"));
			String bgbh = (String) ypxx.get(0).get("ypbh");
			System.out.println(bgbh);
			List<Map<String, Object>> ysfxm = sfxmmxService.getYsfxm(bgbh);
			if (ysfxm != null) {
				mav.addObject("ysfxm", ysfxm);
				int ysfxmLen = ysfxm.size();
				mav.addObject("ysfxmLen", ysfxmLen);
				//System.out.println(ysfxm.size());
			}
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> rwly = yypYpxxService.getDicByJylx("rwly");
		List<Map<String, Object>> cydd = yypYpxxService.getDicByJylx("cydd");
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("cydw",cydw);
		mav.addObject("rwly",rwly);
		mav.addObject("cydd",cydd);
		return mav;
	}
	
	/**
	 * 一般样品复制页面
	 * @author wangyong
	 * @date 2015年12月24日
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cyypfzPageView")
	public ModelAndView cyypfzPageView(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/ypgl/jsp/cyypfz");
		String id = request.getParameter("id");
		String djlx = "0";
		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
		if (ypxx != null) {
			mav.addObject("ypxx", ypxx);
			mav.addObject("fzypbh", ypxx.get(0).get("ypbh"));
			String bgbh = (String) ypxx.get(0).get("ypbh");
			System.out.println(bgbh);
			List<Map<String, Object>> ysfxm = sfxmmxService.getYsfxm(bgbh);
			if (ysfxm != null) {
				mav.addObject("ysfxm", ysfxm);
				int ysfxmLen = ysfxm.size();
				mav.addObject("ysfxmLen", ysfxmLen);
				//System.out.println(ysfxm.size());
			}
		}
		List<Map<String, Object>> jylx = yypYpxxService.getDicByJylx("jylx");
		List<Map<String, Object>> lyfs = yypYpxxService.getDicByJylx("lyfs");
		List<Map<String, Object>> ypzt = yypYpxxService.getDicByJylx("ypzt");
		List<Map<String, Object>> bgfsfs = yypYpxxService.getDicByJylx("bgfsfs");
		List<Map<String, Object>> yhxtk = yypYpxxService.getDicByJylx("yhxtk");
		List<Map<String, Object>> jyfydd = yypYpxxService.getDicByJylx("jyfydd");
		List<Map<String, Object>> ypjyzt = yypYpxxService.getDicByJylx("ypjyzt");
		List<Map<String, Object>> ybzh = yypYpxxService.getDicByJylx("bmzh");
		List<Map<String, Object>> cydw = yypYpxxService.getDicByJylx("jddw");
		List<Map<String, Object>> jjlx = yypYpxxService.getDicByJylx("jjlx");
		List<Map<String, Object>> zslx = yypYpxxService.getDicByJylx("zslx");
		
		mav.addObject("jylx",jylx);
		mav.addObject("lyfs",lyfs);
		mav.addObject("ypzt",ypzt);
		mav.addObject("bgfsfs",bgfsfs);
		mav.addObject("yhxtk",yhxtk);
		mav.addObject("jyfydd",jyfydd);
		mav.addObject("ypjyzt",ypjyzt);
		mav.addObject("ybzh",ybzh);
		mav.addObject("cydw",cydw);
		mav.addObject("jjlx",jjlx);
		mav.addObject("zslx",zslx);
		return mav;
	}
	
	/**
	 * 验证登录名是否有重复
	 * @author liusong
	 * @date 2016-1-6
	 * @return
	 */
	@RequestMapping(value="/checkhth" , method = RequestMethod.POST)
	@ResponseBody
	public String checkhth(HttpServletRequest request){
		String str="";
		String jyhth=request.getParameter("jyhth");
		List<Map<String,Object>> dlmList = yypYpxxService.checkhth(jyhth);
//		如果list有数据，说明有符合条件的检验合同号
		if(dlmList.size()>0){
			str="1";
		}else{
			str="0";
		}
		return str;
	}
	
//	/**
//	 * 通过ID获取样品信息
//	 * @author wangyong
//	 * @date 2016年4月13日
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping(value = "/getypxxById")
//	@ResponseBody
//	public List<Map<String, Object>> getKhxxById(HttpServletRequest request,
//			HttpServletResponse response) {
//		String id = request.getParameter("id");
//		String djlx = request.getParameter("djlx");
//		List<Map<String, Object>> ypxx = yypYpxxService.getYpxx(Integer.parseInt(id),djlx);
//		return ypxx;
//	}
}
