package com.rdm.rdm;

import Interfaces.CreateAnimalService;
import Interfaces.SearchService;
import com.rdm.rdm.implementations.CreateAnimalServiceImpl;
import com.rdm.rdm.implementations.SearchServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.yml")
public class SpringTest {

    @Autowired
    CreateAnimalService createAnimalService = new CreateAnimalServiceImpl();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    @Value("${catNames}")
    public List<String> catNames;
    @Value("${dogNames}")
    public List<String> dogNames;
    @Value("${wolfNames}")
    public List<String> wolfNames;
    @Value("${sharkNames}")
    public List<String> sharkNames;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("Проверка сервиса создания животных - проверка тестовых имен")
    void createAnimalServiceImplTest(){
        int testCount=0;
        int animalsCount=5;
        createAnimalService.createAnimals(animalsCount);

        for (int i=0; i<catNames.size();i++) {
            testCount = testCount+substringCount(output.toString().trim(),"name='"+catNames.get(i)+"'");
        }
        for (int i=0; i<dogNames.size();i++) {
            testCount = testCount+substringCount(output.toString().trim(),"name='"+dogNames.get(i)+"'");
        }
        for (int i=0; i<wolfNames.size();i++) {
            testCount = testCount+substringCount(output.toString().trim(),"name='"+wolfNames.get(i)+"'");
        }
        for (int i=0; i<sharkNames.size();i++) {
            testCount = testCount+substringCount(output.toString().trim(),"name='"+sharkNames.get(i)+"'");
        }
        Assert.assertEquals(animalsCount, testCount);
    }

    @Test
    @DisplayName("Проверка сервиса создания животных - проверка количества")
    void createAnimalServiceImplCountTest(){
        int animalsCount=5;
        createAnimalService.createAnimals(animalsCount);
        Assert.assertEquals(animalsCount,
                substringCount(output.toString().trim(),"name='"));
    }

    @Test
    @DisplayName("Проверка сервиса создания животных - проверка пустого вывода")
    void createAnimalServiceImplEmptyTest(){
        int animalsCount=0;
        createAnimalService.createAnimals(animalsCount);
        Assert.assertEquals("", output.toString().trim());
    }


    // Количество вхождений подстроки в строку
    public static int substringCount(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}
