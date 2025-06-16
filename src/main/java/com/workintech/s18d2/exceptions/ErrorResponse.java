package com.workintech.s18d2.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(String message, int status, LocalDateTime time) {
}
