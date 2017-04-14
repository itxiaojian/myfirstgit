package com.zssi.framework.app.rsgl.service;

import java.math.BigDecimal;
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
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.rsgl.dao.YrsXzinfoKcDao;
import com.zssi.framework.app.rsgl.model.YrsXzinfoKc;
import com.zssi.framework.app.util.ExportExcelUtil;

@Service
public class YrsXzinfoKcService extends BaseBO<YrsXzinfoKc>{

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YrsXzinfoKcDao yrsXzinfoKcDao;
	
	/**
	 * 后台：薪资扣除信息
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param start
	 * @param limit
	 * @param code
	 * @return
	 */
	public Pagination<Map<String, Object>> getXzinfoKcList(Integer start,Integer limit,String rybh){
		return yrsXzinfoKcDao.getXzinfoKcList(start, limit, rybh);
	}
	
	/**
	 * 修改
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param entity
	 * @param id
	 */
	@Transactional
	public void update(YrsXzinfoKc entity,String id){
		entity.setId(Integer.parseInt(id));
		yrsXzinfoKcDao.update(entity);
	}
	
	/**
	 * 存储多条薪资扣除数据
	 * 
	 * @author wangyong
	 * @date 2015年11月27日
	 * @param request
	 */
	@Transactional
	public void insert(HttpServletRequest request){
		Integer num=0;
		if(request.getParameter("num")!=null&&!"".equals(request.getParameter("num"))){
			num=Integer.parseInt(request.getParameter("num"));
		}
		for (int i = 0; i < num; i++) {
			String rybh=request.getParameter("rybh"+(i+1));
			String yf=request.getParameter("yf"+(i+1));
			String qqkc=request.getParameter("qqkc"+(i+1));
			String ylbx=request.getParameter("ylbx"+(i+1));
			String yb=request.getParameter("yb"+(i+1));
			String sybx=request.getParameter("sybx"+(i+1));
			String sbxj=request.getParameter("sbxj"+(i+1));
			String zfgjj=request.getParameter("zfgjj"+(i+1));
			String gs=request.getParameter("gs"+(i+1));
			String kcxj=request.getParameter("kcxj"+(i+1));
			
			YrsXzinfoKc xzkc=new YrsXzinfoKc();
			
			xzkc.setRybh(rybh);
			xzkc.setYf(yf);
			if (qqkc != null && !("").equals(qqkc)) {
				BigDecimal qqkcBigDecimal = new BigDecimal(qqkc);
				qqkcBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				xzkc.setQqkc(qqkcBigDecimal);
			}
			if (ylbx != null && !("").equals(ylbx)) {
				BigDecimal ylbxBigDecimal = new BigDecimal(ylbx);
				ylbxBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				xzkc.setYlbx(ylbxBigDecimal);
			}
			if (yb != null && !("").equals(yb)) {
				BigDecimal ybBigDecimal = new BigDecimal(yb);
				ybBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				xzkc.setYb(ybBigDecimal);
			}
			if (sybx != null && !("").equals(sybx)) {
				BigDecimal sybxbBigDecimal = new BigDecimal(sybx);
				sybxbBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				xzkc.setSybx(sybxbBigDecimal);
			}
			if (sbxj != null && !("").equals(sbxj)) {
				BigDecimal sbxjbBigDecimal = new BigDecimal(sbxj);
				sbxjbBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				xzkc.setSbxj(sbxjbBigDecimal);
			}
			if (zfgjj != null && !("").equals(zfgjj)) {
				BigDecimal zfgjjbBigDecimal = new BigDecimal(zfgjj);
				zfgjjbBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				xzkc.setZfgjj(zfgjjbBigDecimal);
			}
			if (gs != null && !("").equals(gs)) {
				BigDecimal gsbBigDecimal = new BigDecimal(gs);
				gsbBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				xzkc.setGs(gsbBigDecimal);
			}
			if (kcxj != null && !("").equals(kcxj)) {
				BigDecimal kcxjbBigDecimal = new BigDecimal(kcxj);
				kcxjbBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
				xzkc.setKcxj(kcxjbBigDecimal);
			}
			yrsXzinfoKcDao.save(xzkc);
		}
	}
	
	/**
	 * 删除
	 * @author wangyong
	 * @date 2015年10月21日
	 * @param ids
	 */
	@Transactional
	public void delete(Integer[] ids) {
		for(int i=0;i<ids.length;i++){
			yrsXzinfoKcDao.delete(ids[i]);
		}
	}
	
