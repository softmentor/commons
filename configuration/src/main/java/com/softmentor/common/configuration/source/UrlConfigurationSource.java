package com.softmentor.common.configuration.source;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * An implementation of {@link ConfigurationSource} that reads the configuration from a {@link URL}.
 */
public class UrlConfigurationSource implements ConfigurationSource
{
    @Override
    public InputStream open(String path) throws IOException
    {
        return new URL(path).openStream();
    }
}
