package com.betrybe.agrix.controllers.dto;

/**
 * ResponseDto class.
 */
public record ResponseDto<T>(String message, T data) {

}
