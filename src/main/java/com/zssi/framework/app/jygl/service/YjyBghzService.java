package com.zssi.framework.app.jygl.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.likegene.framework.core.BaseBO;
import com.zssi.framework.app.common.dao.support.Pagination;
import com.zssi.framework.app.jygl.dao.YjyBghzDao;
import com.zssi.framework.app.jygl.model.YjyBgfy;
import com.zssi.framework.app.sys.model.SysYh;
import com.zssi.framework.app.util.AppUtil;

import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

/**
 * 检验报告的汇总
 * @author oufeng
 * @date 2016年5月23日
 */
/**
 * @author Administrator
 *
 */
@Service
public class YjyBghzService   extends BaseBO<YjyBghzDao>{
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private YjyBghzDao dao;
	
	/**
	 * 后台:报告的信息的查询
	 * @author oufeng
	 * @date 2016年5月23日
	 * @param start
	 * @param limit
	 * @param canshu
	 * @return
	 */
	public Pagination<Map<String , Object>> getBgxxList(Integer start,Integer limit,String starttime,String endtime,String jylx,String canshu){
		return dao.getBgxxList(start, limit, starttime,endtime,jylx,canshu);
	}

	/**
	 * 后台:获取属性
	 * @author oufeng
	 * @date 2016年5月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getSx(String tabName,String tabName1) {
		return dao.getSx(tabName,tabName1);
	}
	
	/**
	 * 后台:获取条件
	 * @author oufeng
	 * @date 2016年5月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getTj() {
		return dao.getTj();
	}
	
	/**
	 * 检验状态
	 * @author oufeng
	 * @date 2016年5月23日
	 * @return
	 */
	@Transactional
	public List<Map<String, Object>> getZt() {
		return dao.getZt();
	}
	
