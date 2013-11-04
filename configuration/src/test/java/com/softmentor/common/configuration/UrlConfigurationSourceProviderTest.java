package com.softmentor.common.configuration;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.InputStream;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;
import com.google.common.io.Resources;
import com.softmentor.common.configuration.source.ConfigurationSource;
import com.softmentor.common.configuration.source.UrlConfigurationSource;


public class UrlConfigurationSourceProviderTest
{
    private final ConfigurationSource provider = new UrlConfigurationSource();

    @Test
    public void readsFileContents() throws Exception
    {
        try (InputStream input = provider.open(Resources.getResource("example.txt").toString()))
        {
            assertThat(new String(ByteStreams.toByteArray(input), Charsets.UTF_8).trim()).isEqualTo("whee");
        }
    }
}
