package com.kagura.demo01;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing(modular = true)
public class Demo01Config {

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

    @Bean
    public Job flowDemoJob () {
        return jobBuilderFactory.get("flowDemojob").start(showFlow()).next(flowStep03()).end().build();
    }


}
