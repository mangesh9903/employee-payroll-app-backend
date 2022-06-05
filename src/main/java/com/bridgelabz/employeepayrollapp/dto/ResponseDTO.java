package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;
import lombok.ToString;

/***********************************************************************************************************************
 * Class :- Response DTO.
 * @author Mangesh
 * @date 02-06-2022
 **********************************************************************************************************************/
@ToString
@Data
public class ResponseDTO {

    private String message;

    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
