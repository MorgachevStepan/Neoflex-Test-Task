package com.stepanew.neoflextask.api.controllers.doc;

import com.stepanew.neoflextask.entities.responses.VacationPayResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Vacation pau calculator API", description = "API для взаимодействия с калькулятором отпускных")
public interface CalculatorDocumentation {

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Отпускные успешно подсчитаны",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = VacationPayResponseDto.class)
                            )
                    }
            )
    })
    @Operation(summary = "Расчет выплат")
    ResponseEntity<VacationPayResponseDto> calculateVacationPay(
            @Parameter(name = "Average salary", example = "100000") double averageSalary,
            @Parameter(name = "Vacation days", example = "14") int vacationDays
    );

}
