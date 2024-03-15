package com.stepanew.neoflextask.entities.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Schema(description = "Response for salary")
public class VacationPayResponseDto {

    @Schema(description = "Total vacation pay", example = "40000")
    double totalVacationPay;

}
