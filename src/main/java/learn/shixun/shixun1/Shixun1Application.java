package learn.shixun.shixun1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "learn.shixun.shixun1.mapper")//自动扫描mapper，以备注入
public class Shixun1Application {

    public static void main(String[] args) {
        SpringApplication.run(Shixun1Application.class, args);
    }

}
