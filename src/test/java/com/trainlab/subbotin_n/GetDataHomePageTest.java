package com.trainlab.subbotin_n;

import com.trainlab.subbotin_n.model.home_page.DataHomePage;
import com.trainlab.subbotin_n.model.home_page.HomePageClient;
import com.trainlab.subbotin_n.model.home_page.JDBCPostgreSQLConnect;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.*;

public class GetDataHomePageTest {

    private ValidatableResponse response;

    @Test
    @DisplayName("Get StatusCode from HomePage")
    @Description("Expected response: StatusCode 200")
    public void a_getStatusCodeHomePageTest() {

        response = HomePageClient.getDataHomePage();

        int actualStatusCode = response.extract().statusCode();

        assertEquals(SC_OK, actualStatusCode);
    }

    @Test
    @DisplayName("Get data from HomePage")
    @Description("Expected response: Actual Data from HomePage")
    public void b_getDataHomePageTest() {

        response = HomePageClient.getDataHomePage();

        DataHomePage actualDataHomePage = response.extract().as(DataHomePage.class);

        ArrayList<String> expectedListDataHomePage = new ArrayList<>(Arrays.asList(
                "Cоздай свой успех",
                "Наши тренажеры разработаны на основе тестовых заданий работодателей. выполняя задания и зарабатывая баллы, ты найдешь работу мечты", "Выполни задания",
                "Собирай баллы",
                "Повышай рейтинг",
                "Твоя работа найдет тебя",
                "Все права защищены. Любое использование либо копирование материалов и (или) подборки материалов сайта, элементов дизайна и оформления допускается лишь с письменного разрешения правообладателя и только со ссылкой на источник: URL",
                "Здесь будет история успеха нашего пользователя",
                "© 2023 OOO «ХХХХХХХХ»"));

        ArrayList<String> actualListDataHomePage = new ArrayList<>(Arrays.asList(
                actualDataHomePage.getOne(),
                actualDataHomePage.getTwo(),
                actualDataHomePage.getThree(),
                actualDataHomePage.getFour(),
                actualDataHomePage.getFive(),
                actualDataHomePage.getSix(),
                actualDataHomePage.getSeven(),
                actualDataHomePage.getEight(),
                actualDataHomePage.getNine()));

        for (int i = 0; i < expectedListDataHomePage.size(); i++) {
            assertEquals(expectedListDataHomePage.get(i), actualListDataHomePage.get(i));
        }
    }

//    @Test
//    public void jdbcPostgreSqlConnect() {
//        JDBCPostgreSQLConnect connect = new JDBCPostgreSQLConnect();
//        connect.postgresqlConnect();
//        int i = 0;
//    }
}