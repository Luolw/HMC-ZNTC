package com.hmc.zntc.user.utils;

import com.alibaba.fastjson.parser.JSONScanner;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class TypeUtil {
    public TypeUtil() {
    }

    public static String castToString(Object value) {
        return value == null ? null : value.toString();
    }

    public static Byte castToByte(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Number) {
            return ((Number)value).byteValue();
        } else if (value instanceof String) {
            String strVal = (String)value;
            return strVal.length() != 0 && !"null".equals(strVal) && !"NULL".equals(strVal) ? Byte.parseByte(strVal) : null;
        } else {
            throw new RuntimeException("can not cast to byte, value : " + value);
        }
    }

    public static Character castToChar(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Character) {
            return (Character)value;
        } else if (value instanceof String) {
            String strVal = (String)value;
            if (strVal.length() == 0) {
                return null;
            } else if (strVal.length() != 1) {
                throw new RuntimeException("can not cast to char, value : " + value);
            } else {
                return strVal.charAt(0);
            }
        } else {
            throw new RuntimeException("can not cast to char, value : " + value);
        }
    }

    public static Short castToShort(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Number) {
            return ((Number)value).shortValue();
        } else if (value instanceof String) {
            String strVal = (String)value;
            return strVal.length() != 0 && !"null".equals(strVal) && !"NULL".equals(strVal) ? Short.parseShort(strVal) : null;
        } else {
            throw new RuntimeException("can not cast to short, value : " + value);
        }
    }

    public static BigDecimal castToBigDecimal(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof BigDecimal) {
            return (BigDecimal)value;
        } else if (value instanceof BigInteger) {
            return new BigDecimal((BigInteger)value);
        } else {
            String strVal = value.toString();
            return strVal.length() == 0 ? null : new BigDecimal(strVal);
        }
    }

    public static BigInteger castToBigInteger(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof BigInteger) {
            return (BigInteger)value;
        } else if (!(value instanceof Float) && !(value instanceof Double)) {
            String strVal = value.toString();
            return strVal.length() != 0 && !"null".equals(strVal) && !"NULL".equals(strVal) ? new BigInteger(strVal) : null;
        } else {
            return BigInteger.valueOf(((Number)value).longValue());
        }
    }

    public static Float castToFloat(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Number) {
            return ((Number)value).floatValue();
        } else if (value instanceof String) {
            String strVal = value.toString();
            if (strVal.length() != 0 && !"null".equals(strVal) && !"NULL".equals(strVal)) {
                if (strVal.indexOf(44) != 0) {
                    strVal = strVal.replaceAll(",", "");
                }

                return Float.parseFloat(strVal);
            } else {
                return null;
            }
        } else {
            throw new RuntimeException("can not cast to float, value : " + value);
        }
    }

    public static Double castToDouble(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Number) {
            return ((Number)value).doubleValue();
        } else if (value instanceof String) {
            String strVal = value.toString();
            if (strVal.length() != 0 && !"null".equals(strVal) && !"NULL".equals(strVal)) {
                if (strVal.indexOf(44) != 0) {
                    strVal = strVal.replaceAll(",", "");
                }

                return Double.parseDouble(strVal);
            } else {
                return null;
            }
        } else {
            throw new RuntimeException("can not cast to double, value : " + value);
        }
    }

    public static Timestamp castToTimestamp(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Calendar) {
            return new Timestamp(((Calendar)value).getTimeInMillis());
        } else if (value instanceof Timestamp) {
            return (Timestamp)value;
        } else if (value instanceof Date) {
            return new Timestamp(((Date)value).getTime());
        } else {
            long longValue = 0L;
            if (value instanceof Number) {
                longValue = ((Number)value).longValue();
            }

            if (value instanceof String) {
                String strVal = (String)value;
                if (strVal.length() == 0 || "null".equals(strVal) || "NULL".equals(strVal)) {
                    return null;
                }

                longValue = Long.parseLong(strVal);
            }

            if (longValue <= 0L) {
                throw new RuntimeException("can not cast to Date, value : " + value);
            } else {
                return new Timestamp(longValue);
            }
        }
    }

    public static Long castToLong(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Number) {
            return ((Number)value).longValue();
        } else {
            if (value instanceof String) {
                String strVal = (String)value;
                if (strVal.length() == 0 || "null".equals(strVal) || "NULL".equals(strVal)) {
                    return null;
                }

                if (strVal.indexOf(44) != 0) {
                    strVal = strVal.replaceAll(",", "");
                }

                try {
                    return Long.parseLong(strVal);
                } catch (NumberFormatException var4) {
                    JSONScanner dateParser = new JSONScanner(strVal);
                    Calendar calendar = null;
                    if (dateParser.scanISO8601DateIfMatch(false)) {
                        calendar = dateParser.getCalendar();
                    }

                    dateParser.close();
                    if (calendar != null) {
                        return calendar.getTimeInMillis();
                    }
                }
            }

            throw new RuntimeException("can not cast to long, value : " + value);
        }
    }

    public static Integer castToInt(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Integer) {
            return (Integer)value;
        } else if (value instanceof Number) {
            return ((Number)value).intValue();
        } else if (value instanceof String) {
            String strVal = (String)value;
            if (strVal.length() != 0 && !"null".equals(strVal) && !"NULL".equals(strVal)) {
                if (strVal.indexOf(44) != 0) {
                    strVal = strVal.replaceAll(",", "");
                }

                return Integer.parseInt(strVal);
            } else {
                return null;
            }
        } else if (value instanceof Boolean) {
            return (Boolean)value ? 1 : 0;
        } else {
            throw new RuntimeException("can not cast to int, value : " + value);
        }
    }

    public static byte[] castToBytes(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof byte[]) {
            return (byte[])((byte[])value);
        } else if (value instanceof String) {
            return value.toString().getBytes();
        } else {
            throw new RuntimeException("can not cast to int, value : " + value);
        }
    }

    public static Boolean castToBoolean(Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Boolean) {
            return (Boolean)value;
        } else if (value instanceof Number) {
            return ((Number)value).intValue() == 1;
        } else {
            if (value instanceof String) {
                String strVal = (String)value;
                if (strVal.length() == 0 || "null".equals(strVal) || "NULL".equals(strVal)) {
                    return null;
                }

                if ("true".equalsIgnoreCase(strVal) || "1".equals(strVal)) {
                    return Boolean.TRUE;
                }

                if ("false".equalsIgnoreCase(strVal) || "0".equals(strVal)) {
                    return Boolean.FALSE;
                }
            }

            throw new RuntimeException("can not cast to boolean, value : " + value);
        }
    }
}

