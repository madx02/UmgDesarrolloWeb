package gt.edu.umg.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.demo.model.TcMenu;
import gt.edu.umg.demo.repository.TcMenuRepository;
import gt.edu.umg.demo.utils.ApiResponse;
import gt.edu.umg.demo.utils.AppProperty;
import gt.edu.umg.demo.utils.ResponseResult;

@RestController
@RequestMapping("/menu")
public class TcMenuController {

    private boolean showErrors;

    @Autowired
    TcMenuRepository tcMenuRepository;

    ApiResponse apiResponse = new ApiResponse();

    @Autowired
    public TcMenuController(AppProperty properties) {
        this.showErrors = (properties.getShowErrors() == 1);
    }

    @PostMapping("/add")
    public ApiResponse setMenu(@Valid @RequestBody TcMenu tcMenu) {
        try {
            tcMenuRepository.save(tcMenu);
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
            List<?> list = tcMenuRepository.findAll();
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

    @GetMapping("/{menuId}")
    public ApiResponse findById(@PathVariable(value = "menuId") Long menuId) {
        try {
            Optional<TcMenu> found = tcMenuRepository.findById(menuId);
            List<TcMenu> list = new ArrayList<>();
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

    @PutMapping("/{menuId}")
    public ApiResponse updateMenu(@PathVariable(value = "menuId") Long menuId, @Valid @RequestBody TcMenu tcMenu) {
        try {
            Optional<TcMenu> found = tcMenuRepository.findById(menuId);
            TcMenu menu = found.get();
            menu.setMenuDesc(tcMenu.getMenuDesc());
            menu.setStatusId(tcMenu.getStatusId());
            TcMenu menuUpdated = tcMenuRepository.save(menu);
            List<TcMenu> list = new ArrayList<>();
            list.add(menuUpdated);
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
