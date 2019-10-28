package gt.edu.umg.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.demo.model.TcProvider;
import gt.edu.umg.demo.repository.TcProviderRepository;
import gt.edu.umg.demo.utils.ApiResponse;
import gt.edu.umg.demo.utils.AppProperty;
import gt.edu.umg.demo.utils.ResponseResult;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/provider")
public class TcProviderController {

    private boolean showErrors;

    @Autowired
    TcProviderRepository tcProviderRepository;

    ApiResponse apiResponse = new ApiResponse();

    @Autowired
    public TcProviderController(AppProperty properties) {
        this.showErrors = (properties.getShowErrors() == 1);
    }

    @PostMapping("/add")
    public ApiResponse setProvider(@Valid @RequestBody TcProvider tcProvider) {
        try {
            tcProviderRepository.save(tcProvider);
            apiResponse.setStatus(ResponseResult.success.getValue());
            apiResponse.setMessage(ResponseResult.success.getMessage());
        } catch (Exception e) {
            apiResponse.setStatus(ResponseResult.fail.getValue());
            if (this.showErrors) {
                apiResponse.setMessage(e.getMessage());
            } else {
                apiResponse.setMessage(ResponseResult.fail.getMessage());
            }
        }
        return apiResponse;
    }

    @GetMapping("/all")
    public ApiResponse getAll() {
        try {
            List<?> list = tcProviderRepository.findAll();
            apiResponse.setData(list);
            apiResponse.setStatus(ResponseResult.success.getValue());
            apiResponse.setMessage(ResponseResult.success.getMessage());
        } catch (Exception e) {
            apiResponse.setStatus(ResponseResult.fail.getValue());
            if (this.showErrors) {
                apiResponse.setMessage(e.getMessage());
            } else {
                apiResponse.setMessage(ResponseResult.fail.getMessage());
            }
        }
        return apiResponse;
    }

    @GetMapping("/all/active")
    public ApiResponse getAllActive() {
        try {
            List<?> list = tcProviderRepository.findByStatusId((byte) 1);
            apiResponse.setData(list);
            apiResponse.setStatus(ResponseResult.success.getValue());
            apiResponse.setMessage(ResponseResult.success.getMessage());
        } catch (Exception e) {
            apiResponse.setStatus(ResponseResult.fail.getValue());
            if (this.showErrors) {
                apiResponse.setMessage(e.getMessage());
            } else {
                apiResponse.setMessage(ResponseResult.fail.getMessage());
            }
        }
        return apiResponse;
    }

    @GetMapping("/{providerId}")
    public ApiResponse findById(@PathVariable(value = "providerId") Long providerId) {
        try {
            Optional<TcProvider> found = tcProviderRepository.findById(providerId);
            List<TcProvider> list = new ArrayList<>();
            list.add(found.get());
            apiResponse.setData(list);
            apiResponse.setStatus(ResponseResult.success.getValue());
            apiResponse.setMessage(ResponseResult.success.getMessage());
        } catch (Exception e) {
            apiResponse.setStatus(ResponseResult.fail.getValue());
            if (this.showErrors) {
                apiResponse.setMessage(e.getMessage());
            } else {
                apiResponse.setMessage(ResponseResult.fail.getMessage());
            }
        }
        return apiResponse;
    }

    @PutMapping("/{providerId}")
    public ApiResponse updateProvider(@PathVariable(value = "providerId") Long providerId, @Valid @RequestBody TcProvider tcProvider) {
        try {
            Optional<TcProvider> found = tcProviderRepository.findById(providerId);
            TcProvider provider = found.get();
            provider.setProviderDesc(tcProvider.getProviderDesc());
            provider.setContactName(tcProvider.getContactName());
            TcProvider providerUpdated = tcProviderRepository.save(provider);
            List<TcProvider> list = new ArrayList<>();
            list.add(providerUpdated);
            apiResponse.setData(list);
            apiResponse.setStatus(ResponseResult.success.getValue());
            apiResponse.setMessage(ResponseResult.success.getMessage());
        } catch (Exception e) {
            apiResponse.setStatus(ResponseResult.fail.getValue());
            if (this.showErrors) {
                apiResponse.setMessage(e.getMessage());
            } else {
                apiResponse.setMessage(ResponseResult.fail.getMessage());
            }
        }
        return apiResponse;
    }

}
