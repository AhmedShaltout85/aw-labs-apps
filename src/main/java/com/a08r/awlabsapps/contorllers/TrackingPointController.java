package com.a08r.awlabsapps.contorllers;

import com.a08r.awlabsapps.models.dto.TrackingPointDto;
import com.a08r.awlabsapps.services.ITrackingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/break-info")
public class TrackingPointController {

    private final ITrackingPointService iTrackingPointService;

    @Autowired
    public TrackingPointController(ITrackingPointService iTrackingPointService) {
        this.iTrackingPointService = iTrackingPointService;
    }


    @GetMapping
    public ResponseEntity<List<TrackingPointDto>> getAll(){
        return this.iTrackingPointService.findAll();
    }
    @GetMapping(path ="/{id}" )
    public ResponseEntity<TrackingPointDto> findByBreakId(@PathVariable Long id){
        return this.iTrackingPointService.findById(id);
    }

    @GetMapping(path ="/bl/{breakId}/{labCode}" )
    public ResponseEntity<List<TrackingPointDto>> findByBreakIdAndLabCode(@PathVariable int breakId, @PathVariable int labCode){

        return this.iTrackingPointService.findByBreakIdAndLabCode(breakId,labCode);
    }
    @GetMapping(path ="/b/{breakId}" )
    public ResponseEntity<List<TrackingPointDto>> findByBreakId(@PathVariable int breakId){

        return this.iTrackingPointService.findByBreakId(breakId);
    }
  @GetMapping(path ="/l/{labCode}" )
    public ResponseEntity<List<TrackingPointDto>> findByLabCode(@PathVariable int labCode){

        return this.iTrackingPointService.findByLabCode(labCode);
    }


}
