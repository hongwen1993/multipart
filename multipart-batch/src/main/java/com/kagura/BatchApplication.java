package com.kagura;

import com.fasterxml.jackson.core.JsonParseException;
import com.kagura.entity.Message;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.Writer;

@SpringBootApplication
public class BatchApplication {

    //@Autowired
    //private JobBuilderFactory jobBuilderFactory;
    //@Autowired
    //private StepBuilderFactory stepBuilderFactory;

    //public static int CHUNK_SIZE = 10;

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

    //@Bean
    //public Job messageMigrationJob(@Qualifier("messageMigrationStep") Step messageMigrationStep) {
    //    return jobBuilderFactory.get("messageMigrationJob").start(messageMigrationStep).build();
    //}



    //@Bean
    //public Step messageMigrationStep(@Qualifier("jsonMessageReader") FlatFileItemReader<Message> jsonMessageReader,
    //                                 @Qualifier("messageItemWriter") JpaItemWriter<Message> messageItemWriter,
    //                                 @Qualifier("errorWriter") Writer errorWriter) {
    //    return stepBuilderFactory.get("messageMigrationStep")
    //            .<Message, Message>chunk(CHUNK_SIZE)
    //            .reader(jsonMessageReader).faultTolerant().skip(JsonParseException.class).skipLimit(SKIP_LIMIT)
    //            .listener(new MessageItemReadListener(errorWriter))
    //            .writer(messageItemWriter).faultTolerant().skip(Exception.class).skipLimit(SKIP_LIMIT)
    //            .listener(new MessageWriteListener())
    //            .build();
    //}
    //
    //@Bean
    //public FlatFileItemReader<Message> jsonMessageReader() {
    //    FlatFileItemReader<Message> reader = new FlatFileItemReader<>();
    //    reader.setResource(new FileSystemResource(new File(MESSAGE_FILE)));
    //    reader.setLineMapper(new MessageLineMapper());
    //    return reader;
    //}

}
