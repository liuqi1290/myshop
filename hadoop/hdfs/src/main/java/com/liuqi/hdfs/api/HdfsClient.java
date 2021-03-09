package com.liuqi.hdfs.api;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.aspectj.lang.annotation.Before;

;import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @auther liuqi
 * @create 2021-01-21  14:47
 */


public class HdfsClient {
    private static final String HDFS_PATH="hdfs://server1:9000";
    FileSystem fileSystem=null;
    Configuration configuration=null;


    public void init() throws Exception {
         configuration=new Configuration();
         fileSystem=FileSystem.get(new URI(HDFS_PATH), configuration, "root");
    }

    public void create() throws Exception {
        this.init();
        FSDataOutputStream outputStream=fileSystem.create(new Path("/text.txt"));
        outputStream.write("ceshiuixin".getBytes());
        outputStream.flush();
        outputStream.close();
    }

}
