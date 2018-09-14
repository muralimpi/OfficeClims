/**
 * 
 */
package com.serole.wims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.serole.wims.config.SwaggerConfig;

/**
 * @author SONJOY CHAKRABORTY
 *
 */
@SpringBootApplication
@Import({ SwaggerConfig.class})
public class WimsApplication {

    public static void main1(String[] args) {
        SpringApplication.run( WimsApplication.class, args);
    }
}
