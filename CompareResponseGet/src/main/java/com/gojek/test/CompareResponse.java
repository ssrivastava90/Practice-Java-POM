package com.gojek.test;

import com.gojek.test.UrlComparisonExecutor.UrlCompare;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareResponse {

    private File file1;
    private File file2;
    private FileInputStream fileToRead1;
    private FileInputStream fileToRead2;

    public void compareUrlResponse(String fileRead1,String fileRead2) throws IOException {

        this.file1 = new File(fileRead1);
        this.file2 = new File(fileRead2);

        fileToRead1 = new FileInputStream(file1);
        fileToRead2 = new FileInputStream(file2);

        //Initialzing two readers
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileToRead1));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(fileToRead2));
        String url1, url2;

        //Initialize POol
        UrlComparisonExecutor urlComparisonExecutor = new UrlComparisonExecutor();

        //For each url in both file, get the response and match
        while (reader1.ready() && reader2.ready()) {
            url1 = reader1.readLine();
            url2 = reader2.readLine();

            try {
                UrlCompare urlCompare =  urlComparisonExecutor.new UrlCompare(url1, url2);
                urlComparisonExecutor.submitTask(urlCompare);
            } catch(Exception e){
                System.out.println(e.getMessage());
                //Continue with next url set.
            }

        }
        // Closing readers
        reader1.close();
        reader2.close();
        urlComparisonExecutor.shutDown();
    }



}
