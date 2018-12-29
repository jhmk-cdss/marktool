package com.jhmk.model.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ziyu.zhou
 * @date 2018/7/27 11:44
 */

public class StringUtil {

    /**
     * 获取汉字串拼音首字母，英文字符不变
     *
     * @param chinese 汉字串
     * @return 汉语拼音首字母
     */
    public static String getFirstSpell(String chinese) {
        StringBuffer pybf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (temp != null) {
                        pybf.append(temp[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pybf.append(arr[i]);
            }
        }
        return pybf.toString().replaceAll("\\W", "").trim();
    }

    public static String getUppercaseFirstSpell(String chinese) {
        StringBuffer pybf = new StringBuffer();
        char[] arr = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (temp != null) {
                        pybf.append(temp[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pybf.append(arr[i]);
            }
        }
        return pybf.toString().replaceAll("\\W", "").trim();
    }

    /**
     * 判断是否是汉字
     *
     * @param str
     * @return
     */
    public static boolean isChinese(String str) {
        String regEx = "[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regEx);
        Matcher matcher = pat.matcher(str);
        boolean flg = false;
        if (matcher.find()) {
            flg = true;
        }

        return flg;
    }

    //判断是否为数字
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static boolean isNumber(String str) {
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }

    public static void main(String[] args) {
        boolean integer = isNumber("1110.22");
        System.out.println(integer);
    }

    /**
     * 将英文()括号改为中文（）
     *
     * @param data
     * @return
     */
    public static String stringTransform(String data) {
        String s2 = null;
        if (StringUtils.isNotBlank(data)) {
            s2 = data.replaceAll("\\(", "（").replaceAll("\\)", "）");
        }
        return s2;
    }

    /**
     * oracle  blob转str
     *
     * @param blob
     * @return
     */
//    public static String ConvertBLOBtoString(Blob blob) {
//        long BlobLength; // BLOB字段长度
//        byte[] bytes; // BLOB临时存储字节数组
//        int i = 1; // 循环变量
//        String newStr = ""; // 返回字符串
//        try {
//            bytes = blob.getBytes((long) 1, (int) blob.length());
//
//            BlobLength = blob.length();  //获取BLOB长度
//            if (bytes == null || BlobLength == 0)  //如果为空，返回空值
//            {
//                return "";
//            } else {
//                while (i < BlobLength)             //循环处理字符串转换，每次1024；Oracle字符串限制最大4k
//                {
//                    bytes = blob.getBytes(i, 1024);
//                    i = i + 1024;
////                    newStr = newStr + new String(bytes, "gb2312");
//                    newStr = newStr + new String(bytes, "gbk");
//                }
//            }
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        }
//        return newStr;
//    }
    public static String getETLBlobToString(Blob blob, long blwsContentCount, String path, String charset) throws SQLException, IOException {
        String value = null;
        InputStream is = blob.getBinaryStream();
        int length = (int) blob.length();
        if (length != 0) {
            byte[] buffer = new byte[length];
            is.read(buffer);
            is.close();
//    String uuid = UUID.randomUUID().toString();
//    uuid = cleaningStringByETL(uuid);
//    path = path +  uuid + blwsContentCount + ".txt";
//    File file = new File(path);
//    if (file.exists()) {
//       file.delete();
//    }
//    FileOutputStream fo = new FileOutputStream(file); //数据到的文件名
//    fo.write(buffer);
//    fo.close();
//
            // value = FileUtils.getStrFromFile(path,charset);
//    file.delete();
            value = new String(buffer, charset);
        } else {
            value = "";
        }

        return value;
    }

    public static String str2JsonStr(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        String result = str.replaceAll("\\('", "{\"").replaceAll("\\)", "}").replaceAll("',", "\":").trim();
        return result;
    }
}
