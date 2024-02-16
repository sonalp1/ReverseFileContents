package com.file.operation.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.FileNameMap;
import java.nio.file.Path;

public class FileValidator {

    public static boolean emptyOrNullFile(String filePath)
    {

        return StringUtils.isNotEmpty(filePath)?new File(filePath).length()==0:true;

    }
    public static boolean fileSupported(String fileName)
    {
    String extension=null;

    boolean isSupported=false;

        if(StringUtils.isNotEmpty(fileName))
        {
            int dotIndex=fileName.lastIndexOf('.');
            extension= dotIndex>0?fileName.substring(dotIndex+1):null;

        }
    if(StringUtils.isNotBlank(extension) && extension.equalsIgnoreCase("txt"))
            isSupported=true;

    return isSupported;
    }

    public static boolean emptyOrNullString(String name)
    {
        return StringUtils.isEmpty(name);

    }



}
