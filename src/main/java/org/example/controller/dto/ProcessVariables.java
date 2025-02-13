package org.example.controller.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ProcessVariables {

    /**
     * Количество денег в начале процесса
     */

    @NotNull
    @Min(value = 100, message = "sumOfMoney should not be less than 100")
    @Max(value = 1000, message = "sumOfMoney should not be greater than 100")
    Integer countMoney;
}
