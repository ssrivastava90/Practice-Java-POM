package com.gojek.test;

import com.gojek.test.helpers.HttpMethodUtils;
import com.gojek.test.helpers.WebResponseHelper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class UrlComparisonExecutor {

  //Creating thread pool
  ExecutorService threadPool = Executors.newFixedThreadPool(5);

  int currentInProgres = 0;

  private void incrementProgress(){
    synchronized (UrlComparisonExecutor.class) {
      currentInProgres++;
    }
  }

  private void decrementProgress(){
    synchronized (UrlComparisonExecutor.class) {
      currentInProgres--;
    }
  }

  public void submitTask(UrlCompare urlCompare){
    while (!isThreadPoolFree()) {

      try {
        System.out.println("Threads busy sleeping...");
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
    threadPool.submit(urlCompare);

  }

  public void shutDown(){
    threadPool.shutdown();
  }

  private boolean isThreadPoolFree(){
    synchronized (UrlComparisonExecutor.class){
      if (currentInProgres < 5){
        return true;
      }
      return false;
    }
  }

  public class UrlCompare implements Runnable {

    private String url1;
    private String url2;

    public UrlCompare(String url1, String url2){
      this.url1 = url1;
      this.url2 = url2;
    }

    public void run() {
      try {
        incrementProgress();

        WebResponse webResponse1 = HttpMethodUtils.get(url1);
        WebResponse webResponse2 = HttpMethodUtils.get(url2);

        //Check both response code are 200
        if ((webResponse1.getResponseCode() != 200) || (webResponse2.getResponseCode()
            != 200)) {
          System.out.println(url1 + " not equals " + url2);
        } else {
          //Checking both are JSON Responses
          if (webResponse1.getResponseType().contains("json") && (webResponse2
              .getResponseType().contains("json"))) {
            WebResponseHelper.checkJson(webResponse1, webResponse2, url1, url2);
          }
          // Check for XML
          else if (webResponse1.getResponseType().contains("xml") && (webResponse2
              .getResponseType().contains("xml"))) {
            WebResponseHelper.checkXml(webResponse1, webResponse2, url1, url2);
          }
          // if one is Xml and other is Json
          else {
            System.out.println("[Thread]" + Thread.currentThread().getName() + ", " + url1 + " not equals " + url2);
          }
        }


      } catch(Exception e){
        System.out.println(e.getMessage());
        //Continue with next url set.
      } finally {
        decrementProgress();
      }
    }
  }

}
