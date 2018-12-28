package com.zking.ssm_wy.Base.util;

import java.io.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 提供导入导出Excel表格通用
 * 
 * @author biubiubiu
 *
 */
public class ExcelUtils {

	/**
	 * 导出Excel表格通用
	 * 
	 * @param //List<Object>
	 *            数据源
	 * @param tname
	 *            表头名字
	 * @param str
	 *            列名
	 * @param response
	 *            响应对象
	 * @param contol
	 *            1=浏览器下载 2==输出本地
	 * @param filePath
	 *            输出本地地址
	 */
	public static void outExcel(List<Object> li, String tname, String[] str, HttpServletResponse response, int contol,
			String filePath) {
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();

		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet(tname);
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建表头样式对象
		HSSFCellStyle style = wb.createCellStyle();
		// 左右居中
		style.setAlignment(HorizontalAlignment.CENTER);

		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置样式
		cell.setCellStyle(style);
		// 设置单元格内容
		cell.setCellValue(tname);

		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, str.length - 1));
		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容

		for (int s = 0; s < str.length; s++) {
			row2.createCell(s).setCellValue(str[s]);

		}

		for (int i = 2; i < li.size(); i++) {
			// 根据集合的数据在sheet里继续创建 行
			HSSFRow row3 = sheet.createRow(i);
			List st3 = get(li.get(i));
			for (int g = 0; g < st3.size(); g++) {
				String slin = "";
				if (st3.get(g) != null)
					slin = st3.get(g).toString();
				row3.createCell(g).setCellValue(slin);

			}

		}
		if (contol == 1) {
			// 网页下载-打开浏览器下载端
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=未命名.xls");
			try {
				OutputStream out = response.getOutputStream();
				wb.write(out);
				out.close();
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 输出Excel文件
			FileOutputStream fos = null;
			BufferedOutputStream bos = null;
			try {
				// 创建输出流
				fos = new FileOutputStream(filePath);
				// 包装过滤流
				bos = new BufferedOutputStream(fos);
				// 操作数据

				wb.write(bos);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

	/**
	 * 接收对象以反射获取对象中的属性值，实现通用
	 * 
	 * @param //o
	 * @return String []
	 */
	public static List<Object> get(Object obj) {
		List<Object> list = new ArrayList<>();

		// 根据对象取到类对象
		Class clazz = obj.getClass();
		// 获取类对象中所有的属性
		Field[] declaredFields = clazz.getDeclaredFields();
		// 遍历类中的所有属性

		for (int i = 0; i < declaredFields.length; i++) {
			declaredFields[i].setAccessible(true);
			try {

				list.add(declaredFields[i].get(obj));
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return list;
	}

	/**
	 * Map导出Excel表格通用
	 * 
	 * @param //List<Map<String,Object>>
	 *            数据源
	 * @param tname
	 *            表头名字 为空不打印标题列
	 * @param str Map键集合
	 *            列名
	 * @param response
	 *            响应对象
	 * @param contol
	 *            1=浏览器下载 2==输出本地
	 * @param filePath
	 *            输出本地地址
	 */
	public static void mapOutExcel(List<Map<String, Object>> li, String tname, String[] str,
			HttpServletResponse response, int contol, String filePath) {
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		// 创建表头样式对象
		HSSFCellStyle style = wb.createCellStyle();
		// 左右居中
		style.setAlignment(HorizontalAlignment.CENTER);
		//控制打印行号
		int rowindex=0;
		if(tname!=null) {
			HSSFRow row1 = sheet.createRow(rowindex);
			// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个z
			HSSFCell cell = row1.createCell(0);
			// 设置样式
			cell.setCellStyle(style);
			// 设置单元格内容
			cell.setCellValue(tname);
			rowindex++;
			// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, str.length - 1));
		}
		// 在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(rowindex);
		// 创建单元格并设置单元格内容

		for (int s = 0; s < str.length; s++) {
			row2.createCell(s).setCellValue(str[s]);
		}
		for (int i = 0; i < li.size(); i++) {
			// 根据集合的数据在sheet里继续创建 行
			HSSFRow row3 = sheet.createRow(++rowindex);
			//根据键取值，打印cell
			for (int g = 0; g < str.length; g++) {
				String slin = "";
				if (li.get(i).get(str[g]) != null)
					slin =li.get(i).get(str[g]).toString();
				row3.createCell(g).setCellValue(slin);
			}

		}
		if (contol == 1) {
			// 网页下载-打开浏览器下载端
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=未命名.xls");
			try {
				OutputStream out = response.getOutputStream();
				wb.write(out);
				out.close();
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// 输出Excel文件
			FileOutputStream fos = null;
			BufferedOutputStream bos = null;
			try {
				// 创建输出流
				fos = new FileOutputStream(filePath);
				// 包装过滤流
				bos = new BufferedOutputStream(fos);
				// 操作数据

				wb.write(bos);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}

	/**
	 * 读取Execl表格方法
	 * 
	 * @param filePath
	 *            文件路径
	 * @param firstIndex
	 *            起始行号
	 * @param //String[]
	 *            mapKey map键
	 * @return list 属性对象集合
	 */
	public static List<Map<String, Object>> readCaseFile(InputStream filePath, int firstIndex, String[] mapKey) {
		// 定义集合
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;
		List<String> ls = new ArrayList<>();
		Workbook xssf = null;
		// 区别excel版本调用不同的对象 不同版本使用不同的对象
		try {
			xssf = new XSSFWorkbook(filePath);
		} catch (Exception ex) {
			try {
				xssf = new HSSFWorkbook(filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			// 默认一个工作簿
			Sheet sheet = xssf.getSheetAt(0);
			// 如果sheet中第一行为空,视为sheet为空
			if (sheet.getRow(0).getCell(0) == null) {
				System.out.println("工作簿没有数据");
			} else {
				// 获取第一行和最后一行行号
				int firstRowIndex = firstIndex;
				int lastRowIndex = sheet.getLastRowNum();
				// lastRowIndex=4;

				// 读取数据行
				for (int rowIndex = firstRowIndex; rowIndex <= lastRowIndex; rowIndex++) {
					// 当前行
					Row currentRow = sheet.getRow(rowIndex);
					// 首列
					int firstColumnIndex = currentRow.getFirstCellNum();
					// 最后一列
					int lastColumnIndex = currentRow.getLastCellNum();
					// lastColumnIndex=4;
					// 读取列
					for (int columnIndex = firstColumnIndex; columnIndex < lastColumnIndex; columnIndex++) {
						// 当前单元格
						Cell currentCell = currentRow.getCell(columnIndex);
						// 当前单元格的值
						String currentCellValue = getCellValue(currentCell, true);
						// 将单元格的值存入ls
						ls.add(currentCellValue);

					}

					int i = 0;
					// 判断是否为空行
					for (int j = 0; j < lastColumnIndex; j++) {
						if (ls.get(j) == "" || ls.get(j) == null) {
							i++;
						}
					}

					// 不为空行在继续添加
					if (i != lastColumnIndex) {
						map = new LinkedHashMap<String, Object>();
						// 添加值
						for (int ie = 0; ie < ls.size(); ie++) {
							map.put(mapKey[ie], ls.get(ie));

						}

						list.add(map);
						ls.clear();// 读完一行之后清空ls,方便存储下一行数据

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 取单元格的值
	 * 
	 * @param cell
	 *            单元格对象
	 * @param treatAsStr
	 *            为true时，当做文本来取值 (取到的是文本，不会把“1”取成“1.0”)
	 * @return
	 */
	private static String getCellValue(Cell cell, boolean treatAsStr) {
		if (cell == null) {
			return "";
		}
		
		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());

		} else if (cell.getCellType() == 0) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 用于转化为日期格式
				Date d = cell.getDateCellValue();
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				return formater.format(d);
			} else {
				//转换整数
				DecimalFormat df = new DecimalFormat("########");
				return  df.format(cell.getNumericCellValue());
			}
				
		} else {
			return String.valueOf(cell.getStringCellValue());
		}
	}

}
