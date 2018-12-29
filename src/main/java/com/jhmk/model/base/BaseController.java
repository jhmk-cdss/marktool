package com.jhmk.model.base;


import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BaseController {

    public void wirte(HttpServletResponse response, Object obj) {
        response.setCharacterEncoding("utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(JSON.toJSON(obj));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}