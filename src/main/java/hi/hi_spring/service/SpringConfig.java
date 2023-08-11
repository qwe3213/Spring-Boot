package hi.hi_spring.service;

import hi.hi_spring.repository.JdbcMemberRepository;
import hi.hi_spring.repository.MemberRepository;
import hi.hi_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
        @Bean
        public MemberService memberService(){
            return new MemberService(memberRepository());
        }

        @Bean
        public MemberRepository memberRepository(){
            return new JdbcMemberRepository(dataSource);
        }
    }

