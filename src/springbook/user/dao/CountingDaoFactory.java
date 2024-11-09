package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {
    
    @Bean
    public UserDao userDao() {
    // DataSource 인터페이스 사용 예제 시작이후 사용 안하기에 주석처리
    //    return new UserDao(connectionMaker()); 
        return null;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new DConnectionMaker();
    }
}
