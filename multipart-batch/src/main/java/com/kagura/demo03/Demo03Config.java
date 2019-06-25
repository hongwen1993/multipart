package com.kagura.demo03;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 决策器
 */
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing(modular = true)
public class Demo03Config {

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step decideStep01() {
        return stepBuilderFactory.get("decideStep01").tasklet((contribution, chunkContext) -> {
            System.out.println("decideStep01 Start======>>>>>>");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Step decideStep02() {
        return stepBuilderFactory.get("decideStep02").tasklet((contribution, chunkContext) -> {
            System.out.println("偶数======>>>>>>");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Step decideStep03() {
        return stepBuilderFactory.get("decideStep03").tasklet((contribution, chunkContext) -> {
            System.out.println("奇数======>>>>>>");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Job decideJob(@Qualifier("myDecider") JobExecutionDecider myDecider) {
        return jobBuilderFactory.get("decideJob").start(decideStep01())
                .next(myDecider)
                .from(myDecider).on("EVEN").to(decideStep02())
                .from(myDecider).on("ODD").to(decideStep03())
                .end().build();
    }

    @Bean
    public JobExecutionDecider myDecider() {
        return (jobExecution, stepExecution) -> {
            int n = (int) (Math.random() * 10) + 1;
            System.out.println("n : " + n);
            if (n % 2 == 0) {
                return new FlowExecutionStatus("EVEN");
            }
            return new FlowExecutionStatus("ODD");
        };
    }

}
