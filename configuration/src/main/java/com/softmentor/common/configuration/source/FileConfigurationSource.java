package com.softmentor.common.configuration.source;

import java.io.*;


/**
 * An implementation of {@link ConfigurationSource} that reads the configuration from the local file system.
 */
public class FileConfigurationSource implements ConfigurationSource
{
    @Override
    public InputStream open(String path) throws IOException
    {
        final File file = new File(path);
        if (!file.exists())
        {
            throw new FileNotFoundException("File " + file + " not found");
        }

        return new FileInputStream(file);
    }
}
