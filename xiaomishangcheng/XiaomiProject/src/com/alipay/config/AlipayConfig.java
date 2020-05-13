package com.alipay.config;
/**
 * @Description:
 * @param
 * @return
 * @Author Zangdy
 * @CreateTime 2020/4/24 0:16
 */
public class AlipayConfig {
	// 商户appid
	public static String APPID = "2016101600696917";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC0MbX9CYimUUEGvgUGckzxRy5yE9G2AVyFA3CadPJUkMX+1yP+SVr9/fWxyOE7IsgDtukcUGbgu3+e6fqLzuoEn/s4benkO4LqLWgW7cPj40+qpPXbi5EL5whKvJIR0IjonMHsXfJk9nbh6zoL07y6EiQ5KeGgrLdI2qD56k3zb/6uV4f6n3SJz4D0GzR1DV3LAGnlNnmrP3khT7V9owVg55ZocnvNiQpGqZHgI/GrCYJ5Sg6hBnBLG7QX5G4nw3BP7uVSyvhf1WUL8y4vVsxu4yJEgXngcR9Z3LCLi3eSotiAGecP82j6XmJ5XHOZ0bZ+wlynm+Xd8yNHRFVTtqzNAgMBAAECggEAbNKUwNMwJplttv+tEz6WPySo5RYZEVzzHhV8vJsh+nZQTN5rC1gLzta/ufXCKC+SMcQWNhZMey5hHXza5fI5HD/tvR+MIFzcbEat1SMUqZ0O8NSc8lDwcQq+1Dvbz0xsUmbRKsl16Ql7tGaV8KyYDpuEKs2jSKDmM+ZtT2D0YK5fzHgZwSvTHz1pTXM2Tr5dLoG7/wIopzBsgWlCoSEKGBcnTOmDSt0loGcDvAHnjI9KhGBsP9CR9JKgE7lyPFKyzVbeyazfEz/OzsKKFJxpiCQ7MxYv6kI8wHM37HgCB1nWJ6DbVhOkWtO/x1I2kRlNK4S9eouu/r06IuhpuvWn9QKBgQDdRP7nGMdhq5PpIbuZVOfeBXZjYQRH4T2Om+SagYTq9vlZkv8mh0KEbf/EYrwofGCKnZt2pS80E+LlwWwCOv1GVXyPwVE1/M7qtrNxxy6OpNilw4r8opcRyOQEhrSq3mZbtbTb+sFhAOeF2ovQglUaBchINangRj6sW/Myn3tQnwKBgQDQejwpNu2Gwz6Y4iig/g4s+yj5pYZq4Wviczf+kWweoviSMvRJK5kpixgOgBeNYBwI51Z+k1tLoNKKoLAtOZBCGp72kW67nSyPwGjpq2PA0oj69YWEjdq7aSrCIPnDSMHS1sFPhZ4BpUm/4DNpa5yF4Xgfj9b8/mj7ng1diq2vEwKBgEB//E4hSv2NpnAvBSCNP4nYzcnqXfUWE3ueteTUHIrhs44I65evlhREfGoi3fZvSzUc/FR5kmj74whWecWsrGf0Q3skPygdqbOBzo08IrYyF3U6qyk5vA/TH6SyH7gvXGcfcLkvP2+nc9Xw/xCo7WXIibmC6yIVV++mXh5Dnw7BAoGBAImG6WMC4iRRblzqbITvs6hGs1wkroyZUlMbUOf1RM7dEX9Yb8BJK4u1P1RpeaAAs93Hxk5PpR055UogALiEzb5d01myzMqlP71A37SuJGsSN9zd1IuCDLYvBU708+64c2xD0VhFO9u4DvOt0hyMKcBD4btoZxmUNust84Eut67TAoGBALt4afXeRLBOHZyK19W+OBbd21xbEjyE8IqVKFplDjaBB9JTXbfHv3Pqgx6SxVVz+DUGGUifsqk67ufTewtQLBPy9A6iNYav+IdBAKN2ewbNbRzN4IACu7pTck2MvVNiRVuRM2LzQUx+WAY/KB871BIFRLJjkqN7lEqUSq9c3qax";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/XiaomiProject/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://localhost:8080/XiaomiProject/return_url.jsp";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAio2wYdufP5KueW+v/72793nV8nQRy8Goo5GC3XMmHzsy92Nw1mhBsaVVnKuVhRGkUVwgbb28Uz/eom4PYLFoWsWeGZhsfVthF8dFA6uYgvJ3EouBH8qRQ+hAmSV0TFvOD5Uak4pdl/JGunmf0Id8v9FGHuaAa/fYuLKGkTKMzpVrpswy1WGS2fl9cWk+4MXEZQJZRNxF2/X2oxy7QCs4bj/28Pzi+zMTfy17b/9ZgSVlHZwA4GnFs4ovZRdDbOObqjtEGFu00Qcf28JFmDeiwoWUidWtUwUAMvL3a1LIW9A/x5Zmu4dC2KOTJ4raSEey8XD8tSBjyf/kK3/AnFuidQIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
