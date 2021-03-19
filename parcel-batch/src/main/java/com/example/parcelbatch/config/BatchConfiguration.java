package com.example.parcelbatch.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.example.parcelbatch.entities.FilteredParcel;
import com.example.parcelbatch.repository.FilteredParcelRepository;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource datasource;

	@Autowired
	private FilteredParcelRepository filteredParcelRepository;

	// Creating step for job
	@Bean
	public Step processParcelData() {
		return stepBuilderFactory.get("processParcel").<FilteredParcel, FilteredParcel>chunk(2).reader(readerParcel())
				.processor(processParcel()).writer(writeParcel()).build();
	}

	// creating job

	@Bean
	public Job processParcelJob() {
		return jobBuilderFactory.get("processParcelJob").incrementer(new RunIdIncrementer()).flow(processParcelData())
				.end().build();
	}

	@Bean
	public JdbcCursorItemReader<FilteredParcel> readerParcel() {
		JdbcCursorItemReader<FilteredParcel> reader = new JdbcCursorItemReader<FilteredParcel>();
		reader.setDataSource(datasource);
		reader.setSql("Select * from Parcel");
		reader.setRowMapper(new FilteredParcelRowMapper());
		return reader;
	}

	@Bean
	public FilteredParcelProcessor processParcel() {
		return new FilteredParcelProcessor();
	}

	@Bean
	public ItemWriter<FilteredParcel> writeParcel() {
		ItemWriter<FilteredParcel> filteredParcelReader = new ItemWriter<FilteredParcel>() {

			@Override
			public void write(List<? extends FilteredParcel> filteredParcel) {
				List<FilteredParcel> filteredParcelobj = new ArrayList<>();
				if (filteredParcel != null) {
					HashSet<String> hs = new HashSet<>();
					int s = filteredParcel.size();
					for (int i = 0; i < s; i++) {
						if (!hs.contains(
								filteredParcel.get(i).getParcelName() + " " + filteredParcel.get(i).getOrderedDtm()
										+ " " + filteredParcel.get(i).getAadharOfUser())) {
							hs.add(filteredParcel.get(i).getParcelName() + " " + filteredParcel.get(i).getOrderedDtm()
									+ " " + filteredParcel.get(i).getAadharOfUser());
							filteredParcelobj.add(filteredParcel.get(i));
						}
					}
					filteredParcelRepository.saveAll(filteredParcelobj);
				}
			}
		};
		return filteredParcelReader;
	}

}
