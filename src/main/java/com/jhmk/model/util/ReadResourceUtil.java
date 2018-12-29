package com.jhmk.model.util;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ziyu.zhou
 * @date 2018/8/14 15:24
 */

public class ReadResourceUtil {
    public static Set<String> getStrListByFileNmae(String name) {
        ClassPathResource resource = new ClassPathResource(name);
        Set<String> nodeList = new LinkedHashSet<>();
        BufferedReader br = null;
        try {
            File medicineFile = resource.getFile();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(medicineFile)));
            String line = null;
            while ((line = br.readLine()) != null) {
                nodeList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodeList;
    }
}
