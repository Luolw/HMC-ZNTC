package com.hmc.zntc.admin.utils;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalUtil {
    /**
     * 加法
     */
    public static BigDecimal add(BigDecimal b1, BigDecimal b2){
        return b1.add(b2, MathContext.DECIMAL128);
    }

    /**
     * 减法
     */
    public static BigDecimal subtract(BigDecimal b1, BigDecimal b2){
        return b1.subtract(b2, MathContext.DECIMAL128);
    }

    /**
     * 乘法
     */
    public static BigDecimal multiply(BigDecimal b1, BigDecimal b2){
        return b1.multiply(b2, MathContext.DECIMAL128);
    }

    /**
     * 除法
     */
    public static BigDecimal divide(BigDecimal b1, BigDecimal b2){
        return b1.divide(b2, MathContext.DECIMAL128);
    }
}
