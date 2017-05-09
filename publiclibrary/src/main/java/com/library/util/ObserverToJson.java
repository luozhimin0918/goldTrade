package com.library.util;

import io.jsonwebtoken.Claims;

/**
 * Created by Mr'Dai on 2017/4/17.
 */

public abstract class ObserverToJson {
    protected abstract void toJsonString(String json);

    public void toClaims(Claims claims) {

    }
}
