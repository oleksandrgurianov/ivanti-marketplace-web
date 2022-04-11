package s3_gps_ivanti.model.controller;

import s3_gps_ivanti.business.ResponseService;
import s3_gps_ivanti.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/response")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class ResponseController {

    private final ResponseService responseService;

    //Creator
    @GetMapping("{reviewID}")
    public ResponseEntity<ArrayList<Response>> getResponse(@PathVariable("reviewID")int reviewID) {

        ArrayList<Response> responses = responseService.getResponse(reviewID);

        if(responses != null) {
            return ResponseEntity.ok().body(responses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{reviewID}")
    public ResponseEntity<Object>  createResponse(@PathVariable("reviewID")int reviewID, @RequestBody Response response) {

        if(responseService.createResponse(reviewID, response)) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status( HttpStatus.CONFLICT).build();
        }

    }

    @PutMapping()
    public ResponseEntity<Object>  updateResponse(@RequestBody Response response) {
        if(responseService.updateResponse(response)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping({"{responseID}"})
    public ResponseEntity<Object> deleteResponse(@PathVariable int responseID) {
        if (responseService.deleteResponse(responseID)) {
               return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
