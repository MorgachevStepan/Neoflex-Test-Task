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

    double averageSalary;
    int vacationDays;

}
