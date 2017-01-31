package com.qalights.utils;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by brit on 1/22/17.
 */
public class CSVUtils {
    private CSVReader csvReader;

    public CSVUtils(String fileName){
        try {
            csvReader = new CSVReader(new FileReader(CSVUtils.class.getClassLoader().getResource(fileName).getPath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> readAllLines(){
        try {
            return csvReader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String... args){
      CSVUtils csvUtils = new CSVUtils("data.csv");

    }
}
