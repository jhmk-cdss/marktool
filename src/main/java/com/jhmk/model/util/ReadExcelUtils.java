//package com.jhmk.model.util;
//
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.*;
//import java.util.*;
//
///**
// * @author ziyu.zhou
// * @date 2018/9/14 10:13
// */
//
//public class ReadExcelUtils {
//
//    private static HSSFWorkbook workbook = null;
//
//
//    private Logger logger = LoggerFactory.getLogger(ReadExcelUtils.class);
//    private Workbook wb;
//    private Sheet sheet;
//    private Row row;
//
//    public ReadExcelUtils(String filepath) {
//        if (filepath == null) {
//            return;
//        }
//        String ext = filepath.substring(filepath.lastIndexOf("."));
//        try {
//            InputStream is = new FileInputStream(filepath);
//            if (".xls".equals(ext)) {
//                wb = new HSSFWorkbook(is);
//            } else if (".xlsx".equals(ext)) {
//                wb = new XSSFWorkbook(is);
//            } else {
//                wb = null;
//            }
//        } catch (FileNotFoundException e) {
//            logger.error("FileNotFoundException", e);
//        } catch (IOException e) {
//            logger.error("IOException", e);
//        }
//    }
//
//    /**
//     * 读取Excel表格表头的内容
//     *
//     * @param InputStream
//     * @return String 表头内容的数组
//     * @author zengwendong
//     */
//    public String[] readExcelTitle() throws Exception {
//        if (wb == null) {
//            throw new Exception("Workbook对象为空！");
//        }
//        sheet = wb.getSheetAt(0);
//        row = sheet.getRow(0);
//        // 标题总列数
//        int colNum = row.getPhysicalNumberOfCells();
//        System.out.println("colNum:" + colNum);
//        String[] title = new String[colNum];
//        for (int i = 0; i < colNum; i++) {
//            // title[i] = getStringCellValue(row.getCell((short) i));
//            title[i] = row.getCell(i).getCellFormula();
//        }
//        return title;
//    }
//
//    /**
//     * 读取Excel数据内容
//     *
//     * @param InputStream
//     * @return Map 包含单元格数据内容的Map对象
//     * @author zengwendong
//     */
//    public Map<Integer, Map<Integer, String>> readExcelContent() throws Exception {
//        if (wb == null) {
//            throw new Exception("Workbook对象为空！");
//        }
//        Map<Integer, Map<Integer, String>> content = new HashMap<Integer, Map<Integer, String>>();
//
//        sheet = wb.getSheetAt(0);
//        // 得到总行数
//        int rowNum = sheet.getLastRowNum();
//        row = sheet.getRow(0);
//        int colNum = row.getPhysicalNumberOfCells();
//        // 正文内容应该从第二行开始,第一行为表头的标题
//        for (int i = 1; i <= rowNum; i++) {
//            row = sheet.getRow(i);
//            int j = 0;
//            Map<Integer, String> cellValue = new HashMap<Integer, String>();
//            while (j < colNum) {
//                String obj = getCellFormatValue(row.getCell(j)).toString();
//                cellValue.put(j, obj);
//                j++;
//            }
//            content.put(i, cellValue);
//        }
//        return content;
//    }
//
//    /**
//     * 根据Cell类型设置数据
//     *
//     * @param cell
//     * @return
//     * @author zengwendong
//     */
//    private Object getCellFormatValue(Cell cell) {
//        Object cellvalue = "";
//        if (cell != null) {
//            // 判断当前Cell的Type
//            switch (cell.getCellType()) {
//                case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
//                case Cell.CELL_TYPE_FORMULA: {
//                    // 判断当前的cell是否为Date
//                    if (DateUtil.isCellDateFormatted(cell)) {
//                        // 如果是Date类型则，转化为Data格式
//                        // data格式是带时分秒的：2013-7-10 0:00:00
//                        // cellvalue = cell.getDateCellValue().toLocaleString();
//                        // data格式是不带带时分秒的：2013-7-10
//                        Date date = cell.getDateCellValue();
//                        cellvalue = date;
//                    } else {// 如果是纯数字
//
//                        // 取得当前Cell的数值
//                        cellvalue = String.valueOf(cell.getNumericCellValue());
//                    }
//                    break;
//                }
//                case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
//                    // 取得当前的Cell字符串
//                    cellvalue = cell.getRichStringCellValue().getString();
//                    break;
//                default:// 默认的Cell值
//                    cellvalue = "";
//            }
//        } else {
//            cellvalue = "";
//        }
//        return cellvalue;
//    }
//
//    /**
//     * 判断文件是否存在.
//     *
//     * @param fileDir 文件路径
//     * @return
//     */
//    public static boolean fileExist(String fileDir) {
//        boolean flag = false;
//        File file = new File(fileDir);
//        flag = file.exists();
//        return flag;
//    }
//
//    /**
//     * 判断文件的sheet是否存在.
//     *
//     * @param fileDir   文件路径
//     * @param sheetName 表格索引名
//     * @return
//     */
//    public static boolean sheetExist(String fileDir, String sheetName) throws Exception {
//        boolean flag = false;
//        File file = new File(fileDir);
//        if (file.exists()) {    //文件存在
//            //创建workbook
//            try {
//                workbook = new HSSFWorkbook(new FileInputStream(file));
//                //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
//                HSSFSheet sheet = workbook.getSheet(sheetName);
//                if (sheet != null)
//                    flag = true;
//            } catch (Exception e) {
//                throw e;
//            }
//
//        } else {    //文件不存在
//            flag = false;
//        }
//        return flag;
//    }
//
//    /**
//     * 创建新excel.
//     *
//     * @param fileDir   excel的路径
//     * @param sheetName 要创建的表格索引
//     * @param titleRow  excel的第一行即表格头
//     */
//    public static void createExcel(String fileDir, String sheetName, String titleRow[]) throws Exception {
//        //创建workbook
//        workbook = new HSSFWorkbook();
//        //添加Worksheet（不添加sheet时生成的xls文件打开时会报错)
//        HSSFSheet sheet1 = workbook.createSheet(sheetName);
//        //新建文件
//        FileOutputStream out = null;
//        try {
//            //添加表头
//            HSSFRow row = workbook.getSheet(sheetName).createRow(0);    //创建第一行
//            for (short i = 0; i < titleRow.length; i++) {
//                HSSFCell cell = row.createCell(i);
//                cell.setCellValue(titleRow[i]);
//            }
//            out = new FileOutputStream(fileDir);
//            workbook.write(out);
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 删除文件.
//     *
//     * @param fileDir 文件路径
//     */
//    public static boolean deleteExcel(String fileDir) {
//        boolean flag = false;
//        File file = new File(fileDir);
//        // 判断目录或文件是否存在
//        if (!file.exists()) {  // 不存在返回 false
//            return flag;
//        } else {
//            // 判断是否为文件
//            if (file.isFile()) {  // 为文件时调用删除文件方法
//                file.delete();
//                flag = true;
//            }
//        }
//        return flag;
//    }
//
//    /**
//     * 往excel中写入(已存在的数据无法写入).
//     *
//     * @param fileDir   文件路径
//     * @param sheetName 表格索引
//     * @throws Exception
//     */
//    public static void writeToExcel(String fileDir, String sheetName, List<Map> mapList) throws Exception {
//        //创建workbook
//        File file = new File(fileDir);
//        try {
//            workbook = new HSSFWorkbook(new FileInputStream(file));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //流
//        FileOutputStream out = null;
//        HSSFSheet sheet = workbook.getSheet(sheetName);
//        // 获取表格的总行数
//        // int rowCount = sheet.getLastRowNum() + 1; // 需要加一
//        // 获取表头的列数
//        int columnCount = sheet.getRow(0).getLastCellNum() + 1;
//        try {
//            // 获得表头行对象
//            HSSFRow titleRow = sheet.getRow(0);
//            if (titleRow != null) {
//                for (int rowId = 0; rowId < mapList.size(); rowId++) {
//                    Map map = mapList.get(rowId);
//                    HSSFRow newRow = sheet.createRow(rowId + 1);
//                    for (short columnIndex = 0; columnIndex < columnCount; columnIndex++) {  //遍历表头
//                        String mapKey = titleRow.getCell(columnIndex).toString().trim().toString().trim();
//                        HSSFCell cell = newRow.createCell(columnIndex);
//                        cell.setCellValue(map.get(mapKey) == null ? null : map.get(mapKey).toString());
//                    }
//                }
//            }
//
//            out = new FileOutputStream(fileDir);
//            workbook.write(out);
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
////        判断文件是否存在
//        System.out.println(fileExist("C:/Users/11075/Desktop/0912呼吸科统计数据(1).xlsx"));
//        //创建文件
//        String title[] = {"id", "name", "password"};
//        createExcel("E:/test2.xls", "sheet1", title);
//        List<Map> list = new ArrayList<Map>();
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("id", "111");
//        map.put("name", "张三");
//        map.put("password", "111！@#");
//
//        Map<String, String> map2 = new HashMap<String, String>();
//        map2.put("id", "222");
//        map2.put("name", "李四");
//        map2.put("password", "222！@#");
//        list.add(map);
//        list.add(map2);
//        writeToExcel("E:/test2.xls", "sheet1", list);
//
//        String sql = "select aaa,bbb,ccc from dddd";
//        String sqlForSplit = sql.substring(sql.toLowerCase().indexOf("select") + 6, sql.toLowerCase().indexOf("from")).trim();
//        String sqlRemoveFrom = sql.substring(sql.toLowerCase().indexOf("from") + 5).trim();
//        System.out.println(sqlRemoveFrom);
//        String tableName = sqlRemoveFrom.indexOf(" ") == -1 ? sqlRemoveFrom : sqlRemoveFrom.substring(0, sqlRemoveFrom.indexOf(" "));
//        System.out.println(tableName);
//
//
//    }
//}