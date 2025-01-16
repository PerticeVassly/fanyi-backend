package org.fanyi.fanyibackend;

import org.fanyi.fanyibackend.util.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FanyiBackendApplication {

    public static void main(String[] args) throws IOException {

        EnvLoader.loadEnv(".env");

        SpringApplication.run(FanyiBackendApplication.class, args);
    }

}
