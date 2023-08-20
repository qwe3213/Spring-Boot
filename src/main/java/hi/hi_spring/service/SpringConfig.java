package hi.hi_spring.service;

import hi.hi_spring.aop.TimeTraceAop;
import hi.hi_spring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

       private final MemberRepository memberRepository;

       @Autowired
       public SpringConfig(MemberRepository memberRepository){
           this.memberRepository = memberRepository;
       }

        @Bean
        public MemberService memberService(){
            return new MemberService(memberRepository);
        }

      //    @Bean
      //    public TimeTraceAop timeTraceAop(){
      //    return new TimeTraceAop();
      //   }
      //  timeTraceAop에서 @Component를 하지 않을경우 사용

    //    @Bean
    //    public MemberRepository memberRepository(){

    //     return new MemoryMemberRepository();
    //     return new JdbcMemberRepository(dataSource);
    //     return new JdbcTemplateMemberRepository(dataSource);
    //     return new JpaMemberRepository(em);


    //      }
    }

