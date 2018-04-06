package com.winermin.jarslink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * jar version管理，模块化jar版本发生变更时读取新的版本
 * Created by liumin on 2018/4/6.
 */
public class JarVersion {

    private  Map<String,String> version2Map=new HashMap<>();

    private  File versionFile=new File("/Users/liumin/IdeaProjects/JarsLinkDemo/JarApi/src/main/resources/version.config");

    private static JarVersion jarVersion=new JarVersion();

    private volatile long lastModified=0;

    private JarVersion(){
        readVersion();
    }

    public static JarVersion getJarVersion(){
        return jarVersion;
    }

    private void readVersion(){
        if(lastModified!=versionFile.lastModified()){
            synchronized (version2Map){
                if(lastModified==versionFile.lastModified()){
                    return;
                }
                lastModified=versionFile.lastModified();
                StringBuilder result = new StringBuilder();
                try(BufferedReader br= new BufferedReader(new FileReader(versionFile))){
                    String s = null;
                    while((s = br.readLine())!=null){
                        result.append(System.lineSeparator()+s);
                       String[] array= s.split("=");
                        version2Map.put(array[0],array[1]);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }
    }

    public  String getVersion(String key){
        readVersion();
        return version2Map.get(key);
    }







}
