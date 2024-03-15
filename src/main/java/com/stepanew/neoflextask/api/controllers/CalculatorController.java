package com.stepanew.neoflextask.api.controllers;

import com.stepanew.neoflextask.api.controllers.doc.CalculatorDocumentation;
import com.stepanew.neoflextask.api.services.CalculatorService;
import com.stepanew.neoflextask.entities.requests.VacationPayRequestDto;
import com.stepanew.neoflextask.entities.responses.VacationPayResponseDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalculatorController implements CalculatorDocumentation {

    final CalculatorService calculatorService;

    @GetMapping("/calculate")
    public ResponseEntity<VacationPayResponseDto> calculateVacationPay(
            @RequestParam(name = "Average salary") double averageSalary,
            @RequestParam(name = "Vacation days") int vacationDays) {
        VacationPayResponseDto response = calculatorService.calculateVacationPay(
                VacationPayRequestDto.builder()
                        .averageSalary(averageSalary)
                        .vacationDays(vacationDays)
                        .build()
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

}
