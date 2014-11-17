package com.zhirunjia.housekeeper.Utils;

/**
 * 正则表达式验证
 * Created by Xu wenQiang on 2014/4/4.
 */
public class RegexUtils {

    /**
     * 检查 email输入是否正确
     * 正确的书写格 式为 username@domain
     *
     * @param value
     * @return
     */
    public static boolean checkEmail(String value, int length) {
        return value.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*") && value.length() <= length;
    }

    /**
     * 检查电话输入 是否正确
     * 正确格 式 012-87654321、0123-87654321、0123-7654321
     *
     * @param value
     * @return
     */
    public static boolean checkTel(String value) {
        return value.matches("\\d{4}-\\d{8}|\\d{4}-\\d{7}|\\d(3)-\\d(8)");
    }

    /**
     * 检查手机输入 是否正确
     *
     * @param value
     * @return
     */
    public static boolean checkMobile(String value) {
        return value.matches("^[1][3,4,5,7,8]+\\d{9}");
    }

    /**
     * 检查中文名输 入是否正确
     *
     * @param value
     * @return
     */
    public static boolean checkChineseName(String value, int length) {
        return value.matches("^[\u4e00-\u9fa5]+$") && value.length() <= length;
    }

    /**
     * 检查HTML 中首尾空行或空格
     *
     * @param value
     * @return
     */
    public static boolean checkBlank(String value) {
        return value.matches("^\\s*|\\s*$");
    }

    /**
     * 检查字符串是 否含有HTML标签
     *
     * @param value
     * @return
     */

    public static boolean checkHtmlTag(String value) {
        return value.matches("<(\\S*?)[^>]*>.*?</\\1>|<.*? />");
    }

    /**
     * 检查URL是 否合法
     *
     * @param value
     * @return
     */
    public static boolean checkURL(String value) {
        return value.matches("[a-zA-z]+://[^\\s]*");
    }

    /**
     * 检查IP是否 合法
     *
     * @param value
     * @return
     */
    public static boolean checkIP(String value) {
        return value.matches("\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}+\\.\\d{1,3}");
    }

    /**
     * 检查ID是否 合法，开头必须是大小写字母，其他位可以有大小写字符、数字、下划线
     *
     * @param value
     * @return
     */
    public static boolean checkID(String value) {
        return value.matches("[a-zA-Z][a-zA-Z0-9_]{4,15}$");
    }

    /**
     * 检查QQ是否 合法，必须是数字，且首位不能为0，最长15位
     *
     * @param value
     * @return
     */

    public static boolean checkQQ(String value) {
        return value.matches("[1-9][0-9]{4,13}");
    }

    /**
     * 检查邮编是否 合法
     *
     * @param value
     * @return
     */
    public static boolean checkPostCode(String value) {
        return value.matches("[1-9]\\d{5}(?!\\d)");
    }

    /**
     * 检查身份证是 否合法,15位或18位
     *
     * @param value
     * @return
     */
    public static boolean checkIDCard(String value) {
        return value.matches("\\d{15}|\\d{18}");
    }

    /**
     * 检查输入是否 超出规定长度
     *
     * @param length
     * @param value
     * @return
     */
    public static boolean checkLength(String value, int length) {
        return ((value == null || "".equals(value.trim())) ? 0 : value.length()) <= length;
    }

    /**
     * 检查是否为空 字符串,空：true,不空:false
     *
     * @param value
     * @return
     */
    public static boolean checkNull(String value) {
        return value == null || "".equals(value.trim());
    }

    /**
     * 用于匹配多个数字之间用逗号分隔，且第一个和最后一个字符必须是数字。
     * 正确的书写格 式为 123,123
     *
     * @param value
     * @return
     */
    public static boolean checkDigitalAndComma(String value) {
        return value.matches("\\d+((,|，)\\d+)*");

    }
    /**
     * 用于匹配多个小数之间用逗号分隔
     * 正确的书写格 式为 123,123 | 123.00，123.05
     *
     * @param value
     * @return
     */
    public static boolean checkDigitalAndFloat(String value) {
        return value.matches("^(\\d+(.[0-9]{0,2}))+((,|，)\\d+(.[0-9]{0,2}))*");
    }

    /**
     * 验证取货码格式
     * 正确格式为六位纯数字
     *
     * @param value
     * @return boolean
     */
    public static boolean checkCaptcha(String value){
        return value.matches("^\\d\\d{4}\\d$");
    }

    /**
     * 验证密码
     * 只能包含大小写字母和数字
     *
     * @param value
     * @return Boolean
     */
    public static boolean checkPwd(String value){
        return value.matches("^[A-Za-z0-9]{6,18}$");
    }

    /**
     * 验证站点编号
     *
     * @param value
     * @return Boolean
     */
    public static boolean checkStationNumber(String value){
        return value.matches("^[A-Za-z0-9]{4,16}$");
    }

    /**
     * 验证员工编号
     *
     * @param value
     * @return Boolean
     */
    public static boolean checkEmployeeNumber(String value){
        return value.matches("^[A-Za-z0-9]{4,16}$");
    }

    /**
     * 验证运单号
     *
     * @param value
     * @return Boolean
     */
    public static boolean checkWaybillNo(String value){
        return value.matches("^[A-Za-z0-9]{6,18}$");
    }

}
