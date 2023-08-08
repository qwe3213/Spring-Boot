package hi.hi_spring.service;

import hi.hi_spring.repository.MemberRepository;
import hi.hi_spring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


        @Bean
        public MemberService memberService(){
            return new MemberService(memberRepository());
        }

        @Bean
        public MemberRepository memberRepository(){
            return new MemoryMemberRepository();
        }
    }

