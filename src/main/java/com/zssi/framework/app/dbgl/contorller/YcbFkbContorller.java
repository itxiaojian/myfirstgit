package com.zssi.framework.app.dbgl.contorller; 

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.likegene.framework.core.BaseController;
import com.likegene.framework.core.logger.Logger;
import com.likegene.framework.core.logger.LoggerFactory;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.dbgl.model.YcbLbxx;
import com.zssi.framework.app.dbgl.model.YcbFkb;
import com.zssi.framework.app.dbgl.service.YcbLbxxService;
import com.zssi.framework.app.dbgl.service.YcbFkbService;
import com.zssi.framework.app.util.ResponseData;

/** 
 * 业务督办反馈列表contorller类
 * @author liusong E-mail: 2629690209@qq.com
 * @version 创建时间：2015年10月21日 上午10:31:14 
 * 类说明 
 */
	@Controller
	@RequestMapping("/dbgl/YdbFklb")
	public class YcbFkbContorller extends BaseController {
		
		protected final transient Logger logger = LoggerFactory.getPersistenceLog(YcbFkbContorller.class);
		
		@Autowired
		private YcbFkbService ydbFklbService;
		
		@Autowired
		private YcbLbxxService ydbDblbService;
		
		@RequestMapping(value = "/getFklbList")
		@ResponseBody
		public Pagination<Map<String, Object>> getFklbList(Integer start,Integer limit,String code){
			return ydbFklbService.getFklbList(start, limit,code);
			}
		
		@RequestMapping(value = "/FklbPage")
		public ModelAndView openPage(){
			ModelAndView modelAndView = new ModelAndView("/dbgl/yCbFkbList");
			return modelAndView;
			}
		
		
		/**
		 * 保存 
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月23日 下午2:41:37 
		 * 类说明 
		 * @param model
		 * @param entity
		 * @param request
		 * @param response
		 * @return
		 */
		@RequestMapping(value="/save")
		@ResponseBody
		public ResponseData save(ModelMap model,YcbFkb entity,
				HttpServletRequest request,HttpServletResponse response){
			ydbFklbService.save(entity);
			return ResponseData.SUCCESS_NO_DATA;
		}
		
		/**
		 * 点击反馈进行响应，利用相同的bgbh进行操作
		 * @author liusong
		 * @date 2015年10月9日
		 * @return
		 */
		@RequestMapping(value="/saveall")
		@ResponseBody
		public ResponseData saveall(YcbFkb entity,String bgbh, YcbLbxx Db){
			
			//spring security 框架
//			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
//				    .getAuthentication()
//				    .getPrincipal();
//			//时间 java获取时间
//			System.out.println(userDetails.getPassword()+":::"+userDetails.getUsername());
			ydbFklbService.save(entity);
//			YcbLbxx lbxxEntity = ydbDblbService.getDblbById(Integer.parseInt(bgbh));
			Db.setFkzt(0);
//			ydbDblbService.update(dblbEntity);
			ydbDblbService.update(Db);
			return ResponseData.SUCCESS_NO_DATA;
		}
		
		
		/** 
		 * 更新
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月23日 下午2:41:54 
		 * 类说明 
		 * @param entity
		 * @param id
		 * @return
		 */
		@RequestMapping(value = "/update", method = RequestMethod.POST)
		@ResponseBody
		public ResponseData update (YcbFkb entity, String id){
			ydbFklbService.update(entity,id);
			return ResponseData.SUCCESS_NO_DATA;
		}
		
		
		/**
		 * 删除 
		 * @author liusong E-mail: 2629690209@qq.com
		 * @version 创建时间：2015年10月23日 下午2:42:07 
		 * 类说明 
		 * @param ids
		 * @return
		 */
		@RequestMapping(value="/delete", method = RequestMethod.POST)
		@ResponseBody
		public ResponseData delete(Integer[] ids){
			ydbFklbService.delete(ids);
		return ResponseData.SUCCESS_NO_DATA;
		}
}
