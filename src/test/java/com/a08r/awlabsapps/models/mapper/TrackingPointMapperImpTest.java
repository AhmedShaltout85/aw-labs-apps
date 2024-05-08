package com.a08r.awlabsapps.models.mapper;

import com.a08r.awlabsapps.models.dto.TrackingPointDto;
import com.a08r.awlabsapps.models.trackpointentity.TrackingPointEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackingPointMapperImpTest {
    private TrackingPointMapperImp trackingPointMapperImp;

    @BeforeEach
    void setUp() {
        trackingPointMapperImp = new TrackingPointMapperImp();
    }

    @Test
   public void shouldTrackingPointDtoToTrackingPointEntity() {
        //GIVEN
        TrackingPointDto trackingPointDto = new TrackingPointDto(
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

        //WHEN
       TrackingPointEntity trackingPointEntity = trackingPointMapperImp.trackingPointDtoToTrackingPointEntity(trackingPointDto);
        //THEN
        assertEquals(trackingPointDto.getSectorName(), trackingPointEntity.getSectorName());
        assertEquals(trackingPointDto.getLabName(), trackingPointEntity.getLabName());
        assertEquals(trackingPointDto.getLabCode(), trackingPointEntity.getLabCode());


    }

    @Test
   public void shouldTrackingPointEntityToTrackingPointDto() {
        //GIVEN
        TrackingPointEntity trackingPointEntity = new TrackingPointEntity(
                1L,
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
        //WHEN
        TrackingPointDto trackingPointDto = trackingPointMapperImp.trackingPointEntityTotrackingPointDto(trackingPointEntity);
        //THEN
        assertEquals(trackingPointEntity.getSectorName(), trackingPointDto.getSectorName());
        assertEquals(trackingPointEntity.getLabName(), trackingPointDto.getLabName());
        assertEquals(trackingPointEntity.getLabCode(), trackingPointDto.getLabCode());

    }

    @Test
    public void shouldThrowNotNullExceptionWhenLabsDTOisNull() {
        var nullPointerException = assertThrows(NullPointerException.class,
                () -> trackingPointMapperImp.trackingPointDtoToTrackingPointEntity(null));
        assertEquals("trackingPointDto should not be null", nullPointerException.getMessage());

    }
}