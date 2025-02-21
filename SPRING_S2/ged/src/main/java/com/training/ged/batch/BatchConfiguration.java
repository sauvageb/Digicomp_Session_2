package com.training.ged.batch;


import com.training.ged.domain.model.Document;
import com.training.ged.domain.service.CustomerService;
import com.training.ged.repository.DocumentRepository;
import lombok.extern.java.Log;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Log
@Configuration // Indique à Spring Boot que cette classe contient
// des configurations de Bean
public class BatchConfiguration {

    //Composants des étapes (reader, processor, writer)
    @Bean
    public FlatFileItemReader<DocumentCSV> reader() {
        log.info("batch reading");
        return new FlatFileItemReaderBuilder<DocumentCSV>()
                .name("documentReader")
                .resource(new ClassPathResource("documents_batch.csv"))
                .delimited()
                .delimiter(",")
                .names(new String[]{"expiryDate", "customerId", "fileName","status", "type"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(DocumentCSV.class);
                }})
                .linesToSkip(1)
                .build();
    }


    @Bean
    public DocumentCsvProcessor processor(CustomerService customerService) {
        return new DocumentCsvProcessor(customerService);
    }

    @Bean
    public ItemWriter writer(DocumentRepository documentRepository) {
        return new DocumentItemWriter(documentRepository);
    }

    // Définition du traitement par lot (Job)
    @Bean
    public Job job(JobRepository jobRepository, Step step1){
        return new JobBuilder("importDocumentCSV", jobRepository)
                .incrementer(new RunIdIncrementer())
                //.listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    // Définition d'une étape (Step) pour le traitement par lot (Job)
    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      FlatFileItemReader<DocumentCSV> reader,
                      DocumentCsvProcessor processor,
                      DocumentItemWriter writer) {
        return new StepBuilder("step1", jobRepository)
                .<DocumentCSV, Document> chunk(2, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }



}
