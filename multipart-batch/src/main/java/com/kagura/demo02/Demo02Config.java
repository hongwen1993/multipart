package com.kagura.demo02;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing(modular = true)
public class Demo02Config {

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step flowStep01() {
        return stepBuilderFactory.get("flowStep01").tasklet((contribution, chunkContext) -> {
            System.out.println("step01");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Step flowStep02() {
        return stepBuilderFactory.get("flowStep02").tasklet((contribution, chunkContext) -> {
            System.out.println("step02");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Step flowStep03() {
        return stepBuilderFactory.get("flowStep03").tasklet((contribution, chunkContext) -> {
            System.out.println("step03");
            return RepeatStatus.FINISHED;
        }).build();
    }

    @Bean
    public Flow showFlow() {
        return new FlowBuilder<Flow>("showFlow").start(flowStep01()).next(flowStep02()).build();
    }

    /**
     * 并发执行 - (实际上会因为CPU时间片的调度导致顺序执行)
     */
    @Bean
    public Job flowDemoJob () {
        return jobBuilderFactory.get("flowDemojob").start(flowStep03()).split(new SimpleAsyncTaskExecutor())
                .add(showFlow()).end().build();
    }


}
