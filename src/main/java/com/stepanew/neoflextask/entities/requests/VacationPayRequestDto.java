package com.stepanew.neoflextask.entities.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Request for vacation pay")
public class VacationPayRequestDto {

    @Schema(description = "Average salary", example = "100000")
    double averageSalary;

    @Schema(description = "Vacation days", example = "14")
    int vacationDays;

}
