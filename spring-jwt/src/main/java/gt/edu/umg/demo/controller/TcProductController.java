package gt.edu.umg.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.demo.model.TcProduct;
import gt.edu.umg.demo.repository.TcProductRepository;
import gt.edu.umg.demo.utils.ApiResponse2;

/**
 * TcProductController
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class TcProductController {

    @Autowired
    TcProductRepository tcProductRepository;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse2> getAll() {
        try {
            List<TcProduct> products = tcProductRepository.findAll();
            ApiResponse2 apiResponse = new ApiResponse2("OK", "PROCESO REALIZADO CON EXITO", products);
            return new ResponseEntity<ApiResponse2>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse2 apiResponse = new ApiResponse2("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse2>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }
    
}