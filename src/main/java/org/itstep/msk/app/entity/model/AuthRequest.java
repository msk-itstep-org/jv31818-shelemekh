package org.itstep.msk.app.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * DTO model for auth request
 */
@Data
@AllArgsConstructor
@Builder
public class AuthRequest {

    private String customerName;
    private String customerPassword;


}

