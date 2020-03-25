package com.kwu.propictures.service;

import com.kwu.propictures.model.Coronavirus;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
//https://www.youtube.com/watch?v=8hjNG9GZGnQ&t=2055s
@Service
public class CoronaService {
//    String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
    String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    @Cacheable("corona")
    @PostConstruct
    @Scheduled(cron = "* 1 * * * *")
    public List<Coronavirus> getCoronaLatest() throws IOException {
        List<Coronavirus> coronaList = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(VIRUS_DATA_URL, String.class);
        StringReader csvBodyReader = new StringReader(result);
        //java csv library
        //https://commons.apache.org/proper/commons-csv/user-guide.html
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            Coronavirus corVirus = new Coronavirus();
            corVirus.setState(record.get("Province/State"));
            corVirus.setCountry(record.get("Country/Region"));
            corVirus.setPreConfirmed(Integer.parseInt( record.get(record.size()-2).isEmpty()? "0" : record.get(record.size()-2)));
            corVirus.setLatestConfirmed(Integer.parseInt(record.get(record.size()-1).isEmpty()? "0" : record.get(record.size()-1)));
            corVirus.setDiffence(corVirus.getLatestConfirmed() - corVirus.getPreConfirmed());
            System.out.println(corVirus);
            coronaList.add(corVirus);
        }
        return coronaList;
    }


}
