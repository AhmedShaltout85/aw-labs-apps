package com.a08r.awlabsapps.contorllers;

import com.a08r.awlabsapps.models.dto.TrackingPointDto;
import com.a08r.awlabsapps.services.ITrackingPointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrackingPointControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ITrackingPointService iTrackingPointService;


    @Test
    public void shouldGetAllTest() throws Exception {
        //Given
        TrackingPointDto trackingPointDto1 = new TrackingPointDto(
                "sectorName",
                "labName",
                1,
                1,
                1,
                "breakDate",
                "breakTime",
                1.0,
                1.0
        );
        TrackingPointDto trackingPointDto2 = new TrackingPointDto(
                "sectorName1",
                "labName1",
                2,
                1,
                1,
                "breakDate1",
                "breakTime1",
                11.0,
                11.0

        );

        List<TrackingPointDto> data = Arrays.asList(trackingPointDto1, trackingPointDto2);
        //When
        given(iTrackingPointService.findAll()).willReturn(ResponseEntity.ok().body(data));
        //Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/break-info")
                        .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sectorName", equalTo(trackingPointDto1.getSectorName())));
    }

    @Test
    public void shouldFindByBreakIdTest() throws Exception {
        //Given
        TrackingPointDto trackingPointDto1 = new TrackingPointDto(
                "sectorName",
                "labName",
                1,
                1,
                1,
                "breakDate",
                "breakTime",
                1.0,
                1.0
        );
        TrackingPointDto trackingPointDto2 = new TrackingPointDto(
                "sectorName1",
                "labName1",
                2,
                1,
                1,
                "breakDate1",
                "breakTime1",
                11.0,
                11.0

        );

        List<TrackingPointDto> data = Arrays.asList(trackingPointDto1, trackingPointDto2);
        //When
        given(iTrackingPointService.findByBreakId(1)).willReturn(ResponseEntity.ok().body(data));
        //Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/break-info/{id}", 1)
                        .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFindByBreakIdAndLabCodeTest() throws Exception {
        //Given
        TrackingPointDto trackingPointDto1 = new TrackingPointDto(
                "sectorName",
                "labName",
                1,
                1,
                1,
                "breakDate",
                "breakTime",
                1.0,
                1.0
        );
        TrackingPointDto trackingPointDto2 = new TrackingPointDto(
                "sectorName1",
                "labName1",
                2,
                1,
                1,
                "breakDate1",
                "breakTime1",
                11.0,
                11.0
        );
        List<TrackingPointDto> data = Arrays.asList(trackingPointDto1, trackingPointDto2);
        //When
        given(iTrackingPointService.findByBreakIdAndLabCode(1, 1)).willReturn(ResponseEntity.ok().body(data));
        //Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/break-info/{id}/{labCode}", 1, 1)
                        .accept("application/json")
               );


    }

    @Test
    public void shouldTestFindByBreakIdTest() throws Exception {
        //Given
        TrackingPointDto trackingPointDto1 = new TrackingPointDto(
                "sectorName",
                "labName",
                1,
                1,
                1,
                "breakDate",
                "breakTime",
                1.0,
                1.0
        );
        TrackingPointDto trackingPointDto2 = new TrackingPointDto(
                "sectorName1",
                "labName1",
                2,
                1,
                1,
                "breakDate1",
                "breakTime1",
                11.0,
                11.0
        );
        List<TrackingPointDto> data = Arrays.asList(trackingPointDto1, trackingPointDto2);
        //When
        given(iTrackingPointService.findByBreakId(1)).willReturn(ResponseEntity.ok().body(data));
        //Then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/break-info/{id}", 1).accept("application/json")
                        .accept("application/json"))
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    public void shouldFindByLabCodeTest() throws Exception {
        //Given
        TrackingPointDto trackingPointDto1 = new TrackingPointDto(
                "sectorName",
                "labName",
                1,
                1,
                1,
                "breakDate",
                "breakTime",
                1.0,
                1.0
        );
        TrackingPointDto trackingPointDto2 = new TrackingPointDto(
                "sectorName1",
                "labName1",
                2,
                1,
                1,
                "breakDate1",
                "breakTime1",
                11.0,
                11.0
        );
        List<TrackingPointDto> data = Arrays.asList(trackingPointDto1, trackingPointDto2);
        //When
        given(iTrackingPointService.findByLabCode(1)).willReturn(ResponseEntity.ok().body(data));
        //Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/labs/{labCode}", 1).accept("application/json")
        );

    }
}