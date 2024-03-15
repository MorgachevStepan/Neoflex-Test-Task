package com.stepanew.neoflextask.api.services;

import com.stepanew.neoflextask.entities.requests.VacationPayRequestDto;
import com.stepanew.neoflextask.entities.responses.VacationPayResponseDto;

public interface CalculatorService {

    VacationPayResponseDto calculateVacationPay(VacationPayRequestDto request);

}
