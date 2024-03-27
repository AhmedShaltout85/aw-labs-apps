package com.a08r.awlabsapps.services;

import com.a08r.awlabsapps.models.dto.TrackingPointDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITrackingPointService {
    ResponseEntity<List<TrackingPointDto>> findAll();
    ResponseEntity<TrackingPointDto> findById(Long id);
    ResponseEntity<List<TrackingPointDto>> findByBreakId(int breakId);
    ResponseEntity<List<TrackingPointDto>> findByBreakIdAndLabCode(int breakId, int labCode);
    ResponseEntity<List<TrackingPointDto>> findByLabCode(int labCode);
}
