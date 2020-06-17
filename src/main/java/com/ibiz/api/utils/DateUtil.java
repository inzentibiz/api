package com.ibiz.api.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    /**
     * @Method Name : convertToCalendar
     * @Method 설명 : 날짜 포맷 문자열(yyyyMMdd.yyyy-MM-dd,MM/dd/yyyy)를 입력받아 Calendar 개체로 변환한다.
     * @작성자 : 성범수
     * @Modification Information
     *
     *               <pre>
     *     수정일         수정자                   수정내용
     *     -------          --------        ---------------------------
     * </pre>
     * @param input
     * @return
     */
    public static Calendar convertToCalendar(String input) {
        String pattern1 = "^\\d{4}-\\d{2}-\\d{2}$";
        String pattern2 = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
        String pattern3 = "^\\d{8}$";
        if (input.matches(pattern1)) {
            return checkDate(input, "yyyy-MM-dd");
        }
        else if (input.matches(pattern2)) {
            return checkDate(input, "dd/MM/yyyy");
        }
        else if (input.matches(pattern3)) {
            return checkDate(input, "yyyyMMdd");
        }
        return null;
    }

    /**
     * @Method Name : checkDate
     * @Method 설명 : 지정된 문자열이 날짜 형식에 맞는지 체크
     * @작성자 : 성범수
     * @Modification Information
     *
     *               <pre>
     *     수정일         수정자                   수정내용
     *     -------          --------        ---------------------------
     * </pre>
     * @param value
     * @param format
     * @return
     */
    private static Calendar checkDate(String value, String format) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            cal.setTime(sdf.parse(value));
            return cal;
        }
        catch (Exception e) {
            return null;
        }
    }
}
