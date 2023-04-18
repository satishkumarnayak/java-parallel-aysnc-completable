package com.instanceofcake.parallelstreams;

import static com.instanceofcake.util.CommonUtil.delay;
import java.util.List;
import java.util.stream.Collectors;
import com.instanceofcake.util.CommonUtil;
import com.instanceofcake.util.DataSet;
import static com.instanceofcake.util.LoggerUtil.log;

public class ParallelStreamsExample {

  public static void main(String[] args) {
    
    List<String> names = DataSet.namesList();
    
   CommonUtil.startTimer();
    List<String> result = names
           .parallelStream()
         //.stream()
         .map(name -> addNameLengthTransform(name))
         .collect(Collectors.toList());
    
    log("result:"+result);
    CommonUtil.timeTaken();
  }


  private static String addNameLengthTransform(String name) {
    delay(500);
    return name.length() + " - " + name;
  }
}
