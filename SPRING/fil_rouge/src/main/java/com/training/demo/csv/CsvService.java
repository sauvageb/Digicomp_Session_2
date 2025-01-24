package com.training.demo.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.training.demo.csv.CSVMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CsvService<T, K> {
        final CSVMapper<T, K> csvMapper;

        public CsvService(CSVMapper<T, K> csvMapper) {
                this.csvMapper = csvMapper;
        }


        final public Set<T> parseCSV(InputStream stream , Class<K> clazz) throws IOException {

                try (Reader reader = new BufferedReader(new InputStreamReader(stream))) {
                        // creating the strategy object
                        HeaderColumnNameMappingStrategy<K> strategy = new HeaderColumnNameMappingStrategy<>();
                        // setting the format of the data representation in the header
                        strategy.setType(clazz);
                        // Creating instance of CSVTOBEAN class responsable of the mapping
                        CsvToBean<K> csvToBean = new CsvToBeanBuilder<K>(reader)
                                        // Setting the startegy
                                        .withMappingStrategy(strategy)
                                        // Ignore empty lines and leading spaces
                                        .withIgnoreEmptyLine(true)
                                        .withIgnoreLeadingWhiteSpace(true)
                                        .build();
                        // parse the data into the Objects with type T
                        return csvToBean.parse()
                                        .stream()
                                        .map(csvMapper::mapTo)
                                        .collect(Collectors.toSet());
                }
        }

}