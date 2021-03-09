package com.liuqi.rabbit.producer.autoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sun.security.krb5.internal.ccache.FileCredentialsCache;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 自动装配
 */
@Configuration
@ComponentScan("com.liuqi.rabbit.producer.*")
public class RabbitProducerAutoConfiguration {
}
