package com.team1.manager;

import com.team1.dto.response.WorkerListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import java.util.List;

import static com.team1.constant.EndPoints.REGISTER;
import static com.team1.constant.EndPoints.SAVE_COMPANY;

@FeignClient(name = "company-worker-manager", url = "http://localhost:9096/api/v1/worker", decode404 = true)
public interface ICompanyAuthManager {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/finAll")
    ResponseEntity<List<WorkerListResponse>> findAllWorker(Long token);

}