package com.roofflex.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {

    private List<String> fortunesList;

    private Random random = new Random();

    // reading fortunes from file when an instance of FileFortuneService is created

//    public FileFortuneService(){
//        File fortunes = new File("src/fortunes.txt");
//
//        fortunesList = new ArrayList<String>();
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(fortunes));
//            String tempString;
//            while((tempString = br.readLine()) != null){
//                fortunesList.add(tempString);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }


    // reading the fortunes in a different way - with init method

    @PostConstruct
    private void readFortunes(){
        File fortunes = new File("src/fortunes.txt");

        fortunesList = new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fortunes));
            String tempString;
            while((tempString = br.readLine()) != null){
                fortunesList.add(tempString);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public String getFortune() {
        int randomInt = random.nextInt(fortunesList.size());

        return fortunesList.get(randomInt);
    }
}
