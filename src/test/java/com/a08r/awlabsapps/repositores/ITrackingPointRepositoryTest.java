package com.a08r.awlabsapps.repositores;

import com.a08r.awlabsapps.models.trackpointentity.TrackingPointEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class ITrackingPointRepositoryTest {
    @Autowired
    private ITrackingPointRepository iTrackingPointRepository;

    @AfterEach
    void tearDown() {
        iTrackingPointRepository.deleteAll();
    }

    @Test
    void shouldFindByBreakIdAndLabCodeTest() {
        //Given
        TrackingPointEntity trackingPointEntity1 = new TrackingPointEntity(
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
        TrackingPointEntity trackingPointEntity2 = new TrackingPointEntity(
                2L,
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
        List<TrackingPointEntity> trackingPointEntityList = List.of(trackingPointEntity1, trackingPointEntity2);
        iTrackingPointRepository.save(trackingPointEntity1);
        iTrackingPointRepository.save(trackingPointEntity2);

        //When
        List<TrackingPointEntity> expected = iTrackingPointRepository.findByBreakIdAndLabCode(1, 1);
        //Then
        assertEquals(iTrackingPointRepository.findByBreakIdAndLabCode(1, 1), expected);
        assert (expected.size() == 2);
    }

    @Test
    void shouldFindByBreakIdTest() {
        //Given
        TrackingPointEntity trackingPointEntity1 = new TrackingPointEntity(
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
        TrackingPointEntity trackingPointEntity2 = new TrackingPointEntity(
                2L,
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
        List<TrackingPointEntity> trackingPointEntityList = List.of(trackingPointEntity1, trackingPointEntity2);
        iTrackingPointRepository.save(trackingPointEntity1);
        iTrackingPointRepository.save(trackingPointEntity2);

        //When
        List<TrackingPointEntity> expected = iTrackingPointRepository.findByBreakId(1);
        //Then
        assertEquals(iTrackingPointRepository.findByBreakId(1), expected);
    }

    @Test
    void shouldFindByLabCodeTest() {
        //Given
        TrackingPointEntity trackingPointEntity1 = new TrackingPointEntity(
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
        TrackingPointEntity trackingPointEntity2 = new TrackingPointEntity(
                2L,
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
        List<TrackingPointEntity> trackingPointEntityList = List.of(trackingPointEntity1, trackingPointEntity2);
        iTrackingPointRepository.save(trackingPointEntity1);
        iTrackingPointRepository.save(trackingPointEntity2);

        //When
        List<TrackingPointEntity> expected = iTrackingPointRepository.findByLabCode(1);
        //Then
        assertEquals(iTrackingPointRepository.findByLabCode(1), expected);
    }
}