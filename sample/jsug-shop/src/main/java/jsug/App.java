package jsug;

// This is hunds-on SpringBoot.
// see http://jsug-spring-boot-handson.readthedocs.io/en/latest/index.html
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    // memo:Springでwarを生成するために必要な記述。
    /* (非 Javadoc)
     * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure
     * (org.springframework.boot.builder.SpringApplicationBuilder)
     */
    /**
     * warビルドメソッド <br />
     * ビルド時にwarを生成するために必要となる定型メソッド。 <br />
     * @param application アプリケーションビルダー
     */
    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
      return application.sources( App.class );
    }
}