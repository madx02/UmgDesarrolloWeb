package gt.edu.umg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.demo.model.TcClient;
import gt.edu.umg.demo.repository.TcClientRepository;
import gt.edu.umg.demo.utils.ApiResponse2;

/**
 * TcClientController
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/client")
public class TcClientController {

    @Autowired
    TcClientRepository tcClientRepository;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse2> getAll() {
        try {
            List<TcClient> clients = tcClientRepository.findAll();
            ApiResponse2 apiResponse = new ApiResponse2("OK", "PROCESO REALIZADO CON EXITO", clients);
            return new ResponseEntity<ApiResponse2>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse2 apiResponse = new ApiResponse2("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse2>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }
    
}