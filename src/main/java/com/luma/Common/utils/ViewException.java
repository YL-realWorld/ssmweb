package com.luma.Common.utils;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.io.Writer;

public class ViewException extends RuntimeException implements TemplateExceptionHandler{

    private static final long serialVersionUID = 1L;

    public ViewException() {
        super();
    }

    public ViewException(String message) {
        super(message);
    }

    public ViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViewException(Throwable cause) {
        super(cause);
    }

    @Override
    public void handleTemplateException(TemplateException te, Environment en, Writer wr)
            throws TemplateException {
        try {
            wr.write("<script type='text/javascript'>$(function(){window.location.href = 'error.php';});</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

