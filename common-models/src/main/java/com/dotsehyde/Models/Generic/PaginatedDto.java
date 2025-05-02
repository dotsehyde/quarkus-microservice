package com.dotsehyde.Models.Generic;

import java.util.List;

public record PaginatedDto<T>(
        Long size,
        List<T> content
) {
}