	/**
	 * 验证表格中的数据
	 * @author wangyong
	 * @date 2015年10月26日
	 * @param row
	 * @return
	 */
	private String validate(Row row) {
        String v = getSV(row.getCell(0));
        if(v!=null&&!v.matches("^[0-9A-Za-z]{1,12}$")){
            return "第"+(row.getRowNum()+1)+"行第1列，必需是数字字母且长度不超过12";
        }
        return null;
    }

	/**
	 * 获取单元格
	 * @author wangyong
	 * @date 2015年10月26日
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
	 * @date 2015年10月26日
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
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        YrsXzinfoKc xzinfoKc = new YrsXzinfoKc();
                        String rybh=getSV(hssfRow.getCell(0));
                        String yf=getSV(hssfRow.getCell(1));
                        String qqkc=getSV(hssfRow.getCell(2));
                        String ylbx=getSV(hssfRow.getCell(3));
                        String yb=getSV(hssfRow.getCell(4));
                        String sybx=getSV(hssfRow.getCell(5));
                        String sbxj=getSV(hssfRow.getCell(6));
                        String zfgjj=getSV(hssfRow.getCell(7));
                        String gs=getSV(hssfRow.getCell(8));
                        String kcxj=getSV(hssfRow.getCell(9));
                        String bz=getSV(hssfRow.getCell(10));
                        
                        xzinfoKc.setRybh(rybh);
                        xzinfoKc.setYf(yf);
                        if (qqkc!=null && !("").equals(qqkc)) {
                        	BigDecimal qqkcBd = new BigDecimal(qqkc);
                        	qqkcBd.setScale(2, BigDecimal.ROUND_HALF_UP);
                        	xzinfoKc.setQqkc(qqkcBd);
							
						}
                        if (ylbx!=null && !("").equals(ylbx)) {
                        	BigDecimal ylbxBd = new BigDecimal(ylbx);
                        	ylbxBd.setScale(2, BigDecimal.ROUND_HALF_UP);
                        	xzinfoKc.setYlbx(ylbxBd);
							
						}
                        if (yb!=null && !("").equals(yb)) {
                        	BigDecimal ybBd = new BigDecimal(yb);
                        	ybBd.setScale(2, BigDecimal.ROUND_HALF_UP);
                        	xzinfoKc.setYb(ybBd);
							
						}
                        if (sybx!=null && !("").equals(sybx)) {
                        	BigDecimal sybxBd = new BigDecimal(sybx);
                        	sybxBd.setScale(2, BigDecimal.ROUND_HALF_UP);
                        	xzinfoKc.setSybx(sybxBd);
							
						}
                        if (sbxj!=null && !("").equals(sbxj)) {
                        	BigDecimal sbxjBd = new BigDecimal(sbxj);
                        	sbxjBd.setScale(2, BigDecimal.ROUND_HALF_UP);
                        	xzinfoKc.setSbxj(sbxjBd);
							
						}
                        if (zfgjj!=null && !("").equals(zfgjj)) {
                        	BigDecimal zfgjjBd = new BigDecimal(zfgjj);
                        	zfgjjBd.setScale(2, BigDecimal.ROUND_HALF_UP);
                        	xzinfoKc.setZfgjj(zfgjjBd);
							
						}
                        if (gs!=null && !("").equals(gs)) {
                        	BigDecimal gsBd = new BigDecimal(gs);
                        	gsBd.setScale(2, BigDecimal.ROUND_HALF_UP);
                        	xzinfoKc.setGs(gsBd);
							
						}
                        if (kcxj!=null && !("").equals(kcxj)) {
                        	BigDecimal kcxjBd = new BigDecimal(kcxj);
                        	kcxjBd.setScale(2, BigDecimal.ROUND_HALF_UP);
                        	xzinfoKc.setKcxj(kcxjBd);
							
						}
                        xzinfoKc.setBz(bz);
                        yrsXzinfoKcDao.save(xzinfoKc);
                    }
                }
            }
        }
        catch (Exception e)
        {
        	System.out.println(e.getMessage());
          return e.getMessage();
        }               
		return null;
	}
	
	/**
	 * 导出Excel
	 * @author wangyong
	 * @throws Exception 
	 * @date 2015年10月26日
	 */
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String code) throws Exception {
		List<Map<String,Object>> list=yrsXzinfoKcDao.getList(code);
		String[] header=new String[]{"人员编号","月份","缺勤扣除","养老保险","医保","失业保险","社保小计",
				"住房公积金","个税","扣除小计","备注"};
		String[] keys=new String[]{"RYBH","YF","QQKC","YLBX","YB","SYBX","SBXJ","ZFGJJ","GS","KCXJ","BZ"};
		ExportExcelUtil.exportExcel(request, response, header, keys, list);
	}

	public List<Map<String, Object>> getxzkc(Integer id) {
		return yrsXzinfoKcDao.getxzkc(id);
	}	
}
