package com.a08r.awlabsapps.services;

import com.a08r.awlabsapps.models.dto.TrackingPointDto;
import com.a08r.awlabsapps.models.mapper.ITrackingPointMapper;
import com.a08r.awlabsapps.models.trackpointentity.TrackingPointEntity;
import com.a08r.awlabsapps.repositores.ITrackingPointRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrackingPointServiceImplTest {
    @InjectMocks
    private TrackingPointServiceImpl trackingPointServiceImpl;
    @Mock
    private ITrackingPointRepository iTrackingPointRepository;
    @Mock
    private  ITrackingPointMapper TRACKING_POINT_MAPPER;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
   public void shouldFindAllTest() {
        //Given
        List<TrackingPointEntity> trackingPointEntityList = new ArrayList<>();
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
        trackingPointEntityList.add(trackingPointEntity);
        //Mock the calls
        when(iTrackingPointRepository.findAll()).thenReturn(trackingPointEntityList);
        when(TRACKING_POINT_MAPPER.trackingPointEntityTotrackingPointDto(Mockito.any(TrackingPointEntity.class)))
                .thenReturn(new TrackingPointDto(
                        "sectorName",
                        "labName",
                        1,
                        1,
                        1,
                        "breakDate",
                        "breakTime",
                        1.0,
                        1.0
                ));
        //When
        List<TrackingPointDto> trackingPointDtoList = trackingPointServiceImpl.findAll().getBody();

        //Then
        assert trackingPointDtoList != null;
        assertEquals(trackingPointDtoList.size(), trackingPointEntityList.size());
        verify(iTrackingPointRepository, times(1)).findAll();
    }

    @Test

   public void shouldFindByIdTest() {
        //Given
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
        //Mock the calls
        when(iTrackingPointRepository.findById(1L)).thenReturn(java.util.Optional.of(trackingPointEntity));
        when(TRACKING_POINT_MAPPER.trackingPointEntityTotrackingPointDto(Mockito.any(TrackingPointEntity.class)))
                .thenReturn(new TrackingPointDto(
                        "sectorName",
                        "labName",
                        1,
                        1,
                        1,
                        "breakDate",
                        "breakTime",
                        1.0,
                        1.0 ));
        //When
        TrackingPointDto trackingPointDto = trackingPointServiceImpl.findById(1L).getBody();
        //Then
        assertEquals(Objects.requireNonNull(trackingPointDto).getLabName(), "labName");
        assertEquals(trackingPointDto.getSectorName(), "sectorName");
        assertEquals(trackingPointDto.getUserId(), 1);
        verify(iTrackingPointRepository, times(1)).findById(1L);
    }

    @Test
   public void shouldFindByBreakIdTest() {
        //Given
        List<TrackingPointEntity> trackingPointEntityList = new ArrayList<>();
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
        trackingPointEntityList.add(trackingPointEntity);
        //Mock the calls
        when(iTrackingPointRepository.findByBreakId(1)).thenReturn(trackingPointEntityList);
        when(TRACKING_POINT_MAPPER.trackingPointEntityTotrackingPointDto(Mockito.any(TrackingPointEntity.class)))
                .thenReturn(new TrackingPointDto(
                        "sectorName",
                        "labName",
                        1,
                        1,
                        1,
                        "breakDate",
                        "breakTime",
                        1.0,
                        1.0
                ));
        //When
        List<TrackingPointDto> trackingPointDtoList = trackingPointServiceImpl.findByBreakId(1).getBody();
        //Then
        assert trackingPointDtoList != null;
        assertEquals(trackingPointDtoList.size(), trackingPointEntityList.size());
        verify(iTrackingPointRepository, times(1)).findByBreakId(1);

    }

    @Test
   public void shouldFindByBreakIdAndLabCodeTest() {
        //Given
        List<TrackingPointEntity> trackingPointEntityList = new ArrayList<>();
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
        trackingPointEntityList.add(trackingPointEntity);
        //Mock the calls
        when(iTrackingPointRepository.findByBreakIdAndLabCode(1,1)).thenReturn(trackingPointEntityList);
        when(TRACKING_POINT_MAPPER.trackingPointEntityTotrackingPointDto(Mockito.any(TrackingPointEntity.class)))
                .thenReturn(new TrackingPointDto(
                        "sectorName",
                        "labName",
                        1,
                        1,
                        1,
                        "breakDate",
                        "breakTime",
                        1.0,
                        1.0
                ));
        //When
        List<TrackingPointDto> trackingPointDtoList = trackingPointServiceImpl.findByBreakIdAndLabCode(1,1).getBody();
        //Then
        assert trackingPointDtoList != null;
        assertEquals(trackingPointDtoList.size(), trackingPointEntityList.size());
        verify(iTrackingPointRepository, times(1)).findByBreakIdAndLabCode(1,1);
    }

    @Test
   public void shouldFindByLabCodeTest() {
        //Given
        List<TrackingPointEntity> trackingPointEntityList = new ArrayList<>();
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
        trackingPointEntityList.add(trackingPointEntity);
        //Mock the calls
        when(iTrackingPointRepository.findByLabCode(1)).thenReturn(trackingPointEntityList);
        when(TRACKING_POINT_MAPPER.trackingPointEntityTotrackingPointDto(Mockito.any(TrackingPointEntity.class)))
                .thenReturn(new TrackingPointDto(
                        "sectorName",
                        "labName",
                        1,
                        1,
                        1,
                        "breakDate",
                        "breakTime",
                        1.0,
                        1.0
                ));
        //When
        List<TrackingPointDto> trackingPointDtoList = trackingPointServiceImpl.findByLabCode(1).getBody();
        //Then
        assert trackingPointDtoList != null;
        assertEquals(trackingPointDtoList.size(), trackingPointEntityList.size());
        verify(iTrackingPointRepository, times(1)).findByLabCode(1);

    }


}