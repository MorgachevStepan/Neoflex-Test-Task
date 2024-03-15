package com.stepanew.neoflextask.api.services.impl;

import com.stepanew.neoflextask.api.services.CalculatorService;
import com.stepanew.neoflextask.entities.requests.VacationPayRequestDto;
import com.stepanew.neoflextask.entities.responses.VacationPayResponseDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalculatorServiceImpl implements CalculatorService {

    static final double AVERAGE_MONTH_DAYS = 29.3;

    @Override
    public VacationPayResponseDto calculateVacationPay(VacationPayRequestDto request) {
        return VacationPayResponseDto.builder()
                .totalVacationPay(
                        request.getAverageSalary() / AVERAGE_MONTH_DAYS * request.getVacationDays()
                )
                .build();
    }

}
