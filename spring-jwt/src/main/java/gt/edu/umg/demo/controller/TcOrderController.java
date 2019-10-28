package gt.edu.umg.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

//import gt.edu.umg.demo.model.TcClient;
import gt.edu.umg.demo.model.TcDetail;
import gt.edu.umg.demo.model.TcOrder;
import gt.edu.umg.demo.repository.TcClientRepository;
import gt.edu.umg.demo.repository.TcDetailRepository;
import gt.edu.umg.demo.repository.TcOrderRepository;
import gt.edu.umg.demo.repository.TcProductRepository;
import gt.edu.umg.demo.utils.ApiResponse;
import gt.edu.umg.demo.utils.ApiResponse2;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order")
public class TcOrderController {

    @Autowired
    TcClientRepository tcClientRepository;

    @Autowired
    TcOrderRepository tcOrderRepository;

    @Autowired
    TcDetailRepository tcDetailRepository;

    @Autowired
    TcProductRepository tcProductRepository;

    // @PostMapping("/add")
    // public ResponseEntity<ApiResponse> setOrder(@RequestBody TcOrder tcOrder) {
    //     List<TcOrder>data = new ArrayList<>();
    //     try {
    //         TcClient tcClient = tcOrder.getTcClient();
    //         if (tcClientRepository.findById(tcClient.getClientId()).orElse(null).equals(null)) {
    //             tcClientRepository.save(tcClient);
    //             data.add(tcOrderRepository.save(tcOrder));
    //         } else {
    //             data.add(tcOrderRepository.save(tcOrder));
    //         }
    //         ApiResponse apiResponse = new ApiResponse("OK", "PROCESO REALIZADO CON EXITO", data);
    //         return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    //     } catch (Exception e) {
    //         ApiResponse apiResponse = new ApiResponse("FAIL", e.toString(), null);
    //         return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
    //     }
    // }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> setOrder(@RequestBody TcOrder tcOrder) {
        List<TcOrder>data = new ArrayList<>();
        try {
            if (tcClientRepository.existsById(tcOrder.getTcClient().getClientId())==false) {
                tcOrder.setTcClient(tcClientRepository.save(tcOrder.getTcClient()));
            }
            TcOrder orden = tcOrderRepository.save(tcOrder);

            List<TcDetail> detalles =  tcOrder.getTcDetail();
            List<TcDetail> detallesGuardados = new ArrayList<>();
            for (TcDetail detalle : detalles) {
                detallesGuardados.add(tcDetailRepository.save(detalle));
            }
            tcOrder.setTcDetail(detallesGuardados);
            data.add(tcOrderRepository.save(tcOrder));
            ApiResponse apiResponse = new ApiResponse("OK", "PROCESO REALIZADO CON EXITO", data);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse apiResponse = new ApiResponse("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/all")
    public ResponseEntity<ApiResponse2> getAll() {
        try {
            List<TcOrder> orders = tcOrderRepository.findAll();
            ApiResponse2 apiResponse = new ApiResponse2("OK", "PROCESO REALIZADO CON EXITO", orders);
            return new ResponseEntity<ApiResponse2>(apiResponse, HttpStatus.OK);
        } catch (Exception e) {
            ApiResponse2 apiResponse = new ApiResponse2("FAIL", e.toString(), null);
            return new ResponseEntity<ApiResponse2>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }
}
