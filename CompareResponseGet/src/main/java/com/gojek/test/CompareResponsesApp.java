package com.gojek.test;

import java.io.IOException;

public class CompareResponsesApp {


    public static void main(String args[]) throws IOException {

        final String file1 = "/Users/sasthana/Downloads/CompareResponseGet/src/main/resources/urlFile1.txt";
        final String file2 = "/Users/sasthana/Downloads/CompareResponseGet/src/main/resources/urlFile2.txt";

        CompareResponse compareResponse = new CompareResponse();
        compareResponse.compareUrlResponse(file1, file2);


    }
}
