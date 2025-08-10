package com.as.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Slf4j
public class FileServices {

    public static String readFileToString(String filePath) throws Exception {
        log.info("FilePath is : " + filePath);
        return FileUtils.readFileToString(new File(filePath));
    }

    public static JSONObject readJsonIntoObject(String filePath) {
        JSONObject jsonObject = null;
        JSONParser parser = new JSONParser();
        try {
            jsonObject = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public JSONObject readJsonKeyToJSONObject(String filePath, String testCaseName) {
        JSONObject inputObject = FileServices.readJsonIntoObject(filePath);
        return (JSONObject) inputObject.get(testCaseName);
    }

}
