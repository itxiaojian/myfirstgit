package com.zssi.framework.app.cbgl.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.cbgl.dao.YcwCbxxDao;
import com.zssi.framework.app.cbgl.model.YcwCbxx;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.cwgl.dao.YcwCbmxDao;
import com.zssi.framework.app.cwgl.model.YcwCbmx;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;
import com.zssi.framework.app.util.ExportExcelUtil;
import com.zssi.framework.app.yhgl.dao.SysYhDao;

@Service
public class YcwCbxxService extends BaseBO<YcwCbxxDao>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YcwCbxxDao ycwCbxxDao;
	
	@Autowired
	private YcwCbmxDao cbmxDao;
	
	@Autowired
	private SysYhDao sysYhDao;
	/**
	 * 后台:成本信息列表
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getCbxxList(Integer start, Integer limit, String code,String ksbh,String jybh,String ypmc,
			String lrrq,String lrr,String xgrq,String xgr) {
		return ycwCbxxDao.getCbxxList(start, limit, code, ksbh, jybh, ypmc, lrrq, lrr, xgrq, xgr);
	}
	
	/**
	 * 增加
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param entity
	 */
	@Transactional
	public void save(YcwCbxx entity) {
		SysYh yh =AppUtil.getCurrentUser();
		entity.setLrr(yh.getXm());
		Date date = new Date();
		entity.setLrrq(date);
		ycwCbxxDao.save(entity);
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param entity
	 * @param id
	 * @throws Exception 
	 */
	@Transactional
	public void update(YcwCbxx entity,String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		SysYh yh =AppUtil.getCurrentUser();
		entity.setXgr(yh.getXm());
		Date date = new Date();
		entity.setXgrq(date);
		entity.setId(Integer.parseInt(id));
		ycwCbxxDao.update(entity);
		//保存新的成本明细之前删除旧的成本明细
		String cbbh=entity.getCbbh();
		String jybh=entity.getJybh();
		ycwCbxxDao.deleteCbmxByCbbh(cbbh);
		
		//保存新的成本明细
		Integer num = 0;
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
			num=Integer.parseInt(request.getParameter("num"));
		}
		for (int i = 0; i <= num; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			String fylx=request.getParameter("fylx"+(i+1));
			String pjbh=request.getParameter("pjbh"+(i+1));
			String xmmc=request.getParameter("xmmc"+(i+1));
			String fyxq=request.getParameter("fyxq"+(i+1));
			String je=request.getParameter("je"+(i+1));
			String fssj1=request.getParameter("fssj"+(i+1));
			
			if (fylx!=null && !"".equals(fylx)) {
				YcwCbmx ycwCbmx=new YcwCbmx();
				ycwCbmx.setJybh(jybh);
				ycwCbmx.setKsbh(entity.getKsbh());
				ycwCbmx.setFylx(fylx);
				ycwCbmx.setPjbh(pjbh);
				ycwCbmx.setXmmc(xmmc);
				ycwCbmx.setFyxq(fyxq);
				ycwCbmx.setLrrq(date);
				ycwCbmx.setCbbh(cbbh);
				if (fssj1 != null && !("").equals(fssj1)) {
					Date fssj = sdf.parse(fssj1); 
					ycwCbmx.setFssj(fssj);
				}
				if (je != null && !("").equals(je)) {
					BigDecimal jeBigDecimal = new BigDecimal(je);
					jeBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
					ycwCbmx.setJe(jeBigDecimal);
				}
				cbmxDao.save(ycwCbmx);
			}
			
//			entity.setLrr(yh.getXm());
//			entity.setLrrq(date);
//			entity.setFssj(ycwCbmx.getFssj());
//			entity.setCbbh(cbbh);
//			ycwCbxxDao.save(entity);
		}
	}
	
	/**
	 * 修改成本明细的检验编号
	 * @author wangyong
	 * @date 2015年12月8日
	 * @param jybh1
	 * @param jybh2
	 */
	public void updateCbmxJybh(String jybh1,String jybh2) {
		ycwCbxxDao.updateCbmxJybh(jybh1, jybh2);
	}
	/**
	 * jsp中点击修改拉取内容
	 * @author wangyong
	 * @date 2015-11-19
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getCbxx(Integer id){
		return ycwCbxxDao.getCbxx(id);
	}
	
	/**
	 * 通过成本编号获取所有成本明细
	 * @author wangyong
	 * @date 2016年4月7日
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getCbmx(String cbbh){
		return ycwCbxxDao.getCbmx(cbbh);
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月12日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids,String[] ksbhs,String[] lrrqs) {
		for(int i=0;i<ids.length;i++){
			ycwCbxxDao.delete(ids[i]);
		}
		for (int i = 0; i < ksbhs.length; i++) {
			ycwCbxxDao.deleteCbmxByCbbh(ksbhs[i]);
		}
	}
	
	/**
	 * 验证表格中的数据
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param row
	 * @return
	 */
	private String validate(Row row) {
//        String v = getSV(row.getCell(0));
//        if(v!=null&&!v.matches("^[0-9A-Za-z]{1,12}$")){
//            return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
//        }
        return null;
    }

	/**
	 * 获取单元格
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param cell
	 * @return
	 */
	private String getSV(Cell cell)
    {
        if (cell == null)
            return null;
        switch (cell.getCellType())
        {
        case Cell.CELL_TYPE_NUMERIC:
            return "" + cell.getNumericCellValue();
        case Cell.CELL_TYPE_STRING:
            return StringUtils.trim(cell.getStringCellValue());
        default:
            break;
        }

        return null;
    }
	
	/**
	 * 导入EXCEL数据
	 * @author wangyong
	 * @date 2015年10月27日
	 * @param file
	 * @return
	 */
	@Transactional
	public String importMember(MultipartFile file) {
		if (file.getSize() == 0)
        {
            return "上传文件为空";
        }
		try
        {
			 Workbook hssfWorkbook = null;
		        try {
		        	hssfWorkbook = new HSSFWorkbook(file.getInputStream());
		        } catch (Exception ex) {
		        	hssfWorkbook = new XSSFWorkbook(file.getInputStream());
		        }
            //HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());
		    Sheet hssfSheet = hssfWorkbook.getSheetAt(0);
            if (hssfSheet != null)
            {
            	int cbbh = 0;
            	int kobe=0;
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++)
                {
                    //HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    Row hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null)
                    {
                        String result = validate(hssfRow);
                        if (result != null) {
                            return result;
                        }
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                        YcwCbxx cbxx = new YcwCbxx();
                        YcwCbmx cbmx = new YcwCbmx();
                        if(getSV(hssfRow.getCell(0))!=null&&!"".equals(getSV(hssfRow.getCell(0)))){
                        	cbbh=Integer.parseInt(getCbbh())+kobe;
                        	String ks1=getSV(hssfRow.getCell(0));
                        	String jybh=getSV(hssfRow.getCell(1));
                        	String ypmc=getSV(hssfRow.getCell(2));
                        	String xxnr=getSV(hssfRow.getCell(3));
                        	String cbhj=getSV(hssfRow.getCell(4));
                        	String fssj1=getSV(hssfRow.getCell(5));
                        	String bz=getSV(hssfRow.getCell(6));
                        	cbxx.setKsbh(sysYhDao.getbmbh(ks1).get(0).get("bmbh").toString());
                        	cbxx.setJybh(jybh);
                        	cbxx.setYpmc(ypmc);
                        	cbxx.setXxnr(xxnr);
                        	//成本合计字段String转BigDecimal
                        	if (cbhj != null && !("").equals(cbhj)) {
                        		BigDecimal cbhjBigDecimal = new BigDecimal(cbhj);
                        		cbhjBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
                        		cbxx.setCbhj(cbhjBigDecimal);
                        	}
                        	//发生时间字段Sting转Date
                        	if (fssj1 != null && !("").equals(fssj1)) {
                        		Date lrrqdDate = sdf.parse(fssj1);
                        		cbxx.setFssj(lrrqdDate);
                        	}
                        	cbxx.setLrr(AppUtil.getCurrentUser().getXm());
                        	cbxx.setLrrq(new Date());
                        	cbxx.setBz(bz);
                        	cbxx.setLrrq(new Date());
                        	cbxx.setCbbh(String.valueOf(cbbh));
                        	ycwCbxxDao.save(cbxx);
                        	kobe++;
                        }
                        
                        String fylx=getSV(hssfRow.getCell(7));
                        String xmmc=getSV(hssfRow.getCell(8));
                        String fyxq=getSV(hssfRow.getCell(9));
                        String je=getSV(hssfRow.getCell(10));
                        String pjbh=getSV(hssfRow.getCell(11));
                        String fssj2=getSV(hssfRow.getCell(12));
                        String ks2=getSV(hssfRow.getCell(13));
                        cbmx.setKsbh(sysYhDao.getbmbh(ks2).get(0).get("bmbh").toString());
                        cbmx.setFylx(ycwCbxxDao.getfylx(fylx).get(0).get("zdz").toString());
                        cbmx.setFyxq(fyxq);
                        cbmx.setXmmc(xmmc);
                        if (je != null && !("").equals(je)) {
							BigDecimal cbhjBigDecimal = new BigDecimal(je);
							cbhjBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
							cbmx.setJe(cbhjBigDecimal);
						}
                        cbmx.setPjbh(pjbh);
                        if (fssj2 != null && !("").equals(fssj2)) {
							Date lrrqdDate = sdf.parse(fssj2);
							cbmx.setFssj(lrrqdDate);
						}
                        cbmx.setLrrq(new Date());
                        cbmx.setCbbh(String.valueOf(cbbh));
                        cbmxDao.save(cbmx);
                    }
                }
            }
        }
        catch (Exception e)
        {
        	System.out.println(e.getMessage());
          return null;
        }               
		return null;
	}
	
	public String getCbbh(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	    Date date = new Date();
	    String str = sdf.format(date);
	    str = str.substring(2,4);
		List<Map<String, Object>> cydbhList = cbmxDao.getCbbh();
		String cbbhStr = (String) cydbhList.get(0).get("cbbh");
		if (cbbhStr!=null) {
			String cbbhSub = cbbhStr.substring(2, 8);
			Integer maxCydbh = Integer.parseInt(cbbhSub);
			Integer newBh = maxCydbh + 1;
			String tempBh = "" + newBh;
			int bgbhlength = tempBh.length();
			if (bgbhlength==1) {
				str += "00000"+tempBh; 
			}else if (bgbhlength==2) {
				str += "0000"+tempBh; 
			}else if (bgbhlength==3) {
				str += "000"+tempBh; 
			}else if (bgbhlength==4) {
				str += "00"+tempBh; 
			}else if (bgbhlength==5) {
				str += "0"+tempBh; 
			}else {
				str += tempBh; 
			}
		}else {
		    str += "000001";
		}
		
		return str;
	}
	
	/**
	 * 导出Excel
	 * @author wangyong
	 * @throws Exception 
	 * @date 2015年10月27日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		if(code!=null){
			code=java.net.URLDecoder.decode(code,"UTF-8");
		}
		List<Map<String,Object>> list=ycwCbxxDao.getList(code);
		String[] header=new String[]{"科室","检验编号","项目名称","项目详细内容","成本合计","录入日期","录入人","修改人",
				"修改日期","修改原因","备注"};
		String[] keys=new String[]{"KSBH","JYBH","YPMC","XXNR","CBHJ","LRRQ","LRR","XGR",
				"XGRQ","XGYY","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}	
}
