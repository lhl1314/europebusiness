package com.ouqicha.europebusiness.exception;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;import com.google.common.collect.Maps;
import com.ouqicha.europebusiness.bean.vo.ResponseData;

//格式化返回客户端数据格式（json）
public class ReturnFormat {
    private static Map<String,String>messageMap = Maps.newHashMap();
    //初始化状态码与文字说明
    static {
        messageMap.put("0", "");

        messageMap.put("400", "Bad Request!");
        messageMap.put("401", "NotAuthorization");
        messageMap.put("405", "Method Not Allowed");
        messageMap.put("406", "Not Acceptable");
        messageMap.put("500", "Internal Server Error");

        messageMap.put("1000", "[服务器]运行时异常");
        messageMap.put("1001", "[服务器]空值异常");
        messageMap.put("1002", "[服务器]数据类型转换异常");
        messageMap.put("1003", "[服务器]IO异常");
        messageMap.put("1004", "[服务器]未知方法异常");
        messageMap.put("1005", "[服务器]数组越界异常");
        messageMap.put("1006", "[服务器]网络异常");

        messageMap.put("1010", "用户未注册");
        messageMap.put("1011", "用户已注册");
        messageMap.put("1012", "用户名或密码错误");
        messageMap.put("1013", "用户帐号冻结");
        messageMap.put("1014", "用户信息编辑失败");
        messageMap.put("1015", "用户信息失效，请重新获取");
        messageMap.put("1016", "没有权限");

        messageMap.put("1020", "验证码发送失败");
        messageMap.put("1021", "验证码失效");
        messageMap.put("1022", "验证码错误");
        messageMap.put("1023", "验证码不可用");
        messageMap.put("1029", "短信平台异常");

        messageMap.put("1030", "周边无店铺");
        messageMap.put("1031", "店铺添加失败");
        messageMap.put("1032", "编辑店铺信息失败");
        messageMap.put("1033", "每个用户只能添加一个商铺");
        messageMap.put("1034", "店铺不存在");

        messageMap.put("1040", "无浏览商品");
        messageMap.put("1041", "添加失败,商品种类超出上限");
        messageMap.put("1042", "商品不存在");
        messageMap.put("1043", "商品删除失败");

        messageMap.put("2010", "缺少参数或值为空");

        messageMap.put("2029", "参数不合法");
        messageMap.put("2020", "无效的Token");
        messageMap.put("2021", "无操作权限");
        messageMap.put("2022", "RSA解密失败,密文数据已损坏");
        messageMap.put("2023", "请重新登录");
    }
    public static ResponseData retParam(int status,Object data) {
        ResponseData responseData = new ResponseData(data, status, messageMap.get(String.valueOf(status)));
        return responseData;
    }
}
