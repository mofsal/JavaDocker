package com.ibm.mofsal;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

public class SimpleSparkApplication {
	
	public static final String FILE_NAME = "./SampleFile.txt";
	public static final String APP_NAME = "Java Spark basic example";
	public static SparkSession spark;
	
	public static long countLines() {
		spark = SparkSession.builder()
				.appName(APP_NAME)
				.config("spark.master", "local")
				.getOrCreate();

        Dataset<String> logData = spark.read().textFile(FILE_NAME).cache();
        long count = logData.count();
        
        System.out.println("Lines in " + FILE_NAME + ": " + count);
        spark.stop();

        return count;
	}
    public static long countLinesWithAs() {
    	spark = SparkSession.builder()
				.appName(APP_NAME)
				.config("spark.master", "local")
				.getOrCreate();
    	
        Dataset<String> logData = spark.read().textFile(FILE_NAME).cache();
        long numAs = logData.filter(s -> s.contains("a")).count();

        System.out.println("Lines in " + FILE_NAME + " containing 'a': " + numAs);
        spark.stop();
        
        return numAs;
    }
    
    public static void main(String[] args) {
    	countLines();
    	countLinesWithAs();
    }
}
