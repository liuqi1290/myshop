package com.liuqi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    //    http://localhost:8088/swagger-ui.html     原路径   springfox  自带ui
//       http://localhost:8088/doc.html     原路径

    @Bean
    public Docket creatRestApi() {
       return new Docket(DocumentationType.SWAGGER_2)// 指定api类型为swagger2
                .apiInfo(apiInfo())// 用于定义api文档汇总信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liuqi.controller"))// 指定controller包
                .paths(PathSelectors.any())// 所有controller
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("我的商城Api文档")
                .contact(new Contact("liuqi", "http://www.liuqi1290.com", "liuqi1290@.foxmail.com"))
                .description("作为前端开发人员参考的api文档")
                .termsOfServiceUrl("http://www.liuqi1290.com")
                .version("1.0.0").build();
    }
}
