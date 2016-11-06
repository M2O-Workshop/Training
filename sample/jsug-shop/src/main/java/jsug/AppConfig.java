package jsug;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import jsug.domain.model.Cart;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;

@Configuration
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;
    DataSource dataSource;

    @Bean(destroyMethod = "close")
    @ConfigurationProperties(prefix = DataSourceProperties.PREFIX)
    DataSource realDataSource() {
        DataSourceBuilder factory = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword());
        this.dataSource = factory.build();
        return this.dataSource;
    }

    @Primary
    @Bean
    DataSource dataSource() {
        return new DataSourceSpy(this.dataSource);
    }

    // CartをDIコンテナに管理させるためにJavaConfigを修正します。
    // なぜ、DIコンテナに管理させたいかというと、Cartのスコープを制御したいからです。
    // ここではCartを、ログインしたユーザーがログイン中に同じカートインスタンスを使い続けられるように、Sessionスコープに登録します。
    // もし、DIコンテナを使用しなければ、自前でHttpSessionへのオブジェクトの出し入れを管理する必要があり、
    // アプリケーションのソースコードが煩雑になってしまいます。

    // CartをBean定義します。scope属性にはsessionを指定します。
    // sessionスコープよりも寿命の長いsingletonスコープのControllerにもインジェクションできるように、scoped-proxyの設定を行います。
    // Cartの振る舞いには特別なインターフェースを用意していないため、scope属性にはTARGET_CLASSを指定します。
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS) // (1)
    Cart cart() {
        return new Cart();
    }
}