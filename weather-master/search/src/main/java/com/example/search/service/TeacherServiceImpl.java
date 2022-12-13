package com.example.search.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService{
    private final RestTemplate restTemplate;
    TeacherServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public Map<String ,Map[]> fetchAllTeacher(){
    log.info("find all teachers by search with multi threads");
    List<CompletableFuture> completableFutureList = new ArrayList<>();
    String[] ids = new String[3];
        ids[0] = 2 +"";
        ids[1] = 3 +"";
        ids[2] = 4 +"";
        for(String id : ids){
            completableFutureList.add(CompletableFuture.supplyAsync(()->restTemplate.getForObject("http://university-service/university/students?id="+id,HashMap[].class))
            );
        }
        return CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]))
                .thenApply(VOID -> {
                    Map<String, Map[]> res = new HashMap<>();
                    for(int i = 0; i < completableFutureList.size(); i++) {
                        res.put(ids[i], (Map[])completableFutureList.get(i).join());
                    }
                    return res;
                }).join();
    }
}
