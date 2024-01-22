    package study2023.helpers;
    
    
    public class ResourceHelper
    {
      public static String getResourcePath(String path) {
       String basePath = System.getProperty("user.dir");
       System.out.println(String.valueOf(basePath) + path);
       return String.valueOf(basePath) + path;
      }
    }



 