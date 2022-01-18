package com.example.appmap.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private String message;
    
    private boolean isSuccessful;
    
    private Object object;

    public Result(String message) {
        this.message = message;
    }

    public Result(String message, boolean isSuccessful) {
        this.message = message;
        this.isSuccessful = isSuccessful;
    }
}
