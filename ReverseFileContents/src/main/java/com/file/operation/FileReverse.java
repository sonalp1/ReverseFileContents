package com.file.operation;

import com.file.operation.util.FileValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;

public class FileReverse {

    private static final Logger logger = LogManager.getLogger(FileReverse.class);
    private static String outputFile="\\reversedOutput.txt";

    public  boolean createReversedFile(String fileName) {

        boolean reversed=false;

       if (validateInputFile(fileName))
           return reversed;

        Path path = Paths.get(fileName);

        StringBuilder reversedFileName=new StringBuilder(path.getParent().toString().concat(outputFile));
        Path reversedFile = Paths.get(reversedFileName.toString());



            try (BufferedWriter writer = Files.newBufferedWriter(reversedFile)) {
                List<String> lines = Files.readAllLines(path);

                 int numOfLines=lines.size();

                 if(numOfLines==1)
                 {
                 writer.write(StringUtils.reverse(lines.get(0)));
                 }
                 else {
                     writeMultiLineFile(writer, lines, numOfLines);
                 }

                writer.flush();
                reversed=true;
            }
       catch ( IOException ioe) {
            logger.error("Exception:"+ioe.getMessage());
            reversed=false;
        }
    return reversed;

    }

    private static boolean validateInputFile(String fileName) {
        if(FileValidator.emptyOrNullString(fileName)) {
            logger.error("File name provided is null or empty:");
            return true;
        }

        if(!FileValidator.fileSupported(fileName)) {
            logger.error("File extension not supported");
            return true;
        }

        if(FileValidator.emptyOrNullFile(fileName)) {
            logger.error("File is missing or empty");
            return true;
        }
        return false;
    }

    private  void writeMultiLineFile(BufferedWriter writer, List<String> lines, int numOfLines) throws IOException {
        ListIterator<String> lineIterator = lines.listIterator(numOfLines);

        while (lineIterator.hasPrevious()) {
            writer.write(lineIterator.previous().concat("\n"));

        }
    }
}