	/**
	 * 导出信息
	 * @author oufeng
	 * @date 2016年5月23日
	 * @return
	 */
	@Transactional
	public String toexcelBgfyxx(HttpServletRequest request) {
		String str="";
		SysYh yh =AppUtil.getCurrentUser();
		Integer yhbh =yh.getYhbh();
		String bmbh = yh.getBmbh();
		String path = request.getSession().getServletContext().getRealPath("resources/jyhz");
		File file = new File(path);
		String fileName = "";
		if (file.isDirectory()) {
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
		fileName = files[i].getName();
		if((yhbh+""+"_"+bmbh+"bghz.xls").equals(fileName) ||(yhbh+""+"_"+bmbh+"bghz.xls")==fileName){
			  str=fileName; 
			  break;
		      }else{
		       str="0";
		       }
		    }
		}
		// 打印符合要求的文件名
		return str;
	}
	
	/**
	 * 是否包含bgbh
	 * @author oufeng
	 * @date 2016年5月23日
	 * @return
	 */
	@Transactional
	public List<Object> hasDta() {
		List<Object> list = new ArrayList<Object>();
		List<Map<String, Object>> listHasData = dao.hasDtaHf();
		if(listHasData.size()!=0){
			for (int i = 0; i < listHasData.size(); i++) {
				list.add(listHasData.get(i).get("bgbh")+"");
			}
		}
		return list;
	}
	
	/**
	 * 是否有报告附页
	 * @author oufeng
	 * @date 2016年5月23日
	 * @return
	 */
	@Transactional
	public String  hasBgfy(String [] ids,HttpServletRequest request) {
		String str= "";
		List<String> list = new ArrayList<String>();
		String path = request.getSession().getServletContext().getRealPath("resources/doc");
		File file = new File(path);
		String fileName = "";
		if (file.isDirectory()) {
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
		     fileName = files[i].getName();
		     list.add(fileName);
		  }
		}
		for(int i=0;i<ids.length;i++){
			if(!list.contains(ids[i]+"fy.doc")){
				str="1";
				break;
			}else{
				str="0";
			}
		}
		return str;
	}
	
	/**
	 * 后台:获取报告是否有附页
	 * @author oufeng
	 * @date 2016年5月23日
	 * @return
	 */
	@Transactional
	public String getBgfyxx(String[] ids,HttpServletRequest request,String[] ypzt) {
		String str="";
		String excleML="";
		String str1 ="";
		String  _str= this.hasBgfy(ids,request);
		if("1".equals(_str)){str="2";}else{
        dao.delBgfyxx(ids);
		//dao.delBgfyxx(ids);
		List<Map<String, Object>> listHasData = dao.hasDtaHf();
		for(int i=0;i<ypzt.length;i++){
			if(!"4".equals(ypzt[i]) && !"5".equals(ypzt[i]) && !"6".equals(ypzt[i]) ){
			//if("0".equals(ypzt[i])){
			   str="0";
			}else{
				str="1";
			}
		}
		if("1".equals(str)){
			for(int p=0;p<ids.length;p++){
				if(listHasData.size()!=0){
				if(!this.hasDta().contains(ids[p])){
					String ml1=request.getSession().getServletContext().getRealPath("resources/doc")+"/"+ids[p]+"fy.doc";
					//存入报告附页表
					 testWord(ml1,ids[p]);
				}
			  }else{
				  String ml1=request.getSession().getServletContext().getRealPath("resources/doc")+"/"+ids[p]+"fy.doc";
				   testWord(ml1,ids[p]);
				  }
			      str1+=ids[p];
			}
		   /* if(!"".equals(str1)){
		         str=str1+"hz.xls";}*/
		  }
		}
		return str;
	}
	
	/**
	 * 后台:存入excel
	 * @author oufeng
	 * @date 2016年5月23日
	 * @return
	 */
	@Transactional
	public void tobghz(String[] ids,HttpServletRequest request,String [] ypzt) {
		SysYh yh =AppUtil.getCurrentUser();
		Integer yhbh =yh.getYhbh();
		String bmbh = yh.getBmbh();
		String excleML=request.getSession().getServletContext().getRealPath("resources/jyhz")+"/"+yhbh+""+"_"+bmbh+"bghz.xls";
		//从数据读取数据并生excel文件
		List<Map<String, Object>> listBgxx = dao.getBgxx(ids);
		List<Map<String, Object>> listBgfyxx = dao.getBgfyxx(ids);
		List<Map<String, Object>> listBgfyxx1 = dao.getBgfyxx1(ids);
	    writeExcel(listBgxx,listBgfyxx,listBgfyxx1,excleML);
	}
	
	
	@Transactional
	public void testWord(String ml,String bgbh){
		List<String> list = new ArrayList<String>();
		int index=0;
		try{
	    FileInputStream in = new FileInputStream(ml);//载入文档
        POIFSFileSystem pfs = new POIFSFileSystem(in);   
        HWPFDocument hwpf = new HWPFDocument(pfs);   
        Range range = hwpf.getRange();//得到文档的读取范围
        TableIterator it = new TableIterator(range);
      //迭代文档中的表格
        while (it.hasNext()) {
            //1.按照单元格内容进行解析
                 Table table;  
                 TableRow row;  
                 TableCell cell;  
                 while (it .hasNext()) {  
                    table = it .next();  
                    int rowNum = table.numRows();  
                    for (int j=1; j<rowNum; j++) {  
                       row = table.getRow(j);  
                       index++;
                       if(row.numCells()==1){}else{
                       int cellNum = row.numCells();  
                       for (int k=1; k<cellNum; k++) {  
                           cell = row.getCell(k);  
                           //输出单元格的文本  
                           list.add(j+""+k+cell.text().trim());
                        }  
                      }  
                    }
                 }  
             }  //end while
      int subIndex=0;
      for(int m=0;m <index-1;m++){
    	     if((m+1)<10){subIndex=2;}else if((m+1)>=10){subIndex=3;}else if((m+1)>=100){subIndex=4;}else if((m+1)>=1000){subIndex=5;}
   	   YjyBgfy bgfy = new YjyBgfy();
    	    bgfy.setBgbh(bgbh);
    	    bgfy.setXmmc( list.get((m*4)+0).substring(subIndex));
    	    bgfy.setJsyq(list.get((m*4)+1).substring(subIndex));
    	    bgfy.setJyjg(list.get((m*4)+2).substring(subIndex));
    	    //可能存在(合格，合格)这样多个数据或者(合格，不合格)
    	    if(list.get((m*4)+3).substring(subIndex).contains("不合格")){
    	    	 bgfy.setDxpd("不合格");
    	    }else{bgfy.setDxpd("合格");}
    	   
    	    bgfy.setPx(m+1);
    	    dao.save(bgfy);
      }
 }catch(Exception e){
  e.printStackTrace(); 
 }
	}
 /**
  * 生成excel文件
  * **/
	public void writeExcel(List<Map<String, Object>> listBgxx,List<Map<String, Object>> listBgfyxx,
	    List<Map<String, Object>> listBgfyxx1,String fileName) {
		int bgxxSize=listBgxx.size();
		int bgfyxxSize=listBgfyxx.size();
		
	    // 目标文件
	    File file = new File(fileName);
	    FileOutputStream fOut = null;
	    try {
	        // 创建新的Excel 工作簿
	        HSSFWorkbook workbook = new HSSFWorkbook();
	 
	        // 在Excel工作簿中建一工作表，其名为缺省值。
	        // 也可以指定工作表的名字。
	        HSSFSheet sheet = workbook.createSheet("报告汇总");
	        // 创建字体，红色、粗体
	        HSSFFont font = workbook.createFont();
	        // font.setColor(HSSFFont.COLOR_RED);
	        //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	 
	        // 创建单元格的格式，如居中、左对齐等
	        HSSFCellStyle cellStyle = workbook.createCellStyle();
	        // 水平方向上居中对齐
	        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        // 垂直方向上居中对齐
	        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	        // 设置字体
	        cellStyle.setFont(font);
	        //cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框    
	        //cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框    
	        //cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框    
	        //cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	 
	        // 下面将建立一个4行3列的表。第一行为表头。
	        int rowNum = 0;// 行标
	        int colNum = 0;// 列标
	        // 建立表头信息
	        // 在索引0的位置创建行（最顶端的行）
	        HSSFRow row = sheet.createRow((short) rowNum);
	        // 单元格
	        HSSFCell cell = null;

	        // 合并单元格
	        // 先创建2行5列的单元格，然后将这些单元格合并为2个大单元格
	        rowNum = 0;
	        for (; rowNum < 3+bgxxSize; rowNum++) {
	            row = sheet.createRow((short) rowNum);
	            for (colNum = 0; colNum < 10+bgfyxxSize*2; colNum++) {
	                // 在当前行的colNum位置创建单元格
	                cell = row.createCell((short) colNum);
	            }
	        }
	        
	       for(int i=0;i<9;i++){
		        // 建立第一个大单元格，高度为2，宽度为1
		        rowNum = 0;
		        colNum = i;
		        if(i==8){
		        Region region = new Region(rowNum, (short) colNum, (rowNum),
		 	                (short) (colNum+(bgfyxxSize*2)-1));
		        sheet.addMergedRegion(region);
		        }else{
		        Region region = new Region(rowNum, (short) colNum, (rowNum+2),
		                (short) (colNum));
		        sheet.addMergedRegion(region);
		        }
		        // 获得第一个大单元格
		        cell = sheet.getRow(rowNum).getCell((short) colNum);
//		        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		        if(i==0){cell.setCellValue("序号");}
		        if(i==1){cell.setCellValue("抽样号 检验报告编号");}
		        if(i==2){cell.setCellValue("抽查商品 名称 型号规格 商标");}
		        if(i==3){cell.setCellValue("被抽查经销企业名称");}
		        if(i==4){cell.setCellValue("经销单位性质 国营 集体 乡镇 股份 个体");}
		        if(i==5){cell.setCellValue("被抽查生产企业名称");}
		        if(i==6){cell.setCellValue("被查商品出厂日期或批号");}
		        if(i==7){cell.setCellValue("被查商品进货日期");}
		        if(i==8){cell.setCellValue("检  验  项  目  及  检  验  结  果");}
		        cell.setCellStyle(cellStyle);
	        }
	       
	       Map map = new HashMap<String, Object>(); 
	       int n=0;
			for (int i = 0; i < listBgfyxx.size(); i++) {
			    map = (Map<String,Object>) listBgfyxx.get(i);
			        String xmmc = map.get("xmmc")+"";
			        rowNum = 1;
			        colNum = 8+n;
			        Region region = new Region(rowNum, (short) colNum, (rowNum),
			                (short) (colNum+1));
			        sheet.addMergedRegion(region);
			        // 获得第一个大单元格
			        cell = sheet.getRow(rowNum).getCell((short) colNum);
//			        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			        cell.setCellStyle(cellStyle);
			        cell.setCellValue(xmmc);
			        n+=2;
			}
	    
			
			
	        rowNum = 0;
	        colNum = 8+bgfyxxSize*2;
	        Region region = new Region(rowNum, (short) colNum, (rowNum + 2),
	                (short) (colNum));
	        sheet.addMergedRegion(region);
	        // 获得第一个大单元格
	        cell = sheet.getRow(rowNum).getCell((short) colNum);
//	        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	        cell.setCellValue("综合判定");
	        cell.setCellStyle(cellStyle);
	        
	        rowNum = 0;
	        colNum = 8+bgfyxxSize*2+1;
	        region = new Region(rowNum, (short) colNum, (rowNum + 2),
	                (short) (colNum));
	        sheet.addMergedRegion(region);
	        // 获得第一个大单元格
	        cell = sheet.getRow(rowNum).getCell((short) colNum);
//	        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	        cell.setCellValue("备注");
	        cell.setCellStyle(cellStyle);
	     
	        
	        for(int i=0;i<bgfyxxSize*2;i++){
		        rowNum = 2;
		        colNum = 8+i;
		        region = new Region(rowNum, (short) colNum, (rowNum),
		                (short) (colNum));
		        sheet.addMergedRegion(region);
		        // 获得第一个大单元格
		        cell = sheet.getRow(rowNum).getCell((short) colNum);
//		        cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		        if(i%2==0){
		            cell.setCellValue("标准值");
		        }else{
		        	cell.setCellValue("实测值");
		        }
		        cell.setCellStyle(cellStyle);
	        }
	        
	       
	        for (colNum = 0; colNum < 10+bgfyxxSize*2; colNum++) {
	            // 在当前行的colNum列上创建单元格
	            cell = row.createCell((short) colNum);
	 
	            // 定义单元格为字符类型，也可以指定为日期类型、数字类型
	            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	            // 定义编码方式，为了支持中文，这里使用了ENCODING_UTF_16
//	            cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	          //  cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
	          //  cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
	          //  cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
	          //  cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
	            // 为单元格设置格式
	            cell.setCellStyle(cellStyle);
	 
	            // 添加内容至单元格
	            cell.setCellValue("");
	        }
	        rowNum++;
	        Map<String, Object> map1 = new HashMap<String, Object>(); 
	        Map<String, Object> map2 = new HashMap<String, Object>(); 
	        Map<String, Object> map3= new HashMap<String, Object>();
			        for (rowNum=3; rowNum < 3+bgxxSize; rowNum++) {
			         int x=0;
			         int j=0;
			        	map1 = (Map<String,Object>) listBgxx.get(rowNum-3);
					        String ypbh = map1.get("YPBH")+"";
					        String cmxs = map1.get("cmxs")+"";
					        String yxqymc = map1.get("yxqymc")+"";
					        String jgjxgg = map1.get("jgjxgg")+"";
					        String scqymc = map1.get("scqymc")+"";
					        String SCRQPC = map1.get("SCRQPC")+"";
					        String djsj = map1.get("djsj")+"";
			            // 新建第rowNum行
			            row = sheet.createRow((short) rowNum);
			            row.setHeight((short)500);
			            List<Map<String, Object>> bgxmList = dao.getBgxmList(ypbh,listBgfyxx);
			            for (colNum = 0; colNum < 10+bgfyxxSize*2; colNum++) {
			                // 在当前行的colNum位置创建单元格
			                cell = row.createCell((short) colNum);
//			                cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			                cell.setCellStyle(cellStyle);
			                //cell.setCellValue("值-" + rowNum + "-" + colNum);
			          
			                if(colNum==0){cell.setCellValue((rowNum-3)+1);}
			                if(colNum==1){cell.setCellValue(ypbh);}
			                if(colNum==2){cell.setCellValue(cmxs);}
			                if(colNum==3){cell.setCellValue(yxqymc);}
			                if(colNum==4){cell.setCellValue(jgjxgg);}
			                if(colNum==5){cell.setCellValue(scqymc);}
			                if(colNum==6){cell.setCellValue(SCRQPC);}
			                if(colNum==7){cell.setCellValue(djsj);}
			                
			                if(colNum==(8+bgfyxxSize*2)){
			                	int y=0;
			                	for(int t=0;t<bgfyxxSize;t++){
			                		if("合格".equals(bgxmList.get(0).get("dxpd"+t)+"")){
			                			y++;
			                		}
			                		if(y==bgfyxxSize){
			                		cell.setCellValue("合格");
			                	  }else{cell.setCellValue("不合格");}
			                	}
			                }
			                
			                
				            for(int t=0;t<bgfyxxSize*2;t++){
				            	if(bgxmList.size()==1){
				            		if(t%2==0){
				            		if(colNum==8+t){
				            			    cell.setCellValue(bgxmList.get(0).get("jsyq"+x)+"");
				            				x=x+1;
					            		}	
				            		}
				            		if(t%2!=0){
				            			if(colNum==8+t){
				            				if("合格".equals(bgxmList.get(0).get("dxpd"+j)+"")){
				            				   cellStyle.setWrapText(true);
				            					cell.setCellValue(new HSSFRichTextString(bgxmList.get(0).get("jyjg"+j)+""+"\r\n (+)"));
				            				}else{
				            					cell.setCellValue(bgxmList.get(0).get("jyjg"+j)+"");
				            				}
				            				j++;
					            		}
				            		  }
				            	}
				            }
				         
				            sheet.autoSizeColumn(colNum, true);
			            }
			         //   cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
			         //    cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
			        //    cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
			        //    cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
			            cell.setCellStyle(cellStyle);
			        }
	        // 工作薄建立完成，下面将工作薄存入文件
	        // 新建一输出文件流
	        fOut = new FileOutputStream(file);
	        // 把相应的Excel 工作簿存盘
	        workbook.write(fOut);
	        fOut.flush();
	        // 操作结束，关闭文件
	        fOut.close();
	 
	        System.out
	                .println("Excel文件生成成功！Excel文件名：" + file.getAbsolutePath());
	    } catch (Exception e) {
	        System.out
	                .println("Excel文件" + file.getAbsolutePath() + "生成失败：" + e);
	    } finally {
	        if (fOut != null) {
	            try {
	                fOut.close();
	            } catch (IOException e1) {
	            }
	        }
	    }
	}
	
	//测试
	public void testWord1(){
		String[] s1=new String[300]; 
		int index=0;
		try{
	    FileInputStream in = new FileInputStream("C:/Users/Administrator/Desktop/bg/2016JQ00206fy.doc");//载入文档
	  //  FileInputStream in = new FileInputStream("C:/Users/Administrator/Desktop/bg/ 2016SH00774fyfy.doc");//载入文档
        POIFSFileSystem pfs = new POIFSFileSystem(in);   
        HWPFDocument hwpf = new HWPFDocument(pfs);   
        Range range = hwpf.getRange();//得到文档的读取范围
        TableIterator it = new TableIterator(range);
      //迭代文档中的表格
        while (it.hasNext()) {
       //1.按照单元格内容进行解析
            Table table;  
            TableRow row;  
            TableCell cell;  
            while (it .hasNext()) {  
               table = it .next();  
               int rowNum = table.numRows();  
               for (int j=1; j<rowNum-1; j++) {  
                  row = table.getRow(j);  
                  if(row.numCells()==1){}else{
                  int cellNum = row.numCells();  
                  for (int k=1; k<cellNum; k++) {  
                      cell = row.getCell(k);  
                      //输出单元格的文本  
                      s1[index]=cell.text().trim();  
                     // System.out.println(cell.text().trim()); 
                      index++;  
                   }  
                 }  
               }
            }  
        }
        
         //2.按照段落进行解析        
        
        /*Table tb = (Table) it.next();   
          //迭代行，默认从0开始
          for (int i = 1; i < tb.numRows()-1; i++) {   
             TableRow tr = tb.getRow(i);   
             //迭代列，默认从0开始
             if(tr.numCells()==1){}else{
             for (int j = 1; j < tr.numCells(); j++) {   
                 TableCell td = tr.getCell(j);//取得单元格
                 //取得单元格的内容
                 for(int k=0;k<td.numParagraphs();k++){   
                     Paragraph para =td.getParagraph(k);//
                     String s = para.text();
                     //list.add(i+""+j+s.substring(0,s.length()-1));
                     s1[index]=para.text().trim();  
                     index++;  
                     list.add(i+""+j+s.substring(0,s.length()-1));
                 } //end for 
             }   //end for
             }
         }   //end for
     } */
        //end while
        System.out.println(s1.toString());  
        for(int i=0;i<s1.length;i++){  
            System.out.println("s1["+i+"]="+s1[i]);  
        } 
 }catch(Exception e){
  e.printStackTrace(); 
 }
	}
	
	
	
	public static void main(String[] args){
		YjyBghzService a = new YjyBghzService();
		a.testWord1();
		
		String path = "F:/tomcat/tomcat6/64/apache-tomcat-6.0.44/webapps/zjyw/resources/doc";
		File file = new File(path);
		String fileName = "";
		if (file.isDirectory()) {
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
		fileName = files[i].getName();
		    }
		}
		// 打印符合要求的文件名
		System.out.println(fileName);
	
	}
}
