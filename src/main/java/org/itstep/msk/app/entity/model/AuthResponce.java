package org.itstep.msk.app.entity.model;

public class AuthResponce {

    public String getJwt() {
        return jwt;
    }

    private final String jwt;

    public AuthResponce(String jwt) {
        this.jwt = jwt;
    }

}
