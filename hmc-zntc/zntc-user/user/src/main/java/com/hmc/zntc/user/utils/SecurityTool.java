package com.hmc.zntc.user.utils;

public class SecurityTool {

    private SecurityTool()
    {
    }

    private static String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";

    /**
     *
     * @Description	判断字符是否安全.
     * @author  LinApex@163.com
     * @date    2013-11-29 下午5:06:01
     * @version 1
     * @param str
     * @return 	boolean
     */
    public static boolean isSecurity(String str)
    {
        String inj_stra[] = inj_str.split("\\|");
        for (int i = 0; i < inj_stra.length; i++)
        {
            if (str.indexOf(inj_stra[i]) >= 0)
            {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @Description 替换掉不安全的字符.
     * @author  LinApex@163.com
     * @date    2013-11-29 下午5:06:08
     * @version 1
     * @param str
     * @return 	String
     */
    public static String replaceNoSecurityStr(String str)
    {
        String result = "";
        if (str != null && str.length() > 0)
        {
            String inj_stra[] = inj_str.split("\\|");
            for (int i = 0; i < inj_stra.length; i++)
            {
                if (str.indexOf(inj_stra[i]) >= 0)
                {
                    str = str.replace(inj_stra[i], "");
                }
            }
            result = str;
        }
        return result;
    }

}
