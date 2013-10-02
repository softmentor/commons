package com.softmentor.common.util.jackson;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;


public class DiscoverableSubtypeResolverTest
{
    private final ObjectMapper                mapper   = new ObjectMapper();
    private final DiscoverableSubtypeResolver resolver = new DiscoverableSubtypeResolver(ExampleTag.class);

    @Before
    public void setUp() throws Exception
    {
        mapper.setSubtypeResolver(resolver);
    }

    @Test
    public void discoversSubtypes() throws Exception
    {
        assertThat(mapper.readValue("{\"type\":\"a\"}", ExampleSPI.class)).isInstanceOf(ImplA.class);

        assertThat(mapper.readValue("{\"type\":\"b\"}", ExampleSPI.class)).isInstanceOf(ImplB.class);
    }
}
