package com.softmentor.common.util.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public interface ExampleSPI extends ExampleTag
{
}
