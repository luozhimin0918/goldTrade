package com.library.base.http;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.library.util.LogUtil;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author Mr'Dai
 * @date 2016/5/18 14:26
 * @Title: MobileLibrary
 * @Package com.dxmobile.library
 * @Description:
 */
public class StringRequest extends Request<String> {

    private Response.Listener<String> mSuccessListener;
    private Map<String, String> mParams;

    public StringRequest(int method,
                         String url,
                         Map<String, String> mParams,
                         Response.Listener<String> listener,
                         Response.ErrorListener errorListener) {

        super(method, url, errorListener);

        this.mSuccessListener = listener;
        this.mParams = mParams;

        LogUtil.e("Volley", "url:" + url);
        if (mParams != null) {
            LogUtil.e("Volley", "params:" + mParams.toString());
        }

    }


    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }

    /**
     * Subclasses must implement this to perform delivery of the parsed
     * response to their listeners.  The given response is guaranteed to
     * be non-null; responses that fail to parse are not delivered.
     *
     * @param response The parsed response returned by
     *                 {@link #parseNetworkResponse(NetworkResponse)}
     */
    @Override
    protected void deliverResponse(String response) {
        if (mSuccessListener != null) {
            mSuccessListener.onResponse(response);
        }
    }

    @Override
    public void deliverError(VolleyError error) {
        super.deliverError(error);
        LogUtil.e("Volley", "error:" + getUrl() + " >>>> " + error.getMessage());
    }

    @Override
    public Map<String, String> getParams() {
        return mParams;
    }
}
